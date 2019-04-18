/**
 * 厨师管理初始化
 */
var QyCookinfo = {
    id: "QyCookinfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
QyCookinfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '头像', field: 'image', visible: true, align: 'center', valign: 'middle'},
            {title: '民族', field: 'minzu', visible: true, align: 'center', valign: 'middle'},
            {title: '出生日期', field: 'birsthday', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证号', field: 'idnum', visible: true, align: 'center', valign: 'middle'},
            {title: '地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '发证机关', field: 'fazhengjg', visible: true, align: 'center', valign: 'middle'},
            {title: '过期时间', field: 'guoqidate', visible: true, align: 'center', valign: 'middle'},
            {title: '行政区划', field: 'xinzghengqh', visible: true, align: 'center', valign: 'middle'},
            {title: '健康证有效期', field: 'healthdate', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证正面照', field: 'idzheng', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证反面照', field: 'idfan', visible: true, align: 'center', valign: 'middle'},
            {title: '健康证', field: 'healthy', visible: true, align: 'center', valign: 'middle'},
            {title: '登记卡', field: 'singincard', visible: true, align: 'center', valign: 'middle'},
            {title: '培训证', field: 'peixuncard', visible: true, align: 'center', valign: 'middle'},
            {title: '审核时间', field: 'examinetime', visible: true, align: 'center', valign: 'middle'},
            {title: '审核状态', field: 'examinestate', visible: true, align: 'center', valign: 'middle'},
            {title: '审核人', field: 'examinepop', visible: true, align: 'center', valign: 'middle'},
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
        QyCookinfo.openQyCookinfoEdit(row);
    },
    "click  #TableDelete": function (e, value, row, index) {
        QyCookinfo.delete();
    },
    "click  #TableDetails": function (e, value, row, index) {
        QyCookinfo.openQyCookinfoDetails(row);
    },
    "click  #TableExamine": function (e, value, row, index) {
        QyCookinfo.qyCookinfoExamine(row);
    }
}

/**
 * 检查是否选中
 */
QyCookinfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        QyCookinfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加厨师
 */
QyCookinfo.openAddQyCookinfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加厨师',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyCookinfo/qyCookinfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看厨师详情(可修改)
 */

QyCookinfo.openQyCookinfoEdit = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '厨师详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyCookinfo/qyCookinfo_update/' + row.id
    });
    this.layerIndex = index;
    // }
};

/**
 * 打开查看厨师详情(不可修改)
 */

QyCookinfo.openQyCookinfoDetails = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '厨师详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyCookinfo/qyCookinfo_details/' + row.id
    });
    this.layerIndex = index;
    // }
};

/**
 * 删除厨师
 */
QyCookinfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/qyCookinfo/delete", function (data) {
            Feng.success("删除成功!");
            QyCookinfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("qyCookinfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 审核
 */
QyCookinfo.qyCookinfoExamine = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '厨师详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyCookinfo/qyCookinfo_examine/' + row.id
    });
    this.layerIndex = index;
    // }
};

/**
 * 查询厨师列表
 */
QyCookinfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    QyCookinfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = QyCookinfo.initColumn();
    var table = new BSTable(QyCookinfo.id, "/qyCookinfo/list", defaultColunms);
    table.setPaginationType("client");
    QyCookinfo.table = table.init();
});
