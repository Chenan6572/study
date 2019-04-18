package cn.stylefeng.guns.modular.rtagmt.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.ReportAgritainment;
import cn.stylefeng.guns.modular.rtagmt.service.IReportAgritainmentService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 农家乐报备控制器
 *
 * @author fengshuonan
 * @Date 2019-02-26 14:45:35
 */
@Controller
@RequestMapping("/reportAgritainment")
public class ReportAgritainmentController extends BaseController {

    private String PREFIX = "/rtagmt/reportAgritainment/";

    @Autowired
    private IReportAgritainmentService reportAgritainmentService;

    /**
     * 跳转到农家乐报备首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "reportAgritainment.html";
    }

    /**
     * 跳转到添加农家乐报备
     */
    @RequestMapping("/reportAgritainment_add")
    public String reportAgritainmentAdd() {
        return PREFIX + "reportAgritainment_add.html";
    }

    /**
     * 跳转到修改农家乐报备
     */
    @RequestMapping("/reportAgritainment_update/{reportAgritainmentId}")
    public String reportAgritainmentUpdate(@PathVariable String reportAgritainmentId, Model model) {
        ReportAgritainment reportAgritainment = reportAgritainmentService.selectById(reportAgritainmentId);
        model.addAttribute("item",reportAgritainment);
        LogObjectHolder.me().set(reportAgritainment);
        return PREFIX + "reportAgritainment_edit.html";
    }
    /**
     * 跳转到农家乐详情界面
     */
    @RequestMapping("/reportAgritainment_details/{reportAgritainmentId}")
    public String reportAgritainmentDetails(@PathVariable String reportAgritainmentId, Model model) {
        ReportAgritainment reportAgritainment = reportAgritainmentService.selectById(reportAgritainmentId);
        model.addAttribute("item",reportAgritainment);
        LogObjectHolder.me().set(reportAgritainment);
        return PREFIX + "reportAgritainment_details.html";
    }

    /**
     * 跳转到农家乐审核界面
     */
    @RequestMapping("/reportAgritainment_examine/{reportAgritainmentId}")
    public String reportAgritainmentExamine(@PathVariable String reportAgritainmentId, Model model) {
        ReportAgritainment reportAgritainment = reportAgritainmentService.selectById(reportAgritainmentId);
        model.addAttribute("item",reportAgritainment);
        LogObjectHolder.me().set(reportAgritainment);
        return PREFIX + "reportAgritainment_examine.html";
    }
    /**
     * 获取农家乐报备列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return reportAgritainmentService.selectList(null);
    }

    /**
     * 新增农家乐报备
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ReportAgritainment reportAgritainment) {
        reportAgritainmentService.insert(reportAgritainment);
        return SUCCESS_TIP;
    }

    /**
     * 删除农家乐报备
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String reportAgritainmentId) {
        reportAgritainmentService.deleteById(reportAgritainmentId);
        return SUCCESS_TIP;
    }

    /**
     * 修改农家乐报备
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ReportAgritainment reportAgritainment) {
        reportAgritainmentService.updateById(reportAgritainment);
        return SUCCESS_TIP;
    }
    /**
     * 审核农家乐
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public Object examine(ReportAgritainment reportAgritainment) {
        reportAgritainment.setAudittime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        reportAgritainmentService.updateById(reportAgritainment);
        return SUCCESS_TIP;
    }
    /**
     * 农家乐报备详情
     */
    @RequestMapping(value = "/detail/{reportAgritainmentId}")
    @ResponseBody
    public Object detail(@PathVariable("reportAgritainmentId") String reportAgritainmentId) {
        return reportAgritainmentService.selectById(reportAgritainmentId);
    }
}
