<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:377px;left:270px;height:auto;"
    onLoad="modelLoad"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="办事指南"
        class="x-titlebar  title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"> <![CDATA[办事指南]]> </div>  
        <div class="x-titlebar-right reverse"/>
      </div> 
    </div>  
    <div class="x-panel-content" xid="content1"> 
      <div id="app1"> 
        <div component="$UI/system/components/justep/button/button" 
          xid="orderData"> 
          <div class="list_table"> 
            <div v-for="sz in szz" class="list_ta" onclick="jumpvale(this.children[0].text)"> 
              <a style="display:none" v-text="sz.id"/>  
              <div v-text="sz.name" class="list_name"/>  
              <div v-text="sz.bj_org" class="list_mechanism"/> 
            </div> 
          </div> 
        </div> 
      </div> 
    </div> 
  </div> 
</div>