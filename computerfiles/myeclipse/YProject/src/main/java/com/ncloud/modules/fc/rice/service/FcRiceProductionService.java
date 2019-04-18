/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.rice.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.fc.rice.entity.FcRiceProduction;

/**
 * 1986-2000年吉林省水稻面积产量Service
 * @author wangjiale
 * @version 2018-06-22
 */
public class FcRiceProductionService {


	
	public FcRiceProduction get(String id) {
		if(id==null||id.length()==0){
			return new FcRiceProduction();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(FcRiceProduction.class, "id='"+id+"'");
		FcRiceProduction fcRiceProduction =(FcRiceProduction)newHeaderList.get(0);
		
		return fcRiceProduction;
	}
	

	public Page<FcRiceProduction> findPage(Page<FcRiceProduction> page, FcRiceProduction fcRiceProduction) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, fcRiceProduction);
	}
	
	public Page<FcRiceProduction> findPageCondition(Page<FcRiceProduction> page, FcRiceProduction fcRiceProduction,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, fcRiceProduction, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(FcRiceProduction fcRiceProduction) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(fcRiceProduction);
	}
	
	@Tx
	public void delete(FcRiceProduction fcRiceProduction) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(fcRiceProduction.getTableName(), fcRiceProduction.getPKFieldName(), fcRiceProduction.getPrimaryKey().toString());
		
		
	}
	
}