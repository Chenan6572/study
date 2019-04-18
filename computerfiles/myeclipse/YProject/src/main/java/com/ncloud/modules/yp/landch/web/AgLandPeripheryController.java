/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.yp.landch.web;

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
import com.ncloud.modules.yp.landch.entity.AgLandPeriphery;
import com.ncloud.modules.yp.landch.service.AgLandPeripheryService;
/**
 * 土地利用信息表Controller
 * @author wangjiale
 * @version 2018-06-13
 */
@Controller
@RequestMapping(value = "${adminPath}/landch/agLandPeriphery")
public class AgLandPeripheryController extends BaseController {

	AgLandPeripheryService bo=LfwLocator.getInstance().lookup(AgLandPeripheryService.class);
	@ModelAttribute
	public AgLandPeriphery get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("landch:agLandPeriphery:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgLandPeriphery agLandPeriphery, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgLandPeriphery> page = bo.findPage(new Page<AgLandPeriphery>(request, response), agLandPeriphery); 
		model.addAttribute("page", page);
		model.addAttribute("agLandPeriphery", agLandPeriphery);
		return "yp/landch/agLandPeripheryList";
	}

	//翻译参照
	private void setTranslate(AgLandPeriphery entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgLandPeriphery entity) {

	}
	
	@RequiresPermissions("landch:agLandPeriphery:view")
	@RequestMapping(value = "form")
	public String form(AgLandPeriphery agLandPeriphery, Model model) {
		// 判断是否新增
		Object val = agLandPeriphery.getPrimaryKey();
		if (val == null) {
			setDefault(agLandPeriphery);
		}
		model.addAttribute("agLandPeriphery", agLandPeriphery);
		return "yp/landch/agLandPeripheryForm";
	}

	@RequiresPermissions("landch:agLandPeriphery:edit")
	@RequestMapping(value = "save")
	public String save(AgLandPeriphery agLandPeriphery, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agLandPeriphery)){
			return form(agLandPeriphery, model);
		}
		bo.save(agLandPeriphery);
		addMessage(redirectAttributes, "保存土地利用信息成功");
		return "redirect:"+Global.getAdminPath()+"/landch/agLandPeriphery/?repage";
	}
	
	@RequiresPermissions("landch:agLandPeriphery:edit")
	@RequestMapping(value = "delete")
	public String delete(AgLandPeriphery agLandPeriphery, RedirectAttributes redirectAttributes) {
		bo.delete(agLandPeriphery);
		addMessage(redirectAttributes, "删除土地利用信息成功");
		return "redirect:"+Global.getAdminPath()+"/landch/agLandPeriphery/?repage";
	}

}