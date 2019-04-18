/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.engine.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.engine.entity.AgMachineMechEngine;

/**
 * 吉林省各市州农用动力机Service
 * @author wangjiale
 * @version 2018-07-05
 */
public class AgMachineMechEngineService {


	
	public AgMachineMechEngine get(String id) {
		if(id==null||id.length()==0){
			return new AgMachineMechEngine();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgMachineMechEngine.class, "id='"+id+"'");
		AgMachineMechEngine agMachineMechEngine =(AgMachineMechEngine)newHeaderList.get(0);
		
		return agMachineMechEngine;
	}
	

	public Page<AgMachineMechEngine> findPage(Page<AgMachineMechEngine> page, AgMachineMechEngine agMachineMechEngine) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agMachineMechEngine);
	}
	
	public Page<AgMachineMechEngine> findPageCondition(Page<AgMachineMechEngine> page, AgMachineMechEngine agMachineMechEngine,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agMachineMechEngine, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgMachineMechEngine agMachineMechEngine) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agMachineMechEngine);
	}
	
	@Tx
	public void delete(AgMachineMechEngine agMachineMechEngine) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agMachineMechEngine.getTableName(), agMachineMechEngine.getPKFieldName(), agMachineMechEngine.getPrimaryKey().toString());
		
		
	}
	
}