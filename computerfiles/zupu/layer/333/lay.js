define(function(require) {
	// 引入layui
	require("$UI/zupu/layer/model/layui");
	require("css!$UI/zupu/layer/model/css/layui").load();
	var Model = function() {
		this.callParent();
	};
	Model.prototype.modelLoad = function(event) {
		console.log("进入onload");
		layui.use('layer', function() {
			var $ = layui.jquery
			var layer = layui.layer;
			$(".demo").on('click',function(){
				layer.msg('hello');
			})
			
		});
	}
	return Model;
});