define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};

	Model.prototype.modelUnLoad = function(event){

	};
	
	Model.prototype.showDetail = function(event)
	{
		justep.Shell.showPage("matterdetail");
	}
	return Model;
});