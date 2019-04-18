package cn.stylefeng.guns.modular.api;

import cn.stylefeng.guns.config.properties.GunsProperties;
import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.cook.service.IQyCookinfoService;
import cn.stylefeng.guns.modular.system.dao.UserMapper;
import cn.stylefeng.guns.modular.system.model.QyCookinfo;
import cn.stylefeng.guns.modular.system.service.IUserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 厨师控制器
 *
 * @author fengshuonan
 * @Date 2019-02-06 11:18:24
 */
@RestController
@RequestMapping("/cookinfoApi")
public class ApiCookInfoController extends BaseController {

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;


    @Autowired
    private IQyCookinfoService qyCookinfoService;


    /**
     * 修改厨师
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyCookinfo qyCookinfo) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("id",qyCookinfo.getId());
        List<QyCookinfo> cookinfoList = qyCookinfoService.selectByMap(map);
        if (cookinfoList==null||cookinfoList.size()==0){
            responseData.setMessage("当前用户不存在");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return SUCCESS_TIP;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            qyCookinfoService.updateById(qyCookinfo);
            return SUCCESS_TIP;
        }
    }

    /**
     * 查询厨师信息
     */
    @RequestMapping(value = "/query")
    public Object query(@RequestParam("account") String account) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("id",account);
        List<QyCookinfo> cookinfoList = qyCookinfoService.selectByMap(map);
        if (cookinfoList==null||cookinfoList.size()==0){
            responseData.setMessage("当前用户不存在");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return responseData;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            responseData.setData(cookinfoList.get(0));
            return responseData;

        }
    }



    /**
     * 测试接口是否走鉴权
     */
    @RequestMapping(value = "/test")
    public Object test() {
        return SUCCESS_TIP;
    }


}

