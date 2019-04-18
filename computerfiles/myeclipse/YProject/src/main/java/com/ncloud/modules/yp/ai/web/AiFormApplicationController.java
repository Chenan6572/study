/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.yp.ai.web;

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
import com.ncloud.modules.yp.ai.entity.AiFormApplication;
import com.ncloud.modules.yp.ai.service.AiFormApplicationService;
/**
 * 百度AI开放平台Controller
 * @author wangjiale
 * @version 2018-06-28
 */
@Controller
@RequestMapping(value = "${adminPath}/ai/aiFormApplication")
public class AiFormApplicationController extends BaseController {

	AiFormApplicationService bo=LfwLocator.getInstance().lookup(AiFormApplicationService.class);
	@ModelAttribute
	public AiFormApplication get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("ai:aiFormApplication:view")
	@RequestMapping(value = {"list", ""})
	public String list(AiFormApplication aiFormApplication, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AiFormApplication> page = bo.findPage(new Page<AiFormApplication>(request, response), aiFormApplication); 
		model.addAttribute("page", page);
		model.addAttribute("aiFormApplication", aiFormApplication);
		return "yp/ai/aiFormApplicationList";
	}

	//翻译参照
	private void setTranslate(AiFormApplication entity) {
		
	}
	//新增设置默认值
	private void setDefault(AiFormApplication entity) {

	}
	
	@RequiresPermissions("ai:aiFormApplication:view")
	@RequestMapping(value = "form")
	public String form(AiFormApplication aiFormApplication, Model model) {
		// 判断是否新增
		Object val = aiFormApplication.getPrimaryKey();
		if (val == null) {
			setDefault(aiFormApplication);
		}
		model.addAttribute("aiFormApplication", aiFormApplication);
		return "yp/ai/aiFormApplicationForm";
	}

	@RequiresPermissions("ai:aiFormApplication:edit")
	@RequestMapping(value = "save")
	public String save(AiFormApplication aiFormApplication, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, aiFormApplication)){
			return form(aiFormApplication, model);
		}
		bo.save(aiFormApplication);
		addMessage(redirectAttributes, "保存百度AI开放平台成功");
		return "redirect:"+Global.getAdminPath()+"/ai/aiFormApplication/?repage";
	}
	
	@RequiresPermissions("ai:aiFormApplication:edit")
	@RequestMapping(value = "delete")
	public String delete(AiFormApplication aiFormApplication, RedirectAttributes redirectAttributes) {
		bo.delete(aiFormApplication);
		addMessage(redirectAttributes, "删除百度AI开放平台成功");
		return "redirect:"+Global.getAdminPath()+"/ai/aiFormApplication/?repage";
	}

}