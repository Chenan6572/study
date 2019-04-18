define(function(require){
require('$model/UI2/system/components/justep/model/model');
require('$model/UI2/system/components/justep/loadingBar/loadingBar');
require('$model/UI2/system/components/justep/button/button');
require('$model/UI2/system/components/bootstrap/tabs/tab');
require('$model/UI2/system/components/justep/list/list');
require('$model/UI2/system/components/justep/titleBar/titleBar');
require('$model/UI2/system/components/justep/panel/child');
require('$model/UI2/system/components/justep/data/data');
require('$model/UI2/system/components/justep/window/window');
require('$model/UI2/system/components/bootstrap/tabs/tabs');
require('$model/UI2/system/components/justep/panel/panel');
var __parent1=require('$model/UI2/system/lib/base/modelBase'); 
var __parent0=require('$model/UI2/zupu/govement/matterList'); 
var __result = __parent1._extend(__parent0).extend({
	constructor:function(contextUrl){
	this.__sysParam='true';
	this.__contextUrl=contextUrl;
	this.__id='';
	this.__cid='cYbYj2m';
	this._flag_='39d1f2ec16ad010bc78d5c48ba6c6526';
	this._wCfg_={};
	this._appCfg_={};
	this.callParent(contextUrl);
 var __Data__ = require("$UI/system/components/justep/data/data");new __Data__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"content":{"define":"content","label":"内容","name":"content","relation":"content","type":"String"},"id":{"define":"id","label":"标识","name":"id","relation":"id","rules":{"integer":true},"type":"Integer"},"publictime":{"define":"publictime","label":"发布时间","name":"publictime","relation":"publictime","rules":{"time":true},"type":"Time"},"title":{"define":"title","label":"标题","name":"title","relation":"title","type":"String"}},"directDelete":false,"events":{},"idColumn":"id","initData":"[{\"id\":1,\"title\":\"对因见义勇为致残人员进行...\",\"content\":\"关于2019年度居民建立电子档案的通知\",\"publictime\":\"2019-01-03\"},{\"id\":2,\"title\":\"民族成份变更确认\",\"content\":\"关于2019年度居民建立电子档案的通知\",\"publictime\":\"2019-02-01\"},{\"id\":3,\"title\":\"收养子女入户\",\"content\":\"关于2019年度居民建立电子档案的通知\",\"publictime\":\"2019-01-06\"},{\"id\":4,\"title\":\"孤残儿手术费申报\",\"content\":\"关于2019年度居民建立电子档案的通知\",\"publictime\":\"2019-02-03\"}]","isMain":false,"limit":20,"xid":"data1"});
}}); 
return __result;});