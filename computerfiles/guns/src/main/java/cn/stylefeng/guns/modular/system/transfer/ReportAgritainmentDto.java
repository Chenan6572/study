package cn.stylefeng.guns.modular.system.transfer;
import cn.stylefeng.guns.modular.system.model.QyChinfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ReportAgritainmentDto {

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
     * 帮厨信息（多个帮厨）
     */
    @JsonProperty("allQyChinfo")
    private String allQyChinfo;


}
