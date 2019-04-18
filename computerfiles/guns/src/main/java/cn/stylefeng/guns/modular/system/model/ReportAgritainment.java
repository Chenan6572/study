package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 农家乐报备
 * </p>
 *
 * @author wjl
 * @since 2019-02-26
 */
@TableName("report_agritainment")
public class ReportAgritainment extends Model<ReportAgritainment> {

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
     * 手机号
     */
    private String tel;
    /**
     * 行政区划
     */
    private String administrative;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 办宴开始时间
     */
    private String banquetstart;
    /**
     * 办宴天数
     */
    private String banquetdays;
    /**
     * 办宴类型
     */
    private String banquettype;
    /**
     * 就餐人数
     */
    private String numbereat;
    /**
     * 选择帮厨
     */
    private String choosehelper;
    /**
     * 水源
     */
    private String watersource;
    /**
     * 餐具消毒方式
     */
    private String tablewaredis;
    /**
     * 留样设施
     */
    private String retaining;
    /**
     * 有毒有害物品
     */
    private String toxicwup;
    /**
     * 餐具保洁柜
     */
    private String tablewareclean;
    /**
     * 冰箱数量
     */
    private String refrigeratornum;
    /**
     * 专用消毒柜数量
     */
    private String disinfectionnum;
    /**
     * 食品留样柜数量
     */
    private String retainingnum;
    /**
     * 垃圾桶数量
     */
    private String trashnum;
    /**
     * 防鼠防蝇防尘设施数量
     */
    private String protectnum;
    /**
     * 专用洗菜洗肉洗鱼池数量
     */
    private String washnum;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdministrative() {
        return administrative;
    }

    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBanquetstart() {
        return banquetstart;
    }

    public void setBanquetstart(String banquetstart) {
        this.banquetstart = banquetstart;
    }

    public String getBanquetdays() {
        return banquetdays;
    }

    public void setBanquetdays(String banquetdays) {
        this.banquetdays = banquetdays;
    }

    public String getBanquettype() {
        return banquettype;
    }

    public void setBanquettype(String banquettype) {
        this.banquettype = banquettype;
    }

    public String getNumbereat() {
        return numbereat;
    }

    public void setNumbereat(String numbereat) {
        this.numbereat = numbereat;
    }

    public String getChoosehelper() {
        return choosehelper;
    }

    public void setChoosehelper(String choosehelper) {
        this.choosehelper = choosehelper;
    }

    public String getWatersource() {
        return watersource;
    }

    public void setWatersource(String watersource) {
        this.watersource = watersource;
    }

    public String getTablewaredis() {
        return tablewaredis;
    }

    public void setTablewaredis(String tablewaredis) {
        this.tablewaredis = tablewaredis;
    }

    public String getRetaining() {
        return retaining;
    }

    public void setRetaining(String retaining) {
        this.retaining = retaining;
    }

    public String getToxicwup() {
        return toxicwup;
    }

    public void setToxicwup(String toxicwup) {
        this.toxicwup = toxicwup;
    }

    public String getTablewareclean() {
        return tablewareclean;
    }

    public void setTablewareclean(String tablewareclean) {
        this.tablewareclean = tablewareclean;
    }

    public String getRefrigeratornum() {
        return refrigeratornum;
    }

    public void setRefrigeratornum(String refrigeratornum) {
        this.refrigeratornum = refrigeratornum;
    }

    public String getDisinfectionnum() {
        return disinfectionnum;
    }

    public void setDisinfectionnum(String disinfectionnum) {
        this.disinfectionnum = disinfectionnum;
    }

    public String getRetainingnum() {
        return retainingnum;
    }

    public void setRetainingnum(String retainingnum) {
        this.retainingnum = retainingnum;
    }

    public String getTrashnum() {
        return trashnum;
    }

    public void setTrashnum(String trashnum) {
        this.trashnum = trashnum;
    }

    public String getProtectnum() {
        return protectnum;
    }

    public void setProtectnum(String protectnum) {
        this.protectnum = protectnum;
    }

    public String getWashnum() {
        return washnum;
    }

    public void setWashnum(String washnum) {
        this.washnum = washnum;
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
        return "ReportAgritainment{" +
        ", id=" + id +
        ", useraccount=" + useraccount +
        ", name=" + name +
        ", tel=" + tel +
        ", administrative=" + administrative +
        ", address=" + address +
        ", banquetstart=" + banquetstart +
        ", banquetdays=" + banquetdays +
        ", banquettype=" + banquettype +
        ", numbereat=" + numbereat +
        ", choosehelper=" + choosehelper +
        ", watersource=" + watersource +
        ", tablewaredis=" + tablewaredis +
        ", retaining=" + retaining +
        ", toxicwup=" + toxicwup +
        ", tablewareclean=" + tablewareclean +
        ", refrigeratornum=" + refrigeratornum +
        ", disinfectionnum=" + disinfectionnum +
        ", retainingnum=" + retainingnum +
        ", trashnum=" + trashnum +
        ", protectnum=" + protectnum +
        ", washnum=" + washnum +
        ", auditor=" + auditor +
        ", audittime=" + audittime +
        ", auditstate=" + auditstate +
        ", audiopinion=" + audiopinion +
        ", audiresults=" + audiresults +
        "}";
    }
}
