var id = ""; //基础信息id
var chlidid = ""; //教育信息的id

define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	require("$UI/zupu/js/date/datePicker");
	require("css!$UI/zupu/css/LCalendar").load();

	var Model = function () {
		this.callParent();
	};

	Model.prototype.modelParamsReceive = function (event) {};
	//访问后台数据
	// 编辑
	console.log("进入教育信息编辑页");
	Model.prototype.onload = function (event) {
		chlidid = this.params.child; //list的id		
		perid = this.params.parentid; //父亲id

		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl+'/YProject/api/query_edu?id=' + chlidid,
			processData: false,
			cache: false,
			async: true,
			global: false,
			contentType: "application/json; charset=utf-8",
			//contentType:'application/x-www-form-urlencoded',	
			datatype: "json",
			type: 'get',
			success: function (res) {
				// 后台数据显示到前台页面
				console.log(res.data);
				// document.getElementById("names").value=(res.data.name);
				$("#school_name").val(res.data.school_name); // 学校
				$("#related_major").val(res.data.related_major); // 专业
				$("#educations").val(res.data.education); // 学历
				console.log("测试保存学历信息 = " +res.data.education);
				$("#start_date").val(res.data.school_start_data); // 选择开始时间
				$("#end_date").val(res.data.school_end_data); // 选择毕业时间
				//id = res.data.id;
			},
			error: function (res) {
				justep.Util.hint(res.message, {
					type: 'danger',
				});
				console.log("测试失败");
			}
		});
		//日期选择器
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

	// 保存
	Model.prototype.savebtn = function (event) {
		var school_name = document.getElementById("school_name").value; //学校
		var related_major = document.getElementById("related_major").value; //专业
		var education = document.getElementById("educations").value; //学历
		var school_start_data = document.getElementById("start_date").value; //选择入校时间
		var school_end_data = document.getElementById("end_date").value; //选择毕业时间
		console.log("所测试的id为= " + id);
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token')
			},
			url: serverUrl+'/YProject/api/add_edu',
			data: "id=" + chlidid +
				"&parentid=" + perid +
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
				console.log(res.message);
			},
			error: function (res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type: 'danger'
				});
			}
		});
	}
	//删除
	Model.prototype.deletebtn = function (event) {
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl+'/YProject/api/del_edu?id=' + chlidid,
			type: 'get',
			datatype: "json",
			processData: false,
			cache: false,
			async: true,
			global: false,
			contentType: "application/json; charset=utf-8",
			success: function (res) {
				justep.Shell.closePage();
				console.log(res);
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