/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.supply.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 农机供应系统排灌Entity
 * @author wangjiale
 * @version 2018-07-06
 */
public class AgMachineSupplyPower extends DataEntity<AgMachineSupplyPower> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String year;		// 年份
			private Integer diesel_engine;		// 柴油机（台）
			private Integer gasoline_engine;		// 汽油机（台）
			private Integer motor;		// 电动机（台）
			private Integer large_pump;		// 大泵（台）
			private Integer deep_pump;		// 深井泵（台）
			private Integer purchases;		// 纯购进（万元）
			private Integer sales;		// 纯销售（万元）
			private Integer inventory;		// 年末库存（万元）
			private Integer operating;		// 经营利润（万元）
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgMachineSupplyPower() {
		super();
	}

	public AgMachineSupplyPower(String id){
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

		public Integer getDiesel_engine() {
			return diesel_engine;
		}
	
		public void setDiesel_engine(Integer diesel_engine) {
			this.diesel_engine = diesel_engine;
		}

		public Integer getGasoline_engine() {
			return gasoline_engine;
		}
	
		public void setGasoline_engine(Integer gasoline_engine) {
			this.gasoline_engine = gasoline_engine;
		}

		public Integer getMotor() {
			return motor;
		}
	
		public void setMotor(Integer motor) {
			this.motor = motor;
		}

		public Integer getLarge_pump() {
			return large_pump;
		}
	
		public void setLarge_pump(Integer large_pump) {
			this.large_pump = large_pump;
		}

		public Integer getDeep_pump() {
			return deep_pump;
		}
	
		public void setDeep_pump(Integer deep_pump) {
			this.deep_pump = deep_pump;
		}

		public Integer getPurchases() {
			return purchases;
		}
	
		public void setPurchases(Integer purchases) {
			this.purchases = purchases;
		}

		public Integer getSales() {
			return sales;
		}
	
		public void setSales(Integer sales) {
			this.sales = sales;
		}

		public Integer getInventory() {
			return inventory;
		}
	
		public void setInventory(Integer inventory) {
			this.inventory = inventory;
		}

		public Integer getOperating() {
			return operating;
		}
	
		public void setOperating(Integer operating) {
			this.operating = operating;
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
		return "ag_machine_supply_power";
	}
	
}