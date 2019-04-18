/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.service.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 吉林省乡、村农机化服务组织服务情况Entity
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgMachineManaService extends DataEntity<AgMachineManaService> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String year;		// 年份
			private Double towns;		// 乡镇数
			private Double mana_serivce;		// 建管理服务站
			private Double village;		// 村数
			private Double cooperative;		// 农机队或合作社
			private Double association;		// 农机协会
			private Double administrator;		// 农机管理员
			private Double nongjihu;		// 农机户
			private Double pro_nongjihu;		// 其中农机专业户
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgMachineManaService() {
		super();
	}

	public AgMachineManaService(String id){
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

		public Double getTowns() {
			return towns;
		}
	
		public void setTowns(Double towns) {
			this.towns = towns;
		}

		public Double getMana_serivce() {
			return mana_serivce;
		}
	
		public void setMana_serivce(Double mana_serivce) {
			this.mana_serivce = mana_serivce;
		}

		public Double getVillage() {
			return village;
		}
	
		public void setVillage(Double village) {
			this.village = village;
		}

		public Double getCooperative() {
			return cooperative;
		}
	
		public void setCooperative(Double cooperative) {
			this.cooperative = cooperative;
		}

		public Double getAssociation() {
			return association;
		}
	
		public void setAssociation(Double association) {
			this.association = association;
		}

		public Double getAdministrator() {
			return administrator;
		}
	
		public void setAdministrator(Double administrator) {
			this.administrator = administrator;
		}

		public Double getNongjihu() {
			return nongjihu;
		}
	
		public void setNongjihu(Double nongjihu) {
			this.nongjihu = nongjihu;
		}

		public Double getPro_nongjihu() {
			return pro_nongjihu;
		}
	
		public void setPro_nongjihu(Double pro_nongjihu) {
			this.pro_nongjihu = pro_nongjihu;
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
		return "ag_machine_mana_service";
	}
	
}