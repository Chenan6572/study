/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.husbandry.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 农垦企业畜牧业生产情况Entity
 * @author wangjiale
 * @version 2018-07-09
 */
public class AgReclamhusbandry extends DataEntity<AgReclamhusbandry> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String year;		// 年份
			private String varieties;		// 业种类
			private String livestock;		// 大牲畜
			private String cow;		// 牛（万头）
			private String pig;		// 猪（万头）
			private String goat;		// 羊（万头）
			private String deer;		// 鹿（万头）
			private String meat;		// 肉类（吨）
			private String milk;		// 牛奶（吨）
			private String eggs;		// 禽蛋（吨）
			private String antler;		// 鹿茸（公斤）
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgReclamhusbandry() {
		super();
	}

	public AgReclamhusbandry(String id){
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

	@Length(min=0, max=20, message="业种类长度必须介于 0 和 20 之间")
		public String getVarieties() {
			return varieties;
		}
	
		public void setVarieties(String varieties) {
			this.varieties = varieties;
		}

	@Length(min=0, max=20, message="大牲畜长度必须介于 0 和 20 之间")
		public String getLivestock() {
			return livestock;
		}
	
		public void setLivestock(String livestock) {
			this.livestock = livestock;
		}

	@Length(min=0, max=20, message="牛（万头）长度必须介于 0 和 20 之间")
		public String getCow() {
			return cow;
		}
	
		public void setCow(String cow) {
			this.cow = cow;
		}

	@Length(min=0, max=20, message="猪（万头）长度必须介于 0 和 20 之间")
		public String getPig() {
			return pig;
		}
	
		public void setPig(String pig) {
			this.pig = pig;
		}

	@Length(min=0, max=20, message="羊（万头）长度必须介于 0 和 20 之间")
		public String getGoat() {
			return goat;
		}
	
		public void setGoat(String goat) {
			this.goat = goat;
		}

	@Length(min=0, max=20, message="鹿（万头）长度必须介于 0 和 20 之间")
		public String getDeer() {
			return deer;
		}
	
		public void setDeer(String deer) {
			this.deer = deer;
		}

	@Length(min=0, max=20, message="肉类（吨）长度必须介于 0 和 20 之间")
		public String getMeat() {
			return meat;
		}
	
		public void setMeat(String meat) {
			this.meat = meat;
		}

	@Length(min=0, max=20, message="牛奶（吨）长度必须介于 0 和 20 之间")
		public String getMilk() {
			return milk;
		}
	
		public void setMilk(String milk) {
			this.milk = milk;
		}

	@Length(min=0, max=20, message="禽蛋（吨）长度必须介于 0 和 20 之间")
		public String getEggs() {
			return eggs;
		}
	
		public void setEggs(String eggs) {
			this.eggs = eggs;
		}

	@Length(min=0, max=255, message="鹿茸（公斤）长度必须介于 0 和 255 之间")
		public String getAntler() {
			return antler;
		}
	
		public void setAntler(String antler) {
			this.antler = antler;
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
		return "ag_reclam_enterprises";
	}
	
}