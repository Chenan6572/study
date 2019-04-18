/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ginsengprodu.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 1986-2000年吉林省人（园）参生产情况Entity
 * @author YGD
 * @version 2018-07-02
 */
public class AgSpeRedGinseng extends DataEntity<AgSpeRedGinseng> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 城市
			private String year;		// 年份
			private String varieties;		// 品种
			private String goods;		// 品名
			private String specifications_grades;		// 规格及等级
			private String price;		// 价格
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgSpeRedGinseng() {
		super();
	}

	public AgSpeRedGinseng(String id){
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

	@Length(min=0, max=20, message="品种长度必须介于 0 和 20 之间")
		public String getVarieties() {
			return varieties;
		}
	
		public void setVarieties(String varieties) {
			this.varieties = varieties;
		}

	@Length(min=0, max=20, message="品名长度必须介于 0 和 20 之间")
		public String getGoods() {
			return goods;
		}
	
		public void setGoods(String goods) {
			this.goods = goods;
		}

	@Length(min=0, max=20, message="规格及等级长度必须介于 0 和 20 之间")
		public String getSpecifications_grades() {
			return specifications_grades;
		}
	
		public void setSpecifications_grades(String specifications_grades) {
			this.specifications_grades = specifications_grades;
		}

	@Length(min=0, max=20, message="价格长度必须介于 0 和 20 之间")
		public String getPrice() {
			return price;
		}
	
		public void setPrice(String price) {
			this.price = price;
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
		return "ag_spe_red_ginseng";
	}
	
}