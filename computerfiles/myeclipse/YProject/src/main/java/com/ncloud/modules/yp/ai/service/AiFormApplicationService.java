/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.yp.ai.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.yp.ai.entity.AiFormApplication;

/**
 * 百度AI开放平台Service
 * @author wangjiale
 * @version 2018-06-28
 */
public class AiFormApplicationService {


	
	public AiFormApplication get(String id) {
		if(id==null||id.length()==0){
			return new AiFormApplication();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AiFormApplication.class, "id='"+id+"'");
		AiFormApplication aiFormApplication =(AiFormApplication)newHeaderList.get(0);
		
		return aiFormApplication;
	}
	

	public Page<AiFormApplication> findPage(Page<AiFormApplication> page, AiFormApplication aiFormApplication) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, aiFormApplication);
	}
	
	public Page<AiFormApplication> findPageCondition(Page<AiFormApplication> page, AiFormApplication aiFormApplication,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, aiFormApplication, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AiFormApplication aiFormApplication) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(aiFormApplication);
	}
	
	@Tx
	public void delete(AiFormApplication aiFormApplication) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(aiFormApplication.getTableName(), aiFormApplication.getPKFieldName(), aiFormApplication.getPrimaryKey().toString());
		
		
	}
	
}