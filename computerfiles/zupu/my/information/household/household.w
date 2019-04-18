<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;"  onLoad="onload"></div>
    <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" style="background-color:rgba(242, 242, 242, 1)" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="户籍信息"   style="background-color:rgba(231, 64, 58, 1)" 
          class="x-titlebar">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left"/>
                        <span></span>
                    </a>
                </div>
                <div class="x-titlebar-title">户籍信息</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content content" xid="content1">
            <div class="all_list_all">
                <div class="all_list_left">户号</div>
                <div class="all_list_right">
                    <input type="text" placeholder="户号" id="doornums"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">与户主关系</div>
                <div class="all_list_right">
                    <input type="text" placeholder="与户主关系" id="hpopulation"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">身份证号</div>
                <div class="all_list_right">
                    <input  type="text" placeholder="身份证" id="idcard"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">户籍类别</div>
                <div class="all_list_right">
                    <input type="text" placeholder="户籍类别" id="registercategory"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">村社区名称</div>
                <div class="all_list_right">
                    <input type="text" placeholder="村社区名称" id="addresss"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">居民组</div>
                <div class="all_list_right">
                    <input type="text" placeholder="居民组" id="residents_group"/>
                </div>
            </div>
            <div class="btns" bind-click="savebtn">保 存</div>
        </div>
    </div>
</div>