define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function(){
		this.callParent();
	};

	Model.prototype.saveUserBtnClick = function(event){
			
			var baas = this.comp("matterApply");
			baas.newData({
						defaultValues:[{
							"applicant":this.comp("input9").value,
							"phone":this.comp("input8").value,
							"matterID":"1001050001",
							"matterName":"收养子女入户",
							"transactState":"通过",
							"transactResult":"通过"
						}]
					});
			var option={"onSuccess":function(e){ 
				justep.Util.hint("保存成功！", {type: 'danger'});
				justep.Shell.closePage();
				}
			};
			baas.saveData(option);
			
	};

	return Model;
});