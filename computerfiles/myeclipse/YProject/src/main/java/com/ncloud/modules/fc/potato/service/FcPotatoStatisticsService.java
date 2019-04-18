/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.potato.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.fc.potato.entity.FcPotatoStatistics;

/**
 * 2000年吉林省各市县马铃薯统计Service
 * @author wangjiale
 * @version 2018-06-25
 */
public class FcPotatoStatisticsService {


	
	public FcPotatoStatistics get(String id) {
		if(id==null||id.length()==0){
			return new FcPotatoStatistics();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(FcPotatoStatistics.class, "id='"+id+"'");
		FcPotatoStatistics fcPotatoStatistics =(FcPotatoStatistics)newHeaderList.get(0);
		
		return fcPotatoStatistics;
	}
	

	public Page<FcPotatoStatistics> findPage(Page<FcPotatoStatistics> page, FcPotatoStatistics fcPotatoStatistics) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, fcPotatoStatistics);
	}
	
	public Page<FcPotatoStatistics> findPageCondition(Page<FcPotatoStatistics> page, FcPotatoStatistics fcPotatoStatistics,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, fcPotatoStatistics, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(FcPotatoStatistics fcPotatoStatistics) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(fcPotatoStatistics);
	}
	
	@Tx
	public void delete(FcPotatoStatistics fcPotatoStatistics) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(fcPotatoStatistics.getTableName(), fcPotatoStatistics.getPKFieldName(), fcPotatoStatistics.getPrimaryKey().toString());
		
		
	}
	
}