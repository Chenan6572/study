/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.production.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 吉林省蚕茧生产情况统计表Entity
 * @author wangjiale
 * @version 2018-07-03
 */
public class AgSpeCocoPro extends DataEntity<AgSpeCocoPro> {
	
	private static final long serialVersionUID = 1L;
			private java.util.Date ts;		// 时间戳
			private String update_date;		// 更新时间
			private String update_by;		// 更新人
			private String create_date;		// 创建时间
			private String create_by;		// 创建人
			private String mulberry_cocoon;		// 桑蚕茧总产量
			private String field_area;		// 桑园面积（亩）
			private String tussah_cocoon;		// 柞蚕茧总产量（公斤）
			private String acreage;		// 当年放养面积（亩）
			private String new_area;		// 当年新增面积（亩）
			private String slope_area;		// 柞坡面积（亩）
			private String coc_production;		// 蚕茧总产量（公斤）
			private String year;		// 年份
			private String org_name;		// 城市
			private Integer dr;		// 删除标识
	
	public AgSpeCocoPro() {
		super();
	}

	public AgSpeCocoPro(String id){
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

	@Length(min=0, max=19, message="更新时间长度必须介于 0 和 19 之间")
		public String getUpdate_date() {
			return update_date;
		}
	
		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
		}

	@Length(min=0, max=19, message="更新人长度必须介于 0 和 19 之间")
		public String getUpdate_by() {
			return update_by;
		}
	
		public void setUpdate_by(String update_by) {
			this.update_by = update_by;
		}

	@Length(min=0, max=19, message="创建时间长度必须介于 0 和 19 之间")
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

	@Length(min=0, max=20, message="桑蚕茧总产量长度必须介于 0 和 20 之间")
		public String getMulberry_cocoon() {
			return mulberry_cocoon;
		}
	
		public void setMulberry_cocoon(String mulberry_cocoon) {
			this.mulberry_cocoon = mulberry_cocoon;
		}

	@Length(min=0, max=20, message="桑园面积（亩）长度必须介于 0 和 20 之间")
		public String getField_area() {
			return field_area;
		}
	
		public void setField_area(String field_area) {
			this.field_area = field_area;
		}

	@Length(min=0, max=20, message="柞蚕茧总产量（公斤）长度必须介于 0 和 20 之间")
		public String getTussah_cocoon() {
			return tussah_cocoon;
		}
	
		public void setTussah_cocoon(String tussah_cocoon) {
			this.tussah_cocoon = tussah_cocoon;
		}

	@Length(min=0, max=20, message="当年放养面积（亩）长度必须介于 0 和 20 之间")
		public String getAcreage() {
			return acreage;
		}
	
		public void setAcreage(String acreage) {
			this.acreage = acreage;
		}

	@Length(min=0, max=20, message="当年新增面积（亩）长度必须介于 0 和 20 之间")
		public String getNew_area() {
			return new_area;
		}
	
		public void setNew_area(String new_area) {
			this.new_area = new_area;
		}

	@Length(min=0, max=20, message="柞坡面积（亩）长度必须介于 0 和 20 之间")
		public String getSlope_area() {
			return slope_area;
		}
	
		public void setSlope_area(String slope_area) {
			this.slope_area = slope_area;
		}

	@Length(min=0, max=20, message="蚕茧总产量（公斤）长度必须介于 0 和 20 之间")
		public String getCoc_production() {
			return coc_production;
		}
	
		public void setCoc_production(String coc_production) {
			this.coc_production = coc_production;
		}

	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="城市长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
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
		return "ag_spe_coco_pro";
	}
	
}