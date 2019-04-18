<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:415px;left:326px;height:auto;"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full body"
    xid="panel1"> 
    <div class="x-panel-top title" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="我的证件"
        class="x-titlebar title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"><![CDATA[我的证件]]></div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content back" xid="content1"> 
      <div class="list_top"> 
        <span class="top_left">证件列表</span>  
        <div class="top_right" bind-click="add"> 
          <img src="$UI/zupu/img/u12321.png" class=""/>  
          <a bind-click="">添加</a> 
        </div> 
      </div>  
      <div class="list" id="zj"> 
      <!--拼接页面  -->
      <div class="item">
        <div class="media_container"> 
          <img src="$UI/zupu/img/yuan.png" class="media_img"/> 
        </div>  
        <div class="media_cont"> 
          <span id="">身份证</span>  
          <span id="">123132121231321</span> 
        </div>  
        <span class="media_name" id="idcard_name">某某</span> 
      </div> 
      </div>
    </div> 
  </div> 
</div>