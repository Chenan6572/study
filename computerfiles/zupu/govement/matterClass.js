define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};

	Model.prototype.toUrl = function(url){
		console.log("fdfd");
		return require.toUrl(url);
	};
	
	return Model;
});