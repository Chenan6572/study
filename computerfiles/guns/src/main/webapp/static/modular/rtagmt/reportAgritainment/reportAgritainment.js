/**
 * 农家乐报备管理初始化
 */
var ReportAgritainment = {
    id: "ReportAgritainmentTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    lock:false
};

/**
 * 初始化表格的列
 */
ReportAgritainment.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '关联用户', field: 'useraccount', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'tel', visible: true, align: 'center', valign: 'middle'},
            {title: '行政区划', field: 'administrative', visible: true, align: 'center', valign: 'middle'},
            {title: '详细地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '办宴开始时间', field: 'banquetstart', visible: true, align: 'center', valign: 'middle'},
            {title: '办宴天数', field: 'banquetdays', visible: true, align: 'center', valign: 'middle'},
            {title: '办宴类型', field: 'banquettype', visible: true, align: 'center', valign: 'middle'},
            {title: '就餐人数', field: 'numbereat', visible: true, align: 'center', valign: 'middle'},
            {title: '选择帮厨', field: 'choosehelper', visible: true, align: 'center', valign: 'middle'},
            {title: '水源', field: 'watersource', visible: true, align: 'center', valign: 'middle'},
            {title: '餐具消毒方式', field: 'tablewaredis', visible: true, align: 'center', valign: 'middle'},
            {title: '留样设施', field: 'retaining', visible: true, align: 'center', valign: 'middle'},
            {title: '有毒有害物品', field: 'toxicwup', visible: true, align: 'center', valign: 'middle'},
            {title: '餐具保洁柜', field: 'tablewareclean', visible: true, align: 'center', valign: 'middle'},
            {title: '冰箱数量', field: 'refrigeratornum', visible: true, align: 'center', valign: 'middle'},
            {title: '专用消毒柜数量', field: 'disinfectionnum', visible: true, align: 'center', valign: 'middle'},
            {title: '食品留样柜数量', field: 'retainingnum', visible: true, align: 'center', valign: 'middle'},
            {title: '垃圾桶数量', field: 'trashnum', visible: true, align: 'center', valign: 'middle'},
            {title: '防鼠防蝇防尘设施数量', field: 'protectnum', visible: true, align: 'center', valign: 'middle'},
            {title: '专用洗菜洗肉洗鱼池数量', field: 'washnum', visible: true, align: 'center', valign: 'middle'},
            {title: '审核人', field: 'auditor', visible: true, align: 'center', valign: 'middle'},
            {title: '审核时间', field: 'audittime', visible: true, align: 'center', valign: 'middle'},
            {title: '审核状态', field: 'auditstate', visible: true, align: 'center', valign: 'middle'},
            {title: '审核意见', field: 'audiopinion', visible: true, align: 'center', valign: 'middle'},
            {title: '审核结果', field: 'audiresults', visible: true, align: 'center', valign: 'middle'},
            {
                title: '操作',
                field: 'button',
                visible: true,
                width:'200px',
                align: 'center',
                valign: 'middle',
                events: operateEvents, //按钮注册事件
                formatter: AddFunctionAlty
            }
    ];
};

function AddFunctionAlty(value, row, index) {
    return [
        '<text id="TableEditer" icon="fa-edit" type="button" space="true">编辑</text>&nbsp;&nbsp',
        '<text id="TableDelete" type="button" >删除</text>&nbsp;&nbsp',
        '<text id="TableDetails" type="button" >详情</text>&nbsp;&nbsp',
        '<text id="TableExamine" type="button" >审核</text>&nbsp;&nbsp',
    ].join("")
};
window.operateEvents = {
    "click  #TableEditer": function (e, value, row, index) {
        ReportAgritainment.openReportAgritainmentDetail(row);
    },
    "click  #TableDelete": function (e, value, row, index) {
        ReportAgritainment.delete();
    },
    "click  #TableDetails": function (e, value, row, index) {
        ReportAgritainment.openReportAgritainmentDetails(row);
    },
    "click  #TableExamine": function (e, value, row, index) {
        ReportAgritainment.reportAgritainmentExamine(row);
    }
}
/**
 * 检查是否选中
 */
ReportAgritainment.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ReportAgritainment.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加农家乐报备
 */
ReportAgritainment.openAddReportAgritainment = function () {
    var index = layer.open({
        type: 2,
        title: '添加农家乐报备',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/reportAgritainment/reportAgritainment_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看农家乐报备详情(可修改)
 */
ReportAgritainment.openReportAgritainmentDetail = function (row) {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '农家乐报备详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/reportAgritainment/reportAgritainment_update/' + row.id
        });
        this.layerIndex = index;
    }
};
/**
 * 打开查看农家乐报备详情（不可修改）
 */
ReportAgritainment.openReportAgritainmentDetails = function (row) {

    var index = layer.open({
        type: 2,
        title: '农家乐报备详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/reportAgritainment/reportAgritainment_update/' + row.id,
    });
    this.layerIndex = index;
};
/**
 * 删除农家乐报备
 */
ReportAgritainment.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/reportAgritainment/delete", function (data) {
            Feng.success("删除成功!");
            ReportAgritainment.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("reportAgritainmentId",this.seItem.id);
        ajax.start();
    }
};
/**
 * 审核
 */
ReportAgritainment.reportAgritainmentExamine = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '农家乐报备详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/reportAgritainment/reportAgritainment_examine/' + row.id
    });
    this.layerIndex = index;
    // }
};
/**
 * 查询农家乐报备列表
 */
ReportAgritainment.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ReportAgritainment.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ReportAgritainment.initColumn();
    var table = new BSTable(ReportAgritainment.id, "/reportAgritainment/list", defaultColunms);
    table.setPaginationType("client");
    ReportAgritainment.table = table.init();
});
