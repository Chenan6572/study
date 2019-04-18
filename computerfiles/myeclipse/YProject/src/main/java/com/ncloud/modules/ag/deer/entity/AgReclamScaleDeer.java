/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.deer.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 2000年吉林省国有鹿场情况Entity
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgReclamScaleDeer extends DataEntity<AgReclamScaleDeer> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String year;		// 年份
			private String area;		// 场名
			private String ftree_area;		// 隶属关系
			private String ftree_out;		// 社会从业人数（人）
			private String population;		// 人口（人）
			private String deer;		// 鹿（头）
			private String velvet;		// 鹿茸产量（公斤）
			private String income;		// 年人均纯收入（元）
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgReclamScaleDeer() {
		super();
	}

	public AgReclamScaleDeer(String id){
		super(id);
	}


	@Length(min=0, max=20, message="区域（城市）长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="场名长度必须介于 0 和 20 之间")
		public String getArea() {
			return area;
		}
	
		public void setArea(String area) {
			this.area = area;
		}

	@Length(min=0, max=20, message="隶属关系长度必须介于 0 和 20 之间")
		public String getFtree_area() {
			return ftree_area;
		}
	
		public void setFtree_area(String ftree_area) {
			this.ftree_area = ftree_area;
		}

	@Length(min=0, max=20, message="社会从业人数（人）长度必须介于 0 和 20 之间")
		public String getFtree_out() {
			return ftree_out;
		}
	
		public void setFtree_out(String ftree_out) {
			this.ftree_out = ftree_out;
		}

	@Length(min=0, max=20, message="人口（人）长度必须介于 0 和 20 之间")
		public String getPopulation() {
			return population;
		}
	
		public void setPopulation(String population) {
			this.population = population;
		}

	@Length(min=0, max=20, message="鹿（头）长度必须介于 0 和 20 之间")
		public String getDeer() {
			return deer;
		}
	
		public void setDeer(String deer) {
			this.deer = deer;
		}

	@Length(min=0, max=20, message="鹿茸产量（公斤）长度必须介于 0 和 20 之间")
		public String getVelvet() {
			return velvet;
		}
	
		public void setVelvet(String velvet) {
			this.velvet = velvet;
		}

	@Length(min=0, max=20, message="年人均纯收入（元）长度必须介于 0 和 20 之间")
		public String getIncome() {
			return income;
		}
	
		public void setIncome(String income) {
			this.income = income;
		}

	@Length(min=0, max=20, message="创建人长度必须介于 0 和 20 之间")
		public String getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(String create_by) {
			this.create_by = create_by;
		}

	@Length(min=0, max=20, message="创建时间长度必须介于 0 和 20 之间")
		public String getCreate_date() {
			return create_date;
		}
	
		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

	@Length(min=0, max=20, message="更新人长度必须介于 0 和 20 之间")
		public String getUpdate_by() {
			return update_by;
		}
	
		public void setUpdate_by(String update_by) {
			this.update_by = update_by;
		}

	@Length(min=0, max=20, message="更新时间长度必须介于 0 和 20 之间")
		public String getUpdate_date() {
			return update_date;
		}
	
		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
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
		return "ag_reclam_scale_deer";
	}
	
}