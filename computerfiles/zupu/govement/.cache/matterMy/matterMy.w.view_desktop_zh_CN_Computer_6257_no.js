window.__justep.__ResourceEngine.loadCss([{url: '/UI2/v_6257_nol_zh_CNs_desktopd_pc/system/components/bootstrap.min.css', include: '$model/UI2/system/components/bootstrap/lib/css/bootstrap,$model/UI2/system/components/bootstrap/lib/css/bootstrap-theme'},{url: '/UI2/v_6257_nol_zh_CNs_desktopd_pc/system/components/comp.min.css', include: '$model/UI2/system/components/justep/lib/css2/dataControl,$model/UI2/system/components/justep/input/css/datePickerPC,$model/UI2/system/components/justep/messageDialog/css/messageDialog,$model/UI2/system/components/justep/lib/css3/round,$model/UI2/system/components/justep/input/css/datePicker,$model/UI2/system/components/justep/row/css/row,$model/UI2/system/components/justep/dataTables/css/responsive,$model/UI2/system/components/justep/attachment/css/attachment,$model/UI2/system/components/justep/barcode/css/barcodeImage,$model/UI2/system/components/bootstrap/dropdown/css/dropdown,$model/UI2/system/components/justep/contents/css/contents,$model/UI2/system/components/justep/common/css/forms,$model/UI2/system/components/justep/dataTables/css/responsive,$model/UI2/system/components/justep/locker/css/locker,$model/UI2/system/components/justep/menu/css/menu,$model/UI2/system/components/justep/scrollView/css/scrollView,$model/UI2/system/components/justep/loadingBar/loadingBar,$model/UI2/system/components/justep/dialog/css/dialog,$model/UI2/system/components/justep/bar/css/bar,$model/UI2/system/components/justep/popMenu/css/popMenu,$model/UI2/system/components/justep/lib/css/icons,$model/UI2/system/components/justep/lib/css4/e-commerce,$model/UI2/system/components/justep/toolBar/css/toolBar,$model/UI2/system/components/justep/popOver/css/popOver,$model/UI2/system/components/justep/panel/css/panel,$model/UI2/system/components/bootstrap/carousel/css/carousel,$model/UI2/system/components/justep/wing/css/wing,$model/UI2/system/components/bootstrap/scrollSpy/css/scrollSpy,$model/UI2/system/components/justep/titleBar/css/titleBar,$model/UI2/system/components/justep/lib/css1/linear,$model/UI2/system/components/justep/numberSelect/css/numberList,$model/UI2/system/components/justep/list/css/list,$model/UI2/system/components/justep/dataTables/css/dataTables'}]);window.__justep.__ResourceEngine.loadJs(['/v_6257_nol_zh_CNs_desktopd_pc/system/core.min.js','/v_6257_nol_zh_CNs_desktopd_pc/system/common.min.js','/v_6257_nol_zh_CNs_desktopd_pc/system/components/comp.min.js']);define(function(require){
require('$model/UI2/system/components/justep/model/model');
require('$model/UI2/system/components/justep/loadingBar/loadingBar');
require('$model/UI2/system/components/justep/button/button');
require('$model/UI2/system/components/justep/controlGroup/controlGroup');
require('$model/UI2/system/components/justep/list/list');
require('$model/UI2/system/components/justep/panel/child');
require('$model/UI2/system/components/justep/panel/panel');
require('$model/UI2/system/components/justep/popOver/popOver');
require('$model/UI2/system/components/justep/row/row');
require('$model/UI2/system/components/justep/titleBar/titleBar');
require('$model/UI2/system/components/justep/window/window');
require('$model/UI2/system/components/justep/data/baasData');
require('$model/UI2/system/components/justep/button/buttonGroup');
var __parent1=require('$model/UI2/system/lib/base/modelBase'); 
var __parent0=require('$model/UI2/zupu/govement/matterMy'); 
var __result = __parent1._extend(__parent0).extend({
	constructor:function(contextUrl){
	this.__sysParam='true';
	this.__contextUrl=contextUrl;
	this.__id='';
	this.__cid='cnayIBv';
	this._flag_='4f13ebb7c54014ebe89e509e929da2f2';
	this._wCfg_={};
	this._appCfg_={};
	this.callParent(contextUrl);
 var __BaasData__ = require("$UI/system/components/justep/data/baasData");new __BaasData__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"Id":{"define":"Id","label":"Id","name":"Id","relation":"Id","rules":{"integer":true},"type":"Integer"},"applicant":{"define":"applicant","label":"申请人","name":"applicant","relation":"applicant","type":"String"},"matterID":{"define":"matterID","label":"所属事项","name":"matterID","relation":"matterID","rules":{"integer":true},"type":"Integer"},"matterName":{"define":"matterName","label":"所属事项名称","name":"matterName","relation":"matterName","type":"String"},"phone":{"define":"phone","label":"电话","name":"phone","relation":"phone","type":"String"},"staff":{"define":"staff","label":"申请材料","name":"staff","relation":"staff","type":"String"},"staffComment":{"define":"staffComment","label":"材料说明","name":"staffComment","relation":"staffComment","type":"String"},"staffFile":{"define":"staffFile","label":"材料文件","name":"staffFile","relation":"staffFile","type":"String"},"staffName":{"define":"staffName","label":"材料名称","name":"staffName","relation":"staffName","type":"String"},"transactResult":{"define":"transactResult","label":"审核结果","name":"transactResult","relation":"transactResult","type":"String"},"transactState":{"define":"transactState","label":"办理状态","name":"transactState","relation":"transactState","type":"String"}},"directDelete":false,"events":{},"idColumn":"Id","isMain":false,"limit":20,"queryAction":"queryMatterapply","saveAction":"saveMatterapply","tableName":"matterapply","url":"/zupu/Matter","xid":"data1"});
}}); 
return __result;});
