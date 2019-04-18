<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:483px;left:115px;height:auto;"> 
  <div component="$UI/system/components/justep/shell/shell" xid="shell"></div></div>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
  <div class="x-panel-top" xid="top1"> 
        <div component="$UI/system/components/justep/titleBar/titleBar" title="政府事项消息"
          class="x-titlebar" style="background-color:#FF0000;">
          <div class="x-titlebar-left"> 
            <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn"> 
              <i class="icon-chevron-left"/>  
              <span></span> 
            </a> 
          </div>  
          <div class="x-titlebar-title"><![CDATA[政府事项消息]]></div>  
          <div class="x-titlebar-right reverse"> 
          </div>
        </div> 
      </div>  
   <div class="x-panel-content" xid="content5">
   
   	  
          	
          		 <ul xid="ul1" class="list-group" bind-click="{&quot;operation&quot;:&quot;shell.showPage&quot;,&quot;args&quot;:{&quot;url&quot;:&quot;js:$model.toUrl('./matterList.w')&quot;}}">
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button12" icon="icon-ios7-arrow-right"> 
				              <i xid="i18" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span17"/>
				            </a>  
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon"
				              icon="icon-bag" xid="button13"> 
				              <i xid="i26" class="icon-bag text-warning"/>  
				              <span xid="span18"/> 
				            </a>  
				            
				            <span xid="span16"><![CDATA[卫健委]]></span>
				          </li>  
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button14" icon="icon-ios7-arrow-right"> 
				              <i xid="i27" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span20"/>
				            </a>  
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon"
				              icon="icon-bag" xid="button13"> 
				              <i xid="i26" class="icon-bag text-warning"/>  
				              <span xid="span18"/> 
				            </a>  
				            <span xid="span19"><![CDATA[公安]]></span>
				          </li>  
				          <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button16" icon="icon-ios7-arrow-right"> 
				              <i xid="i29" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span23"/>
				            </a>  
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon"
				              icon="icon-bag" xid="button13"> 
				              <i xid="i26" class="icon-bag text-warning"/>  
				              <span xid="span18"/> 
				            </a>  
				            <span xid="span22"><![CDATA[残联]]></span>
				          </li>
				           <li class="list-group-item" xid="li1"> 
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon pull-right"
				              label="button" xid="button16" icon="icon-ios7-arrow-right"> 
				              <i xid="i29" class="icon-ios7-arrow-right text-muted"/>  
				              <span xid="span23"/>
				            </a>  
				            <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-only-icon"
				              icon="icon-bag" xid="button13"> 
				              <i xid="i26" class="icon-bag text-warning"/>  
				              <span xid="span18"/> 
				            </a>  
				            <span xid="span22"><![CDATA[其它]]></span>
				          </li>
				    </ul> 
          
        
          
   
   </div>
   </div></div>