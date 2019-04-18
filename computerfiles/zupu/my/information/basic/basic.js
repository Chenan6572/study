const picurl = serverUrl;
var introduction = "";
define(function (require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	require("$UI/zupu/js/date/datePicker");
	require("css!$UI/zupu/css/LCalendar").load();

//	require("$UI/zupu/js/mui.min"); //MUI选择器js
//	require("css!$UI/zupu/css/mui").load(); //MUI选择器css
			//require("$UI/zupu/js/jquery.min");
			// require("$UI/zupu/js/jquery-ui"); 
			// require("$UI/zupu/js/jquery-ui.min");
			//require("$UI/zupu/js/mui.picker.min"); //MUI选择器js
	//require("css!$UI/zupu/css/mui.picker").load(); //MUI选择器css
	var id = "";

	//祖籍选择器
	var Model = function () {
		this.callParent();
	};

	// 编辑
	console.log("进入基础信息编辑页");
	var loginName = localStorage.getItem("loginName");
	Model.prototype.onload = function (event) {
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url: serverUrl+'/YProject/api/query?login_name=' + loginName,
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: "application/json; charset=utf-8",
			datatype: "json",
			type: 'GET',
			success: function (res) {
				// 后台数据显示到前台页面
				console.log(res.data);
				// document.getElementById("names").value=(res.data.name);
				document.getElementById("imagetou").src = picurl + res.data.picture;
				$("#names").val(res.data.name); // 姓名
				$("#sex").val(res.data.sex); // 性别
				$("#birthdate").val(res.data.birthday); // 出生日期
				$("#register_address").val(res.data.register_address); // 祖籍			
				$("#nowsaddress").val(res.data.nowaddress); // 现居住地
				$("#introductions").val(res.data.introduction); // 简介
				introduction = res.data.introduction;
				id = res.data.id;
				imgsdata = res.data.picture;
			},
			error: function (res) {
				justep.Util.hint(res.message, {
					type: 'danger',
				});
				console.log("测试失败");
			}
		});

		// 日期格式
		var calendar = new datePicker();
		calendar.init({
			'trigger': '#birthdate',
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
		//男女选择器
//		mui('#picture').on('tap', 'li>a', function () {
//			$("#sex").val(this.innerHTML);
//			mui("#picture").popover('toggle'); //这是可以用来关闭底部弹窗的事件
//		})
	};
	var imgsdata = ""; // 存储图片路径全局变量
	// 图库选择图片
	Model.prototype.getPicturesClick = function (event) {
		if (!navigator.camera) {
			return;
		}
		navigator.camera.getPicture(onSuccess, onFail, {
			mediaType: 0, // 只选择图片
			quality: 80,
			allowEdit: true,
			targetWidth: 100,
			targetHeight: 100,
			destinationType: navigator.camera.DestinationType.DATA_URL,
			sourceType: navigator.camera.PictureSourceType.PHOTOLIBRARY
			// navigator.camera.PictureSourceType.PhotoAlbum//在安卓中，这个参数会跳出拍照界面
		});

		function onSuccess(imageData) {
			var smallImage = document.getElementById("imagetou");
			smallImage.style.display = 'block';
			smallImage.src = "data:image/jpeg;base64," + imageData;
			// 图片上传
			var $Blob = getBlobBydataURI(smallImage.src, 'image/jpeg');
			var formData = new FormData();
			formData.append("files", $Blob, "file_" + Date.parse(new Date()) +
				".jpeg");
			$.ajax({
				headers: {
					Authorization: "Bearer " + localStorage.getItem('Token'),
				},
				url: serverUrl+'/YProject/api/upload',
				data: formData,
				processData: false,
				cache: false,
				async: false,
				global: false,
				contentType: false,
				datatype: "json",
				type: 'POST',
				success: function (res) {
					// 图片存储路径后台返回数据
					imgsdata = res.data
				},
				error: function (res) {
					console.log(res);
					justep.Util.hint(res.message, {
						type: 'danger'
					});
				}
			});
		}

		function onFail(message) {
		}
	};
	/**
	 * 根据base64 内容 取得 bolb
	 * 
	 */
	function getBlobBydataURI(dataURI, type) {
		var binary = atob(dataURI.split(',')[1]);
		var array = [];
		for (var i = 0; i < binary.length; i++) {
			array.push(binary.charCodeAt(i));
		}
		return new Blob([new Uint8Array(array)], {
			type: type
		});
	};
	// 保存
	Model.prototype.savebtn = function (event) {
		//var imgsdata = document.getElementById("imagetou").src;
		var name = document.getElementById("names").value;
		var sex = document.getElementById("sex").value;
		var birthday = document.getElementById("birthdate").value;
		var register_address = document.getElementById("register_address").value;
		var nowaddress = document.getElementById("nowsaddress").value;
		var introduction = document.getElementById("introductions").value;
		$.ajax({
			headers: {
				Authorization: "Bearer " + localStorage.getItem('Token')
			},
			url: serverUrl+'/YProject/api/update_basic',
			data: "id=" + id +
				"&picture=" + imgsdata +
				"&name=" + name +
				"&sex=" + sex +
				"&birthday=" + birthday +
				"&register_address=" + register_address +
				"&nowaddress=" + nowaddress +
				"&introduction=" + introduction,
			processData: false,
			cache: false,
			async: false,
			global: false,
			contentType: 'application/x-www-form-urlencoded',
			datatype: "json",
			type: 'POST',
			success: function (res) {
				justep.Shell.fireEvent("perinfo", {
					name: name,
				});
				justep.Shell.closePage();
				// justep.Shell.showPage("perinfo");
				console.log(res.message);
			},
			error: function (res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type: 'danger'
				});
			}
		});
	}
	// //简介详情界面
	// Model.prototype.introduction = function (event) {
	// 	justep.Shell.showPage("introduction", {
	// 		introduction: introduction
	// 	});
	// };
	return Model;
});