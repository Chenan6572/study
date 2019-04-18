/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.savewater.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.savewater.entity.AgMachineMachSavawater;

/**
 * 机械化节水保墒栽培技术项目Service
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgMachineMachSavawaterService {


	
	public AgMachineMachSavawater get(String id) {
		if(id==null||id.length()==0){
			return new AgMachineMachSavawater();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgMachineMachSavawater.class, "id='"+id+"'");
		AgMachineMachSavawater agMachineMachSavawater =(AgMachineMachSavawater)newHeaderList.get(0);
		
		return agMachineMachSavawater;
	}
	

	public Page<AgMachineMachSavawater> findPage(Page<AgMachineMachSavawater> page, AgMachineMachSavawater agMachineMachSavawater) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agMachineMachSavawater);
	}
	
	public Page<AgMachineMachSavawater> findPageCondition(Page<AgMachineMachSavawater> page, AgMachineMachSavawater agMachineMachSavawater,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agMachineMachSavawater, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgMachineMachSavawater agMachineMachSavawater) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agMachineMachSavawater);
	}
	
	@Tx
	public void delete(AgMachineMachSavawater agMachineMachSavawater) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agMachineMachSavawater.getTableName(), agMachineMachSavawater.getPKFieldName(), agMachineMachSavawater.getPrimaryKey().toString());
		
		
	}
	
}