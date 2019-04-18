/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.husbandry.web;

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
import com.ncloud.modules.ag.husbandry.entity.AgReclamhusbandry;
import com.ncloud.modules.ag.husbandry.service.AgReclamhusbandryService;
/**
 * 农垦企业畜牧业生产情况Controller
 * @author wangjiale
 * @version 2018-07-09
 */
@Controller
@RequestMapping(value = "${adminPath}/husbandry/agReclamhusbandry")
public class AgReclamhusbandryController extends BaseController {

	AgReclamhusbandryService bo=LfwLocator.getInstance().lookup(AgReclamhusbandryService.class);
	@ModelAttribute
	public AgReclamhusbandry get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("husbandry:agReclamhusbandry:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgReclamhusbandry agReclamhusbandry, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgReclamhusbandry> page = bo.findPage(new Page<AgReclamhusbandry>(request, response), agReclamhusbandry); 
		model.addAttribute("page", page);
		model.addAttribute("agReclamhusbandry", agReclamhusbandry);
		return "ag/husbandry/agReclamhusbandryList";
	}

	//翻译参照
	private void setTranslate(AgReclamhusbandry entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgReclamhusbandry entity) {

	}
	
	@RequiresPermissions("husbandry:agReclamhusbandry:view")
	@RequestMapping(value = "form")
	public String form(AgReclamhusbandry agReclamhusbandry, Model model) {
		// 判断是否新增
		Object val = agReclamhusbandry.getPrimaryKey();
		if (val == null) {
			setDefault(agReclamhusbandry);
		}
		model.addAttribute("agReclamhusbandry", agReclamhusbandry);
		return "ag/husbandry/agReclamhusbandryForm";
	}

	@RequiresPermissions("husbandry:agReclamhusbandry:edit")
	@RequestMapping(value = "save")
	public String save(AgReclamhusbandry agReclamhusbandry, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agReclamhusbandry)){
			return form(agReclamhusbandry, model);
		}
		bo.save(agReclamhusbandry);
		addMessage(redirectAttributes, "保存农垦企业畜牧业生产情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/husbandry/agReclamhusbandry/?repage";
	}
	
	@RequiresPermissions("husbandry:agReclamhusbandry:edit")
	@RequestMapping(value = "delete")
	public String delete(AgReclamhusbandry agReclamhusbandry, RedirectAttributes redirectAttributes) {
		bo.delete(agReclamhusbandry);
		addMessage(redirectAttributes, "删除农垦企业畜牧业生产情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/husbandry/agReclamhusbandry/?repage";
	}

}