/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.area.web;

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
import com.ncloud.modules.fc.area.entity.FcRiceArea;
import com.ncloud.modules.fc.area.service.FcRiceAreaService;
/**
 * 吉林省水稻分区面积统计Controller
 * @author wangjiale
 * @version 2018-06-22
 */
@Controller
@RequestMapping(value = "${adminPath}/area/fcRiceArea")
public class FcRiceAreaController extends BaseController {

	FcRiceAreaService bo=LfwLocator.getInstance().lookup(FcRiceAreaService.class);
	@ModelAttribute
	public FcRiceArea get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("area:fcRiceArea:view")
	@RequestMapping(value = {"list", ""})
	public String list(FcRiceArea fcRiceArea, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FcRiceArea> page = bo.findPage(new Page<FcRiceArea>(request, response), fcRiceArea); 
		model.addAttribute("page", page);
		model.addAttribute("fcRiceArea", fcRiceArea);
		return "fc/area/fcRiceAreaList";
	}

	//翻译参照
	private void setTranslate(FcRiceArea entity) {
		
	}
	//新增设置默认值
	private void setDefault(FcRiceArea entity) {

	}
	
	@RequiresPermissions("area:fcRiceArea:view")
	@RequestMapping(value = "form")
	public String form(FcRiceArea fcRiceArea, Model model) {
		// 判断是否新增
		Object val = fcRiceArea.getPrimaryKey();
		if (val == null) {
			setDefault(fcRiceArea);
		}
		model.addAttribute("fcRiceArea", fcRiceArea);
		return "fc/area/fcRiceAreaForm";
	}

	@RequiresPermissions("area:fcRiceArea:edit")
	@RequestMapping(value = "save")
	public String save(FcRiceArea fcRiceArea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fcRiceArea)){
			return form(fcRiceArea, model);
		}
		bo.save(fcRiceArea);
		addMessage(redirectAttributes, "保存吉林省水稻分区面积统计表成功");
		return "redirect:"+Global.getAdminPath()+"/area/fcRiceArea/?repage";
	}
	
	@RequiresPermissions("area:fcRiceArea:edit")
	@RequestMapping(value = "delete")
	public String delete(FcRiceArea fcRiceArea, RedirectAttributes redirectAttributes) {
		bo.delete(fcRiceArea);
		addMessage(redirectAttributes, "删除吉林省水稻分区面积统计表成功");
		return "redirect:"+Global.getAdminPath()+"/area/fcRiceArea/?repage";
	}

}