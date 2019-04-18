<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:623px;left:386px;height:auto;" onLoad="modelLoad" onActive="modelActive" onParamsReceive="modelParamsReceive"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="办事指南"
        class="x-titlebar title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"><![CDATA[办事指南]]></div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content" xid="content1"> 
      <div class="condition"> 
        <div class="chaxun"> 
          <span class="span_left "><![CDATA[地区]]></span>  
          <span class="span_right font-color"><![CDATA[吉林省]]></span>  
          <a> 
            <img src="$UI/zupu/img/sj.png" alt="" xid="image2"/> 
          </a> 
        </div>  
        <div class="chaxun" bind-click="bumenclick"> 
          <span class="span_left" id="bumen_leixing"><![CDATA[部门]]></span>  
          <span class="span_right font-color" id="bumen_classification">全部</span>  
          <a> 
            <img src="$UI/zupu/img/sj.png" alt=""/> 
          </a> 
        </div>  
        <div class="chaxun"> 
          <span class="span_left"><![CDATA[关键词]]> </span>  
          <input type="text" placeholder="请输入关键词,如教育等" class="input_css"/> 
        </div>  
        <div class="chaxun" style="padding-left:8%; padding-right:8%;"> 
          <div class="btn_"  bind-click="search">查询</div> 
        </div> 
      </div>  
    <!--   <div class="redian "> 
        <div class="left_redian"> 
          <img src="$UI/zupu/img/address.png" alt="" class="image_redian"/> 
        </div>
        <span class="right_redian"><![CDATA[热点事项]]></span> 
      </div>  
      <div class="chaxun"> 
        <span class="span_left"><![CDATA[1、高龄老人补贴申请]]></span> 
      </div>  
      <div class="chaxun"> 
        <span class="span_left"><![CDATA[2、高龄老人补贴申请]]></span> 
      </div>  
      <div class="chaxun"> 
        <span class="span_left"><![CDATA[3、高龄老人补贴申请]]></span> 
      </div>  -->
    </div> 
  </div> 
</div>
