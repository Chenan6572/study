define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	
	var id = "";
	var Model = function(){
		this.callParent();
	};
	// 编辑页面初始化
	console.log("进入户籍信息编辑页");
	var loginName = localStorage.getItem("loginName");
	Model.prototype.onload = function(event) {
		$.ajax({
			headers : {
				Authorization : "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl+'/YProject/api/query?login_name='+loginName,
			processData : false,
			cache : false,
			async : false,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'GET',
			success : function(res) {
				// 后台数据显示到前台页面
				 console.log(res.data);
				// document.getElementById("names").value=(res.data.name);
				$("#doornums").val(res.data.doornum); // 户号
				$("#hpopulation").val(res.data.hpopulation); // 与户主关系
				$("#idcard").val(res.data.idcard); // 身份证
				$("#registercategory").val(res.data.register_category); // 户籍类别
				$("#addresss").val(res.data.address); // 村社区名称
				$("#residents_group").val(res.data.residents_group); // 居民组
				id = res.data.id;
			},
			error : function(res) {
				justep.Util.hint(res.message, {
					type : 'danger',
				});
				console.log("测试失败");
			}
		});
	}
	//保存户籍信息
	Model.prototype.savebtn = function(event){
		var doornum = document.getElementById("doornums").value;
		var hpopulation = document.getElementById("hpopulation").value;
		var idcard = document.getElementById("idcard").value;
		var register_category = document.getElementById("registercategory").value;
		var address = document.getElementById("addresss").value;
		var residents_group = document.getElementById("residents_group").value;
		$.ajax({
			headers : {
				"Authorization": "Bearer " + localStorage.getItem('Token')
			},
			url : serverUrl+'/YProject/api/update_register',
			data:"id="+id
				+"&doornum="+doornum
				+"&hpopulation="+hpopulation
				+"&idcard="+idcard
				+"&register_category="+register_category
				+"&address="+address
				+"&residents_group="+residents_group,
			processData : false,
			cache : false,
			async : false,
			global : false,
			contentType:'application/x-www-form-urlencoded',	
			datatype : "json",
			type : 'POST',
			success : function(res) {
				justep.Shell.fireEvent("perinfo", {
					doornum :doornum,
				});
				justep.Shell.closePage();
				console.log(res.message);
			},
			error : function(res) {
				justep.Util.hint("服务器异常，请稍后再试！", {
					type : 'danger'
				});
			}
		});
	};
	Model.prototype.modelActive = function(event) {
		
	};
	Model.prototype.modelParamsReceive = function(event) {
		
	};
	
	return Model;
});