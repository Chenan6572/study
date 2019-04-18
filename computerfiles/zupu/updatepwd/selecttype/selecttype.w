<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    style="background-color:rgba(242, 242, 242, 1)" xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="选择方式"
        style="background-color:rgba(231, 64, 58, 1)" class="x-titlebar"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title">选择方式</div>  
        <div class="x-titlebar-right reverse"/>
      </div> 
    </div>  
    <div class="x-panel-content " xid="content1"> 
      <!-- <a href="../original_pwd/original_pwd.w"> -->  
      <div class="update_up" bind-click="original_pwd">通过旧密码方式修改
        <img src="../../img/u13.png"/> 
      </div>  
      <!-- </a> -->  
      <!--  <a href="../yz_pwd/yz_pwd.w"> -->  
      <div class="update_dowm" bind-click="yz_pwd">通过手机号验证修改 
        <img src="../../img/u13.png" alt=""/> 
      </div>  
      <!-- </a> --> 
    </div> 
  </div> 
</div>
