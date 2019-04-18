<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:243px;left:206px;"
    onunLoad="modelUnLoad"> 
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="data1" idColumn="id">
      <column label="标识" name="id" type="Integer" xid="xid1"/>  
      <column label="标题" name="title" type="String" xid="xid2"/>  
      <column label="内容" name="content" type="String" xid="xid3"/>  
      <column label="发布时间" name="publictime" type="Time" xid="xid4"/>  
      <master xid="default2"/>  
      <data xid="default1">[{"id":1,"title":"对因见义勇为致残人员进行...","content":"关于2019年度居民建立电子档案的通知","publictime":"2019-01-03"},{"id":2,"title":"民族成份变更确认","content":"关于2019年度居民建立电子档案的通知","publictime":"2019-02-01"},{"id":3,"title":"收养子女入户","content":"关于2019年度居民建立电子档案的通知","publictime":"2019-01-06"},{"id":4,"title":"孤残儿手术费申报","content":"关于2019年度居民建立电子档案的通知","publictime":"2019-02-03"}]</data>
    </div> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    xid="panel1"> 
    <div class="x-panel-top" xid="top1"> 
      <div component="$UI/system/components/justep/titleBar/titleBar" title="办事指南"
        class="x-titlebar" style="background-color:#FF0000;"> 
        <div class="x-titlebar-left"> 
          <a component="$UI/system/components/justep/button/button" label=""
            class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
            xid="backBtn"> 
            <i class="icon-chevron-left"/>  
            <span/> 
          </a> 
        </div>  
        <div class="x-titlebar-title"><![CDATA[办事指南]]></div>  
        <div class="x-titlebar-right reverse"></div> 
      </div> 
    </div>  
    <div class="x-panel-content" xid="content1">
      <div component="$UI/system/components/bootstrap/tabs/tabs" xid="tabs1"> 
        <ul class="center-block nav nav-tabs  btn-group-justified" xid="ul1"
          style="display:none"> 
          <li class="active" xid="li1"> 
            <a content="tabContent1" xid="tabItem1"><![CDATA[办事指南]]></a>
          </li>  
          <li role="presentation" xid="li2"> 
            <a content="tabContent2" xid="tabItem2"><![CDATA[政府消息]]></a>
          </li> 
        </ul>  
        <div class="tab-content" xid="div1"> 
          <div class="tab-pane active" xid="tabContent1"> 
            <ul component="$UI/system/components/justep/list/list" class="x-list x-list-template"
              xid="list2" data="data1" bind-click="showDetail" style="margin-top:20px"> 
              <li xid="li4"> 
                <div xid="div2" class="padding-tb5" style="height:44px;padding-left:20px;padding-right:20px;padding-top:20px;text-overflow:ellipsis;white-space:nowrap"> 
                  <span xid="span1" class="pull-right" bind-text="val(&quot;publictime&quot;)">2019-01-02</span>  
                  <i xid="i1" class="img:$UI2/zupu/img/redpoint.png|$UI2/zupu/img/redpoint.png"/>  
                  <img src="../img/redpoint.png" style="width:15px;height:15px;margin-top:-18px"
                    xid="image1"/>  
                  <label xid="span2" bind-text="val(&quot;title&quot;)" style="font-family:微软雅黑;font-size:large;width:230px;"
                    class="x-label">办事指南</label>
                </div> 
              </li> 
            </ul>
          </div>  
          <div class="tab-pane" xid="tabContent2"> 
            <ul component="$UI/system/components/justep/list/list" class="x-list x-list-template"
              xid="list4" data="data1" limit="3"> 
              <li xid="li6"> 
                <div xid="div3" class="padding-tb5" style="height:44px;padding-left:20px;padding-right:20px;padding-top:20px;text-overflow:ellipsis;white-space:nowrap"> 
                  <span xid="span4" class="pull-right" bind-text="val(&quot;publictime&quot;)">2019-01-02</span>  
                  <i xid="i2" class="icon-ios7-person text-muted margin-r10"/>  
                  <span xid="span5" style="padding-left:10px;width:100px;text-overflow:ellipsis;white-space:nowrap;font-family:微软雅黑;font-size:large;"
                    bind-text="ref(&quot;title&quot;)"><![CDATA[办事指南]]></span>
                </div> 
              </li> 
            </ul>
          </div> 
        </div> 
      </div> 
    </div> 
  </div> 
</div>
