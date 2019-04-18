/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ec.sugerbeet.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ec.sugerbeet.entity.EcSugerbeetProduction;

/**
 * 1986-2000年吉林省甜菜生产统计Service
 * @author wangjiale
 * @version 2018-06-28
 */
public class EcSugerbeetProductionService {


	
	public EcSugerbeetProduction get(String id) {
		if(id==null||id.length()==0){
			return new EcSugerbeetProduction();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(EcSugerbeetProduction.class, "id='"+id+"'");
		EcSugerbeetProduction ecSugerbeetProduction =(EcSugerbeetProduction)newHeaderList.get(0);
		
		return ecSugerbeetProduction;
	}
	

	public Page<EcSugerbeetProduction> findPage(Page<EcSugerbeetProduction> page, EcSugerbeetProduction ecSugerbeetProduction) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, ecSugerbeetProduction);
	}
	
	public Page<EcSugerbeetProduction> findPageCondition(Page<EcSugerbeetProduction> page, EcSugerbeetProduction ecSugerbeetProduction,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, ecSugerbeetProduction, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(EcSugerbeetProduction ecSugerbeetProduction) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(ecSugerbeetProduction);
	}
	
	@Tx
	public void delete(EcSugerbeetProduction ecSugerbeetProduction) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(ecSugerbeetProduction.getTableName(), ecSugerbeetProduction.getPKFieldName(), ecSugerbeetProduction.getPrimaryKey().toString());
		
		
	}
	
}