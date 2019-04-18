<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:v-bind="http://vue.sike.io/"
    xmlns:v-on="http://vue.sike.io/" component="$UI/system/components/justep/window/window" design="device:m;"
  xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"
    onLoad="onload" />
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full"
    style="background:rgba(242, 242, 242, 1)" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="基础信息" class="x-titlebar"
        style="background-color: rgba(231, 64, 58, 1);">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon"
            icon="icon-chevron-left" onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left" />
                        <span />
                    </a>
                </div>
                <div class="x-titlebar-title">基础信息</div>
                <div class="x-titlebar-right reverse" /></div>
        </div>
        <div class="x-panel-content" xid="content1">
            <div class="content">
                <div class="pic">
                    <div class="font_pic">头像</div>
                    <div class="pic_pic">
                        <div component="$UI/system/components/justep/button/button" class="imgss" id="imageOutput" xid="div1_1"
              onClick="getPicturesClick">
                            <img src="" xid="image1" id="imagetou" alt="图片" />
                        </div>
                    </div>
                </div>
                <div class="all_list_all">
                    <div class="all_list_left">姓名</div>
                    <div class="all_list_right">
                        <input type="text" id="names" placeholder="" />
                    </div>
                </div>
                <!-- <div class="all_list_all">
                    <div class="all_list_left">性别</div>
                    <div class="all_list_right" id="showUserPicker">
                        <a href="#picture">
                        <input type="text" id="sex" placeholder="性别" /></a>
                        <div id="picture" class="mui-popover mui-popover-action " style="left:0;">
                            <ul class="mui-table-view">
                                <li class="mui-table-view-cell">
                                    <a href="">男</a>
                                </li>
                                <li class="mui-table-view-cell">
                                    <a>女</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div> -->
                
                <div class="all_list_all">
                    <div class="all_list_left">性别</div>
                    <div class="all_list_right" id="showUserPicker">
                        <input type="text" id="sex" placeholder="性别" />
                    </div>
                </div>
                
                
                <div class="all_list_all">
                    <div class="all_list_left">出生日期</div>
                    <div class="all_list_right">
                        <input id="birthdate"  type="text" placeholder="出生日期" readonly="true"/>
                    </div>
                </div>
                <div class="all_list_all">
                    <div class="all_list_left">祖籍</div>
                    <div class="all_list_right">
                        <input type="text" placeholder="祖籍" id="register_address" />
                    </div>
                </div>
                <div class="all_list_all">
                    <div class="all_list_left">现居住地</div>
                    <div class="all_list_right">
                        <input type="text" placeholder="请输入居住地" id="nowsaddress" />
                    </div>
                </div>
                <div class="all_list_all">
                    <div class="all_list_left">简介</div>
                    <div class="all_list_right">
                        <input type="text" placeholder="" id="introductions"  />
                    </div>
                </div>
                <div class="btns" bind-click="savebtn">保 存</div>
            </div>
        </div>
    </div>
</div>