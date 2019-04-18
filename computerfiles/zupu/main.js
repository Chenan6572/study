define(function(require) {
	var $ = require("jquery");
	var Vue = require("$UI/zupu/js/vue");
	var justep = require("$UI/system/lib/justep");
	var jsonsql = require("$UI/zupu/lib/jsonsql");
	var Data = require("$UI/system/components/justep/data/data");

	require("$UI/system/lib/cordova/cordova");
	require("cordova!cordova-plugin-camera"); // 调用摄像头类
	require("cordova!cordova-plugin-file"); // 调用本地文件上传类
	require("cordova!cordova-plugin-file-transfer"); // 调用文件上传转换类
	var UUID = require("$UI/system/lib/base/uuid");
	var touch = require("./lib/touch");

	var hDistance = 80;// 成员间距离
	var vDistance = 140;// 成员间距离
	var xCenter = 800;// 中心点X
	var yCenter = 400;// 中心点Y
	var userFrameWidth = 60;// 人物区域宽度
	var userFrameHeight = 100;// 人物区域高度
	var familyData = []; // 保存成员显示坐标等信息
	var familyMember = null; // 所有成员信息
	var globalMemberClick = null;// 点击的成员信息
	var globalMe = null;
	var globalEditMode = 0;// 0显示 1添加 2编辑
	var lastScrollLeft = 400; // 记录最后隐藏前显示偏移
	var lastScrollTop = 400; // 记录最后隐藏前显示偏移

	var me = null;

	var Model = function() {
		this.callParent();
		this.showEdit = justep.Bind.observable(true);
		this.editMy = false;
	};


	function $$(id) {
		return document.getElementById(id);
	}



	// 图片路径转换
	Model.prototype.getImageUrl = function(url) {
		return require.toUrl(url);
	};
	var loginName = localStorage.getItem("loginName");
	// 页面初始化
	Model.prototype.modelLoad = function(event) {
		// 查詢頭像名称
		console.log("进入mainonload方法");
		$.ajax({
			headers:{
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl+'/YProject/api/query?login_name='+loginName,
			processData : false,
			cache : false,
			async : true,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'post',
			success : function(res) {
				console.log(res.data);
				var url = serverUrl + res.data.picture;
				$("#image_head").attr("src",url);
				$("#zupuname").html(res.data.name);
				if((res.data.introduction.length) >= 10){
					var introduction = res.data.introduction.substring(0,10)+'...';
					$("#introduction").html(introduction);
				}
				else{
					$("#introduction").html(res.data.introduction);
				}

				id=res.data.id;
			},
			error : function(res) {
//				justep.Util.hint(res.message, {
//					type: 'danger',	
//				});
				console.log("测试失败");
			}
		});
		
		console.log("最新资讯");
			//require.toUrl('./main/json/newsData.json'),
			//var url = serverUrl + res.data.picture;
			//	$("#image_head").attr("src",url);
		// 使用Vue渲染列表
		new Vue({
			el: '.app',
			data: {
				items: [
				{image:"./img/news/1.png",news:"全省工程建设项目审批制度改革工作电视电话会议召开",news_data:"2019-3-29"},
				{image:"./img/news/2.png",news:"省十三届人大常委会第九次会议闭幕",news_data:"2019-3-28"},
				{image:"./img/news/3.png",news:"全省森林草原防灭火和防汛抗旱工作电视电话会议召开",news_data:"2019-3-28"},
				{image:"./img/news/4.png",news:"专访省统计局党组成员、副局长",news_data:"2019-3-28"},
				{image:"./img/news/5.png",news:"权威解读来了！福建到2022年省市县三级基本建成预算绩效管理体系",news_data:"2019-3-28"},
				{image:"./img/news/6.png",news:"省法院聘任扫黑除恶专项斗争专家咨询委员",news_data:"2019-3-28"},
				{image:"./img/news/7.png",news:"省法院聘任扫黑除恶专项斗争专家咨询委员",news_data:"2019-3-28"},
				]	
			}			
		});	
		
		// 插图 news_illustration
		var news_illustration = document.getElementsByClassName("news_illustration");
		console.log("C6666=" + news_illustration.length);
		for (var i = 0; i < news_illustration.length; i++) {
			var news_ill = $(news_illustration[i]).text();
			//路径转换
			var newsurl = require.toUrl(news_ill);
			console.log(newsurl);
			$(news_illustration[i]).next().attr("src",newsurl);
		};

		// 请求数据
		me = this;

		// this.getElementByXid("spanUserName").innerHTML =
		// localStorage.getItem("Username");
		// this.getElementByXid("spanFamilyCode").innerHTML = "族谱号：" +
		// localStorage.getItem("Familycode");

		// 初始化
		globalMe = this;
		globalEditMode = 0;

		$("#divFamilyCanvas").show();
		$("#divEditMember").hide();
		$("#divEditMember").hide();
		$("#divViewMember").hide();

		console.log("modelLoad");

		this.pinch();
		this.drag();

		justep.Shell.on("onWorkChanged", this.onWorkChanged, this);
		justep.Shell.on("onMarryChanged", this.onMarryChanged, this);
		justep.Shell.on("onEducationChanged", this.onEducationChanged, this);

		// document.getElementById(me.getIDByXID("imgPhoto")).src=
		// localStorage.getItem("Photo");

		/*
		 * var familyCode = localStorage.getItem("Familycode") ;//"100000"
		 * ;//this.comp("input1").val();
		 * console.log(localStorage.getItem("Familycode")+"**");
		 * console.log("I:"+familyCode); justep.Baas.sendRequest({ "url" :
		 * "/zupu/Family", "action" : "FamilyMember", "async" : false, "params" : {
		 * "familyCode" : familyCode }, "success" : function(data) {
		 * $("#test").html(JSON.stringify(data.rows.length));
		 * //alert(data.rows[0]['memberName'].value); // 获取返回值，存放到output1组件中
		 * //me.comp("output1").set({ "value" : data.code }); } });
		 */

		// 绘制族谱
		// $("input[xid=keyInput]", this.getRootNode()).val("请输入...");
		// $("#test").html("");
		// this.showFamily(event);
		this.comp("newsContent").active();

	};

	// 加载数据
	Model.prototype.productDataCustomRefresh = function(event) {
		var newsData = event.source;
		$.ajax({
			type : "GET",
			url : require.toUrl('./main/json/newsData.json'),
			dataType : 'json',
			async : false,
			cache : false,
			success : function(data) {
				newsData.loadData(data);// 将返回的数据加载到data组件
			},
			error : function() {
				throw justep.Error.create("加载数据失败");
			}
		});

	};
	Model.prototype.navDataCustomRefresh = function(event) {
		var navData = event.source;
		$.ajax({
			type : "GET",
			url : require.toUrl('./main/json/navData.json'),
			dataType : 'json',
			async : false,
			cache : false,
			success : function(data) {
				navData.loadData(data);// 将返回的数据加载到data组件
			},
			error : function() {
				throw justep.Error.create("加载数据失败");
			}
		});
	};

	// 进入政府事项
	Model.prototype.openGovement = function(event) {
		justep.Shell.showPage("matterclass");
	}

	// 进入政府事项
	Model.prototype.openPageClick = function(event) {
/*		justep.Util.hint("bbb", {
			type : 'danger'
		});*/
	}
	// 进入政府事项
	Model.prototype.openMymater = function(event) {
		justep.Shell.showPage("mattermy");
	}
	Model.prototype.openFalimyContent = function(event) {
		this.comp("readContent").active();
		// justep.Shell.showPage("mattermy");
	}
	Model.prototype.openSignin = function(event) {
		justep.Util.hint("更多功能待开放，请关注!", {
			type : 'success'
		}); // info success warning danger
		// http://docs.wex5.com/wex5-ui-question-list-2099/
	}

	// 进入列表页
	Model.prototype.listClick = function(event) {
		/*
		 * 代码如下： justep.Shell.showPage("searchList");
		 */
	};

	// 进入内容页
	Model.prototype.detailClick = function(event) {
		/*
		 * 代码如下： justep.Shell.showPage("detail");
		 */
	};

	// 24小时要闻
	Model.prototype.importantBtnClick = function(event) {
		/*
		 * 代码如下： justep.Shell.showPage("important");
		 */
	};

	// 下滑显示搜索
	var startY;
	Model.prototype.navContent1Touchstart = function(event) {
		startY = event.originalEvent.changedTouches[0].pageY;
	};
	Model.prototype.navContent1Touchmove = function(event) {
		var moveEndY = event.originalEvent.changedTouches[0].pageY;
		var Y = moveEndY - startY;
		if (Y > 0) {
			$(".x-seach", this.getRootNode()).slideDown();
		}
	};

	Model.prototype.showFamilyTest = function(event) {

		// $("#test").html(require.toUrl('./img/father.jpg'));
		var can = $$('can');
		$('#can').click(function(event) {
			var can = $$('can');
			// var x = event.pageX; var y = event.pageY;
			var x = event.pageX - can.getBoundingClientRect().left;
			var y = event.pageY - can.getBoundingClientRect().top;
			cans.fillText(x + "." + y, x, y);
			// justep.Shell.showPage("setup");
		});
		var cans = can.getContext('2d');
		// cans.scale(1.1,1.1);
		// cans.translate(10,10);平移
		// cans.fillStyle = 'red';
		cans.clearRect(-100, -100, 800, 800);
		// cans.rect(50, 100, 200, 100);
		// cxt.stroke();
		cans.fill();

		cans.font = 'bold 16px Arial';
		cans.textAlign = 'center';
		cans.textBaseline = 'bottom';
		cans.fillStyle = '#ccc';
		// cans.fillRect(0,0,22,22);
		var img1 = new Image();
		img1.onload = function() {
			cans.drawImage(img1, 120, 120, 50, 70);
			cans.fillText("父亲", 145, 185);
		};
		img1.src = require.toUrl('./img/father.jpg');
		var img2 = new Image();
		img2.onload = function() {
			cans.drawImage(img2, 240, 120, 50, 70);
			cans.fillText("母亲", 265, 185);
		};
		img2.src = require.toUrl('./img/mother.jpg');
		var img3 = new Image();
		img3.onload = function() {
			cans.drawImage(img3, 180, 240, 50, 70);
			cans.fillText("我", 205, 305);// //cans.strokeText("父亲", 145,
			// 185);
		};
		img3.src = require.toUrl('./img/me.jpg');

		cans.moveTo(170, 155);
		cans.lineTo(240, 155);
		cans.stroke();
		cans.moveTo(205, 155);
		cans.lineTo(205, 240);
		cans.stroke();

		// 点击事件

	};

	Model.prototype.loginBtnClick = function(event) {
		this.comp("newsContent").active();
		// localStorage.setItem("Loginname", null);
		console.log("xx");
		justep.Shell.closeAll();
		justep.Shell.showPage("login").done(function() {
			justep.Shell.closePage("main");
		});
		// justep.shellImpl.showPage(url);
	};

	Model.prototype.onWorkChanged = function(event) {
		var userID = localStorage.getItem("ID");
		this.comp("baasWorkhistory").setFilter("filter1", "userid='" + userID + "'");
		this.comp("baasWorkhistory").refreshData();
	};
	Model.prototype.onMarryChanged = function(event) {
		var userID = localStorage.getItem("ID");
		this.comp("baasData2").setFilter("filter1", "Id='" + userID + "'");
		this.comp("baasData2").refreshData();
	};
	Model.prototype.onEducationChanged = function(event) {
		var userID = localStorage.getItem("ID");
		this.comp("baasData1").setFilter("filter1", "userid='" + userID + "'");
		this.comp("baasData1").refreshData();
	};

	Model.prototype.btnShowLocalFamilyClick = function(event) {
		$.ajax({
			type : "GET",
			url : require.toUrl('./main/json/myfamily.json'),
			dataType : 'json',
			async : false,
			cache : false,
			success : function(data) {
				console.log(jsonsql.query("select * from json.familymember where (ID=='3') order by familyCode desc,json", data));
			},
			error : function() {
				throw justep.Error.create("加载数据失败");
			}
		});// justep.Util.hint(ff, {type: 'danger'});
	};

	Model.prototype.imgAddWorkClick = function(event) {
		justep.Shell.showPage("work");
		/*
		 * .done(function(){ console.log("finishAddWork"); var userID =
		 * localStorage.getItem("ID");
		 * globalMe.comp("baasWorkhistory").setFilter("filter1", "userid='" +
		 * userID + "'"); globalMe.comp("baasWorkhistory").refreshData(); })
		 */
	};

	Model.prototype.imgAddEducationClick = function(event) {
		justep.Shell.showPage("education");
	};

	Model.prototype.imgEditMarriedClick = function(event) {

		// console.log($("#idMMM").html());
		// $("#idMarried").html('fffff');
		// $(me.getElementByXid("outMarried")).innerHTML="fdsf";

		justep.Shell.showPage("marry");
		/*
		 * justep.Baas.sendRequest({ "url" : "/zupu/Marryhistory", "action" :
		 * "queryMarryhistory", "params" : { //"columns" :
		 * Baas.getDataColumns(data) limit: 1, filter:"(Id=0)", offset:0 },
		 * "success" : function(resultData) { var data = new Data();
		 * console.log(resultData); $("#idMarried").innerHTML="aaaa";
		 * //data.loadData(resultData); console.log($("#idMarried"));
		 * $(me.getElementByXid("spanMarried")).text("fsdfdsafds");
		 * $(me.getElementByXid("spanMarriedFirst")).innerHTML = "fds";
		 * $(me.getElementByXid("spanMarriedRelation")).innerHTML = "fdsf"; }
		 * });
		 */

	};

	Model.prototype.btnEditMemberDetail = function(event) {

		// 将当前值赋给编辑控件

		this.comp("inName").val(this.comp("inNameView").val());
		this.comp("inSex").val(this.comp("inSexView").val());
		this.comp("inPhone").val(this.comp("inPhoneView").val());
		this.comp("inLiving").val(this.comp("inLivingView").val());

		this.comp("inputSex").val(this.comp("inputSexView").val());
		this.comp("inputLiving").val(this.comp("inputLivingView").val());

		// 控制隐藏
		this.comp("popOver1").hide();
		// $(this.comp("panel1").domNode).hide();
		// $(this.comp("panel4").domNode).show();
		// justep.Util.hint("bbb", {type: 'danger'});
		$("#divFamilyCanvas").hide();
		$("#divEditMember").show();
		var nodeLabelReleation = $(this.getElementByXid("labelReleation"));
		nodeLabelReleation.hide();
		$("#divViewMember").hide();

	};

	Model.prototype.btnCloseClick = function(event) {
		// $(this.comp("panel4").domNode).hide();
		// $(this.comp("panel1").domNode).show();
		$("#divFamilyCanvas").show();
		$("#divEditMember").hide();
		$("#divViewMember").hide();
		console.log(lastScrollTop + ":)");
		document.getElementById(this.getIDByXID("readContent")).scrollLeft = lastScrollLeft;
		document.getElementById(this.getIDByXID("readContent")).scrollTop = lastScrollTop;

	};

	Model.prototype.btnSubmitClick = function(event) {
		var me = this;

		var parentMember = globalMemberClick.fID.value;
		var id = $("#hidMemberID").val();

		var name = this.comp("inName").val();
		var phone = this.comp("inPhone").val();
		var sex = this.comp("inSex").val();
		var living = this.comp("inLiving").val();
		var birth = this.comp("inBirth").val();
		var selReleation = "";
		var selIndex = this.getElementByXid("inReleation").selectedIndex;
		// if(selIndex>=0) selReleation =
		// this.getElementByXid("inReleation").options[selIndex].text ;
		if (selIndex >= 0)
			selReleation = this.getElementByXid("inReleation").options[selIndex].value;

		// justep.Date dtBirth = justep.Date.fromString(birth,'yyyy-MM-dd');

		// fmBirth = justep.Date.toString(new Date(),'yyyy-MM-dd');

		var nodeLabelReleation = $(this.getElementByXid("labelReleation"));
		// nodeLabelReleation.hide();
		if (nodeLabelReleation.is(':hidden')) {
			var baas = this.comp("baasFamilyMember");
			var row = baas.getFirstRow();

			// if(baas.getRowID(row)=="249")
			{
				var dt = new Date(birth);
				var birthA = justep.Date.toString(dt, 'yyyy-MM-dd')
				baas.setValue("memberName", name, row);
				baas.setValue("memberSex", sex, row);
				baas.setValue("memberPhone", phone, row);
				baas.setValue("memberBirthday", birthA, row);
				baas.setValue("memberLiving", living, row);

				var option = {
					"onSuccess" : function(e) {
						justep.Util.hint("保存成功！", {
							type : 'danger'
						});
					}
				};
				baas.saveData(option);

				$("#divFamilyCanvas").show();
				$("#divEditMember").hide();
				$("#divViewMember").hide();

			}
			return;
		}

		var familyCode = localStorage.getItem("Familycode");
		justep.Baas.sendRequest({
			"url" : "/zupu/Family",
			"action" : "AddFamilyMember",
			"async" : false,
			"params" : {
				"memberID" : "0",
				"familyCode" : familyCode,
				"memberName" : name,
				"memberPhone" : phone,
				"memberIDcard" : "220211000000000000",
				"memberBirth" : birth,
				"parentMember" : parentMember,
				"parentReleation" : selReleation,
				"memberGeneration" : "101",
				"memberSex" : sex,
				"memberLiving" : living,
				"memberPhoto" : "./img/me.jpg"
			},
			"success" : function(data) {
				console.log(data);
				me.showFamily(event);
				justep.Util.hint("添加成功！", {
					type : 'danger'
				});
				$("#divFamilyCanvas").show();
				$("#divEditMember").hide();
				$("#divViewMember").hide();
			}
		});
		return;

	};

	Model.prototype.userContentActive = function(event) {

		this.showEdit.set(true);

		// 设置我的页内容
		this.getElementByXid("spanUserNameMy").innerHTML = localStorage.getItem("Username");
		this.getElementByXid("spanNickNameMy").innerHTML = localStorage.getItem("Username");
		;
		this.getElementByXid("spanPhoneMy").innerHTML = localStorage.getItem("Loginname");
		console.log(localStorage.getItem("Loginname"));

		// 获取详细信息
		var userID = localStorage.getItem("ID");
		var loginName = localStorage.getItem("Loginname");
		console.log("my:" + loginName);
		justep.Baas.sendRequest({
			"url" : "/zupu/Census",
			"action" : "GetCensusByLoginname",
			"params" : {
				// "columns" : Baas.getDataColumns(data)
				limit : 1,
				filter : "(loginname='" + loginName + "')",
				offset : 0,
				loginname : loginName
			},
			"success" : function(resultData) {
				var data = new Data();
				data.loadData(resultData);

				var row = data.getFirstRow();
				// $("#idMarried").innerHTML="aaaa";
				// data.loadData(resultData);
				var tmp = data.val("idcard", row).substr(0, 6) + "****" + data.val("idcard", row).substr(14, 4)
				$(me.getElementByXid("xidCensusCode")).html(data.val("code", row));
				$(me.getElementByXid("xidCensusReleation")).html(data.val("relation", row));
				$(me.getElementByXid("spanCensusIDCard")).html(tmp);
				// $(me.getElementByXid("spanCensusClass")).html(data.val("code",
				// row));
				$(me.getElementByXid("spanCensusCollage")).html(data.val("village", row));
				$(me.getElementByXid("spanCensusGroup")).html(data.val("group", row));

			}
		});

		this.comp("baasWorkhistory").setFilter("filter1", "userid='" + userID + "'");
		this.comp("baasWorkhistory").refreshData();

		this.comp("baasData1").setFilter("filter1", "userid='" + userID + "'");
		this.comp("baasData1").refreshData();

		this.comp("baasData2").setFilter("filter1", "Id='" + userID + "'");
		this.comp("baasData2").refreshData();

	};

	Model.prototype.imgPhotoClick = function(event) {

		// 拍照
		var _this = this;

		document.addEventListener("deviceready", onDeviceReady, false);
		function onDeviceReady() {
			navigator.camera.getPicture(onLoadImageSuccess, onLoadImageFail, {
				destinationType : navigator.camera.DestinationType.DATA_URL,// DATA_URL
				quality : 100,
				targetWidth : 200,
				targetHeight : 200,
				saveToPhotoAlbum : true,
				// allowEdit : true,
				sourceType : 2
			// 0、2为从相册文件中选择，1为拍照
			});
			// 拍照成功后回调
			function onLoadImageSuccess(imageData) {// imageURI imageData
				// console.log(imageData);
				document.getElementById(me.getIDByXID("imgPhoto")).src = "data:image/jpeg;base64," + imageData;

				justep.Baas.sendRequest({
					"url" : "/zupu/User",
					"action" : "uploadUserPhoto",
					"params" : {
						loginname : localStorage.getItem("Loginname"),
						picdata : imageData
					},
					"success" : function(resultData) {
						console.log(resultData);
					}
				});

				// $(me.comp("imgPhoto")).src="data:image/jpeg;base," +
				// imageData;

			}
			function onLoadImageFail(error) {
				// alert(error);
			}
		}

	};

	Model.prototype.readContentActive = function(event) {
		// 没有数据时刷新
		if (familyData.length == 0) {
			this.showFamily(event);
			document.getElementById(this.getIDByXID("readContent")).scrollLeft = lastScrollLeft;
			document.getElementById(this.getIDByXID("readContent")).scrollTop = lastScrollTop;
		}
	};

	function PaintFamily(jsonFamily) {
		// $("#test").html(require.toUrl('./img/father.jpg'));
		var can = $$('can');
		var cans = can.getContext('2d');
		cans.fillStyle = "#000000";
		cans.clearRect(-100, -100, 800, 800);
		cans.fill();
		// 定义绘制中心点
		var userFrameX = xCenter + (userFrameWidth / 2);
		var userFrameY = yCenter - userFrameHeight / 2;
		// paintOne(jsonFamily,"自己");
		drawMe(jsonFamily, "自己", userFrameX, userFrameY, userFrameWidth, userFrameHeight);

	}

	function PaintFamilyByID(jsonFamily, memberID) {
		// $("#test").html(require.toUrl('./img/father.jpg'));
		var can = $$('can');
		var cans = can.getContext('2d');
		cans.height = cans.height;
		cans.beginPath();
		cans.fillStyle = "#000000";
		cans.clearRect(0, 0, 2000, 2000);
		cans.fillRect(0, 0, 30, 100);
		cans.closePath();
		cans.fill();
		familyData = [];
		// 定义绘制中心点
		var userFrameX = xCenter + (userFrameWidth / 2);
		var userFrameY = yCenter - (userFrameHeight / 2);
		// paintOne(jsonFamily,"自己");
		drawMe(jsonFamily, memberID, userFrameX, userFrameY, userFrameWidth, userFrameHeight);

		// document.getElementById(this.getIDByXID("readContent")).scrollLeft=400;
	}

	function cleanAll() {
		var can = $$('can');
		var cans = can.getContext('2d');
		cans.height = cans.height;
		cans.beginPath();
		cans.fillStyle = "#000000";
		cans.clearRect(0, 0, 2000, 2000);
		cans.fillRect(0, 0, 30, 100);
		cans.closePath();
		cans.fill();
	}

	function drawInit() {
		var me = this;
		var can = $$('can');
		can.width = 1600;
		var cans = can.getContext('2d');
		cans.font = 'bold 16px Arial';
		cans.textAlign = 'center';
		cans.textBaseline = 'bottom';
		cans.fillStyle = '#ccc';
		familyData = [];
		// 单击事件判断哪个人物被点击
		$('#can').click(function(event) {
			var can = $$('can');

			// 如果已被绽放
			var t = $('#can').css('transform');

			if (t != "matrix(1, 0, 0, 1, 0, 0)") {
				// can.style.webkitTransform = 'scale(' + 1 + ')';
				return;
			}
			var x = event.pageX - can.getBoundingClientRect().left;
			var y = event.pageY - can.getBoundingClientRect().top;
			// cans.fillText(x+"."+ y, x, y);

			for (var i = 0, len = familyData.length; i < len; i++) {
				// console.log(familyData);
				// console.log(x + ":" + y);
				if (familyData[i].x1 < x && familyData[i].x2 > x && familyData[i].y1 < y && familyData[i].y2 > y) {
					globalMemberClick = familyData[i];
					// console.log(globalMemberClick.x1 + ":leftPos");
					globalMe.showOver();
					break;
				}
			}

		});
	}

	Model.prototype.btnInvitClick = function(event) {

		var phone = (globalMemberClick.fPhone.value);
		if (phone)
			justep.Util.hint("手机邀请" + globalMemberClick.fPhone.value + "失败,后台访问错误！", {
				type : 'danger'
			});
		else
			justep.Util.hint("未设置手机号码", {
				type : 'danger'
			});
		this.comp("popOver1").hide();

	}

	Model.prototype.btnAddMember = function(event) {

		// 显示可添加亲人类型 根据当前节点 //需要判断成员是否有父母，夫妻
		var sel = globalMemberClick.fID.value;
		var jsonCur = familyMember.rows.filter(function(item) {
			return item.ID.value === sel;
		});
		if (hasMate(familyMember, sel))
			$("#" + this.getIDByXID("menuAddMate")).hide();
		else
			$("#" + this.getIDByXID("menuAddMate")).show();
		this.comp('menuSelect').set({
			label : jsonCur[0].memberName.value
		});

		if (jsonCur[0].memberSex.value == "男")
			this.comp('menuAddMate').set({
				label : '妻子'
			});
		if (jsonCur[0].memberSex.value == "女")
			this.comp('menuAddMate').set({
				label : '丈夫'
			});
		// 判断父母
		var list = findFatherAndMother(familyMember, sel);
		$("#" + this.getIDByXID("menuAddFather")).show();
		$("#" + this.getIDByXID("menuAddMother")).show();
		var me = this;
		list.forEach(function(value, i) {
			if (value.memberSex.value == "男")
				$("#" + me.getIDByXID("menuAddFather")).hide();
			if (value.memberSex.value == "女")
				$("#" + me.getIDByXID("menuAddMother")).hide();
		});

		this.comp("popOver1").hide();
		this.comp("popOverAdd").show();
		return;

	};
		
	// 跳转进入选项卡
	Model.prototype.bumenclick = function(event){
		justep.Shell.showPage("department");
	};
	// 查询结果，跳转办事指南列表
	Model.prototype.search = function(event){
		justep.Shell.showPage("listserve");
	};
	
	Model.prototype.btnShowMemberDetail = function(event) {
		// 显示成员资料
		var baas = this.comp("baasFamilyMember");
		baas.setFilter("filter1", "ID='" + globalMemberClick.fID.value + "'");
		baas.refreshData();

		// if(baas.find(['ID'],[globalMemberClick.fID.value]).length===0)
		// return;

		this.comp("popOver1").hide();
		// justep.Util.hint("aaa", {type: 'danger'});
		lastScrollLeft = document.getElementById(this.getIDByXID("readContent")).scrollLeft;
		lastScrollTop = document.getElementById(this.getIDByXID("readContent")).scrollTop;
		$("#divFamilyCanvas").hide();
		$("#divViewMember").show();
		$("#divEditMember").hide();
	}

	// 画自己
	function drawMe(jsonFamily, parentReleation, xFrame, yFrame, wFrame, hFrame) {
		/*
		 * var jsonA = jsonFamily.rows; with(jsonA[0]) {
		 * console.log(eval(ID.value=='1')); } console.log("GGG");
		 */
		var jsonOne = null;
		if (parentReleation == "自己")
			jsonOne = jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "') order by memberGeneration desc,json", jsonFamily);
		else
			jsonOne = jsonsql.query("select * from json.rows where (ID.value=='" + parentReleation + "') order by memberGeneration desc,json", jsonFamily);

		var can = $$('can');
		var cans = can.getContext('2d');
		cans.clearRect(-100, -100, 800, 800);
		cans.fill();
		var img3 = new Image();
		img3.onload = function() {
			cans.fillStyle = "rgb(0,0,0)";
			cans.drawImage(img3, xFrame, yFrame, wFrame, hFrame);
			cans.fillText(jsonOne[0].memberName.value, xFrame + 30, yFrame + hFrame - 12);
		};
		if (jsonOne[0].memberSex.value == "女")
			img3.src = require.toUrl('./img/mother.jpg');// jsonOne[0].memberPhoto.value);
		else
			img3.src = require.toUrl('./img/father.jpg');
		// var parentID = jsonOne[0].parentMember;

		// 显示 配偶
		if (jsonOne[0].memberSex.value == "男") {
			var lineStart = {
				x : xFrame + wFrame,
				y : yFrame + hFrame / 2
			};
			drawMate(jsonFamily, jsonOne[0].ID.value, "配偶", xFrame + hDistance, yFrame, wFrame, hFrame, lineStart, 100);
		} else {
			var lineStart = {
				x : xFrame,
				y : yFrame + hFrame / 2
			};
			drawMate(jsonFamily, jsonOne[0].ID.value, "配偶", xFrame - hDistance, yFrame, wFrame, hFrame, lineStart, 100);
		}
		// 显示子女
		var lineStart = {
			x : xFrame + wFrame + 10,
			y : yFrame + hFrame / 2
		};
		if (jsonOne[0].memberSex.value == "女")
			lineStart = {
				x : xFrame - 10,
				y : yFrame + hFrame / 2
			};

		if (MateID(jsonFamily, jsonOne[0].ID.value) == 0)
			lineStart = {
				x : xFrame + wFrame / 2,
				y : yFrame + hFrame
			};
		drawChildren(jsonFamily, jsonOne[0].ID.value, "儿女", xFrame, yFrame + vDistance, wFrame, hFrame, lineStart, 100 + 1);

		// 显示父母
		var lineStart = {
			x : xFrame + wFrame / 2,
			y : yFrame
		};
		drawFatherAndMother(jsonFamily, jsonOne[0].ID.value, "父母", xFrame, yFrame - vDistance, wFrame, hFrame, lineStart, 100 - 1);
		// drawMother(jsonFamily,jsonOne[0].ID.value,"父母",xFrame + hDistance
		// ,yFrame - vDistance,wFrame,hFrame,lineStart);

		// 显示兄弟姐妹
		var lineStart = {
			x : xFrame + wFrame / 2,
			y : yFrame
		};
		var dir = (jsonOne[0].memberSex.value == "女") ? 1 : 0;
		drawBrotherSister(jsonFamily, jsonOne[0].ID.value, "兄妹", xFrame, yFrame, wFrame, hFrame, lineStart, 100, dir);

		// 半显示信息存储全局数组
		var args = {
			fID : jsonOne[0].ID,
			fName : jsonOne[0].memberName,
			fSex : jsonOne[0].memberSex,
			fPhoto : '',
			fPhone : jsonOne[0].memberPhone,
			fGeneration : 100,
			x1 : xFrame,
			y1 : yFrame,
			x2 : xFrame + wFrame,
			y2 : yFrame + hFrame
		};
		familyData.push(args);

	}

	function findFatherAndMother(jsonFamily, memberID) {
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "父母" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json", jsonFamily);
		if (jQuery.isEmptyObject(jsonList)) {// 向下检索不存在，则向上检索
			if (jsonCur[0].parentRelation.value === "儿女") {
				var mateID = MateID(jsonFamily, jsonCur[0].parentMember.value);
				jsonList = jsonFamily.rows.filter(function(item) {
					return (item.ID.value === jsonCur[0].parentMember.value) || (item.ID.value === mateID);
				});
			}
			// 与上一节点是兄妹关系
			if (jsonCur[0].parentRelation.value === "兄妹") {
				var memParent = jsonFamily.rows.filter(function(item) {
					return item.ID.value == jsonCur[0].parentMember.value
				});
				jsonList = jsonFamily.rows.filter(function(item) {
					return (item.parentMember.value == memParent[0].ID.value) && (item.parentRelation.value == "父母");
				});
			}
		}
		return jsonList;

	}

	// 绘制父母
	function drawFatherAndMother(jsonFamily, memberID, parentReleation, xFrame, yFrame, wFrame, hFrame, lineStart, generation) {
		if (generation < 98)
			return;
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json",
				jsonFamily);
		if (jQuery.isEmptyObject(jsonList)) {// 向下检索不存在，则向上检索
			if (jsonCur[0].parentRelation.value === "儿女") {
				var mateID = MateID(jsonFamily, jsonCur[0].parentMember.value);
				jsonList = jsonFamily.rows.filter(function(item) {
					return (item.ID.value === jsonCur[0].parentMember.value) || (item.ID.value === mateID);
				});
			}
			// 与上一节点是兄妹关系
			if (jsonCur[0].parentRelation.value === "兄妹") {
				var memParent = jsonFamily.rows.filter(function(item) {
					return item.ID.value == jsonCur[0].parentMember.value
				});
				jsonList = jsonFamily.rows.filter(function(item) {
					return (item.parentMember.value == memParent[0].ID.value) && (item.parentRelation.value == "父母");
				});
			}
		}

		var can = $$('can');
		var cans = can.getContext('2d');
		cans.fill();

		var imgList = [];
		jsonList.forEach(function(value, i) {

			var a = familyData.filter(function(item) {
				item.fID === value.ID.value
			});
			if (a.length == 0) {
				var xxFrame = 0;
				var yyFrame = 0;
				if (value.memberSex.value == "女") {
					xxFrame = xFrame + hDistance - hDistance * (99 - generation) * 0.5;
					yyFrame = yFrame;
				} else {
					xxFrame = xFrame - hDistance + hDistance * (99 - generation) * 0.5;
					yyFrame = yFrame;
				}

				imgList[i] = new Image();
				imgList[i].onload = function() {
					cans.drawImage(imgList[i], xxFrame, yFrame, wFrame, hFrame);
					cans.fillStyle = "rgb(0,0,0)";
					cans.fillText(value.memberName.value, xxFrame + 30, yFrame + hFrame - 12);

					if (HasOlder(jsonFamily, value.ID.value) && generation == 98) {
						cans.beginPath();
						cans.fillStyle = "rgb(230,120,112)";
						cans.strokeStyle = "rgb(230,120,112)";
						cans.arc(xxFrame + 6, yFrame + 6, 1, 0, Math.PI * 2, true);
						cans.fill();
						cans.stroke();
					}

					// 显示父母
					var lineStartNew = {
						x : xxFrame + wFrame / 2,
						y : yyFrame
					};
					drawFatherAndMother(jsonFamily, value.ID.value, "父母", xxFrame, yyFrame - vDistance, wFrame, hFrame, lineStartNew, generation - 1);

					// 显示 配偶
					var lineStart1 = {
						x : xxFrame + wFrame,
						y : yyFrame + hFrame / 2
					};
					// drawMate(jsonFamily,value.ID.value,"配偶",xFrame +
					// hDistance ,yFrame,wFrame,hFrame,lineStart1);

					// 显示兄妹
					if (generation < 99)
						return;
					var lineStartNew = {
						x : xxFrame + wFrame / 2,
						y : yyFrame
					};
					var dir = (value.memberSex.value == "男") ? 0 : 1;
					drawBrotherSister(jsonFamily, value.ID.value, "兄妹", xxFrame, yyFrame, wFrame, hFrame, lineStartNew, generation - 1, dir);

				};
				if (value.memberSex.value == "女")
					imgList[i].src = require.toUrl('./img/mother.jpg'); // console.log('forEach遍历:'
				// + i +
				// '：' +
				// value.memberName);
				else
					imgList[i].src = require.toUrl('./img/father.jpg');
				// 画线
				cans.moveTo(lineStart.x, lineStart.y);
				var lineTo = {
					x : lineStart.x,
					y : yyFrame + hFrame / 2
				};
				cans.lineTo(lineTo.x, lineTo.y);
				cans.stroke();

				cans.moveTo(lineTo.x, lineTo.y);
				var lineTo2 = value.memberSex.value == "女" ? {
					x : xxFrame,
					y : lineTo.y
				} : {
					x : xxFrame + wFrame,
					y : lineTo.y
				};
				cans.lineTo(lineTo2.x, lineTo2.y);
				cans.stroke();

				// 半显示信息存储全局数组
				var args = {
					fID : value.ID,
					fName : value.memberName,
					fSex : value.memberSex,
					fPhoto : '',
					fPhone : value.memberPhone,
					fGeneration : generation,
					x1 : xxFrame,
					y1 : yyFrame,
					x2 : xxFrame + wFrame,
					y2 : yFrame + hFrame
				};
				familyData.push(args);
			}

		})

	}

	function MateID(jsonFamily, memberID) {
		var tmpID = 0;
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		if (jsonCur[0].parentRelation.value == "配偶")
			return jsonCur[0].parentMember.value;

		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "配偶" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json", jsonFamily);
		if (jsonList.length > 0)
			return jsonList[0].ID.value;

		if (jsonCur[0].parentRelation.value == "父母")
			jsonList = jsonFamily.rows.filter(function(item) {
				return item.parentRelation.value == "父母" && item.parentMember.value == jsonCur[0].parentMember.value && item.ID.value != jsonCur[0].ID.value
			});
		if (jsonList.length > 0)
			return jsonList[0].ID.vallue;

		return 0;

	}
	function hasMate(jsonFamily, memberID) {
		var tmpID = 0;
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		if (jsonCur[0].parentRelation.value == "配偶")
			return true;

		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "配偶" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json", jsonFamily);
		if (jsonList.length > 0)
			return true;

		if (jsonCur[0].parentRelation.value == "父母")
			jsonList = jsonFamily.rows.filter(function(item) {
				return item.parentRelation.value == "父母" && item.parentMember.value == jsonCur[0].parentMember.value && item.ID.value != jsonCur[0].ID.value
			});
		if (jsonList.length > 0)
			return true;
		return false;
	}

	// 绘制子女
	function drawChildren(jsonFamily, memberID, parentReleation, xFrame, yFrame, wFrame, hFrame, lineStart, generation) {
		if (generation > 102)
			return;
		// 当前成员记录
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		// 配偶信息
		var mateID = 0;
		if (jsonCur[0].parentRelation.value === "配偶")
			mateID = jsonCur[0].parentMember.value;
		else {
			var jsonMate = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "配偶" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json",
					jsonFamily);

			if (!jQuery.isEmptyObject(jsonMate))
				mateID = jsonMate[0].ID.value;
		}

		var jsonList;
		if (mateID == 0)
			jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json",
					jsonFamily);
		else
			jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& (parentMember.value=='" + memberID + "' || parentMember.value=='" + mateID
					+ "')) order by memberGeneration desc,json", jsonFamily);

		// 向上检索
		if (jQuery.isEmptyObject(jsonList)) {
			if (jsonCur[0].parentRelation.value === "父母")
				jsonList = jsonFamily.rows.filter(function(item) {
					return item.ID.value === jsonCur[0].parentMember.value;
					return false;
				});

			if (jsonCur[0].parentRelation.value === "配偶") {
				var memParent = jsonFamily.rows.filter(function(item) {
					return item.ID.value == jsonCur[0].parentMember.value
				});
				jsonList = jsonFamily.rows.filter(function(item) {
					return (item.parentMember.value == memParent[0].ID.value) && (item.parentRelation.value == "儿女"); //
				});
			}
		}
		;

		if (jQuery.isEmptyObject(jsonList))
			return;
		var can = $$('can');
		var cans = can.getContext('2d');
		cans.fill();

		var imgList = [];

		var xxFrame = xFrame + wFrame / 2 + 10;
		var yyFrame = yFrame;
		if (generation == 102) // 第三代成员左顺延寻找起始位置
		{
			var x = getBoundByGeneration(10000, xFrame + wFrame, generation).left;
			if (x == 10000)
				xxFrame = getBoundByGeneration(xxFrame, xxFrame + wFrame, generation).left;
			else
				xxFrame = getBoundByGeneration(10000, -10000, generation).left - wFrame - 20;
		}
		jsonList.forEach(function(value, i) {
			// var xxFrame = xFrame - (wFrame/2)*(i)-wFrame*i;
			// var yyFrame = yFrame;
			// if(value.memberName.value=="san")
			// debugger;
			if (i > 0) // 
			{ // 第二位成员 通过获取下一代左边界设置
				xxFrame = xxFrame - 20;
				var childLeft = getBoundByGeneration(xxFrame, xxFrame + wFrame, generation + 1).left
				xxFrame = childLeft - wFrame - 20;
			}
			// if(value.memberName.value=="大孙儿") debugger;

			if (hasMate(jsonFamily, value.ID.value) && (value.memberSex.value === "男")) // 有配偶则预留配偶位置
			{
				xxFrame -= wFrame;
				xxFrame -= hDistance / 2;
			}

			var xxxFrame = xxFrame;
			var yyyFrame = yyFrame;
			var lineStart2 = lineStart;
			// if(hasMate(jsonFamily,value.ID)) //有配偶则预留配偶位置
			// xxFrame -= i*(wFrame+hDistance/2);
			imgList[i] = new Image();
			imgList[i].onload = function() {
				// 绘制当前
				cans.drawImage(imgList[i], xxxFrame, yyyFrame, wFrame, hFrame);
				cans.fillStyle = "rgb(0,0,0)";
				cans.fillText(value.memberName.value, xxxFrame + 30, yyyFrame + hFrame - 12);

				if (HasChildren(jsonFamily, value.ID.value) && generation == 102) {
					cans.beginPath();
					cans.fillStyle = "rgb(230,120,112)";
					cans.strokeStyle = "rgb(230,120,112)";
					cans.arc(xxxFrame + 6, yFrame + 6, 1, 0, Math.PI * 2, true);
					cans.fill();
					cans.stroke();
				}

			};
			// 显示兄妹
			var lineStartNew = {
				x : xxxFrame + wFrame / 2,
				y : yyyFrame
			};
			drawBrotherSister(jsonFamily, value.ID.value, "兄妹", xxxFrame, yyyFrame, wFrame, hFrame, lineStartNew, generation - 1, 0);

			// 显示子女
			if (hasMate(jsonFamily, value.ID.value)) {
				var lineStartNew = {
					x : xxxFrame + wFrame + 10,
					y : yyyFrame + hFrame / 2
				};
				if (value.memberSex.value == "女")
					lineStartNew = {
						x : xxxFrame - 10,
						y : yyyFrame + hFrame / 2
					};
			} else
				lineStartNew = {
					x : xxxFrame + wFrame / 2,
					y : yyyFrame + hFrame
				};
			drawChildren(jsonFamily, value.ID.value, "儿女", xxxFrame, yyyFrame + vDistance, wFrame, hFrame, lineStartNew, generation + 1);

			if (value.memberSex.value == "女")
				imgList[i].src = require.toUrl('./img/mother.jpg'); // console.log('forEach遍历:'
			// + i + '：'
			// +
			// value.memberName);
			else
				imgList[i].src = require.toUrl('./img/father.jpg');

			console.log("正在绘制：" + value.memberName.value);
			// 画线
			var lineTo = {
				x : lineStart2.x,
				y : yyyFrame - 20
			};
			cans.moveTo(lineStart2.x, lineStart2.y);
			cans.lineTo(lineTo.x, lineTo.y);
			cans.stroke();

			cans.moveTo(lineTo.x, lineTo.y);
			var lineTo2 = {
				x : xxxFrame + wFrame / 2,
				y : lineTo.y
			};
			cans.lineTo(lineTo2.x, lineTo2.y);
			cans.stroke();

			cans.moveTo(lineTo2.x, lineTo2.y);
			var lineTo2 = {
				x : xxxFrame + wFrame / 2,
				y : yyFrame
			};
			cans.lineTo(lineTo2.x, lineTo2.y);
			cans.stroke();

			if (value.memberSex.value == "男") {
				var lineStart1 = {
					x : xxxFrame + wFrame,
					y : yyyFrame + hFrame / 2
				};
				drawMate(jsonFamily, value.ID.value, "配偶", xxxFrame + hDistance, yyyFrame, wFrame, hFrame, lineStart1, generation);
			} else {
				lineStart1 = {
					x : xxxFrame,
					y : yyyFrame + hFrame / 2
				};
				drawMate(jsonFamily, value.ID.value, "配偶", xxxFrame - hDistance, yyyFrame, wFrame, hFrame, lineStart1, generation);
			}
			// 半显示信息存储全局数组
			var args = {
				fID : value.ID,
				fName : value.memberName,
				fSex : value.memberSex,
				fPhoto : '',
				fPhone : value.memberPhone,
				fGeneration : generation,
				x1 : xxFrame,
				y1 : yyFrame,
				x2 : xxFrame + wFrame,
				y2 : yFrame + hFrame
			};
			familyData.push(args);

		})

	}
	// 显示配偶
	function drawMate(jsonFamily, memberID, parentReleation, xFrame, yFrame, wFrame, hFrame, lineStart, generation) {

		// 当前成员记录
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		if (jsonCur[0].memberName.value == "父亲")
			debugger;
		var jsonOne = jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value =='" + memberID + "')  order by memberGeneration desc,json",
				jsonFamily);
		// 查找子女的另一个父母为配偶
		if (jQuery.isEmptyObject(jsonOne) && 1) {
			var memCur = jsonCur[0];
			var MateSex = memCur.memberSex.value == "男" ? "女" : "男";
			console.log("配偶");
			if (memCur.parentRelation.value === "父母") {
				var sonID = memCur.parentMember.value;
				jsonOne = jsonFamily.rows.filter(function(item) {
					console.log(item.parentMember.value + ":");
					if (item.parentMember.value == sonID && item.memberSex.value == MateSex && item.parentRelation.value == "父母")
						return true;
					return false;
				});
			}
		}

		// 向上查找
		if (jQuery.isEmptyObject(jsonOne)) {// 配偶 向下检索不存在，则向上检索
			jsonOne = jsonFamily.rows.filter(function(item) {
				// console.log(jsonCur[0]);
				if (jsonCur[0].parentRelation.value === "配偶")
					return item.ID.value === jsonCur[0].parentMember.value;
				return false;
			});
		}

		if (jQuery.isEmptyObject(jsonOne))
			return;

		// 如果已经添加了就不重复了 var a = familyData.filter(function(item){ item.fID
		// ===value.ID.value });
		var exist = familyData.filter(function(item) {
			return item.fID === jsonOne[0].ID.value
		});
		if (exist.length > 0)
			return;

		var can = $$('can');
		var cans = can.getContext('2d');
		// cans.clearRect(-100, -100, 800, 800);
		cans.fill();
		var img2 = new Image();
		img2.onload = function() {
			cans.drawImage(img2, xFrame, yFrame, wFrame, hFrame);
			cans.fillStyle = "rgb(0,0,0)";
			cans.fillText(jsonOne[0].memberName.value, xFrame + 30, yFrame + hFrame - 12);

			// 标识有隐藏关系 、、如果有父子兄弟
			if (HasOlder(jsonFamily, jsonOne[0].ID.value) || HasBrotherOrSister(jsonFamily, jsonOne[0].ID.value)) {
				cans.beginPath();
				cans.fillStyle = "rgb(230,120,112)";
				cans.strokeStyle = "rgb(230,120,112)";
				cans.arc(xFrame + 6, yFrame + 6, 1, 0, Math.PI * 2, true);
				cans.fill();
				cans.stroke();
			}
		};

		if (jsonOne[0].memberSex.value == "女")
			img2.src = require.toUrl('./img/mother.jpg');
		else
			img2.src = require.toUrl('./img/father.jpg');

		// 往回画线
		var lineFinish = {
			x : xFrame,
			y : yFrame + hFrame / 2
		};
		if (jsonCur[0].memberSex.value == "女")
			lineFinish = {
				x : xFrame + wFrame,
				y : yFrame + hFrame / 2
			};
		cans.moveTo(lineFinish.x, lineFinish.y);
		cans.lineTo(lineStart.x, lineStart.y);
		cans.stroke();

		var args = {
			fID : jsonOne[0].ID,
			fName : jsonOne[0].memberName.value,
			fSex : jsonOne[0].memberSex.value,
			fPhoto : '',
			fGeneration : generation,
			fPhone : jsonOne[0].memberPhone,
			x1 : xFrame,
			y1 : yFrame,
			x2 : xFrame + wFrame,
			y2 : yFrame + hFrame
		};
		familyData.push(args);
	}

	function HasOlder(jsonFamily, memberID) {
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		if (jsonCur[0].parentRelation.value == "子女")
			return jsonCur[0].parentMember.value;

		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "父母" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json", jsonFamily);
		if (jsonList.length > 0)
			return jsonList[0].ID.value;
		return 0;
	}
	function HasChildren(jsonFamily, memberID) {
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		if (jsonCur[0].parentRelation.value == "父母")
			return jsonCur[0].parentMember.value;

		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "儿女" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json", jsonFamily);
		if (jsonList.length > 0)
			return jsonList[0].ID.value;
		return 0;
	}
	function HasBrotherOrSister(jsonFamily, memberID) {
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		if (jsonCur[0].parentRelation.value == "兄妹")
			return jsonCur[0].parentMember.value;

		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + "兄妹" + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json", jsonFamily);
		if (jsonList.length > 0)
			return jsonList[0].ID.value;
		return 0;
	}

	function getBoundByGeneration(BoundLeft, BoundRight, generation) {
		var min = 10000;
		var max = -10000;
		for (var i = 0; i < familyData.length; i++) {
			if (familyData[i].fGeneration === generation) {
				// if(generation==102)debugger;
				if (familyData[i].x1 < min)
					min = familyData[i].x1;
				if (familyData[i].x2 > max)
					max = familyData[i].x2;
			}
		}
		if (min == 10000)
			min = BoundLeft;
		if (min > BoundLeft)
			min = BoundLeft;
		if (max == -10000)
			max = BoundRight;
		if (max < BoundLeft)
			max = BoundRight;
		return {
			left : min,
			right : max
		};
	}
	// 显示兄弟姐妹 direction向左或向右方向绘制
	function drawBrotherSister(jsonFamily, memberID, parentReleation, xFrame, yFrame, wFrame, hFrame, lineStart, generation, direction) {
		// 当前成员记录
		var jsonCur = jsonFamily.rows.filter(function(item) {
			return item.ID.value === memberID;
		});
		var jsonList = jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&&parentMember.value=='" + memberID + "') order by memberBirthday desc,json",
				jsonFamily);

		if (jQuery.isEmptyObject(jsonList)) {// 向下检索不存在，则向上检索
			// 与上一节点是兄妹关系
			if (jsonCur[0].parentRelation.value === "兄妹") {
				var memParent = jsonFamily.rows.filter(function(item) {
					return item.ID.value == jsonCur[0].parentMember.value
				});
				console.log("xxx");
				console.log(memParent);
				jsonList = jsonFamily.rows.filter(function(item) {
					if (item.ID.value == memParent[0].ID.value)
						return true;
					return (item.parentMember.value == memParent[0].ID.value) && (item.parentRelation.value == "兄妹" && (item.ID.value != jsonCur[0].ID.value)); //
				});
			}
		}

		var can = $$('can');
		var cans = can.getContext('2d');
		cans.fill();
		var imgList = [];
		// if(jsonCur[0].memberName.value=="母亲") debugger;
		// 根据父成员位置 寻找当前节点位置
		var xxFrame = xFrame;
		var yyFrame = yFrame;
		var box = getBoundByGeneration(xFrame, xFrame + wFrame, generation);// 获取同代最左坐标
		xxFrame = xFrame;// box.left;
		if (direction == 1)
			xxFrame = xFrame + wFrame - 50;
		console.log("正在绘制:" + jsonCur[0].memberName.value + "   右坐标" + box.right);
		console.log("方向：" + direction);
		console.log("开始坐标：" + xxFrame);
		jsonList.forEach(function(value, i) {
			// xxFrame = xxFrame - wFrame*(i+1)-20*i ;
			// 配偶向右延展
			if (direction)
				xxFrame = xxFrame + wFrame + 20;
			else
				xxFrame = xxFrame - wFrame - 20;
			yyFrame = yyFrame;
			console.log(xxFrame);
			var bMate = hasMate(jsonFamily, value.ID.value);
			if (bMate && (value.memberSex.value == "男") && (direction == 0)) // 有配偶则预留配偶位置
			// )
			{
				xxFrame -= (wFrame + 20);
				// xxFrame -= hDistance/2;
			}
			if (bMate && (value.memberSex.value == "女") && (direction == 1)) // 有配偶则预留配偶位置
			// )
			{
				xxFrame += (wFrame + 20);
				// xxFrame += hDistance/2;
			}

			var xxxFrame = xxFrame;
			var yyyFrame = yyFrame;

			imgList[i] = new Image();
			imgList[i].onload = function() {
				cans.drawImage(imgList[i], xxxFrame, yFrame, wFrame, hFrame);
				cans.fillStyle = "rgb(0,0,0)";
				cans.fillText(value.memberName.value, xxxFrame + 30, yFrame + hFrame - 12);

				if (HasChildren(jsonFamily, value.ID.value)) {
					cans.beginPath();
					cans.fillStyle = "rgb(230,120,112)";
					cans.strokeStyle = "rgb(230,120,112)";
					cans.arc(xxxFrame + 6, yFrame + 6, 1, 0, Math.PI * 2, true);
					cans.fill();
					cans.stroke();
				}

			};
			if (value.memberSex.value == "女")
				imgList[i].src = require.toUrl('./img/mother.jpg'); // console.log('forEach遍历:'
			// + i + '：'
			// +
			// value.memberName);
			else
				imgList[i].src = require.toUrl('./img/father.jpg');
			// 画线
			cans.moveTo(lineStart.x, lineStart.y);
			var lineTo = {
				x : lineStart.x,
				y : lineStart.y - 20
			};
			cans.lineTo(lineTo.x, lineTo.y);
			cans.stroke();

			cans.moveTo(lineTo.x, lineTo.y);
			var lineTo2 = {
				x : xxFrame + wFrame / 2,
				y : lineTo.y
			};
			cans.lineTo(lineTo2.x, lineTo2.y);
			cans.stroke();

			cans.moveTo(lineTo2.x, lineTo2.y);
			var lineTo2 = {
				x : xxFrame + wFrame / 2,
				y : yyFrame
			};
			cans.lineTo(lineTo2.x, lineTo2.y);
			cans.stroke();

			if (value.memberSex.value == "男") {
				var lineStart1 = {
					x : xxFrame + wFrame,
					y : yyFrame + hFrame / 2
				};
				drawMate(jsonFamily, value.ID.value, "配偶", xxFrame + hDistance, yyFrame, wFrame, hFrame, lineStart1);
			} else {
				lineStart1 = {
					x : xxFrame,
					y : yyFrame + hFrame / 2
				};
				drawMate(jsonFamily, value.ID.value, "配偶", xxFrame - hDistance, yyFrame, wFrame, hFrame, lineStart1);
			}
			// 半显示信息存储全局数组
			var args = {
				fID : value.ID,
				fName : value.memberName,
				fSex : value.memberSex,
				fPhoto : '',
				fPhone : value.memberPhone,
				fGeneration : generation,
				x1 : xxFrame,
				y1 : yyFrame,
				x2 : xxFrame + wFrame,
				y2 : yFrame + hFrame
			};
			familyData.push(args);
		})
	}

	Model.prototype.showOver = function(event) {
		$("#idAddMember").hide();
		$("#idOperation").show();

		var o = globalMe.comp("popOver1");
		o.show();
	}

	Model.prototype.showFamily = function(event) {

		console.log("fdsaf");
		drawInit();

		var Loginname = localStorage.getItem("Loginname");
		var accessToken = localStorage.getItem("Token");

		justep.Baas.sendRequest({
			"url" : "/zupu/Family",
			"action" : "FamilyMember",
			"async" : false,
			"params" : {
				"loginName" : "admin",// Loginname,
				"accessToken" : accessToken
			},
			"requestHeader" : function(request) {
				request.setRequestHeader("token", "111");
			},
			"success" : function(data) {
				// 获取返回值，存放到output1组件中
				if (data.rows.length > 0) {
					familyMember = data;
					PaintFamily(familyMember);
				}
			}
		});

		/*
		 * $.ajax({ type: "GET", url:
		 * require.toUrl('./main/json/myfamily.json'), dataType: 'json', async:
		 * false, cache: false, success: function(data){ //var jsonFamily
		 * =jsonsql.query("select * from json.rows where (ID=='3') order by
		 * familyCode desc,json",data);
		 * 
		 * PaintFamily(data); }, error: function(){ throw
		 * justep.Error.create("加载数据失败"); } });
		 */

	};

	Model.prototype.modelActive = function(event) {
	
		// deparment接受消息
		console.log("页面激活接收数据=" + this.params.bumenlx);	
		// 部门 及类型
		$("#bumen_leixing").html(this.params.bumenlx);			
		$("#bumen_classification").html(this.params.bumen);

		// this.getElementByXid("spanUserName").innerHTML =
		// localStorage.getItem("Username");
		// this.getElementByXid("spanFamilyCode").innerHTML = "族谱号：" +
		// localStorage.getItem("Familycode");
	console.log("進入頁面激活方法");	
			$.ajax({
			headers:{
				Authorization: "Bearer " + localStorage.getItem('Token'),
			},
			url : serverUrl+'/YProject/api/query?login_name='+loginName,
			processData : false,
			cache : false,
			async : true,
			global : false,
			contentType : "application/json; charset=utf-8",
			datatype : "json",
			type : 'post',
			success : function(res) {
				console.log(res.message);
				var url = serverUrl + res.data.picture;
				$("#image_head").attr("src",url);
				$("#zupuname").html(res.data.name);
				if((res.data.introduction.length) >= 10){
					var introduction = res.data.introduction.substring(0,10)+'...';
					$("#introduction").html(introduction);
				}
				else{
					$("#introduction").html(res.data.introduction);
				}
				id=res.data.id;
			},
			error : function(res) {
//				justep.Util.hint(res.message, {
//					type: 'danger',	
//				});
				console.log("测试失败");
			}
		});
	
		
		$("#divFamilyCanvas").show();
		$("#divEditMember").hide();
		$("#divViewMember").hide();

	};

	Model.prototype.WorkDetail = function(event) {
		var row = event.bindingContext.$object;

		justep.Shell.showPage("work", {
			"data" : {
				"operator" : "edit",
				"Id" : row.val("Id"),
				"rowData" : row.toJson()
			}
		})
	};

	Model.prototype.educationClick = function(event) {
		var row = event.bindingContext.$object;
		justep.Shell.showPage("education", {
			"data" : {
				"operator" : "edit",
				"Id" : row.val("Id"),
				"rowData" : row.toJson()
			}
		})
	};

	Model.prototype.qrCode = function(event) {

		// console.log(justep.URL.toString());
		var loginname = localStorage.getItem("Loginname");
		this.comp('dlgQrCode').open({
			data : "http://www.ygfarm.cn/invitation?userId=" + loginname
		});

	};

	Model.prototype.btnViewRela = function(event) {
		var ID = (globalMemberClick.fID.value);
		this.comp("popOver1").hide();
		PaintFamilyByID(familyMember, ID);

	};

	Model.prototype.btnMyReleationClick = function(event) {
		var can = $$('can');
		var cans = can.getContext('2d');
		cans.height = cans.height;

		cans.fillStyle = "#ffffff";
		cans.clearRect(-0, -0, 800, 800);
		cans.fillRect(0, 0, 800, 800);
		cans.fill();
		this.showFamily(null);

		// $('html,body').animate({scrollTop:1000},'slow');
	};

	Model.prototype.btnDeleteClick = function(event) {
		var ID = (globalMemberClick.fID.value);
		justep.Util.confirm("删除当前家庭成员同时也删除其关联成员，操作无法恢复，是否继续？", function() {
			globalMe.deleteMember(ID);
			justep.Util.hint("删除成功!", {
				type : 'success'
			});
			// 刷新显示
			cleanAll();
			PaintFamily(familyMember);
			$("#divFamilyCanvas").show();
			$("#divEditMember").hide();
			$("#divViewMember").hide();

		}, function() {
			console.log("用户取消");
		});
	};

	Model.prototype.deleteMember = function(memberID) {

		var childX = familyMember.rows.filter(function(item) {
			return item.parentMember.value === memberID
		});
		if (childX.length >= 0) {

			var childMember = familyMember.rows.filter(function(item) {
				return item.parentMember.value === memberID
			});
			for (var i = 0; i < childMember.length; i++) {
				this.deleteMember(childMember[i].ID.value);
			}
		}
		console.log(memberID + "DELET");
		var a = familyMember.rows.filter(function(item) {
			return item.ID.value === memberID
		});
		var index = familyMember.rows.indexOf(a[0]);
		index > -1 && familyMember.rows.splice(index, 1);

		// 从数据库中删除
		var baas = this.comp("baasFamilyMember");
		baas.filters.clear();
		baas.setFilter("filter1", "familyCode='" + localStorage.getItem("Familycode") + "'");
		baas.refreshData();
		console.log(baas.toJson());

		var row = baas.getRowByID(memberID); // data.deleteData(data.getCurrentRow());
		if (row)
			baas.deleteData(row);

	}

	// //////////////////////////////////////////////////////////////////////
	// 触屏事件 hammer.js和pinchzoom.js easyZoom
	Model.prototype.rotate = function(event) {
		/*
		 * var angle = 0; var id = this.getIDByXID('rotate'); touch.on('#' + id,
		 * 'touchstart', function(ev){ ev.startRotate(); ev.preventDefault();
		 * }); touch.on('#' + id, 'rotate', function(ev){ var totalAngle = angle +
		 * ev.rotation; if(ev.fingerStatus === 'end'){ angle = angle +
		 * ev.rotation; } this.style.webkitTransform = 'rotate(' + totalAngle +
		 * 'deg)'; });
		 */
	};

	Model.prototype.pinch = function(event) {
		var id = this.getIDByXID('readContent');

		var canvas = document.getElementById("can");
		canvas.style.webkitTransition = 'all ease 0.05s';

		// var a = this.getIDByXID('btnMyReleation');
		// var b = document.getElementById("tet");
		// b.style.webkitTransform = "translateZ('100px')";

		var initialScale = 1;
		var currentScale;

		touch.on('#' + id, 'touchstart', function(ev) {
			ev.preventDefault();
		});

		touch.on('#' + id, 'pinch', function(ev) {
			ev.hasStopedPropagation = true;
			currentScale = ev.scale - 1;
			currentScale = initialScale + currentScale;
			currentScale = currentScale > 1 ? 1 : currentScale;
			currentScale = currentScale < 0.4 ? 0.4 : currentScale;
			canvas.style.webkitTransform = 'scale(' + currentScale + ')';
		});

		touch.on('#' + id, 'pinchend', function(ev) {
			initialScale = currentScale;
		});

		touch.on('#' + id, 'tap', function(ev) {
			initialScale = 1;
			canvas.style.webkitTransform = 'scale(' + 1 + ')';

		});

	};

	Model.prototype.drag = function(event) {
		var id = this.getIDByXID('readContent');
		touch.on('#' + id, 'touchstart', function(ev) {
			ev.returnValue = true;// window.event.returnValue=false;
			// ev.preventDefault();
		});
	};

	Model.prototype.swipeDelete = function() {
		/*
		 * var newsContentID = this.getIDByXID('newsContent'); var swipeAreaSize =
		 * 100; var dx; touch.on('#' + newsContentID, 'touchstart',
		 * function(ev){ //ev.preventDefault(); var $swipNode = $('#' +
		 * newsContentID + " li").has(ev.target); dx =
		 * parseInt($swipNode.attr('swipeX') || "0"); });
		 * 
		 * touch.on('#'+ newsContentID, 'drag', function(ev){ var $swipNode =
		 * $('#' + newsContentID + " li").has(ev.target); if(ev.direction ===
		 * "left" || ev.direction === "right"){ dx = dx || 0; var offx = dx +
		 * ev.x; if(offx < swipeAreaSize*-1){ offx = swipeAreaSize*-1; } if(offx >
		 * 0){ offx = 0; } if(ev.direction === "right" &&
		 * $swipNode.hasClass('x-swipe-out')){
		 * $swipNode.css({'transform':'translate3d('+offx+'px,0,0)'}); }else
		 * if(ev.direction === "left" && (!$swipNode.hasClass('x-swipe-out'))){
		 * $swipNode.css({'transform':'translate3d('+offx+'px,0,0)'}); } } });
		 * touch.on('#'+ newsContentID, 'dragend', function(ev){ var $swipNode =
		 * $('#' + newsContentID + " li").has(ev.target); if(ev.direction ===
		 * "left"){
		 * $swipNode.css({'transform':'translate3d(-'+swipeAreaSize+'px,0,0)'});
		 * $swipNode.addClass('x-swipe-out'); dx = swipeAreaSize*-1; }else
		 * if(ev.direction === "right"){ $swipNode.removeClass('x-swipe-out');
		 * $swipNode.css({'transform':'translate3d(0,0,0)'}); dx = 0; }
		 * $swipNode.attr('swipeX',dx); });
		 */
	};

	// /////////////////////////////////////////////////////

	Model.prototype.btnAddFatherClick = function(event) {
		// $(this.comp("panel1").domNode).hide();
		// $(this.comp("panel4").domNode).show();
		this.comp("popOverAdd").hide();

		var btnLabel = (event.source.label);

		var dname = "";
		if (btnLabel == "父亲")
			dname = "父母";
		if (btnLabel == "母亲")
			dname = "父母";
		if (btnLabel == "丈夫")
			dname = "配偶";
		if (btnLabel == "妻子")
			dname = "配偶";
		if (btnLabel == "兄妹")
			dname = "兄妹";
		if (btnLabel == "儿子")
			dname = "儿女";
		if (btnLabel == "女儿")
			dname = "儿女";

		var data = this.comp("data1");
		data.clear();
		data.newData({
			defaultValues : [ {
				"value" : 1,
				"name" : btnLabel,
				"dname" : dname
			} ]
		});
		var selIndex = this.getElementByXid("inReleation").selectedIndex;
		// if(selIndex>=0) selReleation =
		// this.getElementByXid("inReleation").options[selIndex].value ;
		if (this.getElementByXid("inReleation").options.length > 0)
			this.getElementByXid("inReleation").selectedIndex = 0;
		// data.refreshData();

		if (btnLabel == "父亲") {
			this.comp("inSex").set({
				"disabled" : true
			});
			this.comp("inputSex").val("男");
		}
		if (btnLabel == "母亲") {
			this.comp("inSex").set({
				"disabled" : true
			});
			this.comp("inputSex").val("女");
		}
		if (btnLabel == "丈夫") {
			this.comp("inSex").set({
				"disabled" : true
			});
			this.comp("inputSex").val("男");
		}
		if (btnLabel == "妻子") {
			this.comp("inSex").set({
				"disabled" : true
			});
			this.comp("inputSex").val("女");
		}
		if (btnLabel == "儿子") {
			this.comp("inSex").set({
				"disabled" : true
			});
			this.comp("inputSex").val("男");
		}
		if (btnLabel == "女儿") {
			this.comp("inSex").set({
				"disabled" : true
			});
			this.comp("inputSex").val("女");
		}
		if (btnLabel == "兄妹") {
			this.comp("inSex").set({
				"disabled" : false
			});
			this.comp("inputSex").val("男");
		}

		this.comp("inName").val("");
		this.comp("inSex").val("男");
		this.comp("inPhone").val();
		this.comp("inLiving").val(1);

		// justep.Util.hint("bbb", {type: 'danger'});
		var nodeLabelReleation = $(this.getElementByXid("labelReleation"));
		nodeLabelReleation.show();
		$("#divFamilyCanvas").hide();
		$("#divEditMember").show();
		$("#divViewMember").hide();

	};

	Model.prototype.inSexChange = function(event) {
		this.comp("inputSex").val(this.comp("inSex").val());
	};

	Model.prototype.inLivingChange = function(event) {
		this.comp("inputLiving").val(this.comp("inLiving").val() == 1 ? "健在" : "已故");
	};

	Model.prototype.btnEditMyClick = function(event) {
		var a = this.getIDByXID("imgAddWork");
		var b = this.getIDByXID("imgAddEducation");
		var c = this.getIDByXID("imgEditMarried");

		console.log(this.editMy);
		var lab = this.editMy ? "编辑" : "取消"
		// if(event.source.label=="取消")
		this.comp('btnEditMy').set({
			label : lab
		});
		if (!this.editMy)
			$("#" + a).show();
		else
			$("#" + a).hide();
		if (!this.editMy)
			$("#" + b).show();
		else
			$("#" + b).hide();
		if (!this.editMy)
			$("#" + c).show();
		else
			$("#" + c).hide();
		this.editMy = !this.editMy;
	};

	Model.prototype.PageActived = function(event) {
		return this.showEdit;
	}

	Model.prototype.userContentInactive = function(event) {
		this.showEdit.set(false);
	};
	

	// 跳转个人信息页

	Model.prototype.jump_edit = function(event) {
		justep.Shell.showPage("perinfo");
	};

	// 跳转政府事项页
	Model.prototype.zfsx = function(event) {
		justep.Shell.showPage("condition");
	};
	
	// 设置界面
	Model.prototype.div9Click = function(event) {
		justep.Shell.showPage("setting");
	};
	// 跳转办事指南界面
	Model.prototype.div1Click = function(event) {
		justep.Shell.showPage("banshizhinan");

	};
	// 跳转我的预约界面
	Model.prototype.appointment = function(event) {
		justep.Shell.showPage("appointment");

	};
	// 我的证件
	Model.prototype.wdzj = function(event){
		justep.Shell.showPage("wdzj");
	};

	return Model;
});

