define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	require("$UI/zupu/js/date/datePicker");
	require("css!$UI/zupu/css/LCalendar").load();

	var Model = function () {
		this.callParent();
	};
	Model.prototype.onload = function (event) {
		parentid = this.params.parentid;

		//日期控件
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
				/* 取消时触发事件 */
			}
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
				/* 取消时触发事件 */
			}
		});
	}
	//添加工作经历
	console.log("我在测试添加工作界面id：" + parentid);
	Model.prototype.addwork = function (event) {
		var company_name = document.getElementById("company_name").value;
		var related_depart = document.getElementById("related_depart").value;
		var position = document.getElementById("position").value;
		var start_date = document.getElementById("start_date").value;
		var end_date = document.getElementById("end_date").value;
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl+'/YProject/api/add_work',
			data: "parentid=" + parentid +
				"&company_name=" + company_name +
				"&related_depart=" + related_depart +
				"&position=" + position +
				"&school_start_data=" + start_date +
				"&school_end_data=" + end_date,
			type: 'POST',
			datatype: "json",
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: 'application/x-www-form-urlencoded',
			//contentType: "application/json; charset=utf-8",
			success: function (res) {
				justep.Shell.closePage();
				console.log(res.message);
			},
			error: function (res) {
				justep.Util.hint(res.message, {
					type: 'danger'
				});
			}
		});
		return;
	}
	return Model;
});