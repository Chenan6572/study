define(function(require){
require('$model/UI2/system/components/justep/model/model');
require('$model/UI2/system/components/justep/loadingBar/loadingBar');
require('$model/UI2/system/components/justep/button/button');
require('$model/UI2/system/components/justep/input/input');
require('$model/UI2/system/components/justep/panel/child');
require('$model/UI2/system/components/justep/button/toggle');
require('$model/UI2/system/components/justep/labelEdit/labelEdit');
require('$model/UI2/system/components/justep/panel/panel');
require('$model/UI2/system/components/justep/popOver/popOver');
require('$model/UI2/system/components/justep/contents/content');
require('$model/UI2/system/components/justep/row/row');
require('$model/UI2/system/components/justep/select/select');
require('$model/UI2/system/components/justep/contents/contents');
require('$model/UI2/system/components/justep/data/data');
require('$model/UI2/system/components/justep/window/window');
require('$model/UI2/system/components/justep/data/baasData');
var __parent1=require('$model/UI2/system/lib/base/modelBase'); 
var __parent0=require('$model/UI2/zupu/test'); 
var __result = __parent1._extend(__parent0).extend({
	constructor:function(contextUrl){
	this.__sysParam='true';
	this.__contextUrl=contextUrl;
	this.__id='';
	this.__cid='cJjE3Mr';
	this._flag_='132625fecaac4463ff1f9e7ba003f516';
	this._wCfg_={};
	this._appCfg_={};
	this.callParent(contextUrl);
 var __Data__ = require("$UI/system/components/justep/data/data");new __Data__(this,{"autoLoad":true,"confirmDelete":true,"confirmRefresh":true,"defCols":{"name":{"define":"name","label":"名称","name":"name","relation":"name","type":"String"},"value":{"define":"value","label":"值","name":"value","relation":"value","rules":{"integer":true},"type":"Integer"}},"directDelete":false,"events":{},"idColumn":"value","initData":"[{\"value\":1,\"name\":\"父母\"},{\"value\":3,\"name\":\"配偶\"},{\"value\":5,\"name\":\"兄妹\"},{\"value\":7,\"name\":\"儿女\"}]","isMain":false,"limit":20,"xid":"data1"});
 var __BaasData__ = require("$UI/system/components/justep/data/baasData");new __BaasData__(this,{"autoLoad":false,"autoNew":false,"confirmDelete":true,"confirmRefresh":true,"defCols":{"ID":{"define":"ID","label":"标识","name":"ID","relation":"ID","rules":{"integer":true},"type":"Integer"},"familyCode":{"define":"familyCode","label":"所属族谱","name":"familyCode","relation":"familyCode","type":"String"},"memberBirthday":{"define":"memberBirthday","label":"出生日期","name":"memberBirthday","relation":"memberBirthday","rules":{"date":true},"type":"Date"},"memberGeneration":{"define":"memberGeneration","label":"第几代","name":"memberGeneration","relation":"memberGeneration","rules":{"integer":true},"type":"Integer"},"memberID":{"define":"memberID","label":"成员用户ID","name":"memberID","relation":"memberID","rules":{"integer":true},"type":"Integer"},"memberIDcard":{"define":"memberIDcard","label":"身份证","name":"memberIDcard","relation":"memberIDcard","type":"String"},"memberLiving":{"define":"memberLiving","label":"健在","name":"memberLiving","relation":"memberLiving","rules":{"integer":true},"type":"Integer"},"memberName":{"define":"memberName","label":"显示名称","name":"memberName","relation":"memberName","type":"String"},"memberPhone":{"define":"memberPhone","label":"成员电话","name":"memberPhone","relation":"memberPhone","type":"String"},"memberPhoto":{"define":"memberPhoto","label":"亲人照片","name":"memberPhoto","relation":"memberPhoto","type":"String"},"memberSex":{"define":"memberSex","label":"性别","name":"memberSex","relation":"memberSex","type":"String"},"memberState":{"define":"memberState","label":"成员状态","name":"memberState","relation":"memberState","rules":{"integer":true},"type":"Integer"},"parentMember":{"define":"parentMember","label":"上级成员","name":"parentMember","relation":"parentMember","rules":{"integer":true},"type":"Integer"},"parentRelation":{"define":"parentRelation","label":"parentRelation","name":"parentRelation","relation":"parentRelation","type":"String"}},"directDelete":false,"events":{},"idColumn":"ID","isMain":false,"limit":20,"queryAction":"queryFamilymember","saveAction":"saveFamilymember ","tableName":"familymember","url":"/zupu/FamilyMember","xid":"baasFamilyMember"});
 var justep = require('$UI/system/lib/justep');if(!this['__justep__']) this['__justep__'] = {};if(!this['__justep__'].selectOptionsAfterRender)	this['__justep__'].selectOptionsAfterRender = function($element) {		var comp = justep.Component.getComponent($element);		if(comp) comp._addDefaultOption();	};if(!this['__justep__'].selectOptionsBeforeRender)	this['__justep__'].selectOptionsBeforeRender = function($element) {		var comp = justep.Component.getComponent($element);		if(comp) comp._optionsBeforeRender();	};
}}); 
return __result;});