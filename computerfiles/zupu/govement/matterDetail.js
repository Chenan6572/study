define(function(require) {
	var Vue = require("$UI/zupu/js/vue");
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var base = require("$UI/system/api/native/base");
	require("$UI/system/lib/cordova/cordova");
	require("cordova!cordova-plugin-camera");
	require("cordova!cordova-plugin-file");
	require("cordova!cordova-open");
	require("cordova!cordova-plugin-file-transfer");
	require("css!$UI/zupu/css/layui").load();
	require("$UI/zupu/js/layui");
	require("$UI/zupu/js/modules/element");
	layui.use('element', function() {
		var element = layui.element;
		console.log(element);
		
	});
	var Model = function() {
		this.callParent();
		this.wx = base.getWx();
	};
	//我要办理
	Model.prototype.btnNewMatterClick = function(event) {
		justep.Shell.showPage("pretrial");
	};

	Model.prototype.downLoadFile = function(event) {
		// var divProgress =
		// $(event.source.domNode.parentElement.parentElement).find("div[xid='progressbar1']");
		//获取当前行的进度条XID
		// var downLoadBtn =
		// $(event.source.domNode.parentElement).find("a[xid='button1']")
		// var row = event.bindingContext.$object; //获取当前行的数据
		var filePath = 'file:///storage/emulated/0/biyao/申请书.doc'; // 下载路径,数据库保存文件名
		// var uri = encodeURI(row.val('fUrl')); //下载地址
		var uri = "http://39.107.254.59:8080/zupu/v-1.0.1-zh_CN-/zupu/upload/staff1.doc";// encodeURI(row.val('fUrl'));
		var fileTransfer = new FileTransfer();
		fileTransfer.onprogress = function(progressEvent) { // 文件传输插件对象的进度方法调用
			var percentProgress = parseInt((progressEvent.loaded / progressEvent.total) * 100)+ "%"; // 获取已下载和总大小的百分比
			if (progressEvent.lengthComputable)// 获取浏览器返回HEAD信息包含CONTENT-LENGTH为TRUE
												// 则执行下面
			{
				console.log(percentProgress);
				// divProgress.css("width",percentProgress); //设置进度条的样式
				// divProgress.html(percentProgress); //设置进度条里面的数字
			}
		};
		fileTransfer.download( // 调用对象的下载方法，开始下载
		uri, filePath, function(entry) {
			console.log("download complete: " + entry.fullPath);// 下载完成后调用方法
			// 这里下载完成后，将进度条隐藏或者写其他需要的代码
			justep.Util.hint('下载成功！');
			downLoadBtn.hide();
		}, function(error) { // 出错回调函数
			console.log("download error source " + error.source);
			console.log("download error target " + error.target);
			console.log("upload error code" + error.code);
		}, false, {
			headers : {
				"Authorization" : "Basic dGVzdHVzZXJuYW1lOnRlc3RwYXNzd29yZA=="
			}
		});
	};

	Model.prototype.openFile = function(event) {
		if (this.wx) {
			warning.onAlert();
		} else {
			var open = cordova.plugins.disusered.open;
			console.log("");
			function success() {
				justep.Util.hint('Success');
			}
			function error(code) {
				if (code === 1) {
					justep.Util.hint('No file handler found');
				} else {
					justep.Util.hint('Undefined error');
				}
			}

			var filePath = 'file:///storage/emulated/0/biyao/申请书.doc';
			open(filePath, success, error);
		}

	};
	//页面初始化
	Model.prototype.onload = function(event){
		// var loginName = localStorage.getItem("loginName");
		// console.log(loginName);
		// var name = document.getElementById("name").value;
		// var idcard = document.getElementById("idcard").value;
		// console.log("Token = "+localStorage.getItem('Token'));
		var id="";
		id = this.params.childid;
		$.ajax({
			headers:{
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl+'/YProject/api/query_matterid?id='+id,
			processData: false,
			cache: false,
			async: true,
			global: false,
			contentType: "application/json; charset=utf-8",
			datatype: "json",
			type: 'get',
			success: function (res) {
					//基本信息
					document.getElementById("sxname").innerHTML=(res.data.name);//事项名称
					document.getElementById("sxtype").innerHTML=(res.data.type);//事项类型
					document.getElementById("sxobject").innerHTML=(res.data.object);//办理对象
					document.getElementById("sqterm").innerHTML=(res.data.uq_date);//申请期限
					document.getElementById("fdterm").innerHTML=(res.data.bj_date);//法定办理时限
					document.getElementById("cnterm").innerHTML=(res.data.in_date);//承诺办理时限
					document.getElementById("bltype").innerHTML=(res.data.bj_type);//办理形式
					document.getElementById("blmechanism").innerHTML=(res.data.bj_org);//办理机构
					document.getElementById("bladdress").innerHTML=(res.data.address);//办理地点

					//受理条件
					document.getElementById("slcondition").innerHTML=(res.data.condition);//受理条件

					new Vue({
						el : ".cl_list_table",
						data : {
							// basicdatas:[],
							yVwuxBlclListDto:[],
							yVwuxLqifListDto:[]
						},					
						created:function(){
							// this.basicdatas = res.data;
							this.yVwuxBlclListDto = res.data.yVwuxBlclListDto;//办理材料
							this.yVwuxLqifListDto = res.data.yVwuxLqifListDto;//办理流程
						}
					});
			},
			error: function (res) {
				justep.Util.hint(res.message, {
					type: 'danger'
				});
			}
		});
		return;
	};
	return Model;
});
//文件下载
function downLoadFiles(){
	$.ajax({
		headers:{
			Authorization: "Bearer " + localStorage.getItem('Token'),
		},
		url: serverUrl+'/YProject/api/download/3j0hqcHx7cuuDIpa8jyn',
		processData: false,
		cache: false,
		async: true,
		global: false,
		contentType: "application/json; charset=utf-8",
		datatype: "json",
		type: 'get',
		success: function (res) {
		},
		error: function (res) {
			justep.Util.hint(res.message, {
				type: 'danger'
			});
		}
	});
	return;
}