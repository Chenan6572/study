/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.millet.web;

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
import com.ncloud.modules.fc.millet.entity.FcMilletMilletarea;
import com.ncloud.modules.fc.millet.service.FcMilletMilletareaService;
/**
 * 1986-2000年吉林省谷子播种面积及产量Controller
 * @author wangjiale
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/millet/fcMilletMilletarea")
public class FcMilletMilletareaController extends BaseController {

	FcMilletMilletareaService bo=LfwLocator.getInstance().lookup(FcMilletMilletareaService.class);
	@ModelAttribute
	public FcMilletMilletarea get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("millet:fcMilletMilletarea:view")
	@RequestMapping(value = {"list", ""})
	public String list(FcMilletMilletarea fcMilletMilletarea, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FcMilletMilletarea> page = bo.findPage(new Page<FcMilletMilletarea>(request, response), fcMilletMilletarea); 
		model.addAttribute("page", page);
		model.addAttribute("fcMilletMilletarea", fcMilletMilletarea);
		return "fc/millet/fcMilletMilletareaList";
	}

	//翻译参照
	private void setTranslate(FcMilletMilletarea entity) {
		
	}
	//新增设置默认值
	private void setDefault(FcMilletMilletarea entity) {

	}
	
	@RequiresPermissions("millet:fcMilletMilletarea:view")
	@RequestMapping(value = "form")
	public String form(FcMilletMilletarea fcMilletMilletarea, Model model) {
		// 判断是否新增
		Object val = fcMilletMilletarea.getPrimaryKey();
		if (val == null) {
			setDefault(fcMilletMilletarea);
		}
		model.addAttribute("fcMilletMilletarea", fcMilletMilletarea);
		return "fc/millet/fcMilletMilletareaForm";
	}

	@RequiresPermissions("millet:fcMilletMilletarea:edit")
	@RequestMapping(value = "save")
	public String save(FcMilletMilletarea fcMilletMilletarea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fcMilletMilletarea)){
			return form(fcMilletMilletarea, model);
		}
		bo.save(fcMilletMilletarea);
		addMessage(redirectAttributes, "保存1986-2000年吉林省谷子播种面积及产量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/millet/fcMilletMilletarea/?repage";
	}
	
	@RequiresPermissions("millet:fcMilletMilletarea:edit")
	@RequestMapping(value = "delete")
	public String delete(FcMilletMilletarea fcMilletMilletarea, RedirectAttributes redirectAttributes) {
		bo.delete(fcMilletMilletarea);
		addMessage(redirectAttributes, "删除1986-2000年吉林省谷子播种面积及产量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/millet/fcMilletMilletarea/?repage";
	}

}