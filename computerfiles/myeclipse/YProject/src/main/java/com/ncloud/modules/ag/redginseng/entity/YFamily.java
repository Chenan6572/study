/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.ncloud.modules.ag.redginseng.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.sunsd.lfw.common.persistence.DataEntity;

/**
 * 1988年长白山红参（抚宝牌）系列品种销售价格表Entity
 * @author wangjiale
 * @version 2018-07-02
 */
public class YFamily extends DataEntity<YFamily> {
	
	private static final long serialVersionUID = 1L;
			private String parentid;		// 父主键
			private String code;		// 人员编号
			private String name;		// 姓名
			private String idcard;		// 身份证
			private String other_card_type;		// 其他证件类型
			private String other_card_code;		// 其他证件号码
			private String sex;		// 性别
			private String birthday;		// 出生日期
			private String nationality;		// 国籍/地区
			private String nation;		// 民族
			private String nickname;		// 别名/绰号
			private String identity;		// 身份
			private String domicile_place;		// 户籍地
			private String register_address;		// 户籍地址
			private String nowaddress;		// 现住地
			private String education;		// 文化程度
			private String telephone_one;		// 联系方式1
			private String telephone_two;		// 联系方式2
			private String telephone_three;		// 联系方式3
			private String people_state;		// 人员状态
			private String license_num;		// 车牌号
			private String note;		// 说明
			private String picture;		// 头像
			private String org_name;		// 所属组织
			private String create_by;		// 创建人
			private String create_date;		// 创建日期
			private String update_by;		// 操作人
			private String update_date;		// 更新时间
			private java.util.Date ts;		// 时间戳
			private Integer dr;		// 删除标识
	
	public YFamily() {
		super();
	}

	public YFamily(String id){
		super(id);
	}


	@Length(min=0, max=20, message="父主键长度必须介于 0 和 20 之间")
		public String getParentid() {
			return parentid;
		}
	
		public void setParentid(String parentid) {
			this.parentid = parentid;
		}

	@Length(min=0, max=50, message="人员编号长度必须介于 0 和 50 之间")
		public String getCode() {
			return code;
		}
	
		public void setCode(String code) {
			this.code = code;
		}

	@Length(min=0, max=20, message="姓名长度必须介于 0 和 20 之间")
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}

	@Length(min=0, max=20, message="身份证长度必须介于 0 和 20 之间")
		public String getIdcard() {
			return idcard;
		}
	
		public void setIdcard(String idcard) {
			this.idcard = idcard;
		}

	@Length(min=0, max=2, message="其他证件类型长度必须介于 0 和 2 之间")
		public String getOther_card_type() {
			return other_card_type;
		}
	
		public void setOther_card_type(String other_card_type) {
			this.other_card_type = other_card_type;
		}

	@Length(min=0, max=30, message="其他证件号码长度必须介于 0 和 30 之间")
		public String getOther_card_code() {
			return other_card_code;
		}
	
		public void setOther_card_code(String other_card_code) {
			this.other_card_code = other_card_code;
		}

	@Length(min=0, max=2, message="性别长度必须介于 0 和 2 之间")
		public String getSex() {
			return sex;
		}
	
		public void setSex(String sex) {
			this.sex = sex;
		}

	@Length(min=0, max=10, message="出生日期长度必须介于 0 和 10 之间")
		public String getBirthday() {
			return birthday;
		}
	
		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

	@Length(min=0, max=20, message="国籍/地区长度必须介于 0 和 20 之间")
		public String getNationality() {
			return nationality;
		}
	
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

	@Length(min=0, max=5, message="民族长度必须介于 0 和 5 之间")
		public String getNation() {
			return nation;
		}
	
		public void setNation(String nation) {
			this.nation = nation;
		}

	@Length(min=0, max=20, message="别名/绰号长度必须介于 0 和 20 之间")
		public String getNickname() {
			return nickname;
		}
	
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

	@Length(min=0, max=20, message="身份长度必须介于 0 和 20 之间")
		public String getIdentity() {
			return identity;
		}
	
		public void setIdentity(String identity) {
			this.identity = identity;
		}

	@Length(min=0, max=255, message="户籍地长度必须介于 0 和 255 之间")
		public String getDomicile_place() {
			return domicile_place;
		}
	
		public void setDomicile_place(String domicile_place) {
			this.domicile_place = domicile_place;
		}

	@Length(min=0, max=255, message="户籍地址长度必须介于 0 和 255 之间")
		public String getRegister_address() {
			return register_address;
		}
	
		public void setRegister_address(String register_address) {
			this.register_address = register_address;
		}

	@Length(min=0, max=255, message="现住地长度必须介于 0 和 255 之间")
		public String getNowaddress() {
			return nowaddress;
		}
	
		public void setNowaddress(String nowaddress) {
			this.nowaddress = nowaddress;
		}

	@Length(min=0, max=2, message="文化程度长度必须介于 0 和 2 之间")
		public String getEducation() {
			return education;
		}
	
		public void setEducation(String education) {
			this.education = education;
		}

	@Length(min=0, max=20, message="联系方式1长度必须介于 0 和 20 之间")
		public String getTelephone_one() {
			return telephone_one;
		}
	
		public void setTelephone_one(String telephone_one) {
			this.telephone_one = telephone_one;
		}

	@Length(min=0, max=20, message="联系方式2长度必须介于 0 和 20 之间")
		public String getTelephone_two() {
			return telephone_two;
		}
	
		public void setTelephone_two(String telephone_two) {
			this.telephone_two = telephone_two;
		}

	@Length(min=0, max=20, message="联系方式3长度必须介于 0 和 20 之间")
		public String getTelephone_three() {
			return telephone_three;
		}
	
		public void setTelephone_three(String telephone_three) {
			this.telephone_three = telephone_three;
		}

	@Length(min=0, max=20, message="人员状态长度必须介于 0 和 20 之间")
		public String getPeople_state() {
			return people_state;
		}
	
		public void setPeople_state(String people_state) {
			this.people_state = people_state;
		}

	@Length(min=0, max=10, message="车牌号长度必须介于 0 和 10 之间")
		public String getLicense_num() {
			return license_num;
		}
	
		public void setLicense_num(String license_num) {
			this.license_num = license_num;
		}

	@Length(min=0, max=255, message="说明长度必须介于 0 和 255 之间")
		public String getNote() {
			return note;
		}
	
		public void setNote(String note) {
			this.note = note;
		}

	@Length(min=0, max=255, message="头像长度必须介于 0 和 255 之间")
		public String getPicture() {
			return picture;
		}
	
		public void setPicture(String picture) {
			this.picture = picture;
		}

	@Length(min=0, max=20, message="所属组织长度必须介于 0 和 20 之间")
		public String getOrg_name() {
			return org_name;
		}
	
		public void setOrg_name(String org_name) {
			this.org_name = org_name;
		}

	@Length(min=0, max=20, message="创建人长度必须介于 0 和 20 之间")
		public String getCreate_by() {
			return create_by;
		}
	
		public void setCreate_by(String create_by) {
			this.create_by = create_by;
		}

	@Length(min=0, max=19, message="创建日期长度必须介于 0 和 19 之间")
		public String getCreate_date() {
			return create_date;
		}
	
		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

	@Length(min=0, max=20, message="操作人长度必须介于 0 和 20 之间")
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
		return "y_family";
	}
	
}