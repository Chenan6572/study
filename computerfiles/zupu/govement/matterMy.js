define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};

	Model.prototype.btnDetail1Click = function(event){
	    this.comp("popOver1").show();
	};

	return Model;
});