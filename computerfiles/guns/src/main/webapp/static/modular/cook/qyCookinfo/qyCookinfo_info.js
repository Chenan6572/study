/**
 * 初始化厨师详情对话框
 */
var pass = "";
var QyCookinfoInfoDlg = {
    qyCookinfoInfoData : {}
};

/**
 * 清除数据
 */
QyCookinfoInfoDlg.clearData = function() {
    this.qyCookinfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyCookinfoInfoDlg.set = function(key, val) {
    this.qyCookinfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyCookinfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QyCookinfoInfoDlg.close = function() {
    parent.layer.close(window.parent.QyCookinfo.layerIndex);
}

/**
 * 收集数据
 */
QyCookinfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('sex')
    .set('image')
    .set('minzu')
    .set('birsthday')
    .set('idnum')
    .set('address')
    .set('fazhengjg')
    .set('guoqidate')
    .set('xinzghengqh')
    .set('healthdate')
    .set('idzheng')
    .set('idfan')
    .set('healthy')
    .set('singincard')
    .set('peixuncard')
    .set('examinetime')
    .set('examinestate')
    .set('examinepop')
    .set('audiopinion')
    .set('audiresults');
}

/**
 * 提交添加
 */
QyCookinfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyCookinfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.QyCookinfo.table.refresh();
        QyCookinfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyCookinfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QyCookinfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyCookinfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.QyCookinfo.table.refresh();
        QyCookinfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyCookinfoInfoData);
    ajax.start();
}

/**
 * 提交审核
 */
QyCookinfoInfoDlg.examineSubmit = function() {

    this.clearData();
    this.collectData();
    if(pass === "1"){
        QyCookinfoInfoDlg.qyCookinfoInfoData.audiresults = "通过";
    }else{
        QyCookinfoInfoDlg.qyCookinfoInfoData.audiresults = "不通过";
    }
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyCookinfo/examine", function(data){
        Feng.success("审核成功!");
        window.parent.QyCookinfo.table.refresh();
        QyCookinfoInfoDlg.close();
    },function(data){
        Feng.error("审核失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyCookinfoInfoData);
    ajax.start();
};

layui.use('form', function(){
    var form = layui.form;
    form.on('radio(radio2)', function(data){
        pass = data.value
    });
});

$(function() {

});
