/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.rice.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 1986-2000年吉林省水稻面积产量Entity
 * @author wangjiale
 * @version 2018-06-22
 */
public class FcRiceProduction extends DataEntity<FcRiceProduction> {
	
	private static final long serialVersionUID = 1L;
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
			private String update_date;		// 更新时间
			private String update_by;		// 更新人
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String area_yield;		// 亩产量
			private String area;		// 面积（万亩）
			private String total_output;		// 总产量（万吨）
			private String year;		// 年份
	
	public FcRiceProduction() {
		super();
	}

	public FcRiceProduction(String id){
		super(id);
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

	@Length(min=0, max=20, message="更新时间长度必须介于 0 和 20 之间")
		public String getUpdate_date() {
			return update_date;
		}
	
		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
		}

	@Length(min=0, max=20, message="更新人长度必须介于 0 和 20 之间")
		public String getUpdate_by() {
			return update_by;
		}
	
		public void setUpdate_by(String update_by) {
			this.update_by = update_by;
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

		public String getArea_yield() {
			return area_yield;
		}
	
		public void setArea_yield(String area_yield) {
			this.area_yield = area_yield;
		}

		public String getArea() {
			return area;
		}
	
		public void setArea(String area) {
			this.area = area;
		}

		public String getTotal_output() {
			return total_output;
		}
	
		public void setTotal_output(String total_output) {
			this.total_output = total_output;
		}

	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
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
		return "fc_rice_production";
	}
	
}