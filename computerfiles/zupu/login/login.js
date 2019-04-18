var phones = "";
define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var jsonsql = require("$UI/zupu/lib/jsonsql");
	var ispwd = "1"; //1是验证码登录 0是密码登录
	var me = null;

	var Model = function () {
		this.callParent();
		me = this;
	};

	abc = function () {
		console.log(require.toUrl("a.img"));
		console.log(me.toUrl("abcdef"));
	}

	// 图片路径转换
	Model.prototype.toUrl = function (url) {
		return url ? require.toUrl(url) : "";
	};
	// 页面初始化
	Model.prototype.modelLoad = function (event) {
		document.addEventListener("deviceready", onDeviceReady, false);
		me = this;
	}
	function onDeviceReady() {
		// 按钮事件
		document.addEventListener("backbutton", function () {}, false); // 返回键
	}
	//获取验证码
	Model.prototype.btnGetCodeClick = function (event) {
		var sjh = document.getElementById("nameInput").value;
		if (sjh == "" || sjh == null) {
			justep.Util.hint("请输入手机号！", {
				"type": "danger",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		} else if (!isPhoneNo(sjh)) {
			justep.Util.hint("手机号格式错误！", {
				type: 'danger'
			});
		} else {
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
					document.getElementById("passwordInput").value = (res.data);
					justep.Util.hint(res.message, {
						"type": "info",
						"delay": 1500,
						"style": "background-color:#6ce26c !important;"
					});
				},
				error: function (res) {
					justep.Util.hint("服务器异常，请稍后再试！", {
						type: 'danger',
						"delay": 1000,
						"style": "background-color:#6ce26c !important;"
					});
				}
			});
			return;
		}
	};
	//登录
	Model.prototype.loginBtnClick = function (event) {
		var sjh = document.getElementById("nameInput").value;
		var yzm = document.getElementById("passwordInput").value;
		var pwd = document.getElementById("pwd").value;
		if (ispwd === "1") {
			// 验证
			if (sjh == "") {
				justep.Util.hint("请输入手机号！", {
					type: 'danger',
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
				return;
			} else if (yzm == "") {
				justep.Util.hint("请输入验证码！", {
					type: 'danger',
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
				return;
			} else if (!isPhoneNo(sjh)) {
				justep.Util.hint("手机号格式错误！", {
					type: 'danger'
				});
			} else $.ajax({
				url: serverUrl + '/YProject/yanz/regilogin?login_name=' + sjh + '&code=' + yzm,
				processData: false,
				cache: false,
				async: true,
				global: false,
				contentType: "application/json; charset=utf-8",
				datatype: "json",
				type: 'get',
				success: function (res) {
					//200为该用户未绑定身份证
					phones = res.data.login_name;
					if (res.state === "200") {
						localStorage.setItem("Token", res.data.token);
						localStorage.setItem("loginName", res.data.login_name);
						justep.Shell.showPage("bind");
						
						//300为该用户已绑定过身份证
					} else if (res.state === "300") {
						localStorage.setItem("Token", res.data.token);
						localStorage.setItem("loginName", res.data.login_name);
						justep.Shell.showPage("main");
						justep.Shell.closePage();
					} else {
						justep.Util.hint(res.message, {
							type: 'danger'
						});
					}
				},
				error: function (res) {
					justep.Util.hint(res.message, {
						type: 'danger',
						"delay": 1500,
						"style": "background-color:#6ce26c !important;"
					});
				}
			});
		} else {
			// 验证
			if (sjh == "") {
				justep.Util.hint("请输入手机号！", {
					type: 'danger',
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
				return;
			} else if (pwd == "") {
				justep.Util.hint("请输入密码！", {
					type: 'danger',
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
				return;
			} else if (!isPhoneNo(sjh)) {
				justep.Util.hint("手机号格式错误！", {
					type: 'danger',
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
			} else $.ajax({
				url: serverUrl + '/YProject/yanz/login?login_name=' + sjh + '&password=' + pwd,
				processData: false,
				cache: false,
				async: true,
				global: false,
				contentType: "application/json; charset=utf-8",
				datatype: "json",
				type: 'get',
				success: function (res) {
					if (res.state === "200") {
						localStorage.setItem("Token", res.data.token);
						localStorage.setItem("loginName", res.data.login_name);
						justep.Shell.showPage("main");
					} else {
						justep.Util.hint(res.message, {
							type: 'danger ',
							"delay": 1500,
							"style": "background-color:#6ce26c !important;"
						});
					}
				},
				error: function (res) {}
			});
		}
		return;
	};
	// 验证身份证
	function isCardNo(card) {
		var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		return pattern.test(card);
	}
	/* 姓名身份证，手机号提交 */
	function isChinaName(name) {
		var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
		return pattern.test(name);
	}

	// 验证手机号
	function isPhoneNo(phone) {
		var pattern = /^1[34578]\d{9}$/;
		return pattern.test(phone);
	}

	Model.prototype.modelActive = function (event) {
		console.log("loginActive");
		justep.Shell.closeAll();
	};


	//忘记密码
	Model.prototype.forgetbtn = function (event) {
		var phone = document.getElementById("nameInput").value;
		if (phone == "" || phone == null) {
			justep.Util.hint("请输入手机号！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		} else if (!isPhoneNo(phone)) {
			justep.Util.hint("请输入正确的手机号！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		} else {
			justep.Shell.showPage("yzpwd", {
				loginName: phone
			});
		}
	};

	// 账号密码登录
	Model.prototype.pwdLogin = function (event) {
		if (ispwd === "1") {
			document.getElementById("disb").style.display = "none";
			document.getElementById("disn").style.display = "block";
			ispwd = "0";
		} else {
			document.getElementById("disn").style.display = "none";
			document.getElementById("disb").style.display = "block";
			ispwd = "1";
		}
	};
	return Model;
});