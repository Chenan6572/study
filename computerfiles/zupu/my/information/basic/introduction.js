var introduction="";
define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};
	Model.prototype.onload = function(event) {
		introduction = this.params.introduction;
		$(".texts").val(introduction)  ;
	}
	return Model;
});