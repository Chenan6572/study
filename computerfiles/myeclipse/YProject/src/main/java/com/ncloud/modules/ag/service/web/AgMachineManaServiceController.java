/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.service.web;

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
import com.ncloud.modules.ag.service.entity.AgMachineManaService;
import com.ncloud.modules.ag.service.service.AgMachineManaServiceService;
/**
 * 吉林省乡、村农机化服务组织服务情况Controller
 * @author wangjiale
 * @version 2018-07-06
 */
@Controller
@RequestMapping(value = "${adminPath}/service/agMachineManaService")
public class AgMachineManaServiceController extends BaseController {

	AgMachineManaServiceService bo=LfwLocator.getInstance().lookup(AgMachineManaServiceService.class);
	@ModelAttribute
	public AgMachineManaService get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("service:agMachineManaService:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgMachineManaService agMachineManaService, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgMachineManaService> page = bo.findPage(new Page<AgMachineManaService>(request, response), agMachineManaService); 
		model.addAttribute("page", page);
		model.addAttribute("agMachineManaService", agMachineManaService);
		return "ag/service/agMachineManaServiceList";
	}

	//翻译参照
	private void setTranslate(AgMachineManaService entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgMachineManaService entity) {

	}
	
	@RequiresPermissions("service:agMachineManaService:view")
	@RequestMapping(value = "form")
	public String form(AgMachineManaService agMachineManaService, Model model) {
		// 判断是否新增
		Object val = agMachineManaService.getPrimaryKey();
		if (val == null) {
			setDefault(agMachineManaService);
		}
		model.addAttribute("agMachineManaService", agMachineManaService);
		return "ag/service/agMachineManaServiceForm";
	}

	@RequiresPermissions("service:agMachineManaService:edit")
	@RequestMapping(value = "save")
	public String save(AgMachineManaService agMachineManaService, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agMachineManaService)){
			return form(agMachineManaService, model);
		}
		bo.save(agMachineManaService);
		addMessage(redirectAttributes, "保存吉林省乡、村农机化服务组织服务情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/service/agMachineManaService/?repage";
	}
	
	@RequiresPermissions("service:agMachineManaService:edit")
	@RequestMapping(value = "delete")
	public String delete(AgMachineManaService agMachineManaService, RedirectAttributes redirectAttributes) {
		bo.delete(agMachineManaService);
		addMessage(redirectAttributes, "删除吉林省乡、村农机化服务组织服务情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/service/agMachineManaService/?repage";
	}

}