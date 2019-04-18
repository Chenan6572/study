/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.fc.potato.entity;

import org.hibernate.validator.constraints.Length;
import com.sunsd.lfw.modules.sys.entity.User;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 2000年吉林省各市县马铃薯统计Entity
 * @author wangjiale
 * @version 2018-06-25
 */
public class FcPotatoStatistics extends DataEntity<FcPotatoStatistics> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 地区
			private String area_sown;		// 播种面积（万亩）
			private String total_output;		// 总产量（万吨）
			private String mu_yield;		// 亩单产（公斤）
			private com.sunsd.lfw.modules.sys.entity.User create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_time;		// 更新时间
			private String ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public FcPotatoStatistics() {
		super();
	}

	public FcPotatoStatistics(String id){
		super(id);
	}


	@Length(min=0, max=20, message="地区长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@Length(min=0, max=20, message="播种面积（万亩）长度必须介于 0 和 20 之间")
		public String getArea_sown() {
			return area_sown;
		}
	
		public void setArea_sown(String area_sown) {
			this.area_sown = area_sown;
		}

	@Length(min=0, max=20, message="总产量（万吨）长度必须介于 0 和 20 之间")
		public String getTotal_output() {
			return total_output;
		}
	
		public void setTotal_output(String total_output) {
			this.total_output = total_output;
		}

	@Length(min=0, max=20, message="亩单产（公斤）长度必须介于 0 和 20 之间")
		public String getMu_yield() {
			return mu_yield;
		}
	
		public void setMu_yield(String mu_yield) {
			this.mu_yield = mu_yield;
		}

		public com.sunsd.lfw.modules.sys.entity.User getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(com.sunsd.lfw.modules.sys.entity.User create_by) {
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
		public String getUpdate_time() {
			return update_time;
		}
	
		public void setUpdate_time(String update_time) {
			this.update_time = update_time;
		}

		public String getTs() {
			return ts;
		}
	
		public void setTs(String ts) {
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
		return "fc_potato_statistics";
	}
	
}