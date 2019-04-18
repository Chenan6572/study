package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 帮厨
 * </p>
 *
 * @author zmq
 * @since 2019-02-08
 */
@TableName("qy_chinfo")
public class QyChinfo extends Model<QyChinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 关联id
     */
    private String realtionid;
    /**
     * 角色id
     */
    private String roleid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private String age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 健康证
     */
    private String healthcard;
    /**
     * 是否培训
     */
    private String istrain;
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
    private String examinetpop;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealtionid() {
        return realtionid;
    }

    public void setRealtionid(String realtionid) {
        this.realtionid = realtionid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHealthcard() {
        return healthcard;
    }

    public void setHealthcard(String healthcard) {
        this.healthcard = healthcard;
    }

    public String getIstrain() {
        return istrain;
    }

    public void setIstrain(String istrain) {
        this.istrain = istrain;
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

    public String getExaminetpop() {
        return examinetpop;
    }

    public void setExaminetpop(String examinetpop) {
        this.examinetpop = examinetpop;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "QyChinfo{" +
        ", id=" + id +
        ", realtionid=" + realtionid +
        ", roleid=" + roleid +
        ", name=" + name +
        ", age=" + age +
        ", sex=" + sex +
        ", healthcard=" + healthcard +
        ", istrain=" + istrain +
        ", examinetime=" + examinetime +
        ", examinestate=" + examinestate +
        ", examinetpop=" + examinetpop +
        "}";
    }
}
