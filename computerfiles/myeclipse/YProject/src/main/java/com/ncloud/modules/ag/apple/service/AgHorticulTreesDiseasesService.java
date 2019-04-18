/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.apple.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.apple.entity.AgHorticulTreesDiseases;

/**
 * 苹果主要病虫害防治Service
 * @author wangjiale
 * @version 2018-07-04
 */
public class AgHorticulTreesDiseasesService {


	
	public AgHorticulTreesDiseases get(String id) {
		if(id==null||id.length()==0){
			return new AgHorticulTreesDiseases();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgHorticulTreesDiseases.class, "id='"+id+"'");
		AgHorticulTreesDiseases agHorticulTreesDiseases =(AgHorticulTreesDiseases)newHeaderList.get(0);
		
		return agHorticulTreesDiseases;
	}
	

	public Page<AgHorticulTreesDiseases> findPage(Page<AgHorticulTreesDiseases> page, AgHorticulTreesDiseases agHorticulTreesDiseases) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agHorticulTreesDiseases);
	}
	
	public Page<AgHorticulTreesDiseases> findPageCondition(Page<AgHorticulTreesDiseases> page, AgHorticulTreesDiseases agHorticulTreesDiseases,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agHorticulTreesDiseases, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgHorticulTreesDiseases agHorticulTreesDiseases) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agHorticulTreesDiseases);
	}
	
	@Tx
	public void delete(AgHorticulTreesDiseases agHorticulTreesDiseases) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agHorticulTreesDiseases.getTableName(), agHorticulTreesDiseases.getPKFieldName(), agHorticulTreesDiseases.getPrimaryKey().toString());
		
		
	}
	
}