/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.main.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.main.entity.AgReclamEnterprisesMain;

/**
 * 吉林省重点建设农垦工业企业情况Service
 * @author wangjiale
 * @version 2018-07-09
 */
public class AgReclamEnterprisesMainService {


	
	public AgReclamEnterprisesMain get(String id) {
		if(id==null||id.length()==0){
			return new AgReclamEnterprisesMain();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgReclamEnterprisesMain.class, "id='"+id+"'");
		AgReclamEnterprisesMain agReclamEnterprisesMain =(AgReclamEnterprisesMain)newHeaderList.get(0);
		
		return agReclamEnterprisesMain;
	}
	

	public Page<AgReclamEnterprisesMain> findPage(Page<AgReclamEnterprisesMain> page, AgReclamEnterprisesMain agReclamEnterprisesMain) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agReclamEnterprisesMain);
	}
	
	public Page<AgReclamEnterprisesMain> findPageCondition(Page<AgReclamEnterprisesMain> page, AgReclamEnterprisesMain agReclamEnterprisesMain,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agReclamEnterprisesMain, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgReclamEnterprisesMain agReclamEnterprisesMain) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agReclamEnterprisesMain);
	}
	
	@Tx
	public void delete(AgReclamEnterprisesMain agReclamEnterprisesMain) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agReclamEnterprisesMain.getTableName(), agReclamEnterprisesMain.getPKFieldName(), agReclamEnterprisesMain.getPrimaryKey().toString());
		
		
	}
	
}