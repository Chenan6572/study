package cn.stylefeng.guns.modular.api;


import cn.stylefeng.guns.core.util.IDCreateUtil;
import cn.stylefeng.guns.modular.chinfo.service.IQyChinfoService;
import cn.stylefeng.guns.modular.system.model.QyChinfo;
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
@RequestMapping("/chinfoApi")
public class ApiChInfoController extends BaseController {

    @Autowired
    private IQyChinfoService qyChinfoService;

    /**
     * 新增帮厨
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(QyChinfo qyChinfo) {
        ResponseData responseData = new ResponseData();
        qyChinfo.setId(IDCreateUtil.genUniqueKey());
        boolean state = qyChinfoService.insert(qyChinfo);
        if (state){
            responseData.setMessage("新增帮厨成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            return responseData;
        }else{
            responseData.setMessage("新增帮厨失败");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return responseData;
        }
    }

    /**
     * 修改厨师
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyChinfo qyChinfo) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("id",qyChinfo.getId());
        List<QyChinfo> qyChinfos = qyChinfoService.selectByMap(map);
        if (qyChinfos==null||qyChinfos.size()==0){
            responseData.setMessage("当前用户不存在");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return responseData;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            qyChinfoService.updateById(qyChinfo);
            return responseData;
        }
    }

    /**
     * 查询帮厨列表信息
     */
    @RequestMapping(value = "/list")
    public Object query(@RequestParam("account") String account) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("realtionid",account);
        List<QyChinfo> qyChinfos = qyChinfoService.selectByMap(map);

            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            responseData.setData(qyChinfos);
            return responseData;

    }

    /**
     * 查询帮厨列表信息
     */
    @RequestMapping(value = "/item")
    public Object queryitem(@RequestParam("id") String id) {
        ResponseData responseData = new ResponseData();
        Map map = new HashMap<>();
        map.put("id",id);
        List<QyChinfo> qyChinfos = qyChinfoService.selectByMap(map);
        if (qyChinfos==null||qyChinfos.size()==0){
            responseData.setMessage("该帮厨不存在");
            responseData.setCode(400);
            responseData.setSuccess(false);
            return responseData;
        }else{
            responseData.setMessage("请求成功");
            responseData.setCode(200);
            responseData.setSuccess(true);
            responseData.setData(qyChinfos.get(0));
            return responseData;

        }
    }

    /**
     * 删除帮厨
     */
    @RequestMapping(value = "/delete")
    public Object delete(@RequestParam("id") String id) {
        qyChinfoService.deleteById(id);
        return SUCCESS_TIP;
    }



}
