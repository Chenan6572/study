/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.fertilizer.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.fertilizer.entity.AgTechnicalManureFertilizer;

/**
 * 农业化肥施用量统计Service
 * @author wangjaile
 * @version 2018-07-05
 */
public class AgTechnicalManureFertilizerService {


	
	public AgTechnicalManureFertilizer get(String id) {
		if(id==null||id.length()==0){
			return new AgTechnicalManureFertilizer();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgTechnicalManureFertilizer.class, "id='"+id+"'");
		AgTechnicalManureFertilizer agTechnicalManureFertilizer =(AgTechnicalManureFertilizer)newHeaderList.get(0);
		
		return agTechnicalManureFertilizer;
	}
	

	public Page<AgTechnicalManureFertilizer> findPage(Page<AgTechnicalManureFertilizer> page, AgTechnicalManureFertilizer agTechnicalManureFertilizer) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agTechnicalManureFertilizer);
	}
	
	public Page<AgTechnicalManureFertilizer> findPageCondition(Page<AgTechnicalManureFertilizer> page, AgTechnicalManureFertilizer agTechnicalManureFertilizer,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agTechnicalManureFertilizer, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgTechnicalManureFertilizer agTechnicalManureFertilizer) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agTechnicalManureFertilizer);
	}
	
	@Tx
	public void delete(AgTechnicalManureFertilizer agTechnicalManureFertilizer) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agTechnicalManureFertilizer.getTableName(), agTechnicalManureFertilizer.getPKFieldName(), agTechnicalManureFertilizer.getPrimaryKey().toString());
		
		
	}
	
}