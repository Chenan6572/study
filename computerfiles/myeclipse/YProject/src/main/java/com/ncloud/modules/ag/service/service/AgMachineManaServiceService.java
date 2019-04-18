/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.service.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.service.entity.AgMachineManaService;

/**
 * 吉林省乡、村农机化服务组织服务情况Service
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgMachineManaServiceService {


	
	public AgMachineManaService get(String id) {
		if(id==null||id.length()==0){
			return new AgMachineManaService();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgMachineManaService.class, "id='"+id+"'");
		AgMachineManaService agMachineManaService =(AgMachineManaService)newHeaderList.get(0);
		
		return agMachineManaService;
	}
	

	public Page<AgMachineManaService> findPage(Page<AgMachineManaService> page, AgMachineManaService agMachineManaService) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agMachineManaService);
	}
	
	public Page<AgMachineManaService> findPageCondition(Page<AgMachineManaService> page, AgMachineManaService agMachineManaService,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agMachineManaService, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgMachineManaService agMachineManaService) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agMachineManaService);
	}
	
	@Tx
	public void delete(AgMachineManaService agMachineManaService) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agMachineManaService.getTableName(), agMachineManaService.getPKFieldName(), agMachineManaService.getPrimaryKey().toString());
		
		
	}
	
}