/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.plant.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.plant.entity.AgHorticulTreesPlant;

/**
 * 吉林省果树栽植情况Service
 * @author wangjiale
 * @version 2018-07-04
 */
public class AgHorticulTreesPlantService {


	
	public AgHorticulTreesPlant get(String id) {
		if(id==null||id.length()==0){
			return new AgHorticulTreesPlant();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgHorticulTreesPlant.class, "id='"+id+"'");
		AgHorticulTreesPlant agHorticulTreesPlant =(AgHorticulTreesPlant)newHeaderList.get(0);
		
		return agHorticulTreesPlant;
	}
	

	public Page<AgHorticulTreesPlant> findPage(Page<AgHorticulTreesPlant> page, AgHorticulTreesPlant agHorticulTreesPlant) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agHorticulTreesPlant);
	}
	
	public Page<AgHorticulTreesPlant> findPageCondition(Page<AgHorticulTreesPlant> page, AgHorticulTreesPlant agHorticulTreesPlant,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agHorticulTreesPlant, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgHorticulTreesPlant agHorticulTreesPlant) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agHorticulTreesPlant);
	}
	
	@Tx
	public void delete(AgHorticulTreesPlant agHorticulTreesPlant) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agHorticulTreesPlant.getTableName(), agHorticulTreesPlant.getPKFieldName(), agHorticulTreesPlant.getPrimaryKey().toString());
		
		
	}
	
}