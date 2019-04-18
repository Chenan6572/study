package cn.stylefeng.guns.modular.chinfo.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.QyChinfo;
import cn.stylefeng.guns.modular.chinfo.service.IQyChinfoService;

/**
 * 帮厨控制器
 *
 * @author fengshuonan
 * @Date 2019-02-08 14:10:18
 */
@Controller
@RequestMapping("/qyChinfo")
public class QyChinfoController extends BaseController {

    private String PREFIX = "/chinfo/qyChinfo/";

    @Autowired
    private IQyChinfoService qyChinfoService;

    /**
     * 跳转到帮厨首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "qyChinfo.html";
    }

    /**
     * 跳转到添加帮厨
     */
    @RequestMapping("/qyChinfo_add")
    public String qyChinfoAdd() {
        return PREFIX + "qyChinfo_add.html";
    }

    /**
     * 跳转到修改帮厨
     */
    @RequestMapping("/qyChinfo_update/{qyChinfoId}")
    public String qyChinfoUpdate(@PathVariable String qyChinfoId, Model model) {
        QyChinfo qyChinfo = qyChinfoService.selectById(qyChinfoId);
        model.addAttribute("item",qyChinfo);
        LogObjectHolder.me().set(qyChinfo);
        return PREFIX + "qyChinfo_edit.html";
    }

    /**
     * 获取帮厨列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return qyChinfoService.selectList(null);
    }

    /**
     * 新增帮厨
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(QyChinfo qyChinfo) {
        qyChinfoService.insert(qyChinfo);
        return SUCCESS_TIP;
    }

    /**
     * 删除帮厨
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String qyChinfoId) {
        qyChinfoService.deleteById(qyChinfoId);
        return SUCCESS_TIP;
    }

    /**
     * 修改帮厨
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(QyChinfo qyChinfo) {
        qyChinfoService.updateById(qyChinfo);
        return SUCCESS_TIP;
    }

    /**
     * 帮厨详情
     */
    @RequestMapping(value = "/detail/{qyChinfoId}")
    @ResponseBody
    public Object detail(@PathVariable("qyChinfoId") String qyChinfoId) {
        return qyChinfoService.selectById(qyChinfoId);
    }
}
