<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:704px;left:361px;"
    onLoad="onload" onParamsReceive="modelParamsReceive" onActive="modelActive" onInactive="modelInactive"/>  
  <div class="panel panel-default body" component="$UI/system/components/bootstrap/panel/panel"
    xid="panel1"> 
    <!--  顶部显示栏  -->  
    <div xid="div1" class="x-panel-top "> 
      <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar"
        xid="titleBar1" style="background-color:rgba(231, 64, 58, 1);"> 
        <div class="x-titlebar-left" xid="left1" reverse="true"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title" xid="title1"><![CDATA[个人信息编辑]]></div>  
        <div class="x-titlebar-right reverse" xid="right1"/> 
      </div> 
    </div>  
    <div> 
      <!-- 基础信息 -->  
      <div class="list"> 
        <div class="item"> 
          <div class="media_left"> 
            <span class="basic">基础信息</span>  
            <div class="media_head "> 
              <img id="head_image" alt="" xid="tou" class="head yuan"/> 
            </div> 
          </div>  
          <div xid="cont" title="neirong" class="media_cont"> 
            <div> 
              <span id="nameone"/>  
              <span> </span>  
              <span id="birthday"/>  
              <br/>  
              <span id=""/>现住址： 
              <span id="nowaddress"/>  
              <img src="$UI/zupu/img/address.png" alt="" xid="image3"/> 
            </div> 
          </div>  
          <div class="media_edit" bind-click="div1Click"> 
            <img src="$UI/zupu/img/edit.png" alt="" xid="link"/> 
          </div> 
        </div> 
      </div>  
      <!-- 联系方式-->  
      <div class="list"> 
        <div class="item"> 
          <div class="media_left"> 
            <span class="basic">联系方式</span>  
            <div class="media_head"> 
              <img src="$UI/zupu/img/lianxi.png" alt="" xid="tou" class="head"
                height="100%"/> 
            </div> 
          </div>  
          <div xid="cont" title="neirong" class="media_cont"> 
            <span id="phone"/> 
          </div>  
          <div class="media_edit" bind-click="div2Click"> 
            <img src="$UI/zupu/img/edit.png" alt="" xid="link"/> 
          </div> 
        </div> 
      </div>  
      <!-- 户籍信息 -->  
      <div class="list"> 
        <div class="item"> 
          <div class="media_left"> 
            <span class="basic">户籍信息</span>  
            <div class="media_head"> 
              <img alt="" xid="tou" class="head" src="$UI/zupu/img/idcard.png"/> 
            </div> 
          </div>  
          <div xid="cont" title="neirong" class="media_cont"> 
            <div> 
              <span id=""/>户 号：
              <span id="doornum"/>  
              <br/>  
              <span id=""/>户籍类型： 
              <span id="register_category"/>  
              <br/>  
              <span id=""/>户籍地址： 
              <span id="address"/> 
            </div> 
          </div>  
          <div class="media_edit" bind-click="div3Click"> 
            <img src="$UI/zupu/img/edit.png" alt="" xid="link"/> 
          </div> 
        </div> 
      </div>  
      <!-- 教育信息 -->  
      <div class="list" id="education"> 
        <div class="app1"> 
          <div class="item" v-for="data in edudata"> 
            <div class="media_left"> 
              <span class="basic">教育信息</span>  
              <div class="media_head"> 
                <img src="$UI/zupu/img/edua.png" alt="" xid="tou" class="head"/> 
              </div> 
            </div>  
            <div xid="cont" title="neirong" class="media_cont"> 
              <div> 
                <span id="name" v-html="data.school_name"/>  
                <br/>  
                <span id="birthday" v-html="data.school_start_data"/>  
                <span id=""/>-
                <span id="" v-html="data.school_end_data"/>  
                <br/>  
                <span id="nowaddress" v-html="data.related_major"/>  
                <span/>|
                <span v-html="data.education"/> 
              </div> 
            </div>  
            <div class="media_edit div4Click"> 
              <p hidden="hidden" class="hi" v-html="data.id"/>  
              <img src="$UI/zupu/img/edit.png" alt="" xid="link"/> 
            </div> 
          </div> 
        </div> 
      </div>  
      <div class="sum" bind-click="sumedu"> 
        <img src="$UI/zupu/img/sum.png" alt="" xid="sum2"/>  
        <span class="span_jiaoyu">  继续添加教育经历</span> 
      </div>  
      <!-- 工作经历 -->  
      <div class="list" id="workexpre"> 
        <div class="app2"> 
          <div class="item" v-for="data in workdata"> 
            <div class="media_left"> 
              <span class="basic">工作经历</span>  
              <div class="media_head"> 
                <img src="$UI/zupu/img/work.png" alt="" xid="tou" class="head"/> 
              </div> 
            </div>  
            <div xid="cont" title="neirong" class="media_cont"> 
              <div> 
                <span id="name" v-html="data.company_name"/>  
                <br/>  
                <span id="birthday" v-html="data.company_end_time"/>  
                <span id=""/>-
                <span id="" v-html="data.company_start_time"/>  
                <br/>  
                <span id="nowaddress" v-html="data.related_depart"/>  
                <span/>|
                <span id="" v-html="data.position"/> 
              </div> 
            </div>  
            <div class="media_edit div5Click"> 
              <p hidden="hidden" class="hi" v-html="data.id"/>  
              <img src="$UI/zupu/img/edit.png" alt="" xid="link"/> 
            </div> 
          </div> 
        </div> 
      </div>  
      <div class="sum" bind-click="sumwork"> 
        <img src="$UI/zupu/img/sum.png" alt="" xid="sum2"/>  
        <span class="span_jiaoyu">  继续添加工作经历</span> 
      </div> 
    </div> 
  </div> 
</div>
