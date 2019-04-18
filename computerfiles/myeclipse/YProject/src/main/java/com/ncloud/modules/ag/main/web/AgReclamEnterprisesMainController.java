/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.main.web;

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
import com.ncloud.modules.ag.main.entity.AgReclamEnterprisesMain;
import com.ncloud.modules.ag.main.service.AgReclamEnterprisesMainService;
/**
 * 吉林省重点建设农垦工业企业情况Controller
 * @author wangjiale
 * @version 2018-07-09
 */
@Controller
@RequestMapping(value = "${adminPath}/main/agReclamEnterprisesMain")
public class AgReclamEnterprisesMainController extends BaseController {

	AgReclamEnterprisesMainService bo=LfwLocator.getInstance().lookup(AgReclamEnterprisesMainService.class);
	@ModelAttribute
	public AgReclamEnterprisesMain get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("main:agReclamEnterprisesMain:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgReclamEnterprisesMain agReclamEnterprisesMain, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgReclamEnterprisesMain> page = bo.findPage(new Page<AgReclamEnterprisesMain>(request, response), agReclamEnterprisesMain); 
		model.addAttribute("page", page);
		model.addAttribute("agReclamEnterprisesMain", agReclamEnterprisesMain);
		return "ag/main/agReclamEnterprisesMainList";
	}

	//翻译参照
	private void setTranslate(AgReclamEnterprisesMain entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgReclamEnterprisesMain entity) {

	}
	
	@RequiresPermissions("main:agReclamEnterprisesMain:view")
	@RequestMapping(value = "form")
	public String form(AgReclamEnterprisesMain agReclamEnterprisesMain, Model model) {
		// 判断是否新增
		Object val = agReclamEnterprisesMain.getPrimaryKey();
		if (val == null) {
			setDefault(agReclamEnterprisesMain);
		}
		model.addAttribute("agReclamEnterprisesMain", agReclamEnterprisesMain);
		return "ag/main/agReclamEnterprisesMainForm";
	}

	@RequiresPermissions("main:agReclamEnterprisesMain:edit")
	@RequestMapping(value = "save")
	public String save(AgReclamEnterprisesMain agReclamEnterprisesMain, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agReclamEnterprisesMain)){
			return form(agReclamEnterprisesMain, model);
		}
		bo.save(agReclamEnterprisesMain);
		addMessage(redirectAttributes, "保存吉林省重点建设农垦工业企业情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/main/agReclamEnterprisesMain/?repage";
	}
	
	@RequiresPermissions("main:agReclamEnterprisesMain:edit")
	@RequestMapping(value = "delete")
	public String delete(AgReclamEnterprisesMain agReclamEnterprisesMain, RedirectAttributes redirectAttributes) {
		bo.delete(agReclamEnterprisesMain);
		addMessage(redirectAttributes, "删除吉林省重点建设农垦工业企业情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/main/agReclamEnterprisesMain/?repage";
	}

}