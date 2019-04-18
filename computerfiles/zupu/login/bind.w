<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"></div>
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"  xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="身份绑定" style="background-color:rgba(231, 64, 58, 1)" class="x-titlebar">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon"
                        icon="icon-chevron-left" onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left" />
                        <span></span>
                    </a>
                </div>
                <div class="x-titlebar-title" >身份绑定</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content main_content" xid="content1">
            <div class="content">
                <img src="$UI/zupu/img/ren.png" alt="" />
                <div class="spans">
                    <span>姓&#160;&#160;&#160;&#160;名:</span>
                </div>
                <div class="inputs">
                    <input type="text" id="names" placeholder="请输入真实姓名"  />
                </div> 
            </div>
            <div class="content">
                <img src="../img/idcard.png" alt="" />
                <div class="spans">
                    <span>身份证:</span>
                </div>
                <div class="inputs">
                    <input type="text" id="idcard" placeholder="请输入身份证号"  />
                </div> 
            </div>
            <div class="btnbind"  bind-click="bindClick">绑 定</div>
             <div class="agree">登录即代表阅读并同意<a>服务条款</a></div>
        </div>
    </div>
</div>