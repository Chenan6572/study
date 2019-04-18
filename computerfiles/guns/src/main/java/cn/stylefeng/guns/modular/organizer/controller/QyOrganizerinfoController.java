package cn.stylefeng.guns.modular.organizer.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.QyOrganizerinfo;
import cn.stylefeng.guns.modular.organizer.service.IQyOrganizerinfoService;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 举办者控制器
 *
 * @author fengshuonan
 * @Date 2019-02-26 14:38:23
 */
@Controller
@RequestMapping("/qyOrganizerinfo")
public class QyOrganizerinfoController extends BaseController {

    private String PREFIX = "/organizer/qyOrganizerinfo/";

    @Autowired
    private IQyOrganizerinfoService qyOrganizerinfoService;

    /**
     * 跳转到举办者首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "qyOrganizerinfo.html";
    }

    /**
     * 跳转到添加举办者
     */
    @RequestMapping("/qyOrganizerinfo_add")
    public String qyOrganizerinfoAdd() {
        return PREFIX + "qyOrganizerinfo_add.html";
    }

    /**
     * 跳转到修改举办者
     */
    @RequestMapping("/qyOrganizerinfo_update/{qyOrganizerinfoId}")
    public String qyOrganizerinfoUpdate(@PathVariable String qyOrganizerinfoId, Model model) {
        QyOrganizerinfo qyOrganizerinfo = qyOrganizerinfoService.selectById(qyOrganizerinfoId);
        model.addAttribute("item",qyOrganizerinfo);
        LogObjectHolder.me().set(qyOrganizerinfo);
        return PREFIX + "qyOrganizerinfo_edit.html";
    }
    /**
     * 跳转到举办者详情
     */
    @RequestMapping("/qyOrganizerinfo_details/{qyOrganizerinfoId}")
    public String qyOrganizerinfoDetails(@PathVariable String qyOrganizerinfoId, Model model) {
        QyOrganizerinfo qyOrganizerinfo = qyOrganizerinfoService.selectById(qyOrganizerinfoId);
        model.addAttribute("item",qyOrganizerinfo);
        LogObjectHolder.me().set(qyOrganizerinfo);
        return PREFIX + "qyOrganizerinfo_details.html";
    }/**
     * 跳转到举办者审核
     */
    @RequestMapping("/qyOrganizerinfo_examine/{qyOrganizerinfoId}")
    public String qyOrganizerinfoExamine(@PathVariable String qyOrganizerinfoId, Model model) {
        QyOrganizerinfo qyOrganizerinfo = qyOrganizerinfoService.selectById(qyOrganizerinfoId);
        model.addAttribute("item",qyOrganizerinfo);
        LogObjectHolder.me().set(qyOrganizerinfo);
        return PREFIX + "qyOrganizerinfo_examine.html";
    }
    /**
     * 获取举办者列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return qyOrganizerinfoService.selectList(null);
    }

    /**
     * 新增举办者
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(QyOrganizerinfo qyOrganizerinfo) {
        qyOrganizerinfoService.insert(qyOrganizerinfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除举办者
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String qyOrganizerinfoId) {
        qyOrganizerinfoService.deleteById(qyOrganizerinfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改举办者
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyOrganizerinfo qyOrganizerinfo) {
        qyOrganizerinfoService.updateById(qyOrganizerinfo);
        return SUCCESS_TIP;
    }
    /**
     * 审核农家乐
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public Object examine(QyOrganizerinfo qyAgritainmentinfo) {
        qyAgritainmentinfo.setAudittime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        qyOrganizerinfoService.updateById(qyAgritainmentinfo);
        return SUCCESS_TIP;
    }

    /**
     * 举办者详情
     */
    @RequestMapping(value = "/detail/{qyOrganizerinfoId}")
    @ResponseBody
    public Object detail(@PathVariable("qyOrganizerinfoId") String qyOrganizerinfoId) {
        return qyOrganizerinfoService.selectById(qyOrganizerinfoId);
    }
}
