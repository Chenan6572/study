define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	require("$UI/zupu/js/date/datePicker");
	require("css!$UI/zupu/css/LCalendar").load();
	var id = "";
	
	var Model = function () {
		this.callParent();
	};
	Model.prototype.onload = function (event) {
		parentid = this.params.parentid;
		var calendar = new datePicker();
	calendar.init({
		'trigger': '#start_date',
		/* 按钮选择器，用于触发弹出插件 */
		'type': 'date',
		/* 模式：date日期；datetime日期时间；time时间；ym年月； */
		'minDate': '1900-1-1',
		/* 最小日期 */
		'maxDate': '2100-12-31',
		/* 最大日期 */
		'onSubmit': function () {
			/* 确认时触发事件 */
			var theSelectData = calendar.value;
		},
		'onClose': function () {
			/* 取消时触发事件 */ }
	});
	var calendar = new datePicker();
	calendar.init({
		'trigger': '#end_date',
		/* 按钮选择器，用于触发弹出插件 */
		'type': 'date',
		/* 模式：date日期；datetime日期时间；time时间；ym年月； */
		'minDate': '1900-1-1',
		/* 最小日期 */
		'maxDate': '2100-12-31',
		/* 最大日期 */
		'onSubmit': function () {
			/* 确认时触发事件 */
			var theSelectData = calendar.value;
		},
		'onClose': function () {
			/* 取消时触发事件 */ }
	});
	}
	//添加教育信息
	// console.log("我在测试添加教育信息界面id："+parentid);
	// var parentid = localStorage.getItem("perid");
	Model.prototype.savebtn = function (event) {
		var school_name = document.getElementById("school_name").value; //学校
		var related_major = document.getElementById("related_major").value; //专业
		var education = document.getElementById("educations").value; //学历
		var school_start_data = document.getElementById("start_date").value; //选择入校时间
		var school_end_data = document.getElementById("end_date").value; //选择毕业时间
		//必输项判断
		if (school_name == "") {
			justep.Util.hint("请输入学校名称！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
			return;
		} else if (related_major == "") {
			justep.Util.hint("请输入专业名称！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		}  else if (education == "") {
			justep.Util.hint("请输入学历！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		}else if (school_start_data == "") {
			justep.Util.hint("请选择入校时间！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		}else if (school_end_data == "") {
			justep.Util.hint("请选择毕业时间！", {
				"type": "info",
				"delay": 1500,
				"style": "background-color:#6ce26c !important;"
			});
		}else $.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token')
			},
			url: serverUrl+'/YProject/api/add_edu',  
			data: "parentid=" + parentid +
				"&school_name=" + school_name +
				"&related_major=" + related_major +
				"&education=" + education +
				"&school_start_data=" + school_start_data +
				"&school_end_data=" + school_end_data,
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: 'application/x-www-form-urlencoded',
			datatype: "json",
			type: 'POST',
			success: function (res) {
				justep.Shell.closePage();
			},
			error: function (res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type: 'danger'
				});
			}
		});
	};
	return Model;
});