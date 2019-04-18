var myappointment = "";
var matterdata = "";
define(function(require) {
	var Vue = require("$UI/zupu/js/vue");
	require("$UI/zupu/layer/model/layui");
	require("css!$UI/zupu/layer/model/css/layui").load();
	var Model = function() {
		this.callParent();
	};
	Model.prototype.modelActive = function(event) {
		console.log("进入激活方法");
		// 使用Vue刷新列表
		myappointment.pushmodify(matterdata);
	};
	// 图片路径
	Model.prototype.getImageUrl = function(url) {
		return require.toUrl(url);
	};
	Model.prototype.modelLoad = function(event) {
		console.log("进入onload方法");
		var loginName = localStorage.getItem("loginName");
		// ajax访问数据
		$.ajax({
			headers : {
				Authorization : "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl + '/YProject/api/query_self?loginname=' + loginName,
			processData : false,
			cache : false,
			async : false,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'post',
			success : function(res) {
				console.log(res.data);
				matterdata = res.data;
				// 使用Vue渲染列表
				myappointment = new Vue({
					el : '.appp',
					data : {
						push : '',
						datas : []
					},
					created : function() {
						this.datas = matterdata;
					},
					methods : {
						pushmodify : function() {
							this.datas = matterdata;
						}
					}
				});
				// 由狀態值修改樣式
				var stylecontro = document.getElementsByClassName("stylecontro");
				for (var i = 0; i < stylecontro.length; i++) {
					console.log($(stylecontro[i]).find(".imgtu").next().attr("src"));
					var state = $(stylecontro[i]).find(".imgtu").text();
					if (state == "已通过") {
						$(stylecontro[i]).find(".imgtu").next().attr("src", 'img/yuyue/u184.png');
						$(stylecontro[i]).find("#material").css("color", "#E7403A");
						$(stylecontro[i]).find("#matter").css("color", "#E7403A");
						$(stylecontro[i]).find("#examine_details").css("color", "#E7403A");
					} else if (state == "未通过") {
						$(stylecontro[i]).find(".imgtu").next().attr("src", 'img/yuyue/u200.png');
						$(stylecontro[i]).find("#material").css("color", "#999999");
						$(stylecontro[i]).find("#matter").css("color", "#999999");
						$(stylecontro[i]).find("#examine_details").css("color", "#999999");
					} else if (state == "已提交") {
						$(stylecontro[i]).find(".imgtu").next().attr("src", 'img/yuyue/u201.png');
						$(stylecontro[i]).find("#material").css("color", "#447ED9");
						$(stylecontro[i]).find("#matter").css("color", "#447ED9");
						$(stylecontro[i]).find("#examine_details").css("color", "#447ED9");
					}
					// 弹窗
					$(stylecontro[i]).find("#examine_details").on("click", function() {showLayer(matterdata)});
				}
			},
			error : function(res) {
				console.log("访问失败数据");
				console.log(res.message);
			}
		});
	};
	return Model;
});
function showLayer(id) {
	console.log(matterdata);
	layui.use('layer', function() {
		var $ = layui.jquery;
		var layer = layui.layer;
		// 示范一个公告层
		layer.open({
			type : 0,
			skin : '' // 传入弹窗样式
			,
			title : [ '预审结果', 'font-size:1.3rem;' ],
			area : [ '25rem', '28rem' ],
			shade : 0.7 // 阴影
			,
			btn : 0 // 关闭按钮
			,
			moveType : 0 // 拖拽模式，0或者1
			,
			content : '<div>审核人：' + matterdata[0].uqren
					+ ' <span id="auditor"></span></div><div>审核时间：<span id="auditortime"></span></div><div>审核结果：<span id="auditorresult"></span></div><div>留言：<div ></div></div>',
			anim : 0 // 弹出动画
			,
			icon : 5
		});
	});
}

function jumpvale1(id) {
	justep.Shell.showPage("material", {
		childid : id,
	});
};
function jumpvale2(id) {
	justep.Shell.showPage("matter", {
		childid : id,
	});
};