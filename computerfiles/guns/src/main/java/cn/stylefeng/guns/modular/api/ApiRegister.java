package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.config.properties.GunsProperties;
import cn.stylefeng.guns.core.common.constant.state.ManagerStatus;
import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.modular.agritainment.service.IQyAgritainmentinfoService;
import cn.stylefeng.guns.modular.cook.service.IQyCookinfoService;
import cn.stylefeng.guns.modular.system.dao.UserMapper;
import cn.stylefeng.guns.modular.system.factory.UserFactory;
import cn.stylefeng.guns.modular.system.model.QyAgritainmentinfo;
import cn.stylefeng.guns.modular.system.model.QyCookinfo;
import cn.stylefeng.guns.modular.system.model.User;
import cn.stylefeng.guns.modular.system.service.IUserService;
import cn.stylefeng.guns.modular.system.transfer.UserDto;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.FileUtil;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * 注册接口
 *
 * @author zmq
 * @Date 2019/2/6 23:39
 */
@RestController
@RequestMapping("/registerApi")
public class ApiRegister extends BaseController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;
    @Autowired
    private IQyCookinfoService cookinfoService;

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private IQyAgritainmentinfoService qyAgritainmentinfoService;


    /**
     * api注册接口
     */
    @RequestMapping("/register")
    public Object register(@RequestParam("account") String account,
                           @RequestParam("password") String password,
                           @RequestParam("roleid") String roleid,
                           @RequestParam("username") String username){
        //创建用户对象
        UserDto userdto = new UserDto();
        //获取数据库中的账号密码，判断账号是否已被注册
        User user = userMapper.getByAccount(account);

        if (!(user==null)) {
            HashMap<String, Object> result = new HashMap<>();
            result.put("code",500);
            result.put("message","账号已存在，请重新注册或登录");
            return result;
        } else {
            boolean isregstate = false;
            HashMap<String, Object> result = new HashMap<>();
            userdto.setAccount(account);
            userdto.setPassword(password);
            userdto.setName(username);
            userdto.setRoleid(roleid);
            // 完善账号信息
            userdto.setSalt(ShiroKit.getRandomSalt(5));
            userdto.setPassword(ShiroKit.md5(userdto.getPassword(), userdto.getSalt()));
            userdto.setStatus(ManagerStatus.OK.getCode());
            userdto.setCreatetime(new Date());
            isregstate = this.userService.insert(UserFactory.createUser(userdto));
            if (isregstate){
                result.put("code",200);
                result.put("message","注册成功");
                if(roleid.equals("9")){
                    QyCookinfo cookinfo = new QyCookinfo();
                    cookinfo.setId(account);
                    cookinfo.setName(username);
                    cookinfoService.insert(cookinfo);
                }else if(roleid.equals("7")){
                    QyAgritainmentinfo cookinfo = new QyAgritainmentinfo();
                    cookinfo.setId(account);
                    cookinfo.setName(username);
                    qyAgritainmentinfoService.insert(cookinfo);
                }
                return result;
            }else{
                result.put("code",400);
                result.put("message","注册失败，服务器错误，请稍后再试");
                return result;
            }
        }
    }

    /**
     * 上传图片
     */
    @RequestMapping(method = RequestMethod.POST, path = "/upload")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile picture) {

        String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
        try {
            String fileSavePath = gunsProperties.getFileUploadPath();

            picture.transferTo(new File(fileSavePath + pictureName));
        } catch (Exception e) {
            throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
        }
        return pictureName;
    }
    /**
     * 返回图片
     *
     * @author stylefeng
     * @Date 2017/5/24 23:00
     */
    @RequestMapping("/{pictureId}")
    public void renderPicture(@PathVariable("pictureId") String pictureId, HttpServletResponse response) {
        String path = gunsProperties.getFileUploadPath() + pictureId;
        try{
            byte[] bytes = FileUtil.toByteArray(path);
            response.getOutputStream().write(bytes);
        } catch (Exception e) {
            //如果找不到图片就返回一个默认图片
            try {response.sendRedirect("/static/img/girl.gif"); } catch (IOException e1){e1.printStackTrace();}}
    }



}
