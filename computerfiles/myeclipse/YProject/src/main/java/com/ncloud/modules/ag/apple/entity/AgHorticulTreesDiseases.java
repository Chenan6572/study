/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.apple.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 苹果主要病虫害防治Entity
 * @author wangjiale
 * @version 2018-07-04
 */
public class AgHorticulTreesDiseases extends DataEntity<AgHorticulTreesDiseases> {
	
	private static final long serialVersionUID = 1L;
			private String year;		// 年份
			private String org_name;		// 地区
			private String varieties;		// 品种
			private String prevention_time;		// 防治时期
			private String prevention_treat;		// 防治对象
			private String prevention_methods;		// 防治措施
			private String create_by;		// 创建人
			private String create_date;		// 创建日期
			private String updata_by;		// 更新人
			private String updata_date;		// 更新日期
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgHorticulTreesDiseases() {
		super();
	}

	public AgHorticulTreesDiseases(String id){
		super(id);
	}


	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="地区长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@Length(min=0, max=20, message="品种长度必须介于 0 和 20 之间")
		public String getVarieties() {
			return varieties;
		}
	
		public void setVarieties(String varieties) {
			this.varieties = varieties;
		}

	@Length(min=0, max=20, message="防治时期长度必须介于 0 和 20 之间")
		public String getPrevention_time() {
			return prevention_time;
		}
	
		public void setPrevention_time(String prevention_time) {
			this.prevention_time = prevention_time;
		}

	@Length(min=0, max=500, message="防治对象长度必须介于 0 和 500 之间")
		public String getPrevention_treat() {
			return prevention_treat;
		}
	
		public void setPrevention_treat(String prevention_treat) {
			this.prevention_treat = prevention_treat;
		}

	@Length(min=0, max=500, message="防治措施长度必须介于 0 和 500 之间")
		public String getPrevention_methods() {
			return prevention_methods;
		}
	
		public void setPrevention_methods(String prevention_methods) {
			this.prevention_methods = prevention_methods;
		}

	@Length(min=0, max=20, message="创建人长度必须介于 0 和 20 之间")
		public String getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(String create_by) {
			this.create_by = create_by;
		}

	@Length(min=0, max=20, message="创建日期长度必须介于 0 和 20 之间")
		public String getCreate_date() {
			return create_date;
		}
	
		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

	@Length(min=0, max=20, message="更新人长度必须介于 0 和 20 之间")
		public String getUpdata_by() {
			return updata_by;
		}
	
		public void setUpdata_by(String updata_by) {
			this.updata_by = updata_by;
		}

	@Length(min=0, max=20, message="更新日期长度必须介于 0 和 20 之间")
		public String getUpdata_date() {
			return updata_date;
		}
	
		public void setUpdata_date(String updata_date) {
			this.updata_date = updata_date;
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
		return "ag_horticul_trees_diseases";
	}
	
}