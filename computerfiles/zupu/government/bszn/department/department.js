define(function(require) {
	var justep = require("$UI/system/lib/justep");
	var Model = function() {
	this.callParent();
	};

	$(".department").addClass('bg_color');
	$("._right").css({display:"block"});
	Model.prototype.modelLoad = function(event){
	console.log("进入选项卡");
		//每一个部门增加点击事件 ,关闭页面
		$(".departmentline").on('click', function(e) {
			var bumenlx = $(".departmentleft").text();
			var bumen = $(this).text();	
			console.log(bumenlx);
	       justep.Shell.showPage("condition", {bumenlx:bumenlx,bumen: bumen});
		});
	};
	
	//主题选择点击效果
	$(".departmentline").on('click', function(e) {
				
	});	
/*	for (var i = 0; i < topic_selection.length; i++) {
		(function(n) {
			topic_selection[n].addEventListener('click', function() {
				for (var j = 0; j < topic_selection.length; j++) {
					topic_selection[j].classList.remove('bg_color');
					bumen[j].style.display = 'none';
				}
				this.classList.add('bg_color');
				bumen[n].style.display = 'block';
			});
		})
	}*/
	return Model;
});
