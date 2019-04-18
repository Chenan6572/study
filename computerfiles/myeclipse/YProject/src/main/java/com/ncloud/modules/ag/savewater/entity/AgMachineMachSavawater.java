/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.savewater.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 机械化节水保墒栽培技术项目Entity
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgMachineMachSavawater extends DataEntity<AgMachineMachSavawater> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String year;		// 年份
			private String plan_area;		// 计划面积（万亩）
			private String fin_area;		// 完成面积（万亩）
			private String machine;		// 投入机具（万台）
			private String acre_increase;		// 亩均增产（公斤）
			private String new_total;		// 新增总产（公斤）
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgMachineMachSavawater() {
		super();
	}

	public AgMachineMachSavawater(String id){
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

	@Length(min=0, max=20, message="计划面积（万亩）长度必须介于 0 和 20 之间")
		public String getPlan_area() {
			return plan_area;
		}
	
		public void setPlan_area(String plan_area) {
			this.plan_area = plan_area;
		}

	@Length(min=0, max=20, message="完成面积（万亩）长度必须介于 0 和 20 之间")
		public String getFin_area() {
			return fin_area;
		}
	
		public void setFin_area(String fin_area) {
			this.fin_area = fin_area;
		}

	@Length(min=0, max=20, message="投入机具（万台）长度必须介于 0 和 20 之间")
		public String getMachine() {
			return machine;
		}
	
		public void setMachine(String machine) {
			this.machine = machine;
		}

	@Length(min=0, max=255, message="亩均增产（公斤）长度必须介于 0 和 255 之间")
		public String getAcre_increase() {
			return acre_increase;
		}
	
		public void setAcre_increase(String acre_increase) {
			this.acre_increase = acre_increase;
		}

	@Length(min=0, max=255, message="新增总产（公斤）长度必须介于 0 和 255 之间")
		public String getNew_total() {
			return new_total;
		}
	
		public void setNew_total(String new_total) {
			this.new_total = new_total;
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
		return "ag_machine_mach_savawater";
	}
	
}