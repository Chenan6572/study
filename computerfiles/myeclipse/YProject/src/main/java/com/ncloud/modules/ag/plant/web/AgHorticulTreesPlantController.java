/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.plant.web;

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
import com.ncloud.modules.ag.plant.entity.AgHorticulTreesPlant;
import com.ncloud.modules.ag.plant.service.AgHorticulTreesPlantService;
/**
 * 吉林省果树栽植情况Controller
 * @author wangjiale
 * @version 2018-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/plant/agHorticulTreesPlant")
public class AgHorticulTreesPlantController extends BaseController {

	AgHorticulTreesPlantService bo=LfwLocator.getInstance().lookup(AgHorticulTreesPlantService.class);
	@ModelAttribute
	public AgHorticulTreesPlant get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("plant:agHorticulTreesPlant:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgHorticulTreesPlant agHorticulTreesPlant, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgHorticulTreesPlant> page = bo.findPage(new Page<AgHorticulTreesPlant>(request, response), agHorticulTreesPlant); 
		model.addAttribute("page", page);
		model.addAttribute("agHorticulTreesPlant", agHorticulTreesPlant);
		return "ag/plant/agHorticulTreesPlantList";
	}

	//翻译参照
	private void setTranslate(AgHorticulTreesPlant entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgHorticulTreesPlant entity) {

	}
	
	@RequiresPermissions("plant:agHorticulTreesPlant:view")
	@RequestMapping(value = "form")
	public String form(AgHorticulTreesPlant agHorticulTreesPlant, Model model) {
		// 判断是否新增
		Object val = agHorticulTreesPlant.getPrimaryKey();
		if (val == null) {
			setDefault(agHorticulTreesPlant);
		}
		model.addAttribute("agHorticulTreesPlant", agHorticulTreesPlant);
		return "ag/plant/agHorticulTreesPlantForm";
	}

	@RequiresPermissions("plant:agHorticulTreesPlant:edit")
	@RequestMapping(value = "save")
	public String save(AgHorticulTreesPlant agHorticulTreesPlant, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agHorticulTreesPlant)){
			return form(agHorticulTreesPlant, model);
		}
		bo.save(agHorticulTreesPlant);
		addMessage(redirectAttributes, "保存吉林省果树栽植情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/plant/agHorticulTreesPlant/?repage";
	}
	
	@RequiresPermissions("plant:agHorticulTreesPlant:edit")
	@RequestMapping(value = "delete")
	public String delete(AgHorticulTreesPlant agHorticulTreesPlant, RedirectAttributes redirectAttributes) {
		bo.delete(agHorticulTreesPlant);
		addMessage(redirectAttributes, "删除吉林省果树栽植情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/plant/agHorticulTreesPlant/?repage";
	}

}