/**
 * 初始化报备帮厨详情对话框
 */
var CkrelationInfoDlg = {
    ckrelationInfoData : {}
};

/**
 * 清除数据
 */
CkrelationInfoDlg.clearData = function() {
    this.ckrelationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CkrelationInfoDlg.set = function(key, val) {
    this.ckrelationInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CkrelationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CkrelationInfoDlg.close = function() {
    parent.layer.close(window.parent.Ckrelation.layerIndex);
}

/**
 * 收集数据
 */
CkrelationInfoDlg.collectData = function() {
    this
    .set('id')
    .set('relationrpid')
    .set('realtionid')
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
CkrelationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ckrelation/add", function(data){
        Feng.success("添加成功!");
        window.parent.Ckrelation.table.refresh();
        CkrelationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ckrelationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CkrelationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ckrelation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Ckrelation.table.refresh();
        CkrelationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ckrelationInfoData);
    ajax.start();
}

$(function() {

});
