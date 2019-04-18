define(function(require) {
	require("$UI/zupu/lib/jsonsql");
	// 引入layui
	require("$UI/zupu/layer/model/layui");
	require("css!$UI/zupu/layer/model/css/layui").load();
	var Model = function() {
		this.callParent();
	};
	//测试弹窗
	Model.prototype.modelLoad = function(event) {
		console.log("进入手机号修改");
	/*	layui.use('layer', function() {
			var $ = layui.jquery
			var layer = layui.layer;
			$(".demo").on('click', function() {
				//layer.msg('hello');
			 //示范一个公告层
	      layer.open({
	        type: 1
	        ,title: false //不显示标题栏
	        ,closeBtn: false
	        ,area: '300px;'
	        ,shade: 0.8
	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	        ,btn: ['火速围观', '残忍拒绝']
	        ,btnAlign: 'c'
	        ,moveType: 1 //拖拽模式，0或者1
	        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
	        ,success: function(layero){
	          var btn = layero.find('.layui-layer-btn');
	          btn.find('.layui-layer-btn0').attr({
	            href: 'http://www.layui.com/'
	            ,target: '_blank'
	          });
	        }
	      });			
			})
		});*/
		};
	// 验证手机号
	function isPhoneNo(phone) {
		var pattern = /^1[34578]\d{9}$/;
		return pattern.test(phone);
	}
	
	// 获取token的loginname
	var loginName = localStorage.getItem("loginName");
	// 发送短信验证码
	var phonenum;
	Model.prototype.yzm = function(event) {
		phonenum = $("#phonenum").val()
		// console.log("电话" + phonenum);
		// 测试电话
		console.log("点击获取手机验证码");
		if (!isPhoneNo(phonenum)) {
			// console.log("我在测试手机号");
		} else {
			// 向后台传送手机号
			$.ajax({
				url : serverUrl+'/YProject/yanz/getCode?login_name=' + phonenum,
				processData : false,
				cache : false,
				async : true,
				global : false,
				contentType : "application/json; charset=utf-8",
				datatype : "json",
				type : 'get',
				success : function(res) {
					$("#verification").val(res.data);
				},
				error : function(res) {
				}
			});
			return;
		}
	};
	// 点击提交
	Model.prototype.subclick = function(event) {
		 var user = this.params.id;
		 console.log("本地loginname2="+loginName);//打印本地存入的loginname
		var phonenum = $("#phonenum").val();
		 console.log("填写的手机号" + phonenum);
		// 验证码
		var verification = $("#verification").val();
		 console.log( "验证码"+verification);
		if (!isPhoneNo(phonenum)) {
			
		} else {
			$.ajax({
				headers : {
					Authorization : "Bearer " + localStorage.getItem('Token'),
				},
				url : serverUrl+'/YProject/api/bind_phone?id=' + user + '&bind_phone=' + phonenum + '&code=' + verification,
				cache : false,
				async : false,
				global : false,
				contentType : "application/json; charset=utf-8",
				datatype : "json",
				type : 'get',
				success : function(res) {
					// 返回信息
					console.log(res.data);
					// 200 修改成功，返回信息页
					if (res.state == 200) {
						// console.log("服务器传回的loginName=" +
						// res.data.login_name);
						// 修改成功后修改本地token loginname
						localStorage.setItem("loginName", res.data.login_name);
						localStorage.setItem("Token", res.data.token);
						localStorage.getItem("loginName");
						// console.log("服务器修改后本地loginname=" + loginname);
						// 修改成功后关闭本页面
						justep.Shell.closePage();
					} else {
						var mes = res.message;
					}
				},
				error : function(res) {
					
				}
			});
		}
	};
	return Model;
});