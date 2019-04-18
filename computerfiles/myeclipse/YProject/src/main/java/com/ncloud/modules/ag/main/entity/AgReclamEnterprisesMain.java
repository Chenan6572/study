/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.main.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 吉林省重点建设农垦工业企业情况Entity
 * @author wangjiale
 * @version 2018-07-09
 */
public class AgReclamEnterprisesMain extends DataEntity<AgReclamEnterprisesMain> {
	
	private static final long serialVersionUID = 1L;
			private String year;		// 年份
			private String project;		// 项目
			private String org_name;		// 建设地点
			private String scale;		// 建设规模
			private String fixed;		// 建设年限
			private String source;		// 资金来源
			private String investment;		// 总投资
			private String plan;		// 计划
			private String actual;		// 实际
			private String output;		// 产值
			private String profits;		// 利润
			private String tax;		// 税金
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AgReclamEnterprisesMain() {
		super();
	}

	public AgReclamEnterprisesMain(String id){
		super(id);
	}


	@Length(min=0, max=20, message="年份长度必须介于 0 和 20 之间")
		public String getYear() {
			return year;
		}
	
		public void setYear(String year) {
			this.year = year;
		}

	@Length(min=0, max=20, message="项目长度必须介于 0 和 20 之间")
		public String getProject() {
			return project;
		}
	
		public void setProject(String project) {
			this.project = project;
		}

	@Length(min=0, max=20, message="建设地点长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@Length(min=0, max=20, message="建设规模长度必须介于 0 和 20 之间")
		public String getScale() {
			return scale;
		}
	
		public void setScale(String scale) {
			this.scale = scale;
		}

	@Length(min=0, max=20, message="建设年限长度必须介于 0 和 20 之间")
		public String getFixed() {
			return fixed;
		}
	
		public void setFixed(String fixed) {
			this.fixed = fixed;
		}

	@Length(min=0, max=20, message="资金来源长度必须介于 0 和 20 之间")
		public String getSource() {
			return source;
		}
	
		public void setSource(String source) {
			this.source = source;
		}

	@Length(min=0, max=20, message="总投资长度必须介于 0 和 20 之间")
		public String getInvestment() {
			return investment;
		}
	
		public void setInvestment(String investment) {
			this.investment = investment;
		}

	@Length(min=0, max=20, message="计划长度必须介于 0 和 20 之间")
		public String getPlan() {
			return plan;
		}
	
		public void setPlan(String plan) {
			this.plan = plan;
		}

	@Length(min=0, max=20, message="实际长度必须介于 0 和 20 之间")
		public String getActual() {
			return actual;
		}
	
		public void setActual(String actual) {
			this.actual = actual;
		}

	@Length(min=0, max=20, message="产值长度必须介于 0 和 20 之间")
		public String getOutput() {
			return output;
		}
	
		public void setOutput(String output) {
			this.output = output;
		}

	@Length(min=0, max=20, message="利润长度必须介于 0 和 20 之间")
		public String getProfits() {
			return profits;
		}
	
		public void setProfits(String profits) {
			this.profits = profits;
		}

	@Length(min=0, max=20, message="税金长度必须介于 0 和 20 之间")
		public String getTax() {
			return tax;
		}
	
		public void setTax(String tax) {
			this.tax = tax;
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
		return "ag_reclam_enterprises_main";
	}
	
}