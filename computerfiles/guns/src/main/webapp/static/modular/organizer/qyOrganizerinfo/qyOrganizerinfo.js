/**
 * 举办者管理初始化
 */
var QyOrganizerinfo = {
    id: "QyOrganizerinfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
QyOrganizerinfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '关联用户', field: 'useraccount', visible: true, align: 'center', valign: 'middle'},
            {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号', field: 'tel', visible: true, align: 'center', valign: 'middle'},
            {title: '性别', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '照片', field: 'photo', visible: true, align: 'center', valign: 'middle'},
            {title: '民族', field: 'nation', visible: true, align: 'center', valign: 'middle'},
            {title: '出生日期', field: 'birthdate', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证', field: 'idcard', visible: true, align: 'center', valign: 'middle'},
            {title: '详细地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '发证机关', field: 'certification', visible: true, align: 'center', valign: 'middle'},
            {title: '过期时间', field: 'expirationdate', visible: true, align: 'center', valign: 'middle'},
            {title: '行政区划', field: 'administrative', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证正面', field: 'idfront', visible: true, align: 'center', valign: 'middle'},
            {title: '身份证反面', field: 'idreverse', visible: true, align: 'center', valign: 'middle'},
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
        '<text id="TableEditer"  type="button" >编辑</text>&nbsp;&nbsp',
        '<text id="TableDelete"  type="button" >删除</text>&nbsp;&nbsp',
        '<text id="TableDetails" type="button" >详情</text>&nbsp;&nbsp',
        '<text id="TableExamine" type="button" >审核</text>&nbsp;&nbsp',
    ].join("")
};
window.operateEvents = {
    "click  #TableEditer": function (e, value, row, index) {
        QyAgritainmentinfo.openQyAgritainmentinfoDetail(row);
    },
    "click  #TableDelete": function (e, value, row, index) {
        QyAgritainmentinfo.delete();
    },
    "click  #TableDetails": function (e, value, row, index) {
        QyAgritainmentinfo.openQyAgritainmentinfoDetails(row);
        // $("#QyAgritainmentinfo").modal();
    },
    "click  #TableExamine": function (e, value, row, index) {
        QyAgritainmentinfo.qyAgritainmentinfoExamine(row);
        // $("#QyAgritainmentinfo").modal();
    }
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
        QyOrganizerinfo.openQyOrganizerinfoEdit(row);
    },
    "click  #TableDelete": function (e, value, row, index) {
        QyOrganizerinfo.delete();
    },
    "click  #TableDetails": function (e, value, row, index) {
        QyOrganizerinfo.openQyOrganizerinfoDetail(row);

    },
    "click  #TableExamine": function (e, value, row, index) {
        QyOrganizerinfo.openQyOrganizerinfoExamine(row);
    }
}


/**
 * 检查是否选中
 */
QyOrganizerinfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        QyOrganizerinfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加举办者
 */
QyOrganizerinfo.openAddQyOrganizerinfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加举办者',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyOrganizerinfo/qyOrganizerinfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看举办者详情（可修改）
 */
QyOrganizerinfo.openQyOrganizerinfoEdit = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '举办者详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyOrganizerinfo/qyOrganizerinfo_update/' + row.id
    });
    this.layerIndex = index;
    // }
};
/**
 * 打开查看举办者详情（不可修改）
 */
QyOrganizerinfo.openQyOrganizerinfoDetail = function (row) {

    var index = layer.open({
        type: 2,
        title: '举办者详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyOrganizerinfo/qyOrganizerinfo_details/' + row.id,
    });
    this.layerIndex = index;
};

/**
 * 删除举办者
 */
QyOrganizerinfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/qyOrganizerinfo/delete", function (data) {
            Feng.success("删除成功!");
            QyOrganizerinfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("qyOrganizerinfoId",this.seItem.id);
        ajax.start();
    }
};
/**
 * 审核
 */
QyOrganizerinfo.openQyOrganizerinfoExamine = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '举办者详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyOrganizerinfo/qyOrganizerinfo_examine/' + row.id
    });
    this.layerIndex = index;
    // }
};
/**
 * 查询举办者列表
 */
QyOrganizerinfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    QyOrganizerinfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = QyOrganizerinfo.initColumn();
    var table = new BSTable(QyOrganizerinfo.id, "/qyOrganizerinfo/list", defaultColunms);
    table.setPaginationType("client");
    QyOrganizerinfo.table = table.init();
});
