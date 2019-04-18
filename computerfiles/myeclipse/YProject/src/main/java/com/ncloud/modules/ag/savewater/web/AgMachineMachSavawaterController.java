/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.savewater.web;

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
import com.ncloud.modules.ag.savewater.entity.AgMachineMachSavawater;
import com.ncloud.modules.ag.savewater.service.AgMachineMachSavawaterService;
/**
 * 机械化节水保墒栽培技术项目Controller
 * @author wangjiale
 * @version 2018-07-06
 */
@Controller
@RequestMapping(value = "${adminPath}/savewater/agMachineMachSavawater")
public class AgMachineMachSavawaterController extends BaseController {

	AgMachineMachSavawaterService bo=LfwLocator.getInstance().lookup(AgMachineMachSavawaterService.class);
	@ModelAttribute
	public AgMachineMachSavawater get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("savewater:agMachineMachSavawater:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgMachineMachSavawater agMachineMachSavawater, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgMachineMachSavawater> page = bo.findPage(new Page<AgMachineMachSavawater>(request, response), agMachineMachSavawater); 
		model.addAttribute("page", page);
		model.addAttribute("agMachineMachSavawater", agMachineMachSavawater);
		return "ag/savewater/agMachineMachSavawaterList";
	}

	//翻译参照
	private void setTranslate(AgMachineMachSavawater entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgMachineMachSavawater entity) {

	}
	
	@RequiresPermissions("savewater:agMachineMachSavawater:view")
	@RequestMapping(value = "form")
	public String form(AgMachineMachSavawater agMachineMachSavawater, Model model) {
		// 判断是否新增
		Object val = agMachineMachSavawater.getPrimaryKey();
		if (val == null) {
			setDefault(agMachineMachSavawater);
		}
		model.addAttribute("agMachineMachSavawater", agMachineMachSavawater);
		return "ag/savewater/agMachineMachSavawaterForm";
	}

	@RequiresPermissions("savewater:agMachineMachSavawater:edit")
	@RequestMapping(value = "save")
	public String save(AgMachineMachSavawater agMachineMachSavawater, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agMachineMachSavawater)){
			return form(agMachineMachSavawater, model);
		}
		bo.save(agMachineMachSavawater);
		addMessage(redirectAttributes, "保存机械化节水保墒栽培技术项目完成情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/savewater/agMachineMachSavawater/?repage";
	}
	
	@RequiresPermissions("savewater:agMachineMachSavawater:edit")
	@RequestMapping(value = "delete")
	public String delete(AgMachineMachSavawater agMachineMachSavawater, RedirectAttributes redirectAttributes) {
		bo.delete(agMachineMachSavawater);
		addMessage(redirectAttributes, "删除机械化节水保墒栽培技术项目完成情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/savewater/agMachineMachSavawater/?repage";
	}

}