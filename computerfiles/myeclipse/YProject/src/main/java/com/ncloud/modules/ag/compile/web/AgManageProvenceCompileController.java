/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.compile.web;

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
import com.ncloud.modules.ag.compile.entity.AgManageProvenceCompile;
import com.ncloud.modules.ag.compile.service.AgManageProvenceCompileService;
/**
 * 农委（农业厅）指数事业单位编制Controller
 * @author wangjiale
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "${adminPath}/compile/agManageProvenceCompile")
public class AgManageProvenceCompileController extends BaseController {

	AgManageProvenceCompileService bo=LfwLocator.getInstance().lookup(AgManageProvenceCompileService.class);
	@ModelAttribute
	public AgManageProvenceCompile get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("compile:agManageProvenceCompile:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgManageProvenceCompile agManageProvenceCompile, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgManageProvenceCompile> page = bo.findPage(new Page<AgManageProvenceCompile>(request, response), agManageProvenceCompile); 
		model.addAttribute("page", page);
		model.addAttribute("agManageProvenceCompile", agManageProvenceCompile);
		return "ag/compile/agManageProvenceCompileList";
	}

	//翻译参照
	private void setTranslate(AgManageProvenceCompile entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgManageProvenceCompile entity) {

	}
	
	@RequiresPermissions("compile:agManageProvenceCompile:view")
	@RequestMapping(value = "form")
	public String form(AgManageProvenceCompile agManageProvenceCompile, Model model) {
		// 判断是否新增
		Object val = agManageProvenceCompile.getPrimaryKey();
		if (val == null) {
			setDefault(agManageProvenceCompile);
		}
		model.addAttribute("agManageProvenceCompile", agManageProvenceCompile);
		return "ag/compile/agManageProvenceCompileForm";
	}

	@RequiresPermissions("compile:agManageProvenceCompile:edit")
	@RequestMapping(value = "save")
	public String save(AgManageProvenceCompile agManageProvenceCompile, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agManageProvenceCompile)){
			return form(agManageProvenceCompile, model);
		}
		bo.save(agManageProvenceCompile);
		addMessage(redirectAttributes, "保存农委（农业厅）指数事业单位编制统计表成功");
		return "redirect:"+Global.getAdminPath()+"/compile/agManageProvenceCompile/?repage";
	}
	
	@RequiresPermissions("compile:agManageProvenceCompile:edit")
	@RequestMapping(value = "delete")
	public String delete(AgManageProvenceCompile agManageProvenceCompile, RedirectAttributes redirectAttributes) {
		bo.delete(agManageProvenceCompile);
		addMessage(redirectAttributes, "删除农委（农业厅）指数事业单位编制统计表成功");
		return "redirect:"+Global.getAdminPath()+"/compile/agManageProvenceCompile/?repage";
	}

}