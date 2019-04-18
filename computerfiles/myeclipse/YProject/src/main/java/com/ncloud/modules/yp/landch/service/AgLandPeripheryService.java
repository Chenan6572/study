/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.yp.landch.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.yp.landch.entity.AgLandPeriphery;

/**
 * 土地利用信息表Service
 * @author wangjiale
 * @version 2018-06-13
 */
public class AgLandPeripheryService {


	
	public AgLandPeriphery get(String id) {
		if(id==null||id.length()==0){
			return new AgLandPeriphery();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgLandPeriphery.class, "id='"+id+"'");
		AgLandPeriphery agLandPeriphery =(AgLandPeriphery)newHeaderList.get(0);
		
		return agLandPeriphery;
	}
	

	public Page<AgLandPeriphery> findPage(Page<AgLandPeriphery> page, AgLandPeriphery agLandPeriphery) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agLandPeriphery);
	}
	
	public Page<AgLandPeriphery> findPageCondition(Page<AgLandPeriphery> page, AgLandPeriphery agLandPeriphery,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agLandPeriphery, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgLandPeriphery agLandPeriphery) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agLandPeriphery);
	}
	
	@Tx
	public void delete(AgLandPeriphery agLandPeriphery) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agLandPeriphery.getTableName(), agLandPeriphery.getPKFieldName(), agLandPeriphery.getPrimaryKey().toString());
		
		
	}
	
}