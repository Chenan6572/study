/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.export.web;

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
import com.ncloud.modules.ag.export.entity.AgReclamEnterpriseExport;
import com.ncloud.modules.ag.export.service.AgReclamEnterpriseExportService;
/**
 * 农垦外贸出口商品情况Controller
 * @author wangjiale
 * @version 2018-07-10
 */
@Controller
@RequestMapping(value = "${adminPath}/export/agReclamEnterpriseExport")
public class AgReclamEnterpriseExportController extends BaseController {

	AgReclamEnterpriseExportService bo=LfwLocator.getInstance().lookup(AgReclamEnterpriseExportService.class);
	@ModelAttribute
	public AgReclamEnterpriseExport get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("export:agReclamEnterpriseExport:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgReclamEnterpriseExport agReclamEnterpriseExport, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgReclamEnterpriseExport> page = bo.findPage(new Page<AgReclamEnterpriseExport>(request, response), agReclamEnterpriseExport); 
		model.addAttribute("page", page);
		model.addAttribute("agReclamEnterpriseExport", agReclamEnterpriseExport);
		return "ag/export/agReclamEnterpriseExportList";
	}

	//翻译参照
	private void setTranslate(AgReclamEnterpriseExport entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgReclamEnterpriseExport entity) {

	}
	
	@RequiresPermissions("export:agReclamEnterpriseExport:view")
	@RequestMapping(value = "form")
	public String form(AgReclamEnterpriseExport agReclamEnterpriseExport, Model model) {
		// 判断是否新增
		Object val = agReclamEnterpriseExport.getPrimaryKey();
		if (val == null) {
			setDefault(agReclamEnterpriseExport);
		}
		model.addAttribute("agReclamEnterpriseExport", agReclamEnterpriseExport);
		return "ag/export/agReclamEnterpriseExportForm";
	}

	@RequiresPermissions("export:agReclamEnterpriseExport:edit")
	@RequestMapping(value = "save")
	public String save(AgReclamEnterpriseExport agReclamEnterpriseExport, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agReclamEnterpriseExport)){
			return form(agReclamEnterpriseExport, model);
		}
		bo.save(agReclamEnterpriseExport);
		addMessage(redirectAttributes, "保存农垦外贸出口商品情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/export/agReclamEnterpriseExport/?repage";
	}
	
	@RequiresPermissions("export:agReclamEnterpriseExport:edit")
	@RequestMapping(value = "delete")
	public String delete(AgReclamEnterpriseExport agReclamEnterpriseExport, RedirectAttributes redirectAttributes) {
		bo.delete(agReclamEnterpriseExport);
		addMessage(redirectAttributes, "删除农垦外贸出口商品情况统计表成功");
		return "redirect:"+Global.getAdminPath()+"/export/agReclamEnterpriseExport/?repage";
	}

}