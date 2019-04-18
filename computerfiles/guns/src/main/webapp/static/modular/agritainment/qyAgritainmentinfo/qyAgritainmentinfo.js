/**
 * 农家乐管理初始化
 */
var QyAgritainmentinfo = {
    id: "QyAgritainmentinfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1,
    lock:false
};
/**
 * 初始化表格的列
 */
QyAgritainmentinfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        // {title: '关联用户', field: 'useraccount', visible: true, align: 'center', valign: 'middle'},
        {title: '姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
        {title: '性别', field: 'sex', visible: true, align: 'center', valign: 'middle'},
        {title: '电话', field: 'id', visible: true, align: 'center', valign: 'middle'},
        {title: '照片', field: 'photo', visible: true, align: 'center', valign: 'middle'},
        {title: '民族', field: 'nation', visible: true, align: 'center', valign: 'middle'},
        {title: '出生日期', field: 'birthdate', visible: true, align: 'center', valign: 'middle'},
        {title: '身份证', field: 'idcard', visible: true, align: 'center', valign: 'middle'},
        {title: '详细地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
        {title: '发证机关', field: 'certification', visible: true, align: 'center', valign: 'middle'},
        {title: '过期时间', field: 'expirationdate', visible: true, align: 'center', valign: 'middle'},
        {title: '行政区划', field: 'administrative', visible: true, align: 'center', valign: 'middle'},
        {
            title: '身份证正面', field: 'idfront', visible: true, align: 'center', valign: 'middle',
            // formatter: paramsMatter
        },
        {title: '身份证反面', field: 'idreverse', visible: true, align: 'center', valign: 'middle'},
        {title: '营业执照', field: 'businesslicense', visible: true, align: 'center', valign: 'middle'},
        {title: '卫生许可证', field: 'hygienelicense', visible: true, align: 'center', valign: 'middle'},
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
    },
    "click  #TableExamine": function (e, value, row, index) {
        QyAgritainmentinfo.qyAgritainmentinfoExamine(row);
        // $("#QyAgritainmentinfo").modal();
    }
}

/**
 * 检查是否选中
 */
QyAgritainmentinfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        QyAgritainmentinfo.seItem = selected[0];
        return true;
    }
};
/**
 * 点击添加农家乐
 */
QyAgritainmentinfo.openAddQyAgritainmentinfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加农家乐',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyAgritainmentinfo/qyAgritainmentinfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看农家乐详情（可修改）
 */
QyAgritainmentinfo.openQyAgritainmentinfoDetail = function (row) {
    // if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '农家乐详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/qyAgritainmentinfo/qyAgritainmentinfo_update/' + row.id
        });
        this.layerIndex = index;
    // }
};
/**
* 打开查看农家乐详情（不可修改）
*/
QyAgritainmentinfo.openQyAgritainmentinfoDetails = function (row) {

            var index = layer.open({
                type: 2,
                title: '农家乐详情',
                area: ['800px', '420px'], //宽高
                fix: false, //不固定
                maxmin: true,
                content: Feng.ctxPath + '/qyAgritainmentinfo/qyAgritainmentinfo_details/' + row.id,
            });
    this.layerIndex = index;
};
/**
 * 删除农家乐
 */
QyAgritainmentinfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/qyAgritainmentinfo/delete", function (data) {
            Feng.success("删除成功!");
            QyAgritainmentinfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("qyAgritainmentinfoId", this.seItem.id);
        ajax.start();
    }
};
/**
 * 审核
 */
QyAgritainmentinfo.qyAgritainmentinfoExamine = function (row) {
    // if (this.check()) {
    var index = layer.open({
        type: 2,
        title: '农家乐详情',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/qyAgritainmentinfo/qyAgritainmentinfo_examine/' + row.id
    });
    this.layerIndex = index;
    // }
};
/**
 * 查询农家乐列表
 */
QyAgritainmentinfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    QyAgritainmentinfo.table.refresh({query: queryData});
};
$(function () {
    var defaultColunms = QyAgritainmentinfo.initColumn();
    var table = new BSTable(QyAgritainmentinfo.id, "/qyAgritainmentinfo/list", defaultColunms);
    table.setPaginationType("client");
    QyAgritainmentinfo.table = table.init();
});
