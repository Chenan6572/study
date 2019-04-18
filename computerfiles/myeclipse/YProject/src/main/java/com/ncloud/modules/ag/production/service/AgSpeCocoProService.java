/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.production.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.production.entity.AgSpeCocoPro;

/**
 * 吉林省蚕茧生产情况统计表Service
 * @author wangjiale
 * @version 2018-07-03
 */
public class AgSpeCocoProService {


	
	public AgSpeCocoPro get(String id) {
		if(id==null||id.length()==0){
			return new AgSpeCocoPro();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgSpeCocoPro.class, "id='"+id+"'");
		AgSpeCocoPro agSpeCocoPro =(AgSpeCocoPro)newHeaderList.get(0);
		
		return agSpeCocoPro;
	}
	

	public Page<AgSpeCocoPro> findPage(Page<AgSpeCocoPro> page, AgSpeCocoPro agSpeCocoPro) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agSpeCocoPro);
	}
	
	public Page<AgSpeCocoPro> findPageCondition(Page<AgSpeCocoPro> page, AgSpeCocoPro agSpeCocoPro,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agSpeCocoPro, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgSpeCocoPro agSpeCocoPro) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agSpeCocoPro);
	}
	
	@Tx
	public void delete(AgSpeCocoPro agSpeCocoPro) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agSpeCocoPro.getTableName(), agSpeCocoPro.getPKFieldName(), agSpeCocoPro.getPrimaryKey().toString());
		
		
	}
	
}