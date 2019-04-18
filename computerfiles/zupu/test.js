define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var jsonsql = require("$UI/zupu/lib/jsonsql");
	
	var hDistance = 80;//成员间距离
	var vDistance = 140;//成员间距离
	var xCenter = 360;//中心点X
	var yCenter = 300;//中心点Y
	var userFrameWidth=60;//人物区域宽度
	var userFrameHeight=100;//人物区域高度
	var familyData=[];
	var globalMemberClick=null;
	var globalMe = null;
	var globalEditMode = 0 ;//0显示 1添加 2编辑
	var Model = function(){
		this.callParent();
	};
	
	function $$(id){
	        return document.getElementById(id);					        
	}
	
	Model.prototype.modelLoad = function(event){	
	    //初始化
	    globalMe = this;
	    globalEditMode = 0;
	    $("#divEditMember").hide();

	    $(this.comp("panel4").domNode).hide(); 
		  
		this.showFamily(event);		
	}
	
	Model.prototype.showOver = function(event)
	{ 
		    //加载数据
	    baas=this.comp("baasFamilyMember");
	    baas.setFilter("filter1", "ID='" + globalMemberClick.fID.value +"'");
	    baas.refreshData();
	   
		var o = globalMe.comp("popOver1");
	    o.show();
		
	}
	
	/*Model.prototype.btnAddMember = function(event)
	{ 
		this.comp("popOver1").hide();
		$("#divEditMember").hide();
		this.comp("popOver1").hide();
		$(this.comp("panel1").domNode).hide(); 
		$(this.comp("panel4").domNode).show();  
	}*/
	
	
	Model.prototype.btnShowMemberDetail = function(event)
	{ 
		this.comp("popOver1").hide();
		$(this.comp("panel1").domNode).hide();
		$(this.comp("panel4").domNode).show();
		// justep.Util.hint("aaa", {type: 'danger'});
		$("#divViewMember").show();
		$("#divEditMember").hide();
	}
	
	Model.prototype.btnEditMemberDetail = function(event){
		
		//将当前值赋给编辑控件
	    this.comp("inName").val(this.comp("inNameView").val());
	    this.comp("inSex").val(this.comp("inSexView").val());
	    this.comp("inPhone").val(this.comp("inPhoneView").val());
	      this.comp("inLiving").val(this.comp("inLivingView").val());
		//控制隐藏
		this.comp("popOver1").hide();
		$(this.comp("panel1").domNode).hide();
		$(this.comp("panel4").domNode).show();
		//justep.Util.hint("bbb", {type: 'danger'});
		$("#divEditMember").show();
		var nodeLabelReleation = $(this.getElementByXid("labelReleation"));
		nodeLabelReleation.hide();
		$("#divViewMember").hide();
		
	};	
	
	Model.prototype.btnAddMember = function(event){
		this.comp("popOver1").hide();
		$(this.comp("panel1").domNode).hide();
		$(this.comp("panel4").domNode).show();
		
		this.comp("inName").val("");
	    this.comp("inSex").val("男");
	    this.comp("inPhone").val();
	    this.comp("inLiving").val(1);
	      
		//justep.Util.hint("bbb", {type: 'danger'});
		var nodeLabelReleation = $(this.getElementByXid("labelReleation"));
		nodeLabelReleation.show();
		$("#divEditMember").show();
		$("#divViewMember").hide();
		
	};	
	

	
	Model.prototype.btnInvitClick = function(event){
		
		var phone = (globalMemberClick.fPhone.value);
		if(phone)
			justep.Util.hint("手机邀请" + globalMemberClick.fPhone.value + "失败,后台访问错误！", {type: 'danger'});
		else
			justep.Util.hint("未设置手机号码", {type: 'danger'});
		this.comp("popOver1").hide();
		
	}
 	Model.prototype.btnCloseClick = function(event){
		  $(this.comp("panel4").domNode).hide(); 
		  $(this.comp("panel1").domNode).show();  
	};	
		
	function drawInit()
	{
		var me=this;
		var can = $$('can');
		can.width = 800;
		cans = can.getContext('2d');	
		cans.font = 'bold 16px Arial';
		cans.textAlign = 'center';
		cans.textBaseline = 'bottom';
		cans.fillStyle = '#ccc';
		familyData =[];
		//单击事件判断哪个人物被点击
	   	 $('#can').click(function(event){
	   		 var can = $$('can');
	   		 var x = event.pageX - can.getBoundingClientRect().left;
	   		 var y = event.pageY - can.getBoundingClientRect().top;
	         //cans.fillText(x+"."+ y, x, y);
	         	         
	         for(var i=0,len=familyData.length;i<len;i++)
	         {
	        	 //console.log(familyData);
	        	 //console.log(x + ":" + y);
	        	 if(familyData[i].x1<x && familyData[i].x2>x && familyData[i].y1<y && familyData[i].y2>y )
	        	 {	       		 
	        	 	 globalMemberClick = familyData[i];
 	        	 	 //console.log(globalMemberClick.fID.value);
	        	 	 globalMe.showOver();
	        	 	 break;
	        	 }	         
	         }
	            
	   	});
	}
	//画自己
	function drawMe(jsonFamily,parentReleation,xFrame,yFrame,wFrame,hFrame)
	{
		/*var jsonA = jsonFamily.rows;
		console.log("FFF");
		with(jsonA[0])
		{
			console.log(eval(ID.value=='1'));
		}
		console.log("GGG");*/
		var jsonOne =jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "') order by memberGeneration desc,json",jsonFamily);
		
		var can = $$('can');
	   	cans = can.getContext('2d');					    	 
	   	cans.clearRect(-100, -100, 800, 800);
	    cans.fill();
		var img3 = new Image();img3.onload=function(){
	    	cans.drawImage(img3,xFrame,yFrame,wFrame,hFrame);
	    	cans.fillText(jsonOne[0].memberName.value, xFrame + 30, yFrame + hFrame - 12);
	    };
	    img3.src =require.toUrl("./img/me.jpg");//jsonOne[0].memberPhoto.value);
	     
	    var parentID = jsonOne[0].parentMember;
	    //显示父母
	    var lineStart = {x:xFrame+wFrame/2,y:yFrame};
	    drawFatherAndMother(jsonFamily,jsonOne[0].ID.value,"父母",xFrame ,yFrame - vDistance,wFrame,hFrame,lineStart);
		//drawMother(jsonFamily,jsonOne[0].ID.value,"父母",xFrame + hDistance ,yFrame - vDistance,wFrame,hFrame,lineStart);	
		//显示子女
		var lineStart = {x:xFrame+wFrame/2,y:yFrame+hFrame};
		drawChildren(jsonFamily,jsonOne[0].ID.value,"儿女",xFrame ,yFrame + vDistance,wFrame,hFrame,lineStart);
	    //显示 配偶
		var lineStart = {x:xFrame+wFrame,y:yFrame+hFrame/2};
		drawMate(jsonFamily,jsonOne[0].ID.value,"配偶",xFrame + hDistance ,yFrame,wFrame,hFrame,lineStart);
		
	    //显示兄弟姐妹
		var lineStart = {x:xFrame+wFrame/2,y:yFrame};
		drawBrotherSister(jsonFamily,jsonOne[0].ID.value,"兄妹",xFrame - hDistance ,yFrame,wFrame,hFrame,lineStart);
		
		//半显示信息存储全局数组
		var args = {fID:jsonOne[0].ID,fName:jsonOne[0].memberName,fSex:jsonOne[0].memberSex,fPhoto:'',fPhone:jsonOne[0].memberPhone,x1:xFrame,y1:yFrame,x2:xFrame+wFrame,y2:yFrame+hFrame};
		familyData.push(args);
	    	    
	}
	//绘制父亲
	function drawFatherAndMother(jsonFamily,memberID,parentReleation,xFrame,yFrame,wFrame,hFrame,lineStart)
	{	
		
		console.log(parentReleation);
		var jsonList =jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json",jsonFamily); 
		if(jQuery.isEmptyObject(jsonList)) return;
		
		var can = $$('can');
	   	cans = can.getContext('2d');					    	 
	    cans.fill();
	       
	    var imgList = [];
	    jsonList.forEach(function(value,i){
	    	
	    	var xxFrame = xFrame - hDistance;	var yyFrame = yFrame;
	    	if(value.memberSex.value=="女")
	    	{
		    	var xxFrame = xFrame + hDistance;	var yyFrame = yFrame;
	    	}

	    		imgList[i] = new Image();
		    	imgList[i].onload=function(){
		    		cans.drawImage(imgList[i],xxFrame ,yFrame ,wFrame,hFrame);
			    	cans.fillText(value.memberName.value, xxFrame + 30 , yFrame + hFrame - 12);
		    	};
		    	imgList[i].src =require.toUrl('./img/mother.jpg');	//console.log('forEach遍历:' + i + '：' + value.memberName);
		    	//画线    
			    var lineTo = {x:lineStart.x,y:yyFrame + hFrame/2 };
				cans.moveTo(lineStart.x,lineStart.y);
				cans.lineTo(lineTo.x,lineTo.y);cans.stroke(); 
				
				cans.moveTo(lineTo.x,lineTo.y);
				var  lineTo2 = {x:xxFrame+wFrame/2,y:lineTo.y};
				cans.lineTo(lineTo2.x,lineTo2.y);cans.stroke();
				
				cans.moveTo(lineTo2.x,lineTo2.y);
				var  lineTo2 = {x:xxFrame+wFrame/2,y:yyFrame};
				cans.lineTo(lineTo2.x,lineTo2.y);cans.stroke();
				
				  //半显示信息存储全局数组
				var args = {fID:value.ID,fName:value.memberName,fSex:value.memberSex,fPhoto:'',fPhone:value.memberPhone,x1:xxFrame,y1:yyFrame,x2:xxFrame+wFrame,y2:yFrame+hFrame};
				familyData.push(args);	 
	    	   	
	    })
	  
	    
/*	    return;
	    var img1 = new Image();img1.onload=function(){
	    	cans.drawImage(img1,xFrame,yFrame,wFrame,hFrame);
	    	cans.fillText(jsonList[0].memberName.value, xFrame + 30, yFrame + hFrame - 12);
	    };
	    img1.src =require.toUrl('./img/father.jpg');	    
	    //画线    
	    var lineTo = {x:lineStart.x,y:lineStart.y  - 90};
		cans.moveTo(lineStart.x,lineStart.y);
		cans.lineTo(lineTo.x,lineTo.y);cans.stroke(); 
		
		cans.moveTo(lineTo.x,lineTo.y);
		var lineTo = {x:xFrame+wFrame,y:yFrame + hFrame/2};		
		cans.lineTo(lineTo.x,lineTo.y);cans.stroke();*/
		
	}
	//绘制母亲
	function drawMother(jsonFamily,memberID,parentReleation,xFrame,yFrame,wFrame,hFrame,lineStart)
	{
		var jsonOne =jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value=='" + memberID + "') order by memberGeneration.value desc,json",jsonFamily); 
		
		var can = $$('can');
	   	cans = can.getContext('2d');					    	 
	   	//cans.clearRect(-100, -100, 800, 800);
	    cans.fill();
		 var img2 = new Image();img2.onload=function(){
		    	cans.drawImage(img2,xFrame,yFrame,wFrame,hFrame);
		    	cans.fillText(jsonOne[0].memberName.value, xFrame + 30, yFrame + hFrame - 12);
		    };
		    img2.src =require.toUrl('./img/mother.jpg');
		    
		    //画线    
		    var lineTo = {x:lineStart.x,y:lineStart.y  - 90};
			cans.moveTo(lineStart.x,lineStart.y);
			cans.lineTo(lineTo.x,lineTo.y);cans.stroke(); 
			
			cans.moveTo(lineTo.x,lineTo.y);
			var lineTo = {x:xFrame+wFrame,y:yFrame + hFrame/2};		
			cans.lineTo(lineTo.x,lineTo.y);cans.stroke();

	}
	//绘制子女
	function drawChildren(jsonFamily,memberID,parentReleation,xFrame,yFrame,wFrame,hFrame,lineStart)
	{
		
		var jsonList =jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value=='" + memberID + "') order by memberGeneration desc,json",jsonFamily); 
		console.log("fff");
		console.log(jsonList);
		if(jQuery.isEmptyObject(jsonList)) return;
		var can = $$('can');
	   	cans = can.getContext('2d');					    	 
	    cans.fill();
	    
	    var imgList = [];
	    jsonList.forEach(function(value,i){
	    	var xxFrame = xFrame  - (wFrame/2)*(i)-wFrame*i;
	    	var yyFrame = yFrame;
	    	imgList[i] = new Image();
	    	imgList[i].onload=function(){
	    		cans.drawImage(imgList[i],xxFrame ,yFrame ,wFrame,hFrame);
		    	cans.fillText(value.memberName.value, xxFrame  + 30, yFrame + hFrame - 12);
	    	};
	    	imgList[i].src =require.toUrl('./img/mother.jpg');	//console.log('forEach遍历:' + i + '：' + value.memberName);
	    	//画线    
		    var lineTo = {x:lineStart.x,y:lineStart.y  + 30};
			cans.moveTo(lineStart.x,lineStart.y);
			cans.lineTo(lineTo.x,lineTo.y);cans.stroke(); 
			
			cans.moveTo(lineTo.x,lineTo.y);
			var  lineTo2 = {x:xxFrame+wFrame/2,y:lineTo.y};
			cans.lineTo(lineTo2.x,lineTo2.y);cans.stroke();
			
			cans.moveTo(lineTo2.x,lineTo2.y);
			var  lineTo2 = {x:xxFrame+wFrame/2,y:yyFrame};
			cans.lineTo(lineTo2.x,lineTo2.y);cans.stroke();	 
			
				  //半显示信息存储全局数组
			var args = {fID:value.ID,fName:value.memberName,fSex:value.memberSex,fPhoto:'',fPhone:value.memberPhone,x1:xxFrame,y1:yyFrame,x2:xxFrame+wFrame,y2:yFrame+hFrame};
			familyData.push(args);	  	
	    })
		
	}
	//显示配偶
	function drawMate(jsonFamily,memberID,parentReleation,xFrame,yFrame,wFrame,hFrame,lineStart)
	{
		console.log(parentReleation);
		var jsonOne =jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&& parentMember.value =='" + memberID + "')  order by memberGeneration desc,json",jsonFamily); 
		if(jQuery.isEmptyObject(jsonOne)) return;
		var can = $$('can');
	   	cans = can.getContext('2d');					    	 
	   	//cans.clearRect(-100, -100, 800, 800);
	    cans.fill();
		var img2 = new Image();img2.onload=function(){
		    	cans.drawImage(img2,xFrame,yFrame,wFrame,hFrame);
		    	cans.fillText(parentReleation, xFrame + 30, yFrame + hFrame - 12);
		};
		img2.src =require.toUrl('./img/mother.jpg');
		//往回画线    
		var lineFinish={x:xFrame,y:yFrame+hFrame/2};
		cans.moveTo(lineFinish.x,lineFinish.y);cans.lineTo(lineStart.x,lineStart.y);cans.stroke(); 
		
		var args = {fID:jsonOne[0].ID,fName:jsonOne[0].memberName.value,fSex:jsonOne[0].memberSex.value,fPhoto:'',fPhone:jsonOne[0].memberPhone,x1:xFrame,y1:yFrame,x2:xFrame+wFrame,y2:yFrame+hFrame};
		familyData.push(args);	
	}
	//显示兄弟姐妹
	function drawBrotherSister(jsonFamily,memberID,parentReleation,xFrame,yFrame,wFrame,hFrame,lineStart)
	{
	
		var jsonList =jsonsql.query("select * from json.rows where (parentRelation.value=='" + parentReleation + "'&&parentMember.value=='" + memberID + "') order by memberBirthday desc,json",jsonFamily); 
		console.log(jsonList);
		
		var can = $$('can');
	   	cans = can.getContext('2d');					    	 
	    cans.fill();
	    var imgList = [];
	    jsonList.forEach(function(value,i){
	    	var xxFrame = xFrame - wFrame*(i+1)-20*i ;
	    	var yyFrame = yFrame;
	    	imgList[i] = new Image();
	    	imgList[i].onload=function(){
	    		cans.drawImage(imgList[i],xxFrame,yFrame,wFrame,hFrame);
		    	cans.fillText(value.memberName.value, xxFrame + 30, yFrame + hFrame - 12);
	    	};
	    	imgList[i].src =require.toUrl('./img/mother.jpg');	//console.log('forEach遍历:' + i + '：' + value.memberName);
	    	
	    	//画线    
			cans.moveTo(lineStart.x,lineStart.y);
			var lineTo = {x:lineStart.x,y:lineStart.y  - 20};
			cans.lineTo(lineTo.x,lineTo.y);cans.stroke(); 
			
			cans.moveTo(lineTo.x,lineTo.y);
			var  lineTo2 = {x:xxFrame+wFrame/2,y:lineTo.y};
			cans.lineTo(lineTo2.x,lineTo2.y);cans.stroke();
			
			cans.moveTo(lineTo2.x,lineTo2.y);
			var  lineTo2 = {x:xxFrame+wFrame/2,y:yyFrame};
			cans.lineTo(lineTo2.x,lineTo2.y);cans.stroke();
	    	
	    })
	}
	
 
	
	function PaintFamily(jsonFamily)
	{
		//$("#test").html(require.toUrl('./img/father.jpg'));
    	var can = $$('can');
    	cans = can.getContext('2d');					    	 
    	cans.clearRect(-100, -100, 800, 800);
	    cans.fill();
	    //定义绘制中心点
	    var userFrameX=xCenter + (userFrameWidth/2);var userFrameY=yCenter-userFrameHeight/2;
	    //paintOne(jsonFamily,"自己"); 
	    drawMe(jsonFamily,"自己",userFrameX ,userFrameY,userFrameWidth,userFrameHeight);	
	}
	
	function paintOne(jsonFamily,parentReleation)
	{		
	
	}
	
	Model.prototype.showFamily = function(event){
	
		 drawInit();
		 
		 justep.Baas.sendRequest({
			 "url" : "/zupu/Family",
			 "action" : "FamilyMember",
			"async" : false,
			"params" : {
				"loginName" : "admin"				
			},
			"success" : function(data) {
                //获取返回值，存放到output1组件中
                console.log(data);    
                PaintFamily(data);
			}
		});
		 return ;
		 
		 $.ajax({
	            type: "GET",
	            url: require.toUrl('./main/json/myfamily.json'),
	            dataType: 'json',
	            async: false,
	            cache: false,
	            success: function(data){
	            	//var jsonFamily =jsonsql.query("select * from json.rows where (ID=='3') order by familyCode desc,json",data); 
	            	
	            	PaintFamily(data);
	            },
	            error: function(){
	              throw justep.Error.create("加载数据失败");
	            }
	     });//justep.Util.hint(ff, {type: 'danger'});
		
	   
	};	
	

	Model.prototype.btnSubmitClick = function(event){
		var me = this;
		
		var parentMember = globalMemberClick.fID.value;
		var id = $("#hidMemberID").val();
		
		var name = this.comp("inName").val();
		var phone = this.comp("inPhone").val();
		var sex = this.comp("inSex").val();
		var living = this.comp("inLiving").val();
		var birth = this.comp("inBirth").val();
		var selReleation="";
		var selIndex = this.getElementByXid("inReleation").selectedIndex ;		
		if(selIndex>=0)  selReleation = this.getElementByXid("inReleation").options[selIndex].text ;
		
		//justep.Date dtBirth = justep.Date.fromString(birth,'yyyy-MM-dd');  
		
		//fmBirth = justep.Date.toString(new Date(),'yyyy-MM-dd');
		
		var nodeLabelReleation = $(this.getElementByXid("labelReleation"));
		//nodeLabelReleation.hide();
		if(nodeLabelReleation.is(':hidden'))
		{
			var baas = this.comp("baasFamilyMember");
			var row = baas.getFirstRow();
			 
			//if(baas.getRowID(row)=="249")
			{
				var dt = new Date(birth);
				var birthA= justep.Date.toString(dt, 'yyyy-MM-dd')
				console.log(birthA);
				baas.setValue("memberName", name, row);
				baas.setValue("memberSex", sex, row);
				baas.setValue("memberPhone", phone, row);
				baas.setValue("memberBirthday", birthA, row);
				baas.setValue("memberLiving", living, row);
				
				var option={"onSuccess":function(e){ justep.Util.hint("保存成功！", {type: 'danger'});}};
				baas.saveData(option);
			}
			return;
		}
		justep.Baas.sendRequest({
			 "url" : "/zupu/Family",
			 "action" : "AddFamilyMember",
			"async" : false,
			"params" : {
				"memberID" : "0",
				"familyCode" : "100001",
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
                 justep.Util.hint("添加成功！", {type: 'danger'});
                  
			}
		});
		 return ;
	

	};	
	
	
	return Model;
});