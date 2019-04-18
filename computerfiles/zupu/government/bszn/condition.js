define(function(require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function() {
		this.callParent();
	};
	//部门 及类型
	$("#bumen_leixing").text();
	$("#bumen_classification").text();

	Model.prototype.modelLoad = function(event){
	
	};

	Model.prototype.modelActive = function(event){
	//deparment接受消息
		console.log("页面激活接收数据=" + this.params.bumenlx);	
		//部门 及类型
		$("#bumen_leixing").html(this.params.bumenlx);			
		$("#bumen_classification").html(this.params.bumen);
	};

	Model.prototype.modelParamsReceive = function(event){
	
	};
	
	//跳转进入选项卡
	Model.prototype.bumenclick = function(event){
		justep.Shell.showPage("department");
	};
	//查询结果，跳转办事指南列表
	Model.prototype.search = function(event){
		justep.Shell.showPage("listserve");
	};

	return Model;
});