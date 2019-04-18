var id="";//基础信息id
var chlidid="";//教育信息的id

define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	require("$UI/zupu/js/date/datePicker");
	require("css!$UI/zupu/css/LCalendar").load();
	
	var Model = function(){
		this.callParent();
	};
	// 编辑
	console.log("进入基础信息编辑页");
	Model.prototype.onload = function(event) {
		chlidid = this.params.child; //list的id
		perid = this.params.parentid;//个人id
		$.ajax({
			headers : {
				Authorization : "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl+'/YProject/api/query_work?id='+chlidid,
			processData : false,
			cache : false,
			async : true,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'GET',
			success : function(res) {
				// 后台数据显示到前台页面
				console.log(res.data);
				// document.getElementById("names").value=(res.data.name);
				$("#company_name").val(res.data.company_name); // 公司
				$("#related_depart").val(res.data.related_depart); // 部门
				$("#position").val(res.data.position); // 职位
				$("#start_date").val(res.data.company_start_time); // 选择入校时间
				$("#end_date").val(res.data.company_end_time); // 选择毕业时间
				id = res.data.id;
			},
			error : function(res) {
				justep.Util.hint(res.message, {
					type : 'danger',
				});
				console.log("测试失败");
			}
		});
	//日期控件
	var calendar = new datePicker();
	var id ="";
	calendar.init({
		'trigger' : '#start_date', /* 按钮选择器，用于触发弹出插件 */
		'type' : 'date',/* 模式：date日期；datetime日期时间；time时间；ym年月； */
		'minDate' : '1900-1-1',/* 最小日期 */
		'maxDate' : '2100-12-31',/* 最大日期 */
		'onSubmit' : function() {/* 确认时触发事件 */
			var theSelectData = calendar.value;
		},
		'onClose' : function() {/* 取消时触发事件 */
		}
	});
	var calendar = new datePicker();
	calendar.init({
		'trigger' : '#end_date', /* 按钮选择器，用于触发弹出插件 */
		'type' : 'date',/* 模式：date日期；datetime日期时间；time时间；ym年月； */
		'minDate' : '1900-1-1',/* 最小日期 */
		'maxDate' : '2100-12-31',/* 最大日期 */
		'onSubmit' : function() {/* 确认时触发事件 */
			var theSelectData = calendar.value;
		},
		'onClose' : function() {/* 取消时触发事件 */
		}
	});
	}
	// 保存
	Model.prototype.savebtns = function(event) {
		var company_name = document.getElementById("company_name").value;
		var related_depart = document.getElementById("related_depart").value;
		var position = document.getElementById("position").value;
		var company_start_time = document.getElementById("start_date").value;
		var company_end_time = document.getElementById("end_date").value;
		$.ajax({
			headers : {
				Authorization : "Bearer " + localStorage.getItem('Token')
			},
			url : serverUrl+'/YProject/api/add_work',
			data:"id="+chlidid
				+"&parentid="+perid
				+"&company_name="+company_name
				+"&related_depart="+related_depart
				+"&position="+position
				+"&company_start_time="+company_start_time
				+"&company_end_time="+company_end_time,
			processData : false,
			cache : false,
			async : false,
			global : false,
			contentType:'application/x-www-form-urlencoded',	
			datatype : "json",
			type : 'POST',
			success : function(res) {
				justep.Shell.closePage();
				console.log(res.message);
			},
			error : function(res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type : 'danger'
				});
			}
		});
	}
	//删除工作经历
	Model.prototype.deletebtns = function(event){
		$.ajax({
			headers:{
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl+'/YProject/api/del_work?id='+chlidid,
			type: 'get',
			datatype: "json",
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: "application/json; charset=utf-8",
			success: function (res) {
				justep.Shell.showPage("perinfo");
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