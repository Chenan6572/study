/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.yaoxie.web;

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
import com.ncloud.modules.ag.yaoxie.entity.AgTechnicalProtectionYaoxie;
import com.ncloud.modules.ag.yaoxie.service.AgTechnicalProtectionYaoxieService;
/**
 * 病虫害发生防治面积和农药使用量Controller
 * @author wangjiale
 * @version 2018-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/yaoxie/agTechnicalProtectionYaoxie")
public class AgTechnicalProtectionYaoxieController extends BaseController {

	AgTechnicalProtectionYaoxieService bo=LfwLocator.getInstance().lookup(AgTechnicalProtectionYaoxieService.class);
	@ModelAttribute
	public AgTechnicalProtectionYaoxie get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("yaoxie:agTechnicalProtectionYaoxie:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgTechnicalProtectionYaoxie> page = bo.findPage(new Page<AgTechnicalProtectionYaoxie>(request, response), agTechnicalProtectionYaoxie); 
		model.addAttribute("page", page);
		model.addAttribute("agTechnicalProtectionYaoxie", agTechnicalProtectionYaoxie);
		return "ag/yaoxie/agTechnicalProtectionYaoxieList";
	}

	//翻译参照
	private void setTranslate(AgTechnicalProtectionYaoxie entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgTechnicalProtectionYaoxie entity) {

	}
	
	@RequiresPermissions("yaoxie:agTechnicalProtectionYaoxie:view")
	@RequestMapping(value = "form")
	public String form(AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie, Model model) {
		// 判断是否新增
		Object val = agTechnicalProtectionYaoxie.getPrimaryKey();
		if (val == null) {
			setDefault(agTechnicalProtectionYaoxie);
		}
		model.addAttribute("agTechnicalProtectionYaoxie", agTechnicalProtectionYaoxie);
		return "ag/yaoxie/agTechnicalProtectionYaoxieForm";
	}

	@RequiresPermissions("yaoxie:agTechnicalProtectionYaoxie:edit")
	@RequestMapping(value = "save")
	public String save(AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agTechnicalProtectionYaoxie)){
			return form(agTechnicalProtectionYaoxie, model);
		}
		bo.save(agTechnicalProtectionYaoxie);
		addMessage(redirectAttributes, "保存病虫害发生防治面积和农药使用量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/yaoxie/agTechnicalProtectionYaoxie/?repage";
	}
	
	@RequiresPermissions("yaoxie:agTechnicalProtectionYaoxie:edit")
	@RequestMapping(value = "delete")
	public String delete(AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie, RedirectAttributes redirectAttributes) {
		bo.delete(agTechnicalProtectionYaoxie);
		addMessage(redirectAttributes, "删除病虫害发生防治面积和农药使用量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/yaoxie/agTechnicalProtectionYaoxie/?repage";
	}

}