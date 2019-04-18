define(function(require){
	var $ = require("jquery");
	var justep = require("$UI/system/lib/justep");
	require("$UI/zupu/js/date/datePicker");
	require("css!$UI/zupu/css/LCalendar").load();
	var calendar = new datePicker();
	calendar.init({
		'trigger' : '#start_date', /* 按钮选择器，用于触发弹出插件 */
		'type' : 'date',/* 模式：date日期；datetime日期时间；time时间；ym年月； */
		'minDate' : '1900-1-1',/* 最小日期 */
		'maxDate' : '2100-12-31',/* 最大日期 */
		'onSubmit' : function() {/* 确认时触发事件 */
			var theSelectData = calendar.value;
		},
		'onClose' : function() {/* 取消时触发事件 */
		}
	});
	calendar.init({
		'trigger' : '#end_date', /* 按钮选择器，用于触发弹出插件 */
		'type' : 'date',/* 模式：date日期；datetime日期时间；time时间；ym年月； */
		'minDate' : '1900-1-1',/* 最小日期 */
		'maxDate' : '2100-12-31',/* 最大日期 */
		'onSubmit' : function() {/* 确认时触发事件 */
			var theSelectData = calendar.value;
		},
		'onClose' : function() {/* 取消时触发事件 */
		}
	});
	var Model = function(){
		this.callParent();
	};

	return Model;
});