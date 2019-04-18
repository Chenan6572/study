/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.yaoxie.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 病虫害发生防治面积和农药使用量Entity
 * @author wangjiale
 * @version 2018-07-05
 */
public class AgTechnicalProtectionYaoxie extends DataEntity<AgTechnicalProtectionYaoxie> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String year;		// 年份
			private String disease;		// 病虫害发生面积（万亩次）
			private String prevention;		// 防治面积（万亩次）
			private String pesticide;		// 农药使用量（吨）
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgTechnicalProtectionYaoxie() {
		super();
	}

	public AgTechnicalProtectionYaoxie(String id){
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

	@Length(min=0, max=20, message="病虫害发生面积（万亩次）长度必须介于 0 和 20 之间")
		public String getDisease() {
			return disease;
		}
	
		public void setDisease(String disease) {
			this.disease = disease;
		}

	@Length(min=0, max=20, message="防治面积（万亩次）长度必须介于 0 和 20 之间")
		public String getPrevention() {
			return prevention;
		}
	
		public void setPrevention(String prevention) {
			this.prevention = prevention;
		}

	@Length(min=0, max=20, message="农药使用量（吨）长度必须介于 0 和 20 之间")
		public String getPesticide() {
			return pesticide;
		}
	
		public void setPesticide(String pesticide) {
			this.pesticide = pesticide;
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
		return "ag_technical_protection_yaoxie";
	}
	
}