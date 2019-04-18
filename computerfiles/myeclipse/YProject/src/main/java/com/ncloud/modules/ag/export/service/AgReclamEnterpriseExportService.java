/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.export.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.export.entity.AgReclamEnterpriseExport;

/**
 * 农垦外贸出口商品情况Service
 * @author wangjiale
 * @version 2018-07-10
 */
public class AgReclamEnterpriseExportService {


	
	public AgReclamEnterpriseExport get(String id) {
		if(id==null||id.length()==0){
			return new AgReclamEnterpriseExport();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgReclamEnterpriseExport.class, "id='"+id+"'");
		AgReclamEnterpriseExport agReclamEnterpriseExport =(AgReclamEnterpriseExport)newHeaderList.get(0);
		
		return agReclamEnterpriseExport;
	}
	

	public Page<AgReclamEnterpriseExport> findPage(Page<AgReclamEnterpriseExport> page, AgReclamEnterpriseExport agReclamEnterpriseExport) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agReclamEnterpriseExport);
	}
	
	public Page<AgReclamEnterpriseExport> findPageCondition(Page<AgReclamEnterpriseExport> page, AgReclamEnterpriseExport agReclamEnterpriseExport,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agReclamEnterpriseExport, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgReclamEnterpriseExport agReclamEnterpriseExport) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agReclamEnterpriseExport);
	}
	
	@Tx
	public void delete(AgReclamEnterpriseExport agReclamEnterpriseExport) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agReclamEnterpriseExport.getTableName(), agReclamEnterpriseExport.getPKFieldName(), agReclamEnterpriseExport.getPrimaryKey().toString());
		
		
	}
	
}