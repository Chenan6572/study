/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.yaoxie.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.yaoxie.entity.AgTechnicalProtectionYaoxie;

/**
 * 病虫害发生防治面积和农药使用量Service
 * @author wangjiale
 * @version 2018-07-05
 */
public class AgTechnicalProtectionYaoxieService {


	
	public AgTechnicalProtectionYaoxie get(String id) {
		if(id==null||id.length()==0){
			return new AgTechnicalProtectionYaoxie();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgTechnicalProtectionYaoxie.class, "id='"+id+"'");
		AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie =(AgTechnicalProtectionYaoxie)newHeaderList.get(0);
		
		return agTechnicalProtectionYaoxie;
	}
	

	public Page<AgTechnicalProtectionYaoxie> findPage(Page<AgTechnicalProtectionYaoxie> page, AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agTechnicalProtectionYaoxie);
	}
	
	public Page<AgTechnicalProtectionYaoxie> findPageCondition(Page<AgTechnicalProtectionYaoxie> page, AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agTechnicalProtectionYaoxie, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agTechnicalProtectionYaoxie);
	}
	
	@Tx
	public void delete(AgTechnicalProtectionYaoxie agTechnicalProtectionYaoxie) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agTechnicalProtectionYaoxie.getTableName(), agTechnicalProtectionYaoxie.getPKFieldName(), agTechnicalProtectionYaoxie.getPrimaryKey().toString());
		
		
	}
	
}