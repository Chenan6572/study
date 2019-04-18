package cn.stylefeng.guns.modular.agritainment.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.QyAgritainmentinfo;
import cn.stylefeng.guns.modular.agritainment.service.IQyAgritainmentinfoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 农家乐控制器
 *
 * @author fengshuonan
 * @Date 2019-02-09 11:03:06
 */
@Controller
@RequestMapping("/qyAgritainmentinfo")
public class QyAgritainmentinfoController extends BaseController {

    private String PREFIX = "/agritainment/qyAgritainmentinfo/";

    @Autowired
    private IQyAgritainmentinfoService qyAgritainmentinfoService;

    /**
     * 跳转到农家乐首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "qyAgritainmentinfo.html";
    }

    /**
     * 跳转到添加农家乐
     */
    @RequestMapping("/qyAgritainmentinfo_add")
    public String qyAgritainmentinfoAdd() {
        return PREFIX + "qyAgritainmentinfo_add.html";
    }

    /**
     * 跳转到修改农家乐
     */
    @RequestMapping("/qyAgritainmentinfo_update/{qyAgritainmentinfoId}")
    public String qyAgritainmentinfoUpdate(@PathVariable String qyAgritainmentinfoId, Model model) {
        QyAgritainmentinfo qyAgritainmentinfo = qyAgritainmentinfoService.selectById(qyAgritainmentinfoId);
        model.addAttribute("item",qyAgritainmentinfo);
        LogObjectHolder.me().set(qyAgritainmentinfo);
        return PREFIX + "qyAgritainmentinfo_edit.html";
    }
    /**
     * 跳转到农家乐详情界面
     */
    @RequestMapping("/qyAgritainmentinfo_details/{qyAgritainmentinfoId}")
    public String qyAgritainmentinfoDetails(@PathVariable String qyAgritainmentinfoId, Model model) {
        QyAgritainmentinfo qyAgritainmentinfo = qyAgritainmentinfoService.selectById(qyAgritainmentinfoId);
        model.addAttribute("item",qyAgritainmentinfo);
        LogObjectHolder.me().set(qyAgritainmentinfo);
        return PREFIX + "qyAgritainmentinfo_details.html";
    }

    /**
     * 跳转到农家乐审核界面
     */
    @RequestMapping("/qyAgritainmentinfo_examine/{qyAgritainmentinfoId}")
    public String qyAgritainmentinfoExamine(@PathVariable String qyAgritainmentinfoId, Model model) {
        QyAgritainmentinfo qyAgritainmentinfo = qyAgritainmentinfoService.selectById(qyAgritainmentinfoId);
        model.addAttribute("item",qyAgritainmentinfo);
        LogObjectHolder.me().set(qyAgritainmentinfo);
        return PREFIX + "qyAgritainmentinfo_examine.html";
    }
    /**
     * 获取农家乐列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return qyAgritainmentinfoService.selectList(null);
    }

    /**
     * 新增农家乐
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(QyAgritainmentinfo qyAgritainmentinfo) {
        qyAgritainmentinfoService.insert(qyAgritainmentinfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除农家乐
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String qyAgritainmentinfoId) {
        qyAgritainmentinfoService.deleteById(qyAgritainmentinfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改农家乐
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyAgritainmentinfo qyAgritainmentinfo) {
        qyAgritainmentinfoService.updateById(qyAgritainmentinfo);
        return SUCCESS_TIP;
    }
    /**
     * 审核农家乐
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public Object examine(QyAgritainmentinfo qyAgritainmentinfo) {
        qyAgritainmentinfo.setAudittime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        qyAgritainmentinfoService.updateById(qyAgritainmentinfo);
        return SUCCESS_TIP;
    }
    /**
     * 农家乐详情
     */
    @RequestMapping(value = "/detail/{qyAgritainmentinfoId}")
    @ResponseBody
    public Object detail(@PathVariable("qyAgritainmentinfoId") String qyAgritainmentinfoId) {
        return qyAgritainmentinfoService.selectById(qyAgritainmentinfoId);
    }

}
