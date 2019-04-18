define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function () {
		this.callParent();
	};

	Model.prototype.bindClick = function (event) {
		var loginName = localStorage.getItem("loginName");
		var name = document.getElementById("names").value;
		var idcard = document.getElementById("idcard").value;
		//console.log("Token = "+localStorage.getItem('Token'));
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl + '/YProject/api/verification?login_name=' + loginName + '&name=' + name + '&idcard=' + idcard,
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: "application/json; charset=utf-8",
			datatype: "json",
			type: 'get',
			success: function (res) {
				if (res.state === "200") {
					justep.Util.hint(res.message, {
						"type": "info",
						"delay": 1500,
						"style": "background-color:#6ce26c !important;"
					});
					justep.Shell.showPage("main");
				} else {
					justep.Util.hint(res.message, {
						"type": "danger",
						"delay": 1500,
						"style": "background-color:#6ce26c !important;"
					});
				}
			},
			error: function (res) {
				justep.Util.hint(res.message, {
					"type": "danger",
					"delay": 1500,
					"style": "background-color:#6ce26c !important;"
				});
			}
		});
		return;
	}

	return Model;
});