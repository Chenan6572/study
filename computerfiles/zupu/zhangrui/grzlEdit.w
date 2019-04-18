<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" xid="panel1"> 
      <div class="x-panel-top" xid="top1" style="background-color:#FF0000;"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="标题"
          class="x-titlebar" style="background-color:#FF0000;">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="取消" class="btn btn-link btn-only-label" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn"> 
              <i class="icon-chevron-left"/>  
              <span>取消</span> 
            </a> 
          </div>  
          <div class="x-titlebar-title"><![CDATA[编辑资料]]></div>  
          <div class="x-titlebar-right reverse"> 
          <a component="$UI/system/components/justep/button/button" class="btn btn-link" label="保存" xid="button2">
   <i xid="i1"></i>
   <span xid="span1">保存</span></a></div>
        </div> 
      </div>  
    <div class="x-panel-content" xid="content1"><div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel2">
   <div class="x-panel-top" xid="top2" height="70"><div xid="div1"><div class="media" xid="media1">
   <div class="media-left" xid="mediaLeft1">
    
  <img src="$UI/zupu/zhangrui/images/7710d05fb8be1657f6cfaac15f536071.jpg" alt="" xid="image2" style="width:69px;height:56px;"></img></div> 
   <div class="media-body" xid="mediaBody1">
    <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row1">
   <div class="col col-xs-12" xid="col1"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input1" placeHolder="张睿" style="height:31px;"></input></div>
   </div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row2">
   <div class="col col-xs-4" xid="col4"><label xid="label2"><![CDATA[性别：男]]></label></div>
   <div class="col col-xs-4" xid="col5"></div>
   <div class="col col-xs-4" xid="col6"><span component="$UI/system/components/justep/button/toggle" class="x-toggle" xid="toggle1" ON="男" OFF="女"></span></div></div></div> </div></div></div>
   <div class="x-panel-content" xid="content2"><div component="$UI/system/components/bootstrap/row/row" class="row" xid="row3" style="background-color:#C0C0C0;">
   <div class="col col-xs-4" xid="col7"><label xid="label3"><![CDATA[出生]]></label></div>
   <div class="col col-xs-4" xid="col8"></div>
   <div class="col col-xs-4" xid="col9"></div></div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row4">
   <div class="col col-xs-4" xid="col10"><label xid="label4"><![CDATA[生日]]></label></div>
   <div class="col col-xs-4" xid="col11"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input3" style="height:23px;" dataType="Date"></input></div>
   <div class="col col-xs-4" xid="col12"></div></div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row5">
   <div class="col col-xs-4" xid="col13"><label xid="label5"><![CDATA[祖籍]]></label></div>
   <div class="col col-xs-4" xid="col14"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input4" style="height:23px;" placeHolder="吉林省吉林市"></input></div>
   <div class="col col-xs-4" xid="col15"></div></div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row6">
   <div class="col col-xs-4" xid="col16"><label xid="label6"><![CDATA[健在]]></label></div>
   <div class="col col-xs-4" xid="col17"><span component="$UI/system/components/justep/button/toggle" class="x-toggle" xid="toggle2" ON="是" OFF="否"></span></div>
   <div class="col col-xs-4" xid="col18"></div></div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row7" style="background-color:#C0C0C0;">
   <div class="col col-xs-4" xid="col19"><label xid="label7"><![CDATA[逝世]]></label></div>
   <div class="col col-xs-4" xid="col20"></div>
   <div class="col col-xs-4" xid="col21"></div></div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row8">
   <div class="col col-xs-4" xid="col22"><label xid="label8"><![CDATA[逝于]]></label></div>
   <div class="col col-xs-4" xid="col23"><input component="$UI/system/components/justep/input/input" class="form-control" xid="input5" style="height:23px;" dataType="Date"></input></div>
   <div class="col col-xs-4" xid="col24"></div></div></div>
   <div class="x-panel-bottom" xid="bottom1" height="80"><div component="$UI/system/components/bootstrap/row/row" class="row" xid="row9">
   <div class="col col-xs-4" xid="col25"></div>
   <div class="col col-xs-4" xid="col26"><a component="$UI/system/components/justep/button/button" class="btn btn-success" label="保存" xid="button3" style="width:178px;height:27px;">
   <i xid="i2"></i>
   <span xid="span2">保存</span></a></div>
   <div class="col col-xs-4" xid="col27"></div></div>
  <div component="$UI/system/components/bootstrap/row/row" class="row" xid="row10">
   <div class="col col-xs-4" xid="col28"></div>
   <div class="col col-xs-4" xid="col29"><a component="$UI/system/components/justep/button/button" class="btn x-gray" label="取消" xid="button4" style="width:180px;height:25px;">
   <i xid="i3"></i>
   <span xid="span3">取消</span></a></div>
   <div class="col col-xs-4" xid="col30"></div></div></div></div></div>
  </div> 
</div>