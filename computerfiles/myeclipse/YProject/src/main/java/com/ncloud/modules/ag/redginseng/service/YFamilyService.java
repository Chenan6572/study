/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.redginseng.service;

import java.util.List;
import com.sunsd.lfw.common.persistence.SuperDMO;
import com.sunsd.lfw.common.tx.jfinal.Tx;
import com.sunsd.lfw.common.persistence.Page;
import com.sunsd.lfw.common.tx.jfinal.LfwLocator;
import com.ncloud.modules.ag.redginseng.entity.YFamily;

/**
 * 1988年长白山红参（抚宝牌）系列品种销售价格表Service
 * @author wangjiale
 * @version 2018-07-02
 */
public class YFamilyService {


	
	public YFamily get(String id) {
		if(id==null||id.length()==0){
			return new YFamily();
		}
		SuperDMO dao=new SuperDMO();
		List newHeaderList=dao.retrieveByClause(YFamily.class, "id='"+id+"'");
		YFamily yFamily =(YFamily)newHeaderList.get(0);
		
		return yFamily;
	}
	

	public Page<YFamily> findPage(Page<YFamily> page, YFamily yFamily) {
		return LfwLocator.getInstance().getCrudBO().findPage(page, yFamily);
	}
	
	public Page<YFamily> findPageCondition(Page<YFamily> page, YFamily yFamily,String sqlWhere,String sqlOrderBy) {
		return LfwLocator.getInstance().getCrudBO().findPageCondition(page, yFamily, sqlWhere,sqlOrderBy);
	}
	
	@Tx
	public void save(YFamily yFamily) {
	    SuperDMO dao=new SuperDMO(); 
		dao.save_DB(yFamily);
	}
	
	@Tx
	public void delete(YFamily yFamily) {
		
		SuperDMO dao=new SuperDMO();
		dao.delete(yFamily.getTableName(), yFamily.getPKFieldName(), yFamily.getPrimaryKey().toString());
		
		
	}
	
}