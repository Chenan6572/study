package cn.stylefeng.guns.modular.ckrelation.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Ckrelation;
import cn.stylefeng.guns.modular.ckrelation.service.ICkrelationService;

/**
 * 报备帮厨控制器
 *
 * @author fengshuonan
 * @Date 2019-02-10 10:09:47
 */
@Controller
@RequestMapping("/ckrelation")
public class CkrelationController extends BaseController {

    private String PREFIX = "/ckrelation/ckrelation/";

    @Autowired
    private ICkrelationService ckrelationService;

    /**
     * 跳转到报备帮厨首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "ckrelation.html";
    }

    /**
     * 跳转到添加报备帮厨
     */
    @RequestMapping("/ckrelation_add")
    public String ckrelationAdd() {
        return PREFIX + "ckrelation_add.html";
    }

    /**
     * 跳转到修改报备帮厨
     */
    @RequestMapping("/ckrelation_update/{ckrelationId}")
    public String ckrelationUpdate(@PathVariable String ckrelationId, Model model) {
        Ckrelation ckrelation = ckrelationService.selectById(ckrelationId);
        model.addAttribute("item",ckrelation);
        LogObjectHolder.me().set(ckrelation);
        return PREFIX + "ckrelation_edit.html";
    }

    /**
     * 获取报备帮厨列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return ckrelationService.selectList(null);
    }

    /**
     * 新增报备帮厨
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Ckrelation ckrelation) {
        ckrelationService.insert(ckrelation);
        return SUCCESS_TIP;
    }

    /**
     * 删除报备帮厨
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String ckrelationId) {
        ckrelationService.deleteById(ckrelationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改报备帮厨
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Ckrelation ckrelation) {
        ckrelationService.updateById(ckrelation);
        return SUCCESS_TIP;
    }

    /**
     * 报备帮厨详情
     */
    @RequestMapping(value = "/detail/{ckrelationId}")
    @ResponseBody
    public Object detail(@PathVariable("ckrelationId") String ckrelationId) {
        return ckrelationService.selectById(ckrelationId);
    }
}
