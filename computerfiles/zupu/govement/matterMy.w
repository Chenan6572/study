<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:456px;left:155px;height:auto;"> 
  <div component="$UI/system/components/justep/data/baasData" autoLoad="true" xid="data1" queryAction="queryMatterapply" saveAction="saveMatterapply" url="/zupu/Matter" tableName="matterapply" idColumn="Id"><column label="Id" name="Id" type="Integer" xid="default1"></column>
  <column label="申请人" name="applicant" type="String" xid="default2"></column>
  <column label="电话" name="phone" type="String" xid="default3"></column>
  <column label="申请材料" name="staff" type="String" xid="default4"></column>
  <column label="材料名称" name="staffName" type="String" xid="default5"></column>
  <column label="材料文件" name="staffFile" type="String" xid="default6"></column>
  <column label="材料说明" name="staffComment" type="String" xid="default7"></column>
  <column label="所属事项" name="matterID" type="Integer" xid="default8"></column>
  <column label="所属事项名称" name="matterName" type="String" xid="default9"></column>
  <column label="办理状态" name="transactState" type="String" xid="default10"></column>
  <column label="审核结果" name="transactResult" type="String" xid="default11"></column></div></div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="我的事项"
          class="x-titlebar" style="background-color:#FF2A37;">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn"> 
              <i class="icon-chevron-left"/>  
              <span></span> 
            </a> 
          </div>  
          <div class="x-titlebar-title">我的事项</div>  
          <div class="x-titlebar-right reverse"> 
          </div>
        </div> 
      </div>  
    <div class="x-panel-content" xid="content1"><ul component="$UI/system/components/justep/list/list" class="x-list x-list-template" xid="list1" data="data1">
   <li xid="li1" style="margin-top:10px"><div component="$UI/system/components/justep/controlGroup/controlGroup" class="x-control-group" title="事项名称" xid="controlGroup1">
   <div class="x-control-group-title" xid="controlGroupTitle1">
    <span xid="span1" bind-text='ref("matterName")'>事项名称</span></div> 
  <ul component="$UI/system/components/justep/list/list" class="x-list" xid="list2">
   <li xid="li4" style="height:36px;"><![CDATA[审核状态：]]> <span bind-text='ref("transactResult")' class="text-muted"><![CDATA[已通过]]></span> </li><li xid="li2" style="height:36px;"><![CDATA[事项编号：]]> <span xid="li5" bind-text='ref("matterID")'><![CDATA[001]]></span></li><li xid="li3" style="height:36px;"><![CDATA[办理状态：]]><span bind-text='val("transactState")'>已办理</span></li>
  <li xid="li5" style="height:36px;"><![CDATA[]]>
  <div xid="div48" class="iEnsure">
   <div component="$UI/system/components/justep/button/buttonGroup" class="btn-group btn-group-justified" tabbed="true" xid="buttonGroup2">
    <a component="$UI/system/components/justep/button/button" class="btn btn-link" label="查看审核详情" xid="btnDetail1" onClick="btnDetail1Click">
     <i xid="i9"></i>
     <span xid="span35">查看审核详情</span></a> 
    <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-left" label="查看申请详情" xid="button4">
     <i xid="i10"></i>
     <span xid="span36">查看申请详情</span></a> 
    <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-left" label="查看事项详情" xid="button5">
     <i xid="i11"></i>
     <span xid="span37">查看事项详情</span></a> </div> </div></li></ul></div></li></ul>
  </div>
  </div> 
<div component="$UI/system/components/justep/popOver/popOver" class="x-popOver" direction="auto" xid="popOver1">
   <div class="x-popOver-overlay" xid="div6"></div>
   <div class="x-popOver-content" xid="div5">
   <div style="width:300px;height:200px;background-color:#FFFFFF;">
  <div component="$UI/system/components/justep/row/row" class="x-row" xid="row5" style="text-align:center">
   <div class="x-col" xid="col21"><![CDATA[预审结果]]></div>
   </div><div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
   <div class="x-col" xid="col4"><![CDATA[审核人]]></div>
   <div class="x-col" xid="col5"><![CDATA[管理员]]></div>
   </div><div component="$UI/system/components/justep/row/row" class="x-row" xid="row9">
     <div class="x-col" xid="col13"><![CDATA[审核时间]]></div> 
     <div class="x-col" xid="col16"><![CDATA[2019-02-01]]></div> 
     </div><div component="$UI/system/components/justep/row/row" class="x-row" xid="row3">
   <div class="x-col" xid="col7"><![CDATA[预审意见]]></div>
   <div class="x-col" xid="col8"><![CDATA[审核通过]]></div>
   </div></div>
     
    </div> </div></div>