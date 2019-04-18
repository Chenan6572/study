define(function(require) {
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");

	var Model = function() {
		this.callParent();
	};
	
	function test2()
	{
		$("#test").html('fssssssssss');
	}
	//图片路径转换
	Model.prototype.getImageUrl = function(url){
		return require.toUrl(url);
	};
	
	//页面初始化
	Model.prototype.modelLoad = function(event){
		$("input[xid=keyInput]", this.getRootNode()).val("请输入...");
		$("#test").html("");
		this.showFamily(event);
	};
		
	//加载数据
	Model.prototype.productDataCustomRefresh = function(event){
		var newsData = event.source;
        $.ajax({
            type: "GET",
            url: require.toUrl('./main/json/newsData.json'),
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data){
            	newsData.loadData(data);//将返回的数据加载到data组件
            },
            error: function(){
              throw justep.Error.create("加载数据失败");
            }
        });
       
	};
	Model.prototype.navDataCustomRefresh = function(event){
		var navData = event.source;
        $.ajax({
            type: "GET",
            url: require.toUrl('./main/json/navData.json'),
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data){
            	navData.loadData(data);//将返回的数据加载到data组件
            },
            error: function(){
              throw justep.Error.create("加载数据失败");
            }
        });	
	};
	
	//进入列表页
	Model.prototype.listClick = function(event){
		/*
		代码如下：
		justep.Shell.showPage("searchList");
		*/
	};
		
	//进入内容页
	Model.prototype.detailClick = function(event){
		/*
		代码如下：
		justep.Shell.showPage("detail");
		*/
	};	
	
	//24小时要闻
	Model.prototype.importantBtnClick = function(event){
		/*
		代码如下：
		justep.Shell.showPage("important");
		*/
	};	
	
	//下滑显示搜索
	var startY;
	Model.prototype.navContent1Touchstart = function(event){
		startY = event.originalEvent.changedTouches[0].pageY;
	};
	Model.prototype.navContent1Touchmove = function(event){
		var moveEndY = event.originalEvent.changedTouches[0].pageY;
		var Y = moveEndY - startY;
		if(Y>0){
			$(".x-seach",this.getRootNode()).slideDown();
		}
	};	
		
	
		
	Model.prototype.showFamily = function(event){
		//$("#test").html(require.toUrl('./img/father.jpg'));
    	var can = $$('can');
    	 $('#can').click(function(event){
    		 var can = $$('can');
    		 //var x = event.pageX;  var y = event.pageY;
    		 var x = event.pageX - can.getBoundingClientRect().left;
    		 var y = event.pageY - can.getBoundingClientRect().top;
             cans.fillText(x+"."+ y, x, y);
    	});
    	cans = can.getContext('2d');					    	 
    	//cans.scale(1.1,1.1);
    	//cans.translate(10,10);平移					    	
    	
    	//cans.fillStyle = 'red';
    	cans.clearRect(-100, -100, 800, 800);
	    //cans.rect(50, 100, 200, 100);
	    //cxt.stroke();
	    cans.fill();
	    
	    
	    cans.font = 'bold 16px Arial';
		cans.textAlign = 'center';
		cans.textBaseline = 'bottom';
		cans.fillStyle = '#ccc';
	    //cans.fillRect(0,0,22,22);
	    var img1 = new Image();img1.onload=function(){
	    	cans.drawImage(img1,120,120,50,70);
	    	cans.fillText("父亲", 145, 185);
	    };
	    img1.src =require.toUrl('./img/father.jpg');
	    var img2 = new Image();img2.onload=function(){
	    	cans.drawImage(img2,240,120,50,70);
	    	cans.fillText("母亲", 265, 185);
	    };
	    img2.src =require.toUrl('./img/mother.jpg');
	    var img3 = new Image();img3.onload=function(){
	    	cans.drawImage(img3,180,240,50,70);
	    	cans.fillText("我", 205, 305);//		//cans.strokeText("父亲", 145, 185);
	    };
	    img3.src =require.toUrl('./img/me.jpg');
	        		
		cans.moveTo(170,155);cans.lineTo(240,155);cans.stroke();
		cans.moveTo(205,155);cans.lineTo(205,240);cans.stroke(); 
		
		//点击事件
		 

	};	
		
	function abc()
    {	    	
    }
		
	return Model;
});