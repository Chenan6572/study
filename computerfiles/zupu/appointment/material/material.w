<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:435px;left:138px;height:auto;"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="标题"
        class="x-titlebar title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title">标题</div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content back" xid="content1"> 
      <div class="up_content"> 
        <div class="txt_tips"> 
          <img src="../../img/u41.png"/>  
          <span>申请人信息</span> 
        </div>  
        <div class="inputs "> 
          <div class="name_inputs">姓名：</div>  
          <input type="text" placeholder="请输入您的姓名"/> 
        </div>  
        <div class="inputs"> 
          <div class="name_inputs">电话：</div>  
          <input type="text" placeholder="请输入您的电话"/> 
        </div> 
      </div>  
      <div class="middle"> 
        <div class="certificates"> 
          <img id="img_card_front" src="$UI/zupu/img/yuyue/55555.png" class="certificates_img"/> 
        </div>  
        <div class="certificates"> 
          <img id="img_card_back" src="$UI/zupu/img/yuyue/3333.png" class="certificates_img"/> 
        </div> 
      </div>  
      <div class="material"> 
        <div class="txt_tips"> 
          <span>材料</span> 
        </div>  
        <div class="material_word"><img class="material_word_img" src="$UI/zupu/img/yuyue/u247.png" alt="" xid="image1"></img></div> 
      </div> 
    </div> 
  </div> 
</div>
