/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ec.sugerbeet.web;

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
import com.ncloud.modules.ec.sugerbeet.entity.EcSugerbeetProduction;
import com.ncloud.modules.ec.sugerbeet.service.EcSugerbeetProductionService;
/**
 * 1986-2000年吉林省甜菜生产统计Controller
 * @author wangjiale
 * @version 2018-06-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sugerbeet/ecSugerbeetProduction")
public class EcSugerbeetProductionController extends BaseController {

	EcSugerbeetProductionService bo=LfwLocator.getInstance().lookup(EcSugerbeetProductionService.class);
	@ModelAttribute
	public EcSugerbeetProduction get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("sugerbeet:ecSugerbeetProduction:view")
	@RequestMapping(value = {"list", ""})
	public String list(EcSugerbeetProduction ecSugerbeetProduction, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<EcSugerbeetProduction> page = bo.findPage(new Page<EcSugerbeetProduction>(request, response), ecSugerbeetProduction); 
		model.addAttribute("page", page);
		model.addAttribute("ecSugerbeetProduction", ecSugerbeetProduction);
		return "ec/sugerbeet/ecSugerbeetProductionList";
	}

	//翻译参照
	private void setTranslate(EcSugerbeetProduction entity) {
		
	}
	//新增设置默认值
	private void setDefault(EcSugerbeetProduction entity) {

	}
	
	@RequiresPermissions("sugerbeet:ecSugerbeetProduction:view")
	@RequestMapping(value = "form")
	public String form(EcSugerbeetProduction ecSugerbeetProduction, Model model) {
		// 判断是否新增
		Object val = ecSugerbeetProduction.getPrimaryKey();
		if (val == null) {
			setDefault(ecSugerbeetProduction);
		}
		model.addAttribute("ecSugerbeetProduction", ecSugerbeetProduction);
		return "ec/sugerbeet/ecSugerbeetProductionForm";
	}

	@RequiresPermissions("sugerbeet:ecSugerbeetProduction:edit")
	@RequestMapping(value = "save")
	public String save(EcSugerbeetProduction ecSugerbeetProduction, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, ecSugerbeetProduction)){
			return form(ecSugerbeetProduction, model);
		}
		bo.save(ecSugerbeetProduction);
		addMessage(redirectAttributes, "保存1986-2000年吉林省甜菜生产统计表成功");
		return "redirect:"+Global.getAdminPath()+"/sugerbeet/ecSugerbeetProduction/?repage";
	}
	
	@RequiresPermissions("sugerbeet:ecSugerbeetProduction:edit")
	@RequestMapping(value = "delete")
	public String delete(EcSugerbeetProduction ecSugerbeetProduction, RedirectAttributes redirectAttributes) {
		bo.delete(ecSugerbeetProduction);
		addMessage(redirectAttributes, "删除1986-2000年吉林省甜菜生产统计表成功");
		return "redirect:"+Global.getAdminPath()+"/sugerbeet/ecSugerbeetProduction/?repage";
	}

}