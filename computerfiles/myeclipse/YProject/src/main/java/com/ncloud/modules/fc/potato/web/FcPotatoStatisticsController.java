/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.potato.web;

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
import com.ncloud.modules.fc.potato.entity.FcPotatoStatistics;
import com.ncloud.modules.fc.potato.service.FcPotatoStatisticsService;
/**
 * 2000年吉林省各市县马铃薯统计Controller
 * @author wangjiale
 * @version 2018-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/potato/fcPotatoStatistics")
public class FcPotatoStatisticsController extends BaseController {

	FcPotatoStatisticsService bo=LfwLocator.getInstance().lookup(FcPotatoStatisticsService.class);
	@ModelAttribute
	public FcPotatoStatistics get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("potato:fcPotatoStatistics:view")
	@RequestMapping(value = {"list", ""})
	public String list(FcPotatoStatistics fcPotatoStatistics, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FcPotatoStatistics> page = bo.findPage(new Page<FcPotatoStatistics>(request, response), fcPotatoStatistics); 
		model.addAttribute("page", page);
		model.addAttribute("fcPotatoStatistics", fcPotatoStatistics);
		return "fc/potato/fcPotatoStatisticsList";
	}

	//翻译参照
	private void setTranslate(FcPotatoStatistics entity) {
		
	}
	//新增设置默认值
	private void setDefault(FcPotatoStatistics entity) {

	}
	
	@RequiresPermissions("potato:fcPotatoStatistics:view")
	@RequestMapping(value = "form")
	public String form(FcPotatoStatistics fcPotatoStatistics, Model model) {
		// 判断是否新增
		Object val = fcPotatoStatistics.getPrimaryKey();
		if (val == null) {
			setDefault(fcPotatoStatistics);
		}
		model.addAttribute("fcPotatoStatistics", fcPotatoStatistics);
		return "fc/potato/fcPotatoStatisticsForm";
	}

	@RequiresPermissions("potato:fcPotatoStatistics:edit")
	@RequestMapping(value = "save")
	public String save(FcPotatoStatistics fcPotatoStatistics, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fcPotatoStatistics)){
			return form(fcPotatoStatistics, model);
		}
		bo.save(fcPotatoStatistics);
		addMessage(redirectAttributes, "保存2000年吉林省各市县马铃薯统计表成功");
		return "redirect:"+Global.getAdminPath()+"/potato/fcPotatoStatistics/?repage";
	}
	
	@RequiresPermissions("potato:fcPotatoStatistics:edit")
	@RequestMapping(value = "delete")
	public String delete(FcPotatoStatistics fcPotatoStatistics, RedirectAttributes redirectAttributes) {
		bo.delete(fcPotatoStatistics);
		addMessage(redirectAttributes, "删除2000年吉林省各市县马铃薯统计表成功");
		return "redirect:"+Global.getAdminPath()+"/potato/fcPotatoStatistics/?repage";
	}

}