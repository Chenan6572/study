define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function () {
		this.callParent();
	};

	Model.prototype.onload = function (event) {
		//获取登录手机号
		var loginName = this.params.loginName;
		//手机号显示格式180****3652
		var phone = loginName.replace(/(\d{3})(\d{4})(\d{3})/, "$1****$3");
		$("#tel").html(phone); // 手机号
	};

	//获取验证码
	Model.prototype.btnGetCodeClick = function (event) {
		var sjh = document.getElementById("yzInput").value;
		$.ajax({
			url: serverUrl + '/YProject/yanz/getCode?login_name=' + sjh,
			processData: false,
			cache: false,
			async: true,
			global: false,
			contentType: "application/json; charset=utf-8",
			datatype: "json",
			type: 'get',
			success: function (res) {
				document.getElementById("yzInput").value = (res.data);
				justep.Util.hint(res.message, {
					"type": "info",
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
			},
			error: function (res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type: 'danger'
				});
			}
		});
		return;
	};
	//确认修改密码
	Model.prototype.savebtn = function (event) {
		console.log("点击获取验证码");
		var sjh = document.getElementById("yzInput").value;
		$.ajax({
			url: serverUrl + '/YProject/yanz/getCode?login_name=' + sjh,
			processData: false,
			cache: false,
			async: true,
			global: false,
			contentType: "application/json; charset=utf-8",
			datatype: "json",
			type: 'get',
			success: function (res) {
				document.getElementById("yzInput").value = (res.data);
				if (res.state === "200") {
					justep.Util.hint("修改成功！", {
						"type": "info",
						"delay": 1500,
						"style": "background-color:#6ce26c !important;"
					});
					justep.Shell.closePage();
				} else {
					justep.Util.hint("修改失败！", {
						type: 'danger'
					});
				}
			},
			error: function (res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type: 'danger'
				});
			}
		});
		return;
	};


	return Model;
});