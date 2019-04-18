/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.deer.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.deer.entity.AgReclamScaleDeer;

/**
 * 2000年吉林省国有鹿场情况Service
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgReclamScaleDeerService {


	
	public AgReclamScaleDeer get(String id) {
		if(id==null||id.length()==0){
			return new AgReclamScaleDeer();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgReclamScaleDeer.class, "id='"+id+"'");
		AgReclamScaleDeer agReclamScaleDeer =(AgReclamScaleDeer)newHeaderList.get(0);
		
		return agReclamScaleDeer;
	}
	

	public Page<AgReclamScaleDeer> findPage(Page<AgReclamScaleDeer> page, AgReclamScaleDeer agReclamScaleDeer) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agReclamScaleDeer);
	}
	
	public Page<AgReclamScaleDeer> findPageCondition(Page<AgReclamScaleDeer> page, AgReclamScaleDeer agReclamScaleDeer,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agReclamScaleDeer, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgReclamScaleDeer agReclamScaleDeer) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agReclamScaleDeer);
	}
	
	@Tx
	public void delete(AgReclamScaleDeer agReclamScaleDeer) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agReclamScaleDeer.getTableName(), agReclamScaleDeer.getPKFieldName(), agReclamScaleDeer.getPrimaryKey().toString());
		
		
	}
	
}