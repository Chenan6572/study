/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.plant.entity;

import org.hibernate.validator.constraints.Length;
import com.sunsd.lfw.modules.sys.entity.User;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 吉林省果树栽植情况Entity
 * @author wangjiale
 * @version 2018-07-04
 */
public class AgHorticulTreesPlant extends DataEntity<AgHorticulTreesPlant> {
	
	private static final long serialVersionUID = 1L;
			private String update_date;		// 更新时间
			private com.sunsd.lfw.modules.sys.entity.User update_by;		// 更新人
			private String create_date;		// 创建时间
			private com.sunsd.lfw.modules.sys.entity.User create_by;		// 创建人
			private String inorde;		// 与1985年比较增减
			private String fruit_production;		// 水果总产量(万吨)
			private String area;		// 栽植面积（万亩）
			private String year;		// 年份
			private String org_name;		// 区域（城市）
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgHorticulTreesPlant() {
		super();
	}

	public AgHorticulTreesPlant(String id){
		super(id);
	}


	@Length(min=0, max=20, message="更新时间长度必须介于 0 和 20 之间")
		public String getUpdate_date() {
			return update_date;
		}
	
		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
		}

		public com.sunsd.lfw.modules.sys.entity.User getUpdate_by() {
			return update_by;
		}
	
		public void setUpdate_by(com.sunsd.lfw.modules.sys.entity.User update_by) {
			this.update_by = update_by;
		}

	@Length(min=0, max=20, message="创建时间长度必须介于 0 和 20 之间")
		public String getCreate_date() {
			return create_date;
		}
	
		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

		public com.sunsd.lfw.modules.sys.entity.User getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(com.sunsd.lfw.modules.sys.entity.User create_by) {
			this.create_by = create_by;
		}

		public String getInorde() {
			return inorde;
		}
	
		public void setInorde(String inorde) {
			this.inorde = inorde;
		}

		public String getFruit_production() {
			return fruit_production;
		}
	
		public void setFruit_production(String fruit_production) {
			this.fruit_production = fruit_production;
		}

		public String getArea() {
			return area;
		}
	
		public void setArea(String area) {
			this.area = area;
		}

	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="区域（城市）长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="时间戳不能为空")
		public java.util.Date getTs() {
			return ts;
		}
	
		public void setTs(java.util.Date ts) {
			this.ts = ts;
		}

		public Integer getDr() {
			return dr;
		}
	
		public void setDr(Integer dr) {
			this.dr = dr;
		}

	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentPKFieldName() {		
		return null;
	}
	
	public String getPKFieldName() {		
		return "id";
	}
	
	public String getTableName() {
		return "ag_horticul_trees_plant";
	}
	
}