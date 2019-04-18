/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.area.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.fc.area.entity.FcRiceArea;

/**
 * 吉林省水稻分区面积统计Service
 * @author wangjiale
 * @version 2018-06-22
 */
public class FcRiceAreaService {


	
	public FcRiceArea get(String id) {
		if(id==null||id.length()==0){
			return new FcRiceArea();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(FcRiceArea.class, "id='"+id+"'");
		FcRiceArea fcRiceArea =(FcRiceArea)newHeaderList.get(0);
		
		return fcRiceArea;
	}
	

	public Page<FcRiceArea> findPage(Page<FcRiceArea> page, FcRiceArea fcRiceArea) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, fcRiceArea);
	}
	
	public Page<FcRiceArea> findPageCondition(Page<FcRiceArea> page, FcRiceArea fcRiceArea,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, fcRiceArea, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(FcRiceArea fcRiceArea) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(fcRiceArea);
	}
	
	@Tx
	public void delete(FcRiceArea fcRiceArea) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(fcRiceArea.getTableName(), fcRiceArea.getPKFieldName(), fcRiceArea.getPrimaryKey().toString());
		
		
	}
	
}