<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full"  style="background-color:rgba(242, 242, 242, 1)" xid="panel1"> 
      <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="身份证" style="background-color:rgba(231, 64, 58, 1)"
          class="x-titlebar">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn"> 
              <i class="icon-chevron-left"/>  
              <span></span> 
            </a> 
          </div>  
          <div class="x-titlebar-title">身份证</div>  
          <div class="x-titlebar-right reverse"> 
          </div>
        </div> 
      </div>  
    <div class="x-panel-content content" xid="content1">
      <div class="up_content">
          <div class="up_content_imgs">
            <img src="../../../img/u12.png" alt=""/>
            <span>身份证</span>
          </div>
          <div class="up_content_message">
            <span>身份证号</span><br />
            <span>44050***********10</span>
          </div>
      </div>
      <div class="zjzp">
        <span >证件照片</span>
      </div>
      <div class="down_content">
          <div class="down_content_imgs">
            <img src="../../../img/u29.png" alt=""/><br />
            <span>暂无证件正面照片</span>
          </div>
      </div>
      <div class="down_content">
          <div class="down_content_imgs">
            <img src="../../../img/u29.png" alt=""/><br />
            <span>暂无证件反面照片</span>
          </div>
      </div>
    </div>
  </div> 
</div>