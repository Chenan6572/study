/**
 * 初始化举办者详情对话框
 */
var pass = "";
var QyOrganizerinfoInfoDlg = {
    qyOrganizerinfoInfoData : {}
};

/**
 * 清除数据
 */
QyOrganizerinfoInfoDlg.clearData = function() {
    this.qyOrganizerinfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyOrganizerinfoInfoDlg.set = function(key, val) {
    this.qyOrganizerinfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyOrganizerinfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QyOrganizerinfoInfoDlg.close = function() {
    parent.layer.close(window.parent.QyOrganizerinfo.layerIndex);
}

/**
 * 收集数据
 */
QyOrganizerinfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('useraccount')
    .set('name')
    .set('tel')
    .set('sex')
    .set('photo')
    .set('nation')
    .set('birthdate')
    .set('idcard')
    .set('address')
    .set('certification')
    .set('expirationdate')
    .set('administrative')
    .set('idfront')
    .set('idreverse')
    .set('auditor')
    .set('audittime')
    .set('auditstate')
    .set('audiopinion')
    .set('audiresults');
}

/**
 * 提交添加
 */
QyOrganizerinfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyOrganizerinfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.QyOrganizerinfo.table.refresh();
        QyOrganizerinfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyOrganizerinfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QyOrganizerinfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyOrganizerinfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.QyOrganizerinfo.table.refresh();
        QyOrganizerinfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyOrganizerinfoInfoData);
    ajax.start();
}
/**
 * 提交审核
 */
QyOrganizerinfoInfoDlg.examineSubmit = function() {

    this.clearData();
    this.collectData();
    if(pass === "1"){
        QyOrganizerinfoInfoDlg.qyOrganizerinfoInfoData.audiresults = "通过";
    }else{
        QyOrganizerinfoInfoDlg.qyOrganizerinfoInfoData.audiresults = "不通过";
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyOrganizerinfo/examine", function(data){
        Feng.success("审核成功!");
        window.parent.QyOrganizerinfo.table.refresh();
        QyOrganizerinfoInfoDlg.close();
    },function(data){
        Feng.error("审核失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyOrganizerinfoInfoData);
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
