/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.wheat.web;

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
import com.ncloud.modules.fc.wheat.entity.FcWheatArea;
import com.ncloud.modules.fc.wheat.service.FcWheatAreaService;
/**
 * 1986年吉林省各市区小麦播种面积及产量Controller
 * @author wangjiale
 * @version 2018-06-25
 */
@Controller
@RequestMapping(value = "${adminPath}/wheat/fcWheatArea")
public class FcWheatAreaController extends BaseController {

	FcWheatAreaService bo=LfwLocator.getInstance().lookup(FcWheatAreaService.class);
	@ModelAttribute
	public FcWheatArea get(@RequestParam(required=false) String id) {				
		return bo.get(id);
	}
	
	@RequiresPermissions("wheat:fcWheatArea:view")
	@RequestMapping(value = {"list", ""})
	public String list(FcWheatArea fcWheatArea, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FcWheatArea> page = bo.findPage(new Page<FcWheatArea>(request, response), fcWheatArea); 
		model.addAttribute("page", page);
		model.addAttribute("fcWheatArea", fcWheatArea);
		return "fc/wheat/fcWheatAreaList";
	}

	//翻译参照
	private void setTranslate(FcWheatArea entity) {
		
	}
	//新增设置默认值
	private void setDefault(FcWheatArea entity) {

	}
	
	@RequiresPermissions("wheat:fcWheatArea:view")
	@RequestMapping(value = "form")
	public String form(FcWheatArea fcWheatArea, Model model) {
		// 判断是否新增
		Object val = fcWheatArea.getPrimaryKey();
		if (val == null) {
			setDefault(fcWheatArea);
		}
		model.addAttribute("fcWheatArea", fcWheatArea);
		return "fc/wheat/fcWheatAreaForm";
	}

	@RequiresPermissions("wheat:fcWheatArea:edit")
	@RequestMapping(value = "save")
	public String save(FcWheatArea fcWheatArea, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fcWheatArea)){
			return form(fcWheatArea, model);
		}
		bo.save(fcWheatArea);
		addMessage(redirectAttributes, "保存1986年吉林省各市区小麦播种面积及产量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/wheat/fcWheatArea/?repage";
	}
	
	@RequiresPermissions("wheat:fcWheatArea:edit")
	@RequestMapping(value = "delete")
	public String delete(FcWheatArea fcWheatArea, RedirectAttributes redirectAttributes) {
		bo.delete(fcWheatArea);
		addMessage(redirectAttributes, "删除1986年吉林省各市区小麦播种面积及产量统计表成功");
		return "redirect:"+Global.getAdminPath()+"/wheat/fcWheatArea/?repage";
	}

}