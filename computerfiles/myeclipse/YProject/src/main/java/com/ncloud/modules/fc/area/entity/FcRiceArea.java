/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.area.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 吉林省水稻分区面积统计Entity
 * @author wangjiale
 * @version 2018-06-22
 */
public class FcRiceArea extends DataEntity<FcRiceArea> {
	
	private static final long serialVersionUID = 1L;
			private String update_date;		// 更新时间
			private String update_by;		// 更新人
			private String create_date;		// 创建时间
			private String create_by;		// 创建人
			private String west_sum;		// 西部合计
			private String west;		// 西部
			private String middle_sum;		// 中部合计
			private String middle;		// 中部
			private String east_sum;		// 东部合计
			private String east;		// 东部
			private String province_sum;		// 全省合计
			private String province;		// 全省
			private String year;		// 年份
			private String area;		// 区域
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public FcRiceArea() {
		super();
	}

	public FcRiceArea(String id){
		super(id);
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

	@Length(min=0, max=20, message="创建时间长度必须介于 0 和 20 之间")
		public String getCreate_date() {
			return create_date;
		}
	
		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

	@Length(min=0, max=20, message="创建人长度必须介于 0 和 20 之间")
		public String getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(String create_by) {
			this.create_by = create_by;
		}

		public String getWest_sum() {
			return west_sum;
		}
	
		public void setWest_sum(String west_sum) {
			this.west_sum = west_sum;
		}

	@Length(min=0, max=20, message="西部长度必须介于 0 和 20 之间")
		public String getWest() {
			return west;
		}
	
		public void setWest(String west) {
			this.west = west;
		}

		public String getMiddle_sum() {
			return middle_sum;
		}
	
		public void setMiddle_sum(String middle_sum) {
			this.middle_sum = middle_sum;
		}

	@Length(min=0, max=20, message="中部长度必须介于 0 和 20 之间")
		public String getMiddle() {
			return middle;
		}
	
		public void setMiddle(String middle) {
			this.middle = middle;
		}

		public String getEast_sum() {
			return east_sum;
		}
	
		public void setEast_sum(String east_sum) {
			this.east_sum = east_sum;
		}

	@Length(min=0, max=20, message="东部长度必须介于 0 和 20 之间")
		public String getEast() {
			return east;
		}
	
		public void setEast(String east) {
			this.east = east;
		}

		public String getProvince_sum() {
			return province_sum;
		}
	
		public void setProvince_sum(String province_sum) {
			this.province_sum = province_sum;
		}

	@Length(min=0, max=20, message="全省长度必须介于 0 和 20 之间")
		public String getProvince() {
			return province;
		}
	
		public void setProvince(String province) {
			this.province = province;
		}

	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="区域长度必须介于 0 和 20 之间")
		public String getArea() {
			return area;
		}
	
		public void setArea(String area) {
			this.area = area;
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
		return "fc_rice_area";
	}
	
}