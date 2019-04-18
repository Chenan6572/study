<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;" xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="left:18px;top:83px;height:244px;" onLoad="onload" onParamsReceive="modelParamsReceive"></div>
    <div component="$UI/system/components/justep/panel/panel" 
    class="x-panel x-full" style="background-color:rgba(242, 242, 242, 1)" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="编辑教育经历"   style="background-color:rgba(231, 64, 58, 1)" 
          class="x-titlebar">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button"
              label="" class="btn btn-link btn-only-icon" icon="icon-chevron-left"
              onClick="{operation:'window.close'}" xid="backBtn">
                        <i class="icon-chevron-left"/>
                        <span></span>
                    </a>
                </div>
                <div class="x-titlebar-title">编辑教育经历</div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content content" xid="content1">
            <div class="all_list_all">
                <div class="all_list_left">学校</div>
                <div class="all_list_right">
                    <input type="text" required="true" placeholder="请输入学校（必填）" id="school_name"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">专业</div>
                <div class="all_list_right">
                    <input type="text" required="true"  placeholder="请输入专业（必填）" id="related_major"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">学历</div>
                <div class="all_list_right">
                    <input   type="text"  required="true" placeholder="请选择学历（必填）" id="educations"/>
                </div>
            </div>
            <div class="all_list_all">
                <div class="all_list_left">时间</div>
                <div class="all_list_right_time">
                    <input class="start_inputs" id="start_date" type="text" required="true"  readonly="readonly" placeholder="选择入校时间"/>
                    <span>至</span>
                    <input class="end_inputs" id="end_date" type="text" required="true"  readonly="readonly" placeholder="选择毕业时间"/>
                </div>
            </div>  
            <div class="savebtns" bind-click="savebtn">保 存</div>
            <div class="deletebtns" bind-click="deletebtn">删 除</div>
        </div>
    </div>
</div>