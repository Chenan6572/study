define(function(require){
require('$model/UI2/system/components/justep/model/model');
require('$model/UI2/system/components/justep/loadingBar/loadingBar');
require('$model/UI2/system/components/justep/button/button');
require('$model/UI2/system/components/bootstrap/table/table');
require('$model/UI2/system/components/justep/input/input');
require('$model/UI2/system/components/justep/titleBar/titleBar');
require('$model/UI2/system/components/justep/panel/child');
require('$model/UI2/system/components/justep/window/window');
require('$model/UI2/system/components/justep/data/baasData');
require('$model/UI2/system/components/justep/panel/panel');
var __parent1=require('$model/UI2/system/lib/base/modelBase'); 
var __parent0=require('$model/UI2/zupu/govement/matterApply'); 
var __result = __parent1._extend(__parent0).extend({
	constructor:function(contextUrl){
	this.__sysParam='true';
	this.__contextUrl=contextUrl;
	this.__id='';
	this.__cid='ceqUJ7j';
	this._flag_='943bba07fb295a5e51d86e5d73884828';
	this._wCfg_={};
	this._appCfg_={};
	this.callParent(contextUrl);
 var __BaasData__ = require("$UI/system/components/justep/data/baasData");new __BaasData__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"Id":{"define":"Id","label":"Id","name":"Id","relation":"Id","rules":{"integer":true},"type":"Integer"},"applicant":{"define":"applicant","label":"申请人","name":"applicant","relation":"applicant","type":"String"},"matterID":{"define":"matterID","label":"所属事项","name":"matterID","relation":"matterID","rules":{"integer":true},"type":"Integer"},"matterName":{"define":"matterName","label":"所属事项名称","name":"matterName","relation":"matterName","type":"String"},"phone":{"define":"phone","label":"电话","name":"phone","relation":"phone","type":"String"},"staff":{"define":"staff","label":"申请材料","name":"staff","relation":"staff","type":"String"},"staffComment":{"define":"staffComment","label":"材料说明","name":"staffComment","relation":"staffComment","type":"String"},"transactResult":{"define":"transactResult","label":"审核结果","name":"transactResult","relation":"transactResult","type":"String"},"transactState":{"define":"transactState","label":"办理状态","name":"transactState","relation":"transactState","type":"String"}},"directDelete":false,"events":{},"idColumn":"Id","isMain":false,"limit":20,"queryAction":"queryMatterapply","saveAction":"saveMatterapply","tableName":"matterapply","url":"/zupu/Matter","xid":"matterApply"});
}}); 
return __result;});