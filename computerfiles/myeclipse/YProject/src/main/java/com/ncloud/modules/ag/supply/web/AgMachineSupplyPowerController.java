/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.supply.web;

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
import com.ncloud.modules.supply.entity.AgMachineSupplyPower;
import com.ncloud.modules.supply.service.AgMachineSupplyPowerService;
/**
 * 农机供应系统排灌Controller
 * @author wangjiale
 * @version 2018-07-06
 */
@Controller
@RequestMapping(value = "${adminPath}/supply/agMachineSupplyPower")
public class AgMachineSupplyPowerController extends BaseController {

	AgMachineSupplyPowerService bo=LfwLocator.getInstance().lookup(AgMachineSupplyPowerService.class);
	@ModelAttribute
	public AgMachineSupplyPower get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("supply:agMachineSupplyPower:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgMachineSupplyPower agMachineSupplyPower, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgMachineSupplyPower> page = bo.findPage(new Page<AgMachineSupplyPower>(request, response), agMachineSupplyPower); 
		model.addAttribute("page", page);
		model.addAttribute("agMachineSupplyPower", agMachineSupplyPower);
		return "modules/supply/agMachineSupplyPowerList";
	}

	//翻译参照
	private void setTranslate(AgMachineSupplyPower entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgMachineSupplyPower entity) {

	}
	
	@RequiresPermissions("supply:agMachineSupplyPower:view")
	@RequestMapping(value = "form")
	public String form(AgMachineSupplyPower agMachineSupplyPower, Model model) {
		// 判断是否新增
		Object val = agMachineSupplyPower.getPrimaryKey();
		if (val == null) {
			setDefault(agMachineSupplyPower);
		}
		model.addAttribute("agMachineSupplyPower", agMachineSupplyPower);
		return "modules/supply/agMachineSupplyPowerForm";
	}

	@RequiresPermissions("supply:agMachineSupplyPower:edit")
	@RequestMapping(value = "save")
	public String save(AgMachineSupplyPower agMachineSupplyPower, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agMachineSupplyPower)){
			return form(agMachineSupplyPower, model);
		}
		bo.save(agMachineSupplyPower);
		addMessage(redirectAttributes, "保存农机供应系统排灌动力机械统计表成功");
		return "redirect:"+Global.getAdminPath()+"/supply/agMachineSupplyPower/?repage";
	}
	
	@RequiresPermissions("supply:agMachineSupplyPower:edit")
	@RequestMapping(value = "delete")
	public String delete(AgMachineSupplyPower agMachineSupplyPower, RedirectAttributes redirectAttributes) {
		bo.delete(agMachineSupplyPower);
		addMessage(redirectAttributes, "删除农机供应系统排灌动力机械统计表成功");
		return "redirect:"+Global.getAdminPath()+"/supply/agMachineSupplyPower/?repage";
	}

}