<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window"
  class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;" onLoad="onload"></div>
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="修改密码" style="background-color:rgba(231, 64, 58, 1)"
        class="x-titlebar">
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
        <div class="x-panel-content content" xid="content1">
            <div class="up_tips">
                <span class="up">已发送验证码到你的手机号</span>
                <span class="down" id="tel"></span>
            </div>
            <div class="yz_inputs ">
                <div class="yz_inputs_left clear">
                    <input type="text" placeholder="请输入验证码" id="yzInput"/>
                </div>
                <div class="yz_inputs_right clear" bind-click="btnGetCodeClick">
                  获取验证码
                </div>
                <div class="pwd_inputs">
                  <input type="password" placeholder="请输入新密码" id="new_pwd"/>
                </div>    
            </div>
            <div class="tips">
                  <img src="../../img/u19.png" />
                  <span>密码长度规则说明</span>
            </div>
            <div class="down_content" bind-click="savebtn">
                <span>确认修改密码</span>
            </div>
        </div>
    </div>
</div>