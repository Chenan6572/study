/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.engine.web;

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
import com.ncloud.modules.ag.engine.entity.AgMachineMechEngine;
import com.ncloud.modules.ag.engine.service.AgMachineMechEngineService;
/**
 * 吉林省各市州农用动力机Controller
 * @author wangjiale
 * @version 2018-07-05
 */
@Controller
@RequestMapping(value = "${adminPath}/engine/agMachineMechEngine")
public class AgMachineMechEngineController extends BaseController {

	AgMachineMechEngineService bo=LfwLocator.getInstance().lookup(AgMachineMechEngineService.class);
	@ModelAttribute
	public AgMachineMechEngine get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("engine:agMachineMechEngine:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgMachineMechEngine agMachineMechEngine, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgMachineMechEngine> page = bo.findPage(new Page<AgMachineMechEngine>(request, response), agMachineMechEngine); 
		model.addAttribute("page", page);
		model.addAttribute("agMachineMechEngine", agMachineMechEngine);
		return "ag/engine/agMachineMechEngineList";
	}

	//翻译参照
	private void setTranslate(AgMachineMechEngine entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgMachineMechEngine entity) {

	}
	
	@RequiresPermissions("engine:agMachineMechEngine:view")
	@RequestMapping(value = "form")
	public String form(AgMachineMechEngine agMachineMechEngine, Model model) {
		// 判断是否新增
		Object val = agMachineMechEngine.getPrimaryKey();
		if (val == null) {
			setDefault(agMachineMechEngine);
		}
		model.addAttribute("agMachineMechEngine", agMachineMechEngine);
		return "ag/engine/agMachineMechEngineForm";
	}

	@RequiresPermissions("engine:agMachineMechEngine:edit")
	@RequestMapping(value = "save")
	public String save(AgMachineMechEngine agMachineMechEngine, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agMachineMechEngine)){
			return form(agMachineMechEngine, model);
		}
		bo.save(agMachineMechEngine);
		addMessage(redirectAttributes, "保存吉林省各市州农用动力机统计表成功");
		return "redirect:"+Global.getAdminPath()+"/engine/agMachineMechEngine/?repage";
	}
	
	@RequiresPermissions("engine:agMachineMechEngine:edit")
	@RequestMapping(value = "delete")
	public String delete(AgMachineMechEngine agMachineMechEngine, RedirectAttributes redirectAttributes) {
		bo.delete(agMachineMechEngine);
		addMessage(redirectAttributes, "删除吉林省各市州农用动力机统计表成功");
		return "redirect:"+Global.getAdminPath()+"/engine/agMachineMechEngine/?repage";
	}

}