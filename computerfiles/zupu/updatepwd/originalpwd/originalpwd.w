<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window"
  class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"></div>
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"  xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="修改密码" style="background-color:rgba(231, 64, 58, 1)" class="x-titlebar">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
            onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left" />
                        <span></span>
                    </a>
                </div>
                <div class="x-titlebar-title">修改密码</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content" xid="content1" >
            <div class="up_content">
                <div class="inputs">
                    <input type="text" placeholder="请输入原密码" id="old_pwd"></input>
                </div>
                <div class="inputs">
                    <input type="password" placeholder="请输入新密码" id="new_pwd"></input>
                </div>
                <div class="inputs">
                    <input type="password" placeholder="请确认新密码" id="sure_new_pwd"></input>
                </div>
                <div class="tips">
                  <img src="../../img/u19.png" />
                  <span>密码长度规则说明</span>
                </div>
            </div>
             <div class="down_content" bind-click="savebtn">
                <span>确认修改密码</span>
            </div>
        </div>
    </div>
</div>