define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};
	//退出登录
	Model.prototype.setting = function(event){
		localStorage.setItem("Token","");
		localStorage.setItem("loginName","");
		justep.Shell.showPage("login");
	};
	//修改密码
	Model.prototype.selecttype = function(event){
		justep.Shell.showPage("selecttype");
	};
	
	//跳转个人信息页
	Model.prototype.perinfo = function(event){
		justep.Shell.showPage("perinfo");

	};
	//联系方式
	Model.prototype.phone = function(event){
		justep.Shell.showPage("bindphone");
	};
	return Model;
});