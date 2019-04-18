/**
 * 报备帮厨管理初始化
 */
var Ckrelation = {
    id: "CkrelationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Ckrelation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            // {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            // {title: '关联报备记录', field: 'relationrpid', visible: true, align: 'center', valign: 'middle'},
            // {title: '关联id', field: 'realtionid', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '年龄', field: 'age', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '健康证', field: 'healthcard', visible: true, align: 'center', valign: 'middle'},
            {title: '是否培训', field: 'istrain', visible: true, align: 'center', valign: 'middle'},
            {title: '审核时间', field: 'examinetime', visible: true, align: 'center', valign: 'middle'},
            {title: '审核状态', field: 'examinestate', visible: true, align: 'center', valign: 'middle'},
            {title: '审核人', field: 'examinetpop', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Ckrelation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Ckrelation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加报备帮厨
 */
Ckrelation.openAddCkrelation = function () {
    var index = layer.open({
        type: 2,
        title: '添加报备帮厨',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/ckrelation/ckrelation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看报备帮厨详情
 */
Ckrelation.openCkrelationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '报备帮厨详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/ckrelation/ckrelation_update/' + Ckrelation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除报备帮厨
 */
Ckrelation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/ckrelation/delete", function (data) {
            Feng.success("删除成功!");
            Ckrelation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("ckrelationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询报备帮厨列表
 */
Ckrelation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Ckrelation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Ckrelation.initColumn();
    var table = new BSTable(Ckrelation.id, "/ckrelation/list", defaultColunms);
    table.setPaginationType("client");
    Ckrelation.table = table.init();
});
