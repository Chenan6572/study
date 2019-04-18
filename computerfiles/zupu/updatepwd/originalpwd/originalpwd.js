define(function(require){
	var $ = require("jquery");
	var Model = function(){
		this.callParent();
	};
	
	var loginName = localStorage.getItem("loginName");
	//确认修改密码
	Model.prototype.savebtn = function(event){
		//获取登录手机号
		var old_pwd = document.getElementById("old_pwd").value;
		var new_pwd = document.getElementById("new_pwd").value;
		var sure_new_pwd = document.getElementById("sure_new_pwd").value;
		if(new_pwd===sure_new_pwd){
			$.ajax({
				headers : {
					Authorization : "Bearer " + localStorage.getItem('Token'),
				},
				url : serverUrl+'/YProject/api/update_pwd_old',
				data : "old_pwd=" + old_pwd 
					+ "&new_pwd=" + new_pwd 
					+ "&login_name=" + loginName,
				processData : false,
				cache : false,
				async : false,
				global : false,
				contentType : 'application/x-www-form-urlencoded',
				datatype : "json",
				type : 'post',
				success : function(res) {
					if (res.state==="200"){	
						justep.Util.hint(res.message, {
							type: 'success'	
						});	
						justep.Shell.closePage();			
					}else{
						justep.Util.hint(res.message, {
						type: 'danger'	
					});				
					}	
				},
				error : function(res) {
					justep.Util.hint(res.message, {
						type : 'danger',
					});
				}
			});
		}
		else{
			justep.Util.hint("两次密码不一致，请重新输入！", {
				type: 'danger'
			});
		}
	};

	return Model;
});
