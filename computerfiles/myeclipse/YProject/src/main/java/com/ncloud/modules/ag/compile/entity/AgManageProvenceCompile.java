/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.compile.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 农委（农业厅）指数事业单位编制Entity
 * @author wangjiale
 * @version 2018-07-10
 */
public class AgManageProvenceCompile extends DataEntity<AgManageProvenceCompile> {
	
	private static final long serialVersionUID = 1L;
			private String org_name;		// 区域（城市）
			private String name_entity;		// 单位名称
			private String year;		// 年份
			private String compile_one;		// 编制（1986年）
			private String compile_two;		// 编制（2000年）
			private String ftree_out;		// 实有
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgManageProvenceCompile() {
		super();
	}

	public AgManageProvenceCompile(String id){
		super(id);
	}


	@Length(min=0, max=20, message="区域（城市）长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@Length(min=0, max=255, message="单位名称长度必须介于 0 和 255 之间")
		public String getName_entity() {
			return name_entity;
		}
	
		public void setName_entity(String name_entity) {
			this.name_entity = name_entity;
		}

	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="编制（1986年）长度必须介于 0 和 20 之间")
		public String getCompile_one() {
			return compile_one;
		}
	
		public void setCompile_one(String compile_one) {
			this.compile_one = compile_one;
		}

	@Length(min=0, max=20, message="编制（2000年）长度必须介于 0 和 20 之间")
		public String getCompile_two() {
			return compile_two;
		}
	
		public void setCompile_two(String compile_two) {
			this.compile_two = compile_two;
		}

	@Length(min=0, max=20, message="实有长度必须介于 0 和 20 之间")
		public String getFtree_out() {
			return ftree_out;
		}
	
		public void setFtree_out(String ftree_out) {
			this.ftree_out = ftree_out;
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
		return "ag_manage_provence_compile";
	}
	
}