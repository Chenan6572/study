<?xml version="1.0" encoding="utf-8"?>
<div xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
    xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;">
    </div>
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="登 录"
                style="background-color:rgba(231, 64, 58, 1)" class="x-titlebar">
                <div class="x-titlebar-left"></div>
                <div class="x-titlebar-title">登 录</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content" xid="content1">
            <div class="up_content">
                <div class="main_imgs">
                    <img src="$UI/zupu/img/family.png" alt="" />
                    <span>族HI</span>
                </div>
            </div>
            <div class="middle_content clear">
                <div class="middle_content_first">
                    <div class="middle_content_img">
                        <img src="$UI/zupu/img/UI/u10.png" alt="" />
                    </div>
                    <div class="middle_content_right">
                        <div class="tips">
                            <span>手机号:</span>
                        </div>
                        <div class="inputs">
                            <input type="text" id="nameInput" placeholder="请输入手机号" bind-value="&quot;18067792994&quot;" />
                        </div>
                    </div>
                </div>
                <div class="middle_content_second" style="display:block" id="disb">
                    <div class="middle_content_img">
                        <img src="$UI/zupu/img/UI/u13.png" alt="" />
                    </div>
                    <div class="middle_content_second_right">
                        <div class="tips">
                            <span id="span5">验证码:</span>
                        </div>
                        <div class="rights_inputs">
                            <input type="text" id="passwordInput" placeholder="请输入验证码" bind-value="&quot;&quot;" />
                            <!-- <span id="ceshi"></span> -->
                        </div>
                        <div class="yzm" bind-click="btnGetCodeClick" id="span6">获取验证码</div>
                    </div>
                </div>
                <div class="middle_content_second" style="display:none" id="disn">
                    <div class="middle_content_img">
                        <img src="$UI/zupu/img/UI/u13.png" alt="" />
                    </div>
                    <div class="middle_content_second_right">
                        <div class="tips">
                            <span id="span7">密&#160;&#160;&#160;&#160;码:</span>
                        </div>
                        <div class="rights_inputs">
                            <input type="password" id="pwd" placeholder="请输入密码" bind-value="&quot;&quot;" />
                            <!-- <span id="ceshi"></span> -->
                        </div>
                        <div class="yzm" bind-click="forgetbtn" id="span8">忘记密码</div>
                    </div>
                </div>
                <div class="message">未注册的手机验证后将自动登录</div>
            </div>
            <div class="down_content">
                <div class="btnlog" bind-click="loginBtnClick">登&#160;&#160;&#160;&#160;录</div>
                <div class="pwd_btnlog" bind-click="pwdLogin" id="account">账号密码登录</div>
                <div class="agree">登录即代表阅读并同意
                    <a>服务条款</a>
                </div>
            </div>
        </div>
    </div>
</div>