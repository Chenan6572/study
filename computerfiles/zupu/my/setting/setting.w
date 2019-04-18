<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"></div>
    <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" style="background-color:rgba(242, 242, 242, 1)" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="设置"   style="background-color:rgba(231, 64, 58, 1)" 
          class="x-titlebar">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left"/>
                        <span></span>
                    </a>
                </div>
                <div class="x-titlebar-title">设置</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content" xid="content1">
            <div class="first_content">
                <div class="up_message" bind-click="perinfo">个人信息
                    <img src="../../img/u13.png" alt=""/>
                </div>
                <div class="up_message" bind-click="phone">联系方式
                    <img src="../../img/u13.png" alt=""/>
                </div>
                <div class="up_message"  bind-click="selecttype">修改密码
                    <img src="../../img/u13.png" alt=""/>
                </div>
            </div>
            <div class="second_content">
              <div class="up_message">消息与推送通知
                    <img src="../../img/u13.png" alt=""/>
                </div>
                <div class="up_message">清理缓存
                    <img src="../../img/u13.png" alt=""/>
                </div>
            </div>
            <div class="third_content">
               <div class="up_message">关于我们
                    <img src="../../img/u13.png" alt=""/>
                </div>
            </div>
            <div class="forth_content">
              <div class="up_message" bind-click="setting">
                <span> 退出登录</span>
                </div>
            </div>
        </div>
    </div>
</div>