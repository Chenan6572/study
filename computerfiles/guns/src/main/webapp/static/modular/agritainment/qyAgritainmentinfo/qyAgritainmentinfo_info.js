/**
 * 初始化农家乐详情对话框
 */

var pass = "";
var QyAgritainmentinfoInfoDlg = {
    qyAgritainmentinfoInfoData : {}
};
/**
 * 清除数据
 */
QyAgritainmentinfoInfoDlg.clearData = function() {
    this.qyAgritainmentinfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyAgritainmentinfoInfoDlg.set = function(key, val) {
    this.qyAgritainmentinfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyAgritainmentinfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QyAgritainmentinfoInfoDlg.close = function() {
    parent.layer.close(window.parent.QyAgritainmentinfo.layerIndex);
}

/**
 * 收集数据
 */

QyAgritainmentinfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('useraccount')
    .set('name')
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
    .set('businesslicense')
    .set('hygienelicense')
    .set('auditor')
    .set('audittime')

}

/**
 * 提交添加
 */
QyAgritainmentinfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyAgritainmentinfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.QyAgritainmentinfo.table.refresh();
        QyAgritainmentinfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyAgritainmentinfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QyAgritainmentinfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();


    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyAgritainmentinfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.QyAgritainmentinfo.table.refresh();
        QyAgritainmentinfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyAgritainmentinfoInfoData);
    ajax.start();
}
/**
 * 提交审核
 */
QyAgritainmentinfoInfoDlg.examineSubmit = function() {

    this.clearData();
    this.collectData();
    if(pass === "1"){
        QyAgritainmentinfoInfoDlg.qyAgritainmentinfoInfoData.audiresults = "通过";
    }else{
        QyAgritainmentinfoInfoDlg.qyAgritainmentinfoInfoData.audiresults = "不通过";
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyAgritainmentinfo/examine", function(data){
        Feng.success("审核成功!");
        window.parent.QyAgritainmentinfo.table.refresh();
        QyAgritainmentinfoInfoDlg.close();
    },function(data){
        Feng.error("审核失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyAgritainmentinfoInfoData);
    ajax.start();
};

layui.use('form', function(){
    var form = layui.form;
    form.on('radio(radio1)', function(data){
        pass = data.value
    });
});

$(function() {

});
