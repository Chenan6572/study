package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 农家乐
 * </p>
 *
 * @author wjl
 * @since 2019-02-21
 */
@TableName("qy_agritainmentinfo")
public class QyAgritainmentinfo extends Model<QyAgritainmentinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 关联用户
     */
    private String useraccount;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 照片
     */
    private String photo;
    /**
     * 民族
     */
    private String nation;
    /**
     * 出生日期
     */
    private String birthdate;
    /**
     * 身份证
     */
    private String idcard;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 发证机关
     */
    private String certification;
    /**
     * 过期时间
     */
    private String expirationdate;
    /**
     * 行政区划
     */
    private String administrative;
    /**
     * 身份证正面
     */
    private String idfront;
    /**
     * 身份证反面
     */
    private String idreverse;
    /**
     * 营业执照
     */
    private String businesslicense;
    /**
     * 卫生许可证
     */
    private String hygienelicense;
    /**
     * 审核人
     */
    private String auditor;
    /**
     * 审核时间
     */
    private String audittime;
    /**
     * 审核状态
     */
    private String auditstate;
    /**
     * 审核意见
     */
    private String audiopinion;
    /**
     * 审核结果
     */
    private String audiresults;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getAdministrative() {
        return administrative;
    }

    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }

    public String getIdfront() {
        return idfront;
    }

    public void setIdfront(String idfront) {
        this.idfront = idfront;
    }

    public String getIdreverse() {
        return idreverse;
    }

    public void setIdreverse(String idreverse) {
        this.idreverse = idreverse;
    }

    public String getBusinesslicense() {
        return businesslicense;
    }

    public void setBusinesslicense(String businesslicense) {
        this.businesslicense = businesslicense;
    }

    public String getHygienelicense() {
        return hygienelicense;
    }

    public void setHygienelicense(String hygienelicense) {
        this.hygienelicense = hygienelicense;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAudittime() {
        return audittime;
    }

    public void setAudittime(String audittime) {
        this.audittime = audittime;
    }

    public String getAuditstate() {
        return auditstate;
    }

    public void setAuditstate(String auditstate) {
        this.auditstate = auditstate;
    }

    public String getAudiopinion() {
        return audiopinion;
    }

    public void setAudiopinion(String audiopinion) {
        this.audiopinion = audiopinion;
    }

    public String getAudiresults() {
        return audiresults;
    }

    public void setAudiresults(String audiresults) {
        this.audiresults = audiresults;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QyAgritainmentinfo{" +
        ", id=" + id +
        ", useraccount=" + useraccount +
        ", name=" + name +
        ", sex=" + sex +
        ", photo=" + photo +
        ", nation=" + nation +
        ", birthdate=" + birthdate +
        ", idcard=" + idcard +
        ", address=" + address +
        ", certification=" + certification +
        ", expirationdate=" + expirationdate +
        ", administrative=" + administrative +
        ", idfront=" + idfront +
        ", idreverse=" + idreverse +
        ", businesslicense=" + businesslicense +
        ", hygienelicense=" + hygienelicense +
        ", auditor=" + auditor +
        ", audittime=" + audittime +
        ", auditstate=" + auditstate +
        ", audiopinion=" + audiopinion +
        ", audiresults=" + audiresults +
        "}";
    }
}
