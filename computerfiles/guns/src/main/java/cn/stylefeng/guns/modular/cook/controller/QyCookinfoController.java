package cn.stylefeng.guns.modular.cook.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.QyCookinfo;
import cn.stylefeng.guns.modular.cook.service.IQyCookinfoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 厨师控制器
 *
 * @author fengshuonan
 * @Date 2019-02-26 14:41:25
 */
@Controller
@RequestMapping("/qyCookinfo")
public class QyCookinfoController extends BaseController {

    private String PREFIX = "/cook/qyCookinfo/";

    @Autowired
    private IQyCookinfoService qyCookinfoService;

    /**
     * 跳转到厨师首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "qyCookinfo.html";
    }

    /**
     * 跳转到添加厨师
     */
    @RequestMapping("/qyCookinfo_add")
    public String qyCookinfoAdd() {
        return PREFIX + "qyCookinfo_add.html";
    }

    /**
     * 跳转到修改厨师
     */
    @RequestMapping("/qyCookinfo_update/{qyCookinfoId}")
    public String qyCookinfoUpdate(@PathVariable String qyCookinfoId, Model model) {
        QyCookinfo qyCookinfo = qyCookinfoService.selectById(qyCookinfoId);
        model.addAttribute("item",qyCookinfo);
        LogObjectHolder.me().set(qyCookinfo);
        return PREFIX + "qyCookinfo_edit.html";
    }

    /**
     * 跳转到厨师详情界面
     */
    @RequestMapping("/qyCookinfo_details/{qyCookinfoId}")
    public String qyCookinfoDetails(@PathVariable String qyCookinfoId, Model model) {
        QyCookinfo qyCookinfo = qyCookinfoService.selectById(qyCookinfoId);
        model.addAttribute("item",qyCookinfo);
        LogObjectHolder.me().set(qyCookinfo);
        return PREFIX + "qyCookinfo_details.html";
    }

    /**
     * 跳转到厨师审核界面
     */
    @RequestMapping("/qyCookinfo_examine/{qyCookinfoId}")
    public String qyCookinfoExamine(@PathVariable String qyCookinfoId, Model model) {
        QyCookinfo qyCookinfo = qyCookinfoService.selectById(qyCookinfoId);
        model.addAttribute("item",qyCookinfo);
        LogObjectHolder.me().set(qyCookinfo);
        return PREFIX + "qyCookinfo_examine.html";
    }

    /**
     * 获取厨师列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return qyCookinfoService.selectList(null);
    }

    /**
     * 新增厨师
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(QyCookinfo qyCookinfo) {
        qyCookinfoService.insert(qyCookinfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除厨师
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String qyCookinfoId) {
        qyCookinfoService.deleteById(qyCookinfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改厨师
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyCookinfo qyCookinfo) {
        qyCookinfoService.updateById(qyCookinfo);
        return SUCCESS_TIP;
    }
    /**
     * 审核农家乐
     */
    @RequestMapping(value = "/examine")
    @ResponseBody
    public Object examine(QyCookinfo qyCookinfo) {
        qyCookinfo.setExaminetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        qyCookinfoService.updateById(qyCookinfo);
        return SUCCESS_TIP;
    }
    /**
     * 厨师详情
     */
    @RequestMapping(value = "/detail/{qyCookinfoId}")
    @ResponseBody
    public Object detail(@PathVariable("qyCookinfoId") String qyCookinfoId) {
        return qyCookinfoService.selectById(qyCookinfoId);
    }
}
