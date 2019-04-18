/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.deer.web;

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
import com.ncloud.modules.ag.deer.entity.AgReclamScaleDeer;
import com.ncloud.modules.ag.deer.service.AgReclamScaleDeerService;
/**
 * 2000年吉林省国有鹿场情况Controller
 * @author wangjiale
 * @version 2018-07-06
 */
@Controller
@RequestMapping(value = "${adminPath}/deer/agReclamScaleDeer")
public class AgReclamScaleDeerController extends BaseController {

	AgReclamScaleDeerService bo=LfwLocator.getInstance().lookup(AgReclamScaleDeerService.class);
	@ModelAttribute
	public AgReclamScaleDeer get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("deer:agReclamScaleDeer:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgReclamScaleDeer agReclamScaleDeer, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgReclamScaleDeer> page = bo.findPage(new Page<AgReclamScaleDeer>(request, response), agReclamScaleDeer); 
		model.addAttribute("page", page);
		model.addAttribute("agReclamScaleDeer", agReclamScaleDeer);
		return "ag/deer/agReclamScaleDeerList";
	}

	//翻译参照
	private void setTranslate(AgReclamScaleDeer entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgReclamScaleDeer entity) {

	}
	
	@RequiresPermissions("deer:agReclamScaleDeer:view")
	@RequestMapping(value = "form")
	public String form(AgReclamScaleDeer agReclamScaleDeer, Model model) {
		// 判断是否新增
		Object val = agReclamScaleDeer.getPrimaryKey();
		if (val == null) {
			setDefault(agReclamScaleDeer);
		}
		model.addAttribute("agReclamScaleDeer", agReclamScaleDeer);
		return "ag/deer/agReclamScaleDeerForm";
	}

	@RequiresPermissions("deer:agReclamScaleDeer:edit")
	@RequestMapping(value = "save")
	public String save(AgReclamScaleDeer agReclamScaleDeer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agReclamScaleDeer)){
			return form(agReclamScaleDeer, model);
		}
		bo.save(agReclamScaleDeer);
		addMessage(redirectAttributes, "保存2000年吉林省国有鹿场情况明细表成功");
		return "redirect:"+Global.getAdminPath()+"/deer/agReclamScaleDeer/?repage";
	}
	
	@RequiresPermissions("deer:agReclamScaleDeer:edit")
	@RequestMapping(value = "delete")
	public String delete(AgReclamScaleDeer agReclamScaleDeer, RedirectAttributes redirectAttributes) {
		bo.delete(agReclamScaleDeer);
		addMessage(redirectAttributes, "删除2000年吉林省国有鹿场情况明细表成功");
		return "redirect:"+Global.getAdminPath()+"/deer/agReclamScaleDeer/?repage";
	}

}