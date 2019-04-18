<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:v-bind="http://vue.sike.io/"
    xmlns:v-on="http://vue.sike.io/"
  component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"
    onActive="modelActive" onLoad="modelLoad"></div>
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="标题" class="x-titlebar">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button" label="" class="btn btn-link btn-only-icon"
            icon="icon-chevron-left" onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left" />
                        <span></span>
                    </a>
                </div>
                <div class="x-titlebar-title">标题</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content" xid="content1">
            <input component="$UI/system/components/justep/input/input" class="form-control" xid="input1"
        bind-click="input1Click" readonly="true"></input>
            <div class="list" id="education">
                <div class="app1">
                    <div class="item" v-for="data in edudata">
                        <div class="media_left">
                            <span class="basic">教育信息</span>
                            <div class="media_head">
                                <img src="$UI/zupuYG/img/edua.png" alt="" xid="tou" class="head" height="40px" style="width:40px;" />
                            </div>
                        </div>
                        <div xid="cont" title="neirong" class="media_cont">
                            <div>
                                <span id="name" v-html="data.message"></span>
                                <br />
                                <span v-html="data.education" />
                      {{"--" + data.message + "---"}}
                            
                            
                            </div>
                        </div>
                        <div class="media_edit div4Click">
                            <p hidden="hidden" class="hi" v-html="data.id" />
                            <img src="$UI/zupu/img/edit.png" alt="" xid="link" v-bind:src="data.message" />
                        </div>
                    </div>
                </div>
            </div>
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
            <div class="all_list_all">
                <div class="all_list_left">性别</div>
                <div class="all_list_right" id="showUserPicker">
                    <a href="#picture">
                        <input type="text" id="sex" placeholder="性别" />
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div component="$UI/system/components/justep/distpicker/distpicker2" class="x-popPicker" xid="distpicker21">
        <div class="x-popPicker-overlay" xid="div1"></div>
        <div class="x-popPicker-content" xid="div2">
            <div class="x-poppicker-header" xid="div3">
                <button class="btn btn-default x-btn-ok" xid="button1" bind-click="button1Click">确定</button>
            </div>
        </div>
    </div>
</div>