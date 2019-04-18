window.__justep.__ResourceEngine.loadCss([{url: '/UI2/v_a232a792bd5648b4a31c2aa8045bdaacl_zh_CNs_d_m/system/components/bootstrap.min.css', include: '$model/UI2/system/components/bootstrap/lib/css/bootstrap,$model/UI2/system/components/bootstrap/lib/css/bootstrap-theme'},{url: '/UI2/v_1c6a31be919c406389a8fd69aeae850al_zh_CNs_d_m/system/components/comp.min.css', include: '$model/UI2/system/components/justep/lib/css2/dataControl,$model/UI2/system/components/justep/input/css/datePickerPC,$model/UI2/system/components/justep/messageDialog/css/messageDialog,$model/UI2/system/components/justep/lib/css3/round,$model/UI2/system/components/justep/input/css/datePicker,$model/UI2/system/components/justep/row/css/row,$model/UI2/system/components/justep/dataTables/css/responsive,$model/UI2/system/components/justep/attachment/css/attachment,$model/UI2/system/components/justep/barcode/css/barcodeImage,$model/UI2/system/components/bootstrap/dropdown/css/dropdown,$model/UI2/system/components/justep/contents/css/contents,$model/UI2/system/components/justep/common/css/forms,$model/UI2/system/components/justep/dataTables/css/responsive,$model/UI2/system/components/justep/locker/css/locker,$model/UI2/system/components/justep/menu/css/menu,$model/UI2/system/components/justep/scrollView/css/scrollView,$model/UI2/system/components/justep/loadingBar/loadingBar,$model/UI2/system/components/justep/dialog/css/dialog,$model/UI2/system/components/justep/bar/css/bar,$model/UI2/system/components/justep/popMenu/css/popMenu,$model/UI2/system/components/justep/lib/css/icons,$model/UI2/system/components/justep/lib/css4/e-commerce,$model/UI2/system/components/justep/toolBar/css/toolBar,$model/UI2/system/components/justep/popOver/css/popOver,$model/UI2/system/components/justep/panel/css/panel,$model/UI2/system/components/bootstrap/carousel/css/carousel,$model/UI2/system/components/justep/wing/css/wing,$model/UI2/system/components/bootstrap/scrollSpy/css/scrollSpy,$model/UI2/system/components/justep/titleBar/css/titleBar,$model/UI2/system/components/justep/lib/css1/linear,$model/UI2/system/components/justep/numberSelect/css/numberList,$model/UI2/system/components/justep/list/css/list,$model/UI2/system/components/justep/dataTables/css/dataTables'}]);window.__justep.__ResourceEngine.loadJs(['/v_61366e6512b5416293ce023369374460l_zh_CNs_d_m/system/core.min.js','/v_8e658dc4ee4c4ea0906691ac9c179e48l_zh_CNs_d_m/system/common.min.js','/v_294cef09c36b43f49c6319aec64fc17fl_zh_CNs_d_m/system/components/comp.min.js']);define(function(require){
require('$model/UI2/system/components/justep/model/model');
require('$model/UI2/system/components/justep/loadingBar/loadingBar');
require('$model/UI2/system/components/justep/button/button');
require('$model/UI2/system/components/justep/input/input');
require('$model/UI2/system/components/justep/titleBar/titleBar');
require('$model/UI2/system/components/justep/panel/child');
require('$model/UI2/system/components/justep/window/window');
require('$model/UI2/system/components/justep/data/baasData');
require('$model/UI2/system/components/justep/labelEdit/labelEdit');
require('$model/UI2/system/components/justep/panel/panel');
var __parent1=require('$model/UI2/system/lib/base/modelBase'); 
var __parent0=require('$model/UI2/zupu/my/education'); 
var __result = __parent1._extend(__parent0).extend({
	constructor:function(contextUrl){
	this.__sysParam='true';
	this.__contextUrl=contextUrl;
	this.__id='';
	this.__cid='cniYZNv';
	this._flag_='9871e555ef320ce24050fcbe2f0f52ec';
	this._wCfg_={};
	this._appCfg_={};
	this.callParent(contextUrl);
 var __BaasData__ = require("$UI/system/components/justep/data/baasData");new __BaasData__(this,{"autoLoad":true,"confirmDelete":false,"confirmRefresh":true,"defCols":{"Id":{"define":"Id","label":"Id","name":"Id","relation":"Id","rules":{"integer":true},"type":"Integer"},"finishtime":{"define":"finishtime","label":"结束时间","name":"finishtime","relation":"finishtime","rules":{"date":true},"type":"Date"},"howlong":{"define":"howlong","label":"工作时长","name":"howlong","relation":"howlong","type":"String"},"record":{"define":"record","label":"学历","name":"record","relation":"record","type":"String"},"school":{"define":"school","label":"大学","name":"school","relation":"school","type":"String"},"starttime":{"define":"starttime","label":"开始时间","name":"starttime","relation":"starttime","rules":{"date":true},"type":"Date"},"subject":{"define":"subject","label":"专业","name":"subject","relation":"subject","type":"String"},"userid":{"define":"userid","label":"用户ID","name":"userid","relation":"userid","rules":{"integer":true},"type":"Integer"}},"directDelete":true,"events":{},"idColumn":"Id","isMain":false,"limit":20,"queryAction":"queryEducationhistory","saveAction":"saveEducationhistory","tableName":"educationhistory","url":"/zupu/Educationhistory","xid":"baasData1"});
}}); 
return __result;});
