/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.fertilizer.web;

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
import com.ncloud.modules.ag.fertilizer.entity.AgTechnicalManureFertilizer;
import com.ncloud.modules.ag.fertilizer.service.AgTechnicalManureFertilizerService;
/**
 * 农业化肥施用量统计Controller
 * @author wangjaile
 * @version 2018-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/fertilizer/agTechnicalManureFertilizer")
public class AgTechnicalManureFertilizerController extends BaseController {

	AgTechnicalManureFertilizerService bo=LfwLocator.getInstance().lookup(AgTechnicalManureFertilizerService.class);
	@ModelAttribute
	public AgTechnicalManureFertilizer get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("fertilizer:agTechnicalManureFertilizer:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgTechnicalManureFertilizer agTechnicalManureFertilizer, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgTechnicalManureFertilizer> page = bo.findPage(new Page<AgTechnicalManureFertilizer>(request, response), agTechnicalManureFertilizer); 
		model.addAttribute("page", page);
		model.addAttribute("agTechnicalManureFertilizer", agTechnicalManureFertilizer);
		return "ag/fertilizer/agTechnicalManureFertilizerList";
	}

	//翻译参照
	private void setTranslate(AgTechnicalManureFertilizer entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgTechnicalManureFertilizer entity) {

	}
	
	@RequiresPermissions("fertilizer:agTechnicalManureFertilizer:view")
	@RequestMapping(value = "form")
	public String form(AgTechnicalManureFertilizer agTechnicalManureFertilizer, Model model) {
		// 判断是否新增
		Object val = agTechnicalManureFertilizer.getPrimaryKey();
		if (val == null) {
			setDefault(agTechnicalManureFertilizer);
		}
		model.addAttribute("agTechnicalManureFertilizer", agTechnicalManureFertilizer);
		return "ag/fertilizer/agTechnicalManureFertilizerForm";
	}

	@RequiresPermissions("fertilizer:agTechnicalManureFertilizer:edit")
	@RequestMapping(value = "save")
	public String save(AgTechnicalManureFertilizer agTechnicalManureFertilizer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agTechnicalManureFertilizer)){
			return form(agTechnicalManureFertilizer, model);
		}
		bo.save(agTechnicalManureFertilizer);
		addMessage(redirectAttributes, "保存农业化肥施用量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/fertilizer/agTechnicalManureFertilizer/?repage";
	}
	
	@RequiresPermissions("fertilizer:agTechnicalManureFertilizer:edit")
	@RequestMapping(value = "delete")
	public String delete(AgTechnicalManureFertilizer agTechnicalManureFertilizer, RedirectAttributes redirectAttributes) {
		bo.delete(agTechnicalManureFertilizer);
		addMessage(redirectAttributes, "删除农业化肥施用量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/fertilizer/agTechnicalManureFertilizer/?repage";
	}

}