/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.yp.landch.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 土地利用信息表Entity
 * @author wangjiale
 * @version 2018-06-13
 */
public class AgLandPeriphery extends DataEntity<AgLandPeriphery> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 城市
			private String year;		// 年份
			private String increase_od;		// 增减
			private String sum;		// 合计
			private String forestland;		// 有林地
			private String other_fd;		// 其他林地
			private String forest_gp;		// 林草小计
			private String waters;		// 水域
			private String town;		// 城镇
			private String rural_residential;		// 农村居民地
			private String paddy_field;		// 水田
			private String dry_farmland;		// 旱田
			private String cultivated_land;		// 耕地小计
			private String unused_land;		// 未利用地
			private String grassland;		// 草地
			private String marshland;		// 沼泽地
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgLandPeriphery() {
		super();
	}

	public AgLandPeriphery(String id){
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

		public String getIncrease_od() {
			return increase_od;
		}
	
		public void setIncrease_od(String increase_od) {
			this.increase_od = increase_od;
		}

		public String getSum() {
			return sum;
		}
	
		public void setSum(String sum) {
			this.sum = sum;
		}

		public String getForestland() {
			return forestland;
		}
	
		public void setForestland(String forestland) {
			this.forestland = forestland;
		}

		public String getOther_fd() {
			return other_fd;
		}
	
		public void setOther_fd(String other_fd) {
			this.other_fd = other_fd;
		}

		public String getForest_gp() {
			return forest_gp;
		}
	
		public void setForest_gp(String forest_gp) {
			this.forest_gp = forest_gp;
		}

		public String getWaters() {
			return waters;
		}
	
		public void setWaters(String waters) {
			this.waters = waters;
		}

		public String getTown() {
			return town;
		}
	
		public void setTown(String town) {
			this.town = town;
		}

		public String getRural_residential() {
			return rural_residential;
		}
	
		public void setRural_residential(String rural_residential) {
			this.rural_residential = rural_residential;
		}

		public String getPaddy_field() {
			return paddy_field;
		}
	
		public void setPaddy_field(String paddy_field) {
			this.paddy_field = paddy_field;
		}

		public String getDry_farmland() {
			return dry_farmland;
		}
	
		public void setDry_farmland(String dry_farmland) {
			this.dry_farmland = dry_farmland;
		}

		public String getCultivated_land() {
			return cultivated_land;
		}
	
		public void setCultivated_land(String cultivated_land) {
			this.cultivated_land = cultivated_land;
		}

		public String getUnused_land() {
			return unused_land;
		}
	
		public void setUnused_land(String unused_land) {
			this.unused_land = unused_land;
		}

		public String getGrassland() {
			return grassland;
		}
	
		public void setGrassland(String grassland) {
			this.grassland = grassland;
		}

		public String getMarshland() {
			return marshland;
		}
	
		public void setMarshland(String marshland) {
			this.marshland = marshland;
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
		return "ag_land_periphery";
	}
	
}