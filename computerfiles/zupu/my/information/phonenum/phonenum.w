<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:625px;left:590px;height:auto;" onLoad="modelLoad"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="修改手机号码"
        class="x-titlebar title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"><![CDATA[修改手机号码]]></div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content"> 
      <div class="top_image"> 
        <img src="$UI/zupu/img/head/u17.png" class="image_tou"/> 
      </div>  
      <div class="frame"> 
        <div class="frame_border clear" data-type="btn1"> 
          <div class="img_left"> 
            <img src="$UI/zupu/img/bindphone/u2269.png" class="img_img"/> 
          </div>  
          <div class="cont"> 
            <span class="left">+86&#160;</span> 
          </div>  
          <input class="input" placeholder="请输入您要更换的手机号码" id="phonenum"/> 
        </div>   
      </div>  
      <div class="frame"> 
        <div class="frame_border_ clear"> 
          <div class="img_left"> 
            <img src="$UI/zupu/img/bindphone/u2265.png" class="img_img"/>  
            <!-- <img src="$UI/zupu/img/bindphone/u2264.png" class="img_img"/>  --> 
          </div>  
          <div class="cont_phone"> 
            <span>验证码:</span> 
          </div>  
          <input class="input_" placeholder="请输入验证码" id="verification"/> 
        </div>  
        <div class="seize_seat" bind-click="yzm">获取验证码</div> 
      </div>  
      <div class="bangding" bind-click="subclick" > 
        <span>绑定手机号码</span> 
      </div>  
      <div class="clause">账号激活需要绑定手机号</div> 
    </div> 
  </div> 
</div>
