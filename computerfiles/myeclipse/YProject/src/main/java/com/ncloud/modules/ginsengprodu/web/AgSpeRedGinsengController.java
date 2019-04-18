/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ginsengprodu.web;

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
import com.ncloud.modules.ginsengprodu.entity.AgSpeRedGinseng;
import com.ncloud.modules.ginsengprodu.service.AgSpeRedGinsengService;
/**
 * 1986-2000年吉林省人（园）参生产情况Controller
 * @author YGD
 * @version 2018-07-02
 */
@Controller
@RequestMapping(value = "${adminPath}/ginsengprodu/agSpeRedGinseng")
public class AgSpeRedGinsengController extends BaseController {

	AgSpeRedGinsengService bo=LfwLocator.getInstance().lookup(AgSpeRedGinsengService.class);
	@ModelAttribute
	public AgSpeRedGinseng get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("ginsengprodu:agSpeRedGinseng:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgSpeRedGinseng agSpeRedGinseng, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgSpeRedGinseng> page = bo.findPage(new Page<AgSpeRedGinseng>(request, response), agSpeRedGinseng); 
		model.addAttribute("page", page);
		model.addAttribute("agSpeRedGinseng", agSpeRedGinseng);
		return "modules/ginsengprodu/agSpeRedGinsengList";
	}

	//翻译参照
	private void setTranslate(AgSpeRedGinseng entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgSpeRedGinseng entity) {

	}
	
	@RequiresPermissions("ginsengprodu:agSpeRedGinseng:view")
	@RequestMapping(value = "form")
	public String form(AgSpeRedGinseng agSpeRedGinseng, Model model) {
		// 判断是否新增
		Object val = agSpeRedGinseng.getPrimaryKey();
		if (val == null) {
			setDefault(agSpeRedGinseng);
		}
		model.addAttribute("agSpeRedGinseng", agSpeRedGinseng);
		return "modules/ginsengprodu/agSpeRedGinsengForm";
	}

	@RequiresPermissions("ginsengprodu:agSpeRedGinseng:edit")
	@RequestMapping(value = "save")
	public String save(AgSpeRedGinseng agSpeRedGinseng, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agSpeRedGinseng)){
			return form(agSpeRedGinseng, model);
		}
		bo.save(agSpeRedGinseng);
		addMessage(redirectAttributes, "保存人（园）参生产情况成功");
		return "redirect:"+Global.getAdminPath()+"/ginsengprodu/agSpeRedGinseng/?repage";
	}
	
	@RequiresPermissions("ginsengprodu:agSpeRedGinseng:edit")
	@RequestMapping(value = "delete")
	public String delete(AgSpeRedGinseng agSpeRedGinseng, RedirectAttributes redirectAttributes) {
		bo.delete(agSpeRedGinseng);
		addMessage(redirectAttributes, "删除人（园）参生产情况成功");
		return "redirect:"+Global.getAdminPath()+"/ginsengprodu/agSpeRedGinseng/?repage";
	}

}