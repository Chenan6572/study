/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.redginseng.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.sunsd.lfw.common.config.Global;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.web.BaseController;
import com.ncloud.modules.ag.redginseng.entity.YFamily;
import com.ncloud.modules.ag.redginseng.service.YFamilyService;
/**
 * 1988年长白山红参（抚宝牌）系列品种销售价格表Controller
 * @author wangjiale
 * @version 2018-07-02
 */
@Controller
@RequestMapping(value = "${adminPath}/redginseng/yFamily")
public class YFamilyController extends BaseController {

	YFamilyService bo=LfwLocator.getInstance().lookup(YFamilyService.class);
	@ModelAttribute
	public YFamily get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("redginseng:yFamily:view")
	@RequestMapping(value = {"list", ""})
	public String list(YFamily yFamily, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<YFamily> page = bo.findPage(new Page<YFamily>(request, response), yFamily); 
		model.addAttribute("page", page);
		model.addAttribute("yFamily", yFamily);
		return "ag/redginseng/yFamilyList";
	}

	//翻译参照
	private void setTranslate(YFamily entity) {
		
	}
	//新增设置默认值
	private void setDefault(YFamily entity) {

	}
	
	@RequiresPermissions("redginseng:yFamily:view")
	@RequestMapping(value = "form")
	public String form(YFamily yFamily, Model model) {
		// 判断是否新增
		Object val = yFamily.getPrimaryKey();
		if (val == null) {
			setDefault(yFamily);
		}
		model.addAttribute("yFamily", yFamily);
		return "ag/redginseng/yFamilyForm";
	}

	@RequiresPermissions("redginseng:yFamily:edit")
	@RequestMapping(value = "save")
	public String save(YFamily yFamily, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, yFamily)){
			return form(yFamily, model);
		}
		bo.save(yFamily);
		addMessage(redirectAttributes, "保存1988年长白山红参（抚宝牌）系列品种销售价格表成功");
		return "redirect:"+Global.getAdminPath()+"/redginseng/yFamily/?repage";
	}
	
	@RequiresPermissions("redginseng:yFamily:edit")
	@RequestMapping(value = "delete")
	public String delete(YFamily yFamily, RedirectAttributes redirectAttributes) {
		bo.delete(yFamily);
		addMessage(redirectAttributes, "删除1988年长白山红参（抚宝牌）系列品种销售价格表成功");
		return "redirect:"+Global.getAdminPath()+"/redginseng/yFamily/?repage";
	}

}