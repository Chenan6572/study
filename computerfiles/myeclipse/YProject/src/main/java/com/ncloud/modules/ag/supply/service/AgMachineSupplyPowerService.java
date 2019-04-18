/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.supply.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.supply.entity.AgMachineSupplyPower;

/**
 * 农机供应系统排灌Service
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgMachineSupplyPowerService {


	
	public AgMachineSupplyPower get(String id) {
		if(id==null||id.length()==0){
			return new AgMachineSupplyPower();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgMachineSupplyPower.class, "id='"+id+"'");
		AgMachineSupplyPower agMachineSupplyPower =(AgMachineSupplyPower)newHeaderList.get(0);
		
		return agMachineSupplyPower;
	}
	

	public Page<AgMachineSupplyPower> findPage(Page<AgMachineSupplyPower> page, AgMachineSupplyPower agMachineSupplyPower) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agMachineSupplyPower);
	}
	
	public Page<AgMachineSupplyPower> findPageCondition(Page<AgMachineSupplyPower> page, AgMachineSupplyPower agMachineSupplyPower,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agMachineSupplyPower, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgMachineSupplyPower agMachineSupplyPower) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agMachineSupplyPower);
	}
	
	@Tx
	public void delete(AgMachineSupplyPower agMachineSupplyPower) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agMachineSupplyPower.getTableName(), agMachineSupplyPower.getPKFieldName(), agMachineSupplyPower.getPrimaryKey().toString());
		
		
	}
	
}