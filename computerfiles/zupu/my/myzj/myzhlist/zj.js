define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};
	//添加证件
	Model.prototype.add = function(event){
		 justep.Shell.showPage("addzj");
	};

	return Model;
});