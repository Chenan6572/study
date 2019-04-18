<?xml version="1.0" encoding="UTF-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" xid="window" class="window" component="$UI/system/components/justep/window/window" design="device:m;">  
  <div component="$UI/system/components/justep/model/model" xid="model" onLoad="modelLoad" style="height:auto;top:576px;left:502px;"><div component="$UI/system/components/justep/data/data" autoLoad="true" xid="data1" idColumn="id"><column label="关系ID" name="id" type="Long" xid="xid1"></column>
  <column label="关系名称" name="name" type="String" xid="xid2"></column>
  <data xid="default1">[{&quot;id&quot;:1,&quot;name&quot;:&quot;父亲&quot;},{&quot;id&quot;:2,&quot;name&quot;:&quot;母亲&quot;},{&quot;id&quot;:3,&quot;name&quot;:&quot;妻子&quot;},{&quot;id&quot;:4,&quot;name&quot;:&quot;兄弟姐妹&quot;},{&quot;id&quot;:5,&quot;name&quot;:&quot;儿子&quot;},{&quot;id&quot;:6,&quot;name&quot;:&quot;女儿&quot;}]</data></div></div> 
    
<div component="$UI/system/components/justep/popOver/popOver" class="x-popOver" direction="auto" xid="popOver1">
   <div class="x-popOver-overlay" xid="div1"></div>
<div class="x-popOver-content" xid="div2">
<div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
   <div class="x-col x-col-center" xid="col4" ><img src="$UI/zupu/img/weibo.png"   alt="" xid="imagexxx" style="width:100px;text-align:center" bind-click="test" ></img></div>
   <div class="x-col" xid="col5"><img src="$UI/zupu/img/weibo.png"   alt="" xid="imagexxx" style="width:100px;" bind-click="test"></img></div>
   <div class="x-col" xid="col6"><img src="$UI/zupu/img/weibo.png"   alt="" xid="imagexxx" style="width:100px;" bind-click="test"></img></div>
</div>
<div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
   <div class="x-col" xid="col4"  style="text-align:center">邀请加入</div>
   <div class="x-col" xid="col5" style="text-align:center">查看资料</div>
   <div class="x-col" xid="col6" style="text-align:center">添加亲人</div>
</div>

</div></div>
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel2">
   
   <div class="x-panel-content" xid="content4"><div component="$UI/system/components/justep/contents/contents" class="x-contents x-full" active="0" xid="contents3">
   <div class="x-contents-content" xid="content5">
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel4" style="display:block">
   
  <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar" xid="titleBar1">
	   <div class="x-titlebar-left" xid="left1">
	   		<a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon" label="返回" xid="backBtn" icon="icon-arrow-left-c" onClick="btnCloseClick">
	 		 <i xid="i2" class="icon-arrow-left-c"></i>
		   <span xid="span5">返回</span>
		   </a>
		</div>
		<div class="x-titlebar-title" xid="title1">
		   <span xid="span4"><![CDATA[添加亲人]]></span>
		</div>
  		 <div class="x-titlebar-right reverse" xid="right1"></div>
  </div>
  
   <div class="x-panel-content" xid="content6" style="display:block;margin-top:60px">
   	  	
   
    <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30"
        xid="labelSelect1"> 
        <label class="x-label" xid="label5"><![CDATA[类型]]></label>  
        <select component="$UI/system/components/justep/select/select" class="form-control x-edit"
          xid="select4" bind-ref="accountData.ref('fType')" bind-options="typeData"
          bind-optionsValue="fType"/> 
      </div>  
      <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30"
        xid="labelSelect2"> 
        <label class="x-label" xid="label2"><![CDATA[分类]]></label>  
        <select component="$UI/system/components/justep/select/select" class="form-control x-edit"
          xid="select2" bind-ref="accountData.ref('fClass')" bind-options="$model.classData.find(['fType'], [$model.accountData.getValue('fType')])"
          bind-optionsValue="fClass"/> 
      </div>  
      <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30"
        xid="labelInput1"> 
        <label class="x-label" xid="label1"><![CDATA[日期]]></label>  
        <input component="$UI/system/components/justep/input/input" class="form-control x-edit"
          xid="input1" bind-ref="accountData.ref('fDate')"/> 
      </div>  
      <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30"
        xid="labelInput2"> 
        <label class="x-label" xid="label3"><![CDATA[金额]]></label>  
        <input component="$UI/system/components/justep/input/input" class="form-control x-edit"
          xid="input2" bind-ref="accountData.ref('fMoney')" format="0,000.00" placeHolder="0.00"/> 
      </div>  
      <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30"
        xid="labelInput3"> 
        <label class="x-label" xid="label6"><![CDATA[备注]]></label>  
        <input component="$UI/system/components/justep/input/input" class="form-control x-edit"
          xid="input3" bind-ref="accountData.ref('fDescription')" placeHolder="请输入备注"/> 
      </div> 
   
   
   
   </div>
  <div class="x-panel-bottom" xid="bottom1"></div></div><div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
   <div class="x-panel-content" xid="content2">
  <canvas id="can" width="500" height="800"></canvas>
  </div>
   </div></div>
  </div></div>
   </div></div>