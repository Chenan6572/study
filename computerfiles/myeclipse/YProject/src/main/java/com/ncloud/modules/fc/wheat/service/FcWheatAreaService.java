/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.wheat.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.fc.wheat.entity.FcWheatArea;

/**
 * 1986年吉林省各市区小麦播种面积及产量Service
 * @author wangjiale
 * @version 2018-06-25
 */
public class FcWheatAreaService {


	
	public FcWheatArea get(String id) {
		if(id==null||id.length()==0){
			return new FcWheatArea();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(FcWheatArea.class, "id='"+id+"'");
		FcWheatArea fcWheatArea =(FcWheatArea)newHeaderList.get(0);
		
		return fcWheatArea;
	}
	

	public Page<FcWheatArea> findPage(Page<FcWheatArea> page, FcWheatArea fcWheatArea) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, fcWheatArea);
	}
	
	public Page<FcWheatArea> findPageCondition(Page<FcWheatArea> page, FcWheatArea fcWheatArea,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, fcWheatArea, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(FcWheatArea fcWheatArea) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(fcWheatArea);
	}
	
	@Tx
	public void delete(FcWheatArea fcWheatArea) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(fcWheatArea.getTableName(), fcWheatArea.getPKFieldName(), fcWheatArea.getPrimaryKey().toString());
		
		
	}
	
}