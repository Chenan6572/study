/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.husbandry.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.husbandry.entity.AgReclamhusbandry;

/**
 * 农垦企业畜牧业生产情况Service
 * @author wangjiale
 * @version 2018-07-09
 */
public class AgReclamhusbandryService {


	
	public AgReclamhusbandry get(String id) {
		if(id==null||id.length()==0){
			return new AgReclamhusbandry();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgReclamhusbandry.class, "id='"+id+"'");
		AgReclamhusbandry agReclamhusbandry =(AgReclamhusbandry)newHeaderList.get(0);
		
		return agReclamhusbandry;
	}
	

	public Page<AgReclamhusbandry> findPage(Page<AgReclamhusbandry> page, AgReclamhusbandry agReclamhusbandry) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agReclamhusbandry);
	}
	
	public Page<AgReclamhusbandry> findPageCondition(Page<AgReclamhusbandry> page, AgReclamhusbandry agReclamhusbandry,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agReclamhusbandry, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgReclamhusbandry agReclamhusbandry) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agReclamhusbandry);
	}
	
	@Tx
	public void delete(AgReclamhusbandry agReclamhusbandry) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agReclamhusbandry.getTableName(), agReclamhusbandry.getPKFieldName(), agReclamhusbandry.getPrimaryKey().toString());
		
		
	}
	
}