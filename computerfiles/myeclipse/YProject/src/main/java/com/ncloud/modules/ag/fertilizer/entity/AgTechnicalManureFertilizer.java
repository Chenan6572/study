/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.fertilizer.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 农业化肥施用量统计Entity
 * @author wangjaile
 * @version 2018-07-05
 */
public class AgTechnicalManureFertilizer extends DataEntity<AgTechnicalManureFertilizer> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 城市
			private String year;		// 年份
			private String total_physical;		// 实物量合计（万吨）
			private String total_refractive;		// 折纯量合计（万吨）
			private String way;		// 施肥方式
			private String nitrogen;		// 氮肥（万吨）
			private String phosphate;		// 磷肥（万吨）
			private String potash;		// 钾肥（万吨）
			private String compound;		// 复合肥（万吨）
			private String per_mu;		// 亩均施化肥量（万吨）
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgTechnicalManureFertilizer() {
		super();
	}

	public AgTechnicalManureFertilizer(String id){
		super(id);
	}


	@Length(min=0, max=20, message="城市长度必须介于 0 和 20 之间")
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

		public String getTotal_physical() {
			return total_physical;
		}
	
		public void setTotal_physical(String total_physical) {
			this.total_physical = total_physical;
		}

		public String getTotal_refractive() {
			return total_refractive;
		}
	
		public void setTotal_refractive(String total_refractive) {
			this.total_refractive = total_refractive;
		}

	@Length(min=0, max=20, message="施肥方式长度必须介于 0 和 20 之间")
		public String getWay() {
			return way;
		}
	
		public void setWay(String way) {
			this.way = way;
		}

		public String getNitrogen() {
			return nitrogen;
		}
	
		public void setNitrogen(String nitrogen) {
			this.nitrogen = nitrogen;
		}

		public String getPhosphate() {
			return phosphate;
		}
	
		public void setPhosphate(String phosphate) {
			this.phosphate = phosphate;
		}

		public String getPotash() {
			return potash;
		}
	
		public void setPotash(String potash) {
			this.potash = potash;
		}

		public String getCompound() {
			return compound;
		}
	
		public void setCompound(String compound) {
			this.compound = compound;
		}

		public String getPer_mu() {
			return per_mu;
		}
	
		public void setPer_mu(String per_mu) {
			this.per_mu = per_mu;
		}

	@Length(min=0, max=20, message="创建人长度必须介于 0 和 20 之间")
		public String getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(String create_by) {
			this.create_by = create_by;
		}

	@Length(min=0, max=19, message="创建时间长度必须介于 0 和 19 之间")
		public String getCreate_date() {
			return create_date;
		}
	
		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

	@Length(min=0, max=19, message="更新人长度必须介于 0 和 19 之间")
		public String getUpdate_by() {
			return update_by;
		}
	
		public void setUpdate_by(String update_by) {
			this.update_by = update_by;
		}

	@Length(min=0, max=19, message="更新时间长度必须介于 0 和 19 之间")
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
		return "ag_technical_manure_fertilizer";
	}
	
}