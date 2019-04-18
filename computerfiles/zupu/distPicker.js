define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	var Vue = require("$UI/zupu/js/vue");

	require("$UI/zupu/js/mui.min"); //MUI选择器js
	require("css!$UI/zupu/css/mui").load(); //MUI选择器css
	
	var Model = function(){
		this.callParent();
	};
 	
	Model.prototype.input1Click = function(event){
			var ditpicker2 = this.comp('distpicker21');
			ditpicker2.show();
	};

	Model.prototype.button1Click = function(event){
		var ditpicker2 = this.comp('distpicker21');
		var a = ditpicker2.getValue();
		console.log(a);
		this.comp("input1").val(a.district); //province  city district
	};

	Model.prototype.modelActive = function(event){
			 
		
	};

	Model.prototype.modelLoad = function(event){
	
			edulist = new Vue({
					el : '.app1',
					data : {
						push:'',
						edudata : [
						         { message: 'Foo' },
						         { message: 'Bar' }    
						]
					},
					created : function() {
						;
					},
					methods:{
						pushlist1:function(){
							;//this.edudata = edudata;
						}
					}
				});
				
				
				
				//男女选择器
		mui('#picture').on('tap', 'li>a', function () {
			$("#sex").val(this.innerHTML);
			mui("#picture").popover('toggle'); //这是可以用来关闭底部弹窗的事件
		})

	};

	return Model;
});