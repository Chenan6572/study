/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.apple.web;

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
import com.ncloud.modules.ag.apple.entity.AgHorticulTreesDiseases;
import com.ncloud.modules.ag.apple.service.AgHorticulTreesDiseasesService;
/**
 * 苹果主要病虫害防治Controller
 * @author wangjiale
 * @version 2018-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/apple/agHorticulTreesDiseases")
public class AgHorticulTreesDiseasesController extends BaseController {

	AgHorticulTreesDiseasesService bo=LfwLocator.getInstance().lookup(AgHorticulTreesDiseasesService.class);
	@ModelAttribute
	public AgHorticulTreesDiseases get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("apple:agHorticulTreesDiseases:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgHorticulTreesDiseases agHorticulTreesDiseases, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgHorticulTreesDiseases> page = bo.findPage(new Page<AgHorticulTreesDiseases>(request, response), agHorticulTreesDiseases); 
		model.addAttribute("page", page);
		model.addAttribute("agHorticulTreesDiseases", agHorticulTreesDiseases);
		return "ag/apple/agHorticulTreesDiseasesList";
	}

	//翻译参照
	private void setTranslate(AgHorticulTreesDiseases entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgHorticulTreesDiseases entity) {

	}
	
	@RequiresPermissions("apple:agHorticulTreesDiseases:view")
	@RequestMapping(value = "form")
	public String form(AgHorticulTreesDiseases agHorticulTreesDiseases, Model model) {
		// 判断是否新增
		Object val = agHorticulTreesDiseases.getPrimaryKey();
		if (val == null) {
			setDefault(agHorticulTreesDiseases);
		}
		model.addAttribute("agHorticulTreesDiseases", agHorticulTreesDiseases);
		return "ag/apple/agHorticulTreesDiseasesForm";
	}

	@RequiresPermissions("apple:agHorticulTreesDiseases:edit")
	@RequestMapping(value = "save")
	public String save(AgHorticulTreesDiseases agHorticulTreesDiseases, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agHorticulTreesDiseases)){
			return form(agHorticulTreesDiseases, model);
		}
		bo.save(agHorticulTreesDiseases);
		addMessage(redirectAttributes, "保存苹果主要病虫害防治一览表成功");
		return "redirect:"+Global.getAdminPath()+"/apple/agHorticulTreesDiseases/?repage";
	}
	
	@RequiresPermissions("apple:agHorticulTreesDiseases:edit")
	@RequestMapping(value = "delete")
	public String delete(AgHorticulTreesDiseases agHorticulTreesDiseases, RedirectAttributes redirectAttributes) {
		bo.delete(agHorticulTreesDiseases);
		addMessage(redirectAttributes, "删除苹果主要病虫害防治一览表成功");
		return "redirect:"+Global.getAdminPath()+"/apple/agHorticulTreesDiseases/?repage";
	}

}