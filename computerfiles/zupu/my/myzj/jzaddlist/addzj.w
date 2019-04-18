<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:415px;left:326px;height:auto;"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full body"
    xid="panel1"> 
    <div class="x-panel-top title" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="添加证件"
        class="x-titlebar title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"><![CDATA[添加证件]]></div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content back" xid="content1"> 
      <div class="list"> 
        <img src="$UI/zupu/img/yuan.png" class="media_img"/>  
        <div class="media_cont"> 
          <span id="" class="zj">身份证</span> 
        </div>  
        <img class="media_right" src="$UI/zupu/img/u13.png"/> 
      </div> 
    </div> 
  </div> 
</div>
