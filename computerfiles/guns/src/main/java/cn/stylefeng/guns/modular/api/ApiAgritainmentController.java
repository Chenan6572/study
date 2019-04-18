package cn.stylefeng.guns.modular.api;


import cn.stylefeng.guns.config.properties.GunsProperties;
import cn.stylefeng.guns.modular.agritainment.service.IQyAgritainmentinfoService;
import cn.stylefeng.guns.modular.ckrelation.service.ICkrelationService;
import cn.stylefeng.guns.modular.system.dao.UserMapper;
import cn.stylefeng.guns.modular.system.model.QyAgritainmentinfo;
import cn.stylefeng.guns.modular.system.model.QyCookinfo;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 帮厨api控制器
 *
 * @author zmq
 * @Date 2019-02-06 11:18:24
 */
@RestController
@RequestMapping("/agritainmentApi")
public class ApiAgritainmentController extends BaseController {

    @Autowired
    private GunsProperties gunsProperties;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IQyAgritainmentinfoService qyAgritainmentinfoService;



    /**
     * 修改厨师
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyAgritainmentinfo qyAgritainmentinfo) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("id",qyAgritainmentinfo.getId());
        List<QyAgritainmentinfo> qyAgritainmentinfos = qyAgritainmentinfoService.selectByMap(map);
        if (qyAgritainmentinfos==null||qyAgritainmentinfos.size()==0){
            responseData.setMessage("当前用户不存在");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return SUCCESS_TIP;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            qyAgritainmentinfoService.updateById(qyAgritainmentinfo);
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
        List<QyAgritainmentinfo> qyAgritainmentinfos = qyAgritainmentinfoService.selectByMap(map);
        if (qyAgritainmentinfos==null||qyAgritainmentinfos.size()==0){
            responseData.setMessage("当前用户不存在");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return responseData;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            responseData.setData(qyAgritainmentinfos.get(0));
            return responseData;

        }
    }
}

