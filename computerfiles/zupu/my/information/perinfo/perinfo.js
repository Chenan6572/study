var parentid = "";
var edulist = "";
var edudata = "";
var worklist = "";
var workdata = "";
var educavalue = "";
var workvalue = "";
define(function(require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var Vue = require("$UI/zupu/js/vue");
	var Model = function() {
		this.callParent();
	};
	// 进入onload方法
	Model.prototype.onload = function(event) {
		// 访问后台数据
		var loginName = localStorage.getItem("loginName");
		console.log(loginName);
		console.log("进入onload方法");
		$.ajax({
			headers : {
				Authorization : "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl + '/YProject/api/query?login_name=' + loginName,
			processData : false,
			cache : false,
			async : true,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'post',
			success : function(res) {
				parentid = res.data.id;
				// 图片路径
				var url = serverUrl + res.data.picture;
				$("#head_image").attr("src", url);
				$("#nameone").html(res.data.name); // 姓名
				$("#doornum").html(res.data.doornum);// 户号
				$("#birthday").html(res.data.birthday);// 生日
				$("#address").html(res.data.address);// 地址
				// 手机号加密处理
				$("#phone").html(res.data.phone.replace(/(\d{3})(\d{5})(\d{3})/, "$1*****$3"));// 电话
				$("#nowaddress").html(res.data.nowaddress);// 现住址
				$("#address").html(res.data.address);// 户籍住址
				$("#register_category").html(res.data.register_category);// 户籍类型
				// 赋值
				edudata = res.data.zEducationInfoList;
				workdata = res.data.zWorkExperienceList;
				// 使用Vue渲染列表
				edulist = new Vue({
					el : '.app1',
					data : {
						push : '',
						edudata : []
					},
					created : function() {
						this.edudata = edudata;
					},
					methods : {
						pushlist1 : function() {
							this.edudata = edudata;
						}
					}
				});
				// 使用Vue渲染工作列表
				worklist = new Vue({
					el : '.app2',
					data : {
						push : '',
						workdata : []
					},
					created : function() {
						this.workdata = workdata;
					},
					methods : {
						pushlist2 : function() {
							this.workdata = workdata;
						}
					}
				});
				// 编辑教育 、、工作经历信息
				$(".div4Click").on("click", function() {
					educavalue = $(this).text();
					education(educavalue, parentid);
				});
				$(".div5Click").on("click", function() {
					workvalue = $(this).text();
					work(workvalue, parentid)
				});
			},
			error : function(res) {
				justep.Util.hint(res.message, {
					type : 'danger',
				});
				console.log("测试失败");
			}
		});

	};
	// 页面激活方法
	Model.prototype.modelActive = function(event) {
		// 访问后台数据
		var loginName = localStorage.getItem("loginName");
		console.log("进入页面激活方法");
		$.ajax({
			headers : {
				Authorization : "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl + '/YProject/api/query?login_name=' + loginName,
			processData : false,
			cache : false,
			async : true,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'post',
			success : function(res) {
				parentid = res.data.id;
				// 图片路径
				var url = serverUrl + res.data.picture;
				$("#head_image").attr("src", url);
				$("#nameone").html(res.data.name); // 姓名
				$("#doornum").html(res.data.doornum);// 户号
				$("#birthday").html(res.data.birthday);// 生日
				$("#address").html(res.data.address);// 地址
				// 手机号加密处理
				$("#phone").html(res.data.phone.replace(/(\d{3})(\d{5})(\d{3})/, "$1*****$3"));// 电话
				$("#nowaddress").html(res.data.nowaddress);// 现住址
				$("#address").html(res.data.address);// 户籍住址
				$("#register_category").html(res.data.register_category);// 户籍类型
				// 赋值
				edudata = res.data.zEducationInfoList;
				workdata = res.data.zWorkExperienceList;
				// 使用Vue刷新列表
				edulist.pushlist1(edudata);
				// 使用Vue更新工作列表
				worklist.pushlist2(workdata);
				// 编辑教育 、、工作经历信息
				$(".div4Click").on("click", function() {
					educavalue = $(this).text();
					education(educavalue, parentid);
				});
				$(".div5Click").on("click", function() {
					workvalue = $(this).text();
					work(workvalue, parentid)
				});
			},
			error : function(res) {
				console.log("测试失败");
			}
		});
	};

	// 跳转个人信息页
	Model.prototype.div1Click = function(event) {
		console.log("fuid=" + parentid);
		justep.Shell.showPage("jibenxinxi", {
			id : parentid
		});
	};
	// 修改手机号
	Model.prototype.div2Click = function(event) {
		console.log("fuid=" + parentid);
		justep.Shell.showPage("bindphone", {
			id : parentid
		});
	};
	// 编辑户籍信息
	Model.prototype.div3Click = function(event) {
		justep.Shell.showPage("bindhuji", {
			id : parentid
		});
	};
	// 添加教育信息
	Model.prototype.sumedu = function(event) {
		justep.Shell.showPage("bindaddedu", {
			parentid : parentid
		});
	};
	// 添加工作经历
	Model.prototype.sumwork = function(event) {
		justep.Shell.showPage("bindaddwork", {
			parentid : parentid
		});
	};

	Model.prototype.modelParamsReceive = function(event) {
	};
	// 页面离开事件
	Model.prototype.modelInactive = function(event) {
		console.log("页面离开");
	};
	return Model;
});
function education() {
	justep.Shell.showPage("bindeditedu", {
		child : educavalue,
		parentid : parentid
	});
}
function work() {
	justep.Shell.showPage("bindeditwork", {
		child : workvalue,
		parentid : parentid
	});
}