define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};
	//原始密码修改方式界面
	Model.prototype.original_pwd = function(event){
		justep.Shell.showPage("originalpwd");
	};
	//验证码修改方式界面
	Model.prototype.yz_pwd = function(event){
		justep.Shell.showPage("yzpwd");
	};
	
	return Model;
});