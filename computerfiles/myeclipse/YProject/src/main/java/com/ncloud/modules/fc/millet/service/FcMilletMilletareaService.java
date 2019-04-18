/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.millet.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.fc.millet.entity.FcMilletMilletarea;

/**
 * 1986-2000年吉林省谷子播种面积及产量Service
 * @author wangjiale
 * @version 2018-06-22
 */
public class FcMilletMilletareaService {


	
	public FcMilletMilletarea get(String id) {
		if(id==null||id.length()==0){
			return new FcMilletMilletarea();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(FcMilletMilletarea.class, "id='"+id+"'");
		FcMilletMilletarea fcMilletMilletarea =(FcMilletMilletarea)newHeaderList.get(0);
		
		return fcMilletMilletarea;
	}
	

	public Page<FcMilletMilletarea> findPage(Page<FcMilletMilletarea> page, FcMilletMilletarea fcMilletMilletarea) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, fcMilletMilletarea);
	}
	
	public Page<FcMilletMilletarea> findPageCondition(Page<FcMilletMilletarea> page, FcMilletMilletarea fcMilletMilletarea,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, fcMilletMilletarea, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(FcMilletMilletarea fcMilletMilletarea) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(fcMilletMilletarea);
	}
	
	@Tx
	public void delete(FcMilletMilletarea fcMilletMilletarea) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(fcMilletMilletarea.getTableName(), fcMilletMilletarea.getPKFieldName(), fcMilletMilletarea.getPrimaryKey().toString());
		
		
	}
	
}