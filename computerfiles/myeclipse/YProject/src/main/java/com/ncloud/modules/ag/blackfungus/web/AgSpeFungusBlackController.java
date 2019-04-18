/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.blackfungus.web;

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
import com.ncloud.modules.ag.blackfungus.entity.AgSpeFungusBlack;
import com.ncloud.modules.ag.blackfungus.service.AgSpeFungusBlackService;
/**
 * 吉林省黑木耳产量统计Controller
 * @author wangjiale
 * @version 2018-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/blackfungus/agSpeFungusBlack")
public class AgSpeFungusBlackController extends BaseController {

	AgSpeFungusBlackService bo=LfwLocator.getInstance().lookup(AgSpeFungusBlackService.class);
	@ModelAttribute
	public AgSpeFungusBlack get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("blackfungus:agSpeFungusBlack:view")
	@RequestMapping(value = {"list", ""})
	public String list(AgSpeFungusBlack agSpeFungusBlack, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AgSpeFungusBlack> page = bo.findPage(new Page<AgSpeFungusBlack>(request, response), agSpeFungusBlack); 
		model.addAttribute("page", page);
		model.addAttribute("agSpeFungusBlack", agSpeFungusBlack);
		return "ag/blackfungus/agSpeFungusBlackList";
	}

	//翻译参照
	private void setTranslate(AgSpeFungusBlack entity) {
		
	}
	//新增设置默认值
	private void setDefault(AgSpeFungusBlack entity) {

	}
	
	@RequiresPermissions("blackfungus:agSpeFungusBlack:view")
	@RequestMapping(value = "form")
	public String form(AgSpeFungusBlack agSpeFungusBlack, Model model) {
		// 判断是否新增
		Object val = agSpeFungusBlack.getPrimaryKey();
		if (val == null) {
			setDefault(agSpeFungusBlack);
		}
		model.addAttribute("agSpeFungusBlack", agSpeFungusBlack);
		return "ag/blackfungus/agSpeFungusBlackForm";
	}

	@RequiresPermissions("blackfungus:agSpeFungusBlack:edit")
	@RequestMapping(value = "save")
	public String save(AgSpeFungusBlack agSpeFungusBlack, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, agSpeFungusBlack)){
			return form(agSpeFungusBlack, model);
		}
		bo.save(agSpeFungusBlack);
		addMessage(redirectAttributes, "保存吉林省黑木耳产量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/blackfungus/agSpeFungusBlack/?repage";
	}
	
	@RequiresPermissions("blackfungus:agSpeFungusBlack:edit")
	@RequestMapping(value = "delete")
	public String delete(AgSpeFungusBlack agSpeFungusBlack, RedirectAttributes redirectAttributes) {
		bo.delete(agSpeFungusBlack);
		addMessage(redirectAttributes, "删除吉林省黑木耳产量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/blackfungus/agSpeFungusBlack/?repage";
	}

}