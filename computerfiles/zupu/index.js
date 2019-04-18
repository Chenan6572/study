//serverUrl="http://10.10.1.232:8088";
 serverUrl="http://218.62.64.9:9001";
define(function(require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var ShellImpl = require('$UI/system/lib/portal/shellImpl');
	var CommonUtils = require("$UI/system/components/justep/common/utils");

	require("$UI/zupu/lib/jquery.qrcode");
	var jQuery = require("$UI/zupu/lib/qrcode");

	var Model = function() {
		this.callParent();
		var shellImpl = new ShellImpl(this, {
			"contentsXid" : "pages",
			"pageMappings" : {
				// 主界面
				"main" : {
					url : require.toUrl('./main.w')
				},
				"home" : {
					url : require.toUrl('./home.w')
				},
				// 登录界面
				"login" : {
					url : require.toUrl('./login/login.w')
				},
				"setup" : {
					url : require.toUrl('./setup.w')
				},

				// 修改密码方式界面
				"selecttype" : {
					url : require.toUrl('./updatepwd/selecttype/selecttype.w')
				},
				// 原始密码修改方式界面
				"originalpwd" : {
					url : require.toUrl('./updatepwd/originalpwd/originalpwd.w')
				},
				// 验证码修改方式界面
				"yzpwd" : {
					url : require.toUrl('./updatepwd/yzpwd/yzpwd.w')
				},
				// 退出登录
				"setting" : {
					url : require.toUrl('./my/setting/setting.w')
				},
				//我的证件
				"wdzj" : {
					url : require.toUrl('./my/myzj/myzhlist/zj.w')
				},
				//证件添加
				"addzj": {
					url : require.toUrl('./my/myzj/jzaddlist/addzj.w')
				},
				// 个人信息界面
				"perinfo" : {
					url : require.toUrl('./my/information/perinfo/perinfo.w')
				},
				// 编辑基本信息界面
				"jibenxinxi" : {
					url : require.toUrl('./my/information/basic/basic.w')
				},
				// 绑定手机号
				"bindphone" : {
					url : require.toUrl('./my/information/phonenum/phonenum.w')
				},
				// 绑定户籍信息
				"bindhuji" : {
					url : require.toUrl('./my/information/household/household.w')
				},
				// 编辑教育信息
				"bindeditedu" : {
					url : require.toUrl('./my/information/education/education.w')
				},
				// 添加教育信息
				"bindaddedu" : {
					url : require.toUrl('./my/information/education/addeducation.w')
				},
				// 编辑工作经历
				"bindeditwork" : {
					url : require.toUrl('./my/information/work/work.w')
				},
				// 添加工作经历
				"bindaddwork" : {
					url : require.toUrl('./my/information/work/addwork.w')
				},
				// 身份绑定界面
				"bind" : {
					url : require.toUrl('./login/bind.w')
				},
				// 办事指南列表界面
				"listserve" : {
					url : require.toUrl('./government/govelistserve/listserve.w')
				},
				//部门选项卡
				"department" : {
					url : require.toUrl('./government/bszn/department/department.w')
				},
				//跳转进入办事指南
				"condition" : {
					url : require.toUrl('./government/bszn/condition.w')
				},
				//跳转进入我的预约
				"appointment" : {
					url : require.toUrl('./appointment/matter/matter.w')
				},
				//跳转简介界面
				"introduction" : {
					url : require.toUrl('./my/information/basic/introduction.w')
				},
				//预审材料填写
				"pretrial" : {
					url : require.toUrl('./businessguide/guide/pretrial.w')
				},
				//跳转进入已上传的材料
				"material" :{
					url : require.toUrl('./appointment/material/material.w')
				},
				//卫健委事项详情
				"matter" :{
					url : require.toUrl('./govement/matterDetail.w')
				},
				//卫健委事项详情
				"matterDetail" : {
					url : require.toUrl('./govement/matterDetail.w')
				},
				"setup" : {
					url : require.toUrl('./setup.w')
				},
				"work" : {
					url : require.toUrl('./my/work.w')
				},
				"education" : {
					url : require.toUrl('./my/education.w')
				},
				"marry" : {
					url : require.toUrl('./my/marry.w')
				},
				"matterdetail" : {
					url : require.toUrl('./govement/matterDetail.w')
				},
				"matterapply" : {
					url : require.toUrl('./govement/matterApply.w')
				},
				"mattermy" : {
					url : require.toUrl('./govement/matterMy.w')
				}
			}
		})

	};

	// shellImpl.setIsSinglePage(true);
	// shellImpl.useDefaultExitHandler = false;
	CommonUtils.attachDoubleClickExitApp(function() {
		// var isHomePage =
		// shellImpl.pagesComp.contents[0].innerContainer.getInnerModel().comp('contents2').getActiveIndex()
		// == 0;
		// console.log(shellImpl.pagesComp.getActiveIndex());
		console.log(window.location.hash);
		if (window.location.hash.indexOf("!login") > 0)
			return true;
		// if (shellImpl.pagesComp.getActiveIndex() === 0) {
		// return true;
		// }
		return false;
	});

	/*
	 * define(function(require){ var $ = require("jquery"); var justep =
	 * require("$UI/system/lib/justep");
	 * 
	 * var Model = function(){
	 * 
	 * this.callParent(); justep.Baas.BASE_URL = "http://localhost:80/baas"; //
	 * 设置为您的IIS的实际URL。 }; return Model; });
	 */

	Model.prototype.modelLoad = function(event) {
		// justep.Shell.userName==justep.Bind.observable();
		// justep.Shell.loginName = justep.Bind.observable();
		// justep.Shell.token = justep.Bind.observable();
		
		var loginName = localStorage.getItem("Loginname");
		var token = localStorage.getItem("Token");

		if (loginName != null) {
			justep.Shell.showMainPage();
		} else
			justep.Shell.showPage("login");
	};

	return Model;
});