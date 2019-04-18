/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.redginseng.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.redginseng.entity.AgSpeRedGinseng;

/**
 * 长白山红参（抚宝牌）系列品种销售价格表Service
 * @author wangjiale
 * @version 2018-07-02
 */
public class AgSpeRedGinsengService {


	
	public AgSpeRedGinseng get(String id) {
		if(id==null||id.length()==0){
			return new AgSpeRedGinseng();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgSpeRedGinseng.class, "id='"+id+"'");
		AgSpeRedGinseng agSpeRedGinseng =(AgSpeRedGinseng)newHeaderList.get(0);
		
		return agSpeRedGinseng;
	}
	

	public Page<AgSpeRedGinseng> findPage(Page<AgSpeRedGinseng> page, AgSpeRedGinseng agSpeRedGinseng) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agSpeRedGinseng);
	}
	
	public Page<AgSpeRedGinseng> findPageCondition(Page<AgSpeRedGinseng> page, AgSpeRedGinseng agSpeRedGinseng,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agSpeRedGinseng, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgSpeRedGinseng agSpeRedGinseng) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agSpeRedGinseng);
	}
	
	@Tx
	public void delete(AgSpeRedGinseng agSpeRedGinseng) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agSpeRedGinseng.getTableName(), agSpeRedGinseng.getPKFieldName(), agSpeRedGinseng.getPrimaryKey().toString());
		
		
	}
	
}