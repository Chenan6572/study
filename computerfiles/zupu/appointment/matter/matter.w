<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:757px;left:403px;height:auto;"
    onLoad="modelLoad" onActive="modelActive"/>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="我的预约"
        class="x-titlebar title"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"><![CDATA[我的预约]]></div>  
        <div class="x-titlebar-right reverse"/> 
      </div> 
    </div>  
    <div class="x-panel-content" xid="content1"> 
      <div class="appp"> 
        <div class="list_container stylecontro" v-for="(value,key) in datas"> 
          <div class="media_cont"> 
            <div> 
              <span class="sx">事项名称：</span>  
              <span id="matter_name" class="media_color" v-text="value.matter_name"/> 
            </div>  
            <div> 
              <span class="sx">事项编号：</span>  
              <span id="matter_number" class="media_color" v-text="value.matter_code"/> 
            </div>  
            <div> 
              <span class="sx">申请时间：</span>  
              <span id="application_time " class="media_color" v-text="value.uqtime"/> 
            </div> 
          </div>  
          <div class="media_img"> 
            <span style="display:none " v-text="value.state" class="imgtu"/>  
            <img id="album" class="image_ " src="$UI/zupu/img/yuyue/u201.png"/> 
          </div>  
          <div class="media_state" component="$UI/system/components/justep/button/button"
            xid="orderData"> 
            <div onclick="jumpvale1(this.children[0].text)"> 
              <span style="display:none" v-text="value.yVwuxBlclListDto"/>  
              <span id="material" class="media_right">已上传的材料</span> 
            </div>  
            <div onclick="jumpvale2(this.children[0].text)"> 
              <span style="display:none" v-text="value.id"/>  
              <span id="matter" class="media_right">查看事项</span> 
            </div>  
            <div> 
              <span id="examine_details" class="media_right popup" data-type="audit">审核详情</span> 
            </div> 
          </div> 
        </div> 
      </div> 
    </div> 
  </div> 
</div>
