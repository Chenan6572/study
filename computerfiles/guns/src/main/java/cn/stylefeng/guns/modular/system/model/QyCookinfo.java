package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 厨师
 * </p>
 *
 * @author wjl
 * @since 2019-02-26
 */
@TableName("qy_cookinfo")
public class QyCookinfo extends Model<QyCookinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private String image;
    /**
     * 民族
     */
    private String minzu;
    /**
     * 出生日期
     */
    private String birsthday;
    /**
     * 身份证号
     */
    private String idnum;
    /**
     * 地址
     */
    private String address;
    /**
     * 发证机关
     */
    private String fazhengjg;
    /**
     * 过期时间
     */
    private String guoqidate;
    /**
     * 行政区划
     */
    private String xinzghengqh;
    /**
     * 健康证有效期
     */
    private String healthdate;
    /**
     * 身份证正面照
     */
    private String idzheng;
    /**
     * 身份证反面照
     */
    private String idfan;
    /**
     * 健康证
     */
    private String healthy;
    /**
     * 登记卡
     */
    private String singincard;
    /**
     * 培训证
     */
    private String peixuncard;
    /**
     * 审核时间
     */
    private String examinetime;
    /**
     * 审核状态
     */
    private String examinestate;
    /**
     * 审核人
     */
    private String examinepop;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMinzu() {
        return minzu;
    }

    public void setMinzu(String minzu) {
        this.minzu = minzu;
    }

    public String getBirsthday() {
        return birsthday;
    }

    public void setBirsthday(String birsthday) {
        this.birsthday = birsthday;
    }

    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFazhengjg() {
        return fazhengjg;
    }

    public void setFazhengjg(String fazhengjg) {
        this.fazhengjg = fazhengjg;
    }

    public String getGuoqidate() {
        return guoqidate;
    }

    public void setGuoqidate(String guoqidate) {
        this.guoqidate = guoqidate;
    }

    public String getXinzghengqh() {
        return xinzghengqh;
    }

    public void setXinzghengqh(String xinzghengqh) {
        this.xinzghengqh = xinzghengqh;
    }

    public String getHealthdate() {
        return healthdate;
    }

    public void setHealthdate(String healthdate) {
        this.healthdate = healthdate;
    }

    public String getIdzheng() {
        return idzheng;
    }

    public void setIdzheng(String idzheng) {
        this.idzheng = idzheng;
    }

    public String getIdfan() {
        return idfan;
    }

    public void setIdfan(String idfan) {
        this.idfan = idfan;
    }

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy;
    }

    public String getSingincard() {
        return singincard;
    }

    public void setSingincard(String singincard) {
        this.singincard = singincard;
    }

    public String getPeixuncard() {
        return peixuncard;
    }

    public void setPeixuncard(String peixuncard) {
        this.peixuncard = peixuncard;
    }

    public String getExaminetime() {
        return examinetime;
    }

    public void setExaminetime(String examinetime) {
        this.examinetime = examinetime;
    }

    public String getExaminestate() {
        return examinestate;
    }

    public void setExaminestate(String examinestate) {
        this.examinestate = examinestate;
    }

    public String getExaminepop() {
        return examinepop;
    }

    public void setExaminepop(String examinepop) {
        this.examinepop = examinepop;
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
        return "QyCookinfo{" +
        ", id=" + id +
        ", name=" + name +
        ", sex=" + sex +
        ", image=" + image +
        ", minzu=" + minzu +
        ", birsthday=" + birsthday +
        ", idnum=" + idnum +
        ", address=" + address +
        ", fazhengjg=" + fazhengjg +
        ", guoqidate=" + guoqidate +
        ", xinzghengqh=" + xinzghengqh +
        ", healthdate=" + healthdate +
        ", idzheng=" + idzheng +
        ", idfan=" + idfan +
        ", healthy=" + healthy +
        ", singincard=" + singincard +
        ", peixuncard=" + peixuncard +
        ", examinetime=" + examinetime +
        ", examinestate=" + examinestate +
        ", examinepop=" + examinepop +
        ", audiopinion=" + audiopinion +
        ", audiresults=" + audiresults +
        "}";
    }
}
