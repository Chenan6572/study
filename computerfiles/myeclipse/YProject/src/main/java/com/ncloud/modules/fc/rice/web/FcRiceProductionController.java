/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.rice.web;

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
import com.ncloud.modules.fc.rice.entity.FcRiceProduction;
import com.ncloud.modules.fc.rice.service.FcRiceProductionService;
/**
 * 1986-2000年吉林省水稻面积产量Controller
 * @author wangjiale
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/rice/fcRiceProduction")
public class FcRiceProductionController extends BaseController {

	FcRiceProductionService bo=LfwLocator.getInstance().lookup(FcRiceProductionService.class);
	@ModelAttribute
	public FcRiceProduction get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("rice:fcRiceProduction:view")
	@RequestMapping(value = {"list", ""})
	public String list(FcRiceProduction fcRiceProduction, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FcRiceProduction> page = bo.findPage(new Page<FcRiceProduction>(request, response), fcRiceProduction); 
		model.addAttribute("page", page);
		model.addAttribute("fcRiceProduction", fcRiceProduction);
		return "fc/rice/fcRiceProductionList";
	}

	//翻译参照
	private void setTranslate(FcRiceProduction entity) {
		
	}
	//新增设置默认值
	private void setDefault(FcRiceProduction entity) {

	}
	
	@RequiresPermissions("rice:fcRiceProduction:view")
	@RequestMapping(value = "form")
	public String form(FcRiceProduction fcRiceProduction, Model model) {
		// 判断是否新增
		Object val = fcRiceProduction.getPrimaryKey();
		if (val == null) {
			setDefault(fcRiceProduction);
		}
		model.addAttribute("fcRiceProduction", fcRiceProduction);
		return "fc/rice/fcRiceProductionForm";
	}

	@RequiresPermissions("rice:fcRiceProduction:edit")
	@RequestMapping(value = "save")
	public String save(FcRiceProduction fcRiceProduction, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fcRiceProduction)){
			return form(fcRiceProduction, model);
		}
		bo.save(fcRiceProduction);
		addMessage(redirectAttributes, "保存1986-2000年吉林省水稻面积产量统计信息表成功");
		return "redirect:"+Global.getAdminPath()+"/rice/fcRiceProduction/?repage";
	}
	
	@RequiresPermissions("rice:fcRiceProduction:edit")
	@RequestMapping(value = "delete")
	public String delete(FcRiceProduction fcRiceProduction, RedirectAttributes redirectAttributes) {
		bo.delete(fcRiceProduction);
		addMessage(redirectAttributes, "删除1986-2000年吉林省水稻面积产量统计信息表成功");
		return "redirect:"+Global.getAdminPath()+"/rice/fcRiceProduction/?repage";
	}

}