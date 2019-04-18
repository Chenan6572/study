/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.production.web;

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
import com.ncloud.modules.ag.production.entity.AgSpeCocoPro;
import com.ncloud.modules.ag.production.service.AgSpeCocoProService;
/**
 * 吉林省蚕茧生产情况统计表Controller
 * @author wangjiale
 * @version 2018-07-03
 */
@Controller
@RequestMapping(value = "${adminPath}/production/agSpeCocoPro")
public class AgSpeCocoProController extends BaseController {

	AgSpeCocoProService bo=LfwLocator.getInstance().lookup(AgSpeCocoProService.class);
	@ModelAttribute
	public AgSpeCocoPro get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("production:agSpeCocoPro:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgSpeCocoPro agSpeCocoPro, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgSpeCocoPro> page = bo.findPage(new Page<AgSpeCocoPro>(request, response), agSpeCocoPro); 
		model.addAttribute("page", page);
		model.addAttribute("agSpeCocoPro", agSpeCocoPro);
		return "ag/production/agSpeCocoProList";
	}

	//翻译参照
	private void setTranslate(AgSpeCocoPro entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgSpeCocoPro entity) {

	}
	
	@RequiresPermissions("production:agSpeCocoPro:view")
	@RequestMapping(value = "form")
	public String form(AgSpeCocoPro agSpeCocoPro, Model model) {
		// 判断是否新增
		Object val = agSpeCocoPro.getPrimaryKey();
		if (val == null) {
			setDefault(agSpeCocoPro);
		}
		model.addAttribute("agSpeCocoPro", agSpeCocoPro);
		return "ag/production/agSpeCocoProForm";
	}

	@RequiresPermissions("production:agSpeCocoPro:edit")
	@RequestMapping(value = "save")
	public String save(AgSpeCocoPro agSpeCocoPro, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agSpeCocoPro)){
			return form(agSpeCocoPro, model);
		}
		bo.save(agSpeCocoPro);
		addMessage(redirectAttributes, "保存吉林省蚕茧生产情况统计成功");
		return "redirect:"+Global.getAdminPath()+"/production/agSpeCocoPro/?repage";
	}
	
	@RequiresPermissions("production:agSpeCocoPro:edit")
	@RequestMapping(value = "delete")
	public String delete(AgSpeCocoPro agSpeCocoPro, RedirectAttributes redirectAttributes) {
		bo.delete(agSpeCocoPro);
		addMessage(redirectAttributes, "删除吉林省蚕茧生产情况统计成功");
		return "redirect:"+Global.getAdminPath()+"/production/agSpeCocoPro/?repage";
	}

}