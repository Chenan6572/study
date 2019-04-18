/**
 * 初始化农家乐报备详情对话框
 */
var pass = "";
var ReportAgritainmentInfoDlg = {
    reportAgritainmentInfoData : {}
};

/**
 * 清除数据
 */
ReportAgritainmentInfoDlg.clearData = function() {
    this.reportAgritainmentInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReportAgritainmentInfoDlg.set = function(key, val) {
    this.reportAgritainmentInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ReportAgritainmentInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ReportAgritainmentInfoDlg.close = function() {
    parent.layer.close(window.parent.ReportAgritainment.layerIndex);
}

/**
 * 收集数据
 */
ReportAgritainmentInfoDlg.collectData = function() {
    this
    .set('id')
    .set('useraccount')
    .set('name')
    .set('tel')
    .set('administrative')
    .set('address')
    .set('banquetstart')
    .set('banquetdays')
    .set('banquettype')
    .set('numbereat')
    .set('choosehelper')
    .set('watersource')
    .set('tablewaredis')
    .set('retaining')
    .set('toxicwup')
    .set('tablewareclean')
    .set('refrigeratornum')
    .set('disinfectionnum')
    .set('retainingnum')
    .set('trashnum')
    .set('protectnum')
    .set('washnum')
    .set('auditor')
    .set('audittime')
    .set('auditstate')
    .set('audiopinion')
    .set('audiresults');
}

/**
 * 提交添加
 */
ReportAgritainmentInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportAgritainment/add", function(data){
        Feng.success("添加成功!");
        window.parent.ReportAgritainment.table.refresh();
        ReportAgritainmentInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportAgritainmentInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ReportAgritainmentInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportAgritainment/update", function(data){
        Feng.success("修改成功!");
        window.parent.ReportAgritainment.table.refresh();
        ReportAgritainmentInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportAgritainmentInfoData);
    ajax.start();
}

/**
 * 提交审核
 */
ReportAgritainmentInfoDlg.examineSubmit = function() {

    this.clearData();
    this.collectData();
    if(pass === "1"){
        ReportAgritainmentInfoDlg.reportAgritainmentInfoData.audiresults = "通过";
    }else{
        ReportAgritainmentInfoDlg.reportAgritainmentInfoData.audiresults = "不通过";
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/reportAgritainment/examine", function(data){
        Feng.success("审核成功!");
        window.parent.ReportAgritainment.table.refresh();
        ReportAgritainmentInfoDlg.close();
    },function(data){
        Feng.error("审核失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.reportAgritainmentInfoData);
    ajax.start();
};

layui.use('form', function(){
    var form = layui.form;
    form.on('radio(radio)', function(data){
        pass = data.value
    });
});

$(function() {

});
