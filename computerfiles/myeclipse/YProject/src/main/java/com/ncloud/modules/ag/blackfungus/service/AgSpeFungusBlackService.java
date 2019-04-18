/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.blackfungus.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.blackfungus.entity.AgSpeFungusBlack;

/**
 * 吉林省黑木耳产量统计Service
 * @author wangjiale
 * @version 2018-07-04
 */
public class AgSpeFungusBlackService {


	
	public AgSpeFungusBlack get(String id) {
		if(id==null||id.length()==0){
			return new AgSpeFungusBlack();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgSpeFungusBlack.class, "id='"+id+"'");
		AgSpeFungusBlack agSpeFungusBlack =(AgSpeFungusBlack)newHeaderList.get(0);
		
		return agSpeFungusBlack;
	}
	

	public Page<AgSpeFungusBlack> findPage(Page<AgSpeFungusBlack> page, AgSpeFungusBlack agSpeFungusBlack) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agSpeFungusBlack);
	}
	
	public Page<AgSpeFungusBlack> findPageCondition(Page<AgSpeFungusBlack> page, AgSpeFungusBlack agSpeFungusBlack,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agSpeFungusBlack, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgSpeFungusBlack agSpeFungusBlack) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agSpeFungusBlack);
	}
	
	@Tx
	public void delete(AgSpeFungusBlack agSpeFungusBlack) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agSpeFungusBlack.getTableName(), agSpeFungusBlack.getPKFieldName(), agSpeFungusBlack.getPrimaryKey().toString());
		
		
	}
	
}