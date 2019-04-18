/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.yp.ai.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 百度AI开放平台Entity
 * @author wangjiale
 * @version 2018-06-28
 */
public class AiFormApplication extends DataEntity<AiFormApplication> {
	
	private static final long serialVersionUID = 1L;
			private String application_type;		// 申请类型
			private String industry_choose;		// 行业选择
			private String intention_technology;		// 意向技术
			private String whether_use;		// 是否使用
			private String company_name;		// 公司名称
			private String company_website;		// 公司网址
			private String business_description;		// 业务描述
			private String cooperation_expected;		// 合作期望
			private String registered_capital;		// 注册资本
			private String employees;		// 雇员人数
			private String company_address;		// 公司地址
			private String company_tel;		// 公司电话
			private String contact_name;		// 联系人姓名
			private String contact_persion;		// 联系人职务
			private String contact_phone;		// 联系人手机
			private String contact_email;		// 联系人邮箱
			private String key;		// 密钥
			private String audit_time;		// 审核时间
			private String create_by;		// 创建人
			private String create_date;		// 创建时间
			private String update_by;		// 更新人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public AiFormApplication() {
		super();
	}

	public AiFormApplication(String id){
		super(id);
	}


	@Length(min=0, max=20, message="申请类型长度必须介于 0 和 20 之间")
		public String getApplication_type() {
			return application_type;
		}
	
		public void setApplication_type(String application_type) {
			this.application_type = application_type;
		}

	@Length(min=0, max=20, message="行业选择长度必须介于 0 和 20 之间")
		public String getIndustry_choose() {
			return industry_choose;
		}
	
		public void setIndustry_choose(String industry_choose) {
			this.industry_choose = industry_choose;
		}

	@Length(min=0, max=20, message="意向技术长度必须介于 0 和 20 之间")
		public String getIntention_technology() {
			return intention_technology;
		}
	
		public void setIntention_technology(String intention_technology) {
			this.intention_technology = intention_technology;
		}

	@Length(min=0, max=20, message="是否使用长度必须介于 0 和 20 之间")
		public String getWhether_use() {
			return whether_use;
		}
	
		public void setWhether_use(String whether_use) {
			this.whether_use = whether_use;
		}

	@Length(min=0, max=20, message="公司名称长度必须介于 0 和 20 之间")
		public String getCompany_name() {
			return company_name;
		}
	
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}

	@Length(min=0, max=20, message="公司网址长度必须介于 0 和 20 之间")
		public String getCompany_website() {
			return company_website;
		}
	
		public void setCompany_website(String company_website) {
			this.company_website = company_website;
		}

		public String getBusiness_description() {
			return business_description;
		}
	
		public void setBusiness_description(String business_description) {
			this.business_description = business_description;
		}

		public String getCooperation_expected() {
			return cooperation_expected;
		}
	
		public void setCooperation_expected(String cooperation_expected) {
			this.cooperation_expected = cooperation_expected;
		}

	@Length(min=0, max=20, message="注册资本长度必须介于 0 和 20 之间")
		public String getRegistered_capital() {
			return registered_capital;
		}
	
		public void setRegistered_capital(String registered_capital) {
			this.registered_capital = registered_capital;
		}

	@Length(min=0, max=20, message="雇员人数长度必须介于 0 和 20 之间")
		public String getEmployees() {
			return employees;
		}
	
		public void setEmployees(String employees) {
			this.employees = employees;
		}

	@Length(min=0, max=20, message="公司地址长度必须介于 0 和 20 之间")
		public String getCompany_address() {
			return company_address;
		}
	
		public void setCompany_address(String company_address) {
			this.company_address = company_address;
		}

	@Length(min=0, max=20, message="公司电话长度必须介于 0 和 20 之间")
		public String getCompany_tel() {
			return company_tel;
		}
	
		public void setCompany_tel(String company_tel) {
			this.company_tel = company_tel;
		}

	@Length(min=0, max=20, message="联系人姓名长度必须介于 0 和 20 之间")
		public String getContact_name() {
			return contact_name;
		}
	
		public void setContact_name(String contact_name) {
			this.contact_name = contact_name;
		}

	@Length(min=0, max=20, message="联系人职务长度必须介于 0 和 20 之间")
		public String getContact_persion() {
			return contact_persion;
		}
	
		public void setContact_persion(String contact_persion) {
			this.contact_persion = contact_persion;
		}

	@Length(min=0, max=20, message="联系人手机长度必须介于 0 和 20 之间")
		public String getContact_phone() {
			return contact_phone;
		}
	
		public void setContact_phone(String contact_phone) {
			this.contact_phone = contact_phone;
		}

	@Length(min=0, max=20, message="联系人邮箱长度必须介于 0 和 20 之间")
		public String getContact_email() {
			return contact_email;
		}
	
		public void setContact_email(String contact_email) {
			this.contact_email = contact_email;
		}

	@Length(min=0, max=20, message="密钥长度必须介于 0 和 20 之间")
		public String getKey() {
			return key;
		}
	
		public void setKey(String key) {
			this.key = key;
		}

	@Length(min=0, max=20, message="审核时间长度必须介于 0 和 20 之间")
		public String getAudit_time() {
			return audit_time;
		}
	
		public void setAudit_time(String audit_time) {
			this.audit_time = audit_time;
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
		return "ai_form_application";
	}
	
}