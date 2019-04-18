/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.redginseng.web;

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
import com.ncloud.modules.redginseng.entity.AgSpeRedGinseng;
import com.ncloud.modules.redginseng.service.AgSpeRedGinsengService;
/**
 * 长白山红参（抚宝牌）系列品种销售价格表Controller
 * @author wangjiale
 * @version 2018-07-02
 */
@Controller
@RequestMapping(value = "${adminPath}/redginseng/agSpeRedGinseng")
public class AgSpeRedGinsengController extends BaseController {

	AgSpeRedGinsengService bo=LfwLocator.getInstance().lookup(AgSpeRedGinsengService.class);
	@ModelAttribute
	public AgSpeRedGinseng get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("redginseng:agSpeRedGinseng:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgSpeRedGinseng agSpeRedGinseng, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgSpeRedGinseng> page = bo.findPage(new Page<AgSpeRedGinseng>(request, response), agSpeRedGinseng); 
		model.addAttribute("page", page);
		model.addAttribute("agSpeRedGinseng", agSpeRedGinseng);
		return "modules/redginseng/agSpeRedGinsengList";
	}

	//翻译参照
	private void setTranslate(AgSpeRedGinseng entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgSpeRedGinseng entity) {

	}
	
	@RequiresPermissions("redginseng:agSpeRedGinseng:view")
	@RequestMapping(value = "form")
	public String form(AgSpeRedGinseng agSpeRedGinseng, Model model) {
		// 判断是否新增
		Object val = agSpeRedGinseng.getPrimaryKey();
		if (val == null) {
			setDefault(agSpeRedGinseng);
		}
		model.addAttribute("agSpeRedGinseng", agSpeRedGinseng);
		return "modules/redginseng/agSpeRedGinsengForm";
	}

	@RequiresPermissions("redginseng:agSpeRedGinseng:edit")
	@RequestMapping(value = "save")
	public String save(AgSpeRedGinseng agSpeRedGinseng, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agSpeRedGinseng)){
			return form(agSpeRedGinseng, model);
		}
		bo.save(agSpeRedGinseng);
		addMessage(redirectAttributes, "保存长白山红参（抚宝牌）系列品种销售价格表成功");
		return "redirect:"+Global.getAdminPath()+"/redginseng/agSpeRedGinseng/?repage";
	}
	
	@RequiresPermissions("redginseng:agSpeRedGinseng:edit")
	@RequestMapping(value = "delete")
	public String delete(AgSpeRedGinseng agSpeRedGinseng, RedirectAttributes redirectAttributes) {
		bo.delete(agSpeRedGinseng);
		addMessage(redirectAttributes, "删除长白山红参（抚宝牌）系列品种销售价格表成功");
		return "redirect:"+Global.getAdminPath()+"/redginseng/agSpeRedGinseng/?repage";
	}

}