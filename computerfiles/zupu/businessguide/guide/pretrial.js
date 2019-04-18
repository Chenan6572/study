define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};

	Model.prototype.savebtn = function(event){
		var files = $("#files").val();
		console.log("测试文件 = "+files)
	};
	return Model;
});