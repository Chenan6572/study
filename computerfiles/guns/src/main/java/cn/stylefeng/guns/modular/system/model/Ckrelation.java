package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 报备帮厨
 * </p>
 *
 * @author zmq
 * @since 2019-02-10
 */
@TableName("ckrelation")
public class Ckrelation extends Model<Ckrelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 关联报备记录
     */
    private String relationrpid;
    /**
     * 关联id
     */
    private String realtionid;
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

    public String getRelationrpid() {
        return relationrpid;
    }

    public void setRelationrpid(String relationrpid) {
        this.relationrpid = relationrpid;
    }

    public String getRealtionid() {
        return realtionid;
    }

    public void setRealtionid(String realtionid) {
        this.realtionid = realtionid;
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
        return "Ckrelation{" +
        ", id=" + id +
        ", relationrpid=" + relationrpid +
        ", realtionid=" + realtionid +
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
