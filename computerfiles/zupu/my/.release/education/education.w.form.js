define(function(require){
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