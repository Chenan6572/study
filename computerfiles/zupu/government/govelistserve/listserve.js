var childid = "";
var id = "";
define(function (require) {
	var Vue = require("$UI/zupu/js/vue");
	// 引入layui
	require("$UI/zupu/layer/model/layui");
	require("css!$UI/zupu/layer/model/css/layui").load();
	var Model = function () {
		this.callParent();
	};
	Model.prototype.modelLoad = function (event) {
		console.log("进入onload");
		//弹窗提示
		// layui.use('layer', function () {
		// 	var $ = layui.jquery
		// 	var layer = layui.layer;
		// 	$(".list_ta").on('click', function () {
		// 		layer.open({
		// 			type: 1,
		// 			id: 'layerDemo' ,//防止重复弹出
		// 			content: '<div style="padding: 20px 100px;">确认前往嘛</div>',
		// 			btn: '点击前往',
		// 			btnAlign: 'c' ,//按钮居中
		// 			shade: 0 , //不显示遮罩
		// 			yes: function (id) {
		// 				layer.closeAll();
		// 				justep.Shell.showPage("matterDetail", {
		// 					chlidid: id,
		// 				});
		// 			}
		// 		});
		// 	})
		// })

		var loginName = localStorage.getItem("loginName");
		// ajax访问数据
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl+'/YProject/api/query_matter?loginname=' + loginName,
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: "application/json; charset=utf-8",
			datatype: "json",
			type: 'post',
			success: function (res) {
				
				//使用Vue渲染列表
				new Vue({
					el: '.list_table',
					data: {
						szz: []

					},
					created: function () {
						this.szz = res.data;
					}
				});
			},
			error: function (res) {
				console.log("访问失败数据");
				console.log(res.message);
			}
		})
	};
	
	return Model;
});

   function jumpvale(id) {
	justep.Shell.showPage("matterDetail", {
		childid: id,
	});
};
