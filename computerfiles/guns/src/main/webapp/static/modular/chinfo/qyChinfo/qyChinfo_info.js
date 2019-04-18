/**
 * 初始化帮厨详情对话框
 */
var QyChinfoInfoDlg = {
    qyChinfoInfoData : {}
};

/**
 * 清除数据
 */
QyChinfoInfoDlg.clearData = function() {
    this.qyChinfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyChinfoInfoDlg.set = function(key, val) {
    this.qyChinfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
QyChinfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
QyChinfoInfoDlg.close = function() {
    parent.layer.close(window.parent.QyChinfo.layerIndex);
}

/**
 * 收集数据
 */
QyChinfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('realtionid')
    .set('roleid')
    .set('name')
    .set('age')
    .set('sex')
    .set('healthcard')
    .set('istrain')
    .set('examinetime')
    .set('examinestate')
    .set('examinetpop');
}

/**
 * 提交添加
 */
QyChinfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyChinfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.QyChinfo.table.refresh();
        QyChinfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyChinfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
QyChinfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/qyChinfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.QyChinfo.table.refresh();
        QyChinfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.qyChinfoInfoData);
    ajax.start();
}

$(function() {

});
