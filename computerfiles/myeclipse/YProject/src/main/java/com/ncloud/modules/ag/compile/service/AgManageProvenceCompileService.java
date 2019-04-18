/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.compile.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.compile.entity.AgManageProvenceCompile;

/**
 * 农委（农业厅）指数事业单位编制Service
 * @author wangjiale
 * @version 2018-07-10
 */
public class AgManageProvenceCompileService {


	
	public AgManageProvenceCompile get(String id) {
		if(id==null||id.length()==0){
			return new AgManageProvenceCompile();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(AgManageProvenceCompile.class, "id='"+id+"'");
		AgManageProvenceCompile agManageProvenceCompile =(AgManageProvenceCompile)newHeaderList.get(0);
		
		return agManageProvenceCompile;
	}
	

	public Page<AgManageProvenceCompile> findPage(Page<AgManageProvenceCompile> page, AgManageProvenceCompile agManageProvenceCompile) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, agManageProvenceCompile);
	}
	
	public Page<AgManageProvenceCompile> findPageCondition(Page<AgManageProvenceCompile> page, AgManageProvenceCompile agManageProvenceCompile,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, agManageProvenceCompile, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(AgManageProvenceCompile agManageProvenceCompile) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(agManageProvenceCompile);
	}
	
	@Tx
	public void delete(AgManageProvenceCompile agManageProvenceCompile) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(agManageProvenceCompile.getTableName(), agManageProvenceCompile.getPKFieldName(), agManageProvenceCompile.getPrimaryKey().toString());
		
		
	}
	
}