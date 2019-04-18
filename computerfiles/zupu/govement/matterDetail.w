<?xml version="1.0" encoding="utf-8"?>
<div
    xmlns="http://www.w3.org/1999/xhtml" component="$UI/system/components/justep/window/window" design="device:m;"
    xid="window" class="window">
    <div component="$UI/system/components/justep/model/model" xid="model" style="height:auto;top:277px;left:1089px;"
        onLoad="onload"></div>
    <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
        <div class="x-panel-top" xid="top1">
            <div component="$UI/system/components/justep/titleBar/titleBar" title="卫健委事项详情" class="x-titlebar"
                style="background-color:#FF0000;">
                <div class="x-titlebar-left">
                    <a component="$UI/system/components/justep/button/button" label=""
                        class="btn btn-link btn-only-icon" icon="icon-chevron-left" onClick="{operation:'window.close'}"
                        xid="backBtn">
                        <i class="icon-chevron-left" />
                        <span />
                    </a>
                </div>
                <div class="x-titlebar-title">
                    <![CDATA[卫健委事项消息]]>
                </div>
                <div class="x-titlebar-right reverse"></div>
            </div>
        </div>
        <div class="x-panel-content cl_list_table" xid="content1">
            <div component="$UI/system/components/justep/list/list" class="x-list" xid="matterDetail" limit="10"
                autoLoad="false" data="dataMatter">
                <ul xid="listTemplateUl3">
                    <li xid="li3" class="takeout-list-row" >
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row7">
                            <div xid="col13">
                                <div class="basic"></div>
                                <span xid="span17" style="font-weight:bold;width:10rem;font-size:2rem;"
                                    class="x-output">基本信息</span>
                            </div>
                            <div class="x-col" xid="col32" /></div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row8">
                            <div xid="col20">
                                <span xid="span16" style="margin-left:15px;" class="x-output">事项名称：</span>
                            </div>
                            <div xid="col21">
                                <span class="x-output" id="sxname"></span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row9">
                            <div xid="col23">
                                <span xid="span116" style="margin-left:15px" class="x-output">事项类型：</span>
                            </div>
                            <div xid="col24">
                                <span class="x-output" id="sxtype">
                                </span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row10">
                            <div xid="col26" style="margin-left:15px;color:#FF8040;">
                                <span xid="span117" class="x-output">办理对象：</span>
                            </div>
                            <div xid="col27">
                                <span class="x-output" id="sxobject">
                                </span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row11">
                            <div xid="col28" style="margin-left:15px;color:#FF8040;">
                                <span xid="span119" class="x-output">申请期限：</span>
                            </div>
                            <div xid="col29">
                                <span xid="span120" class="x-output" id="sqterm">
                                </span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row12">
                            <div xid="col36" style="margin-left:15px;color:#FF8040;">
                                <span xid="span19" class="x-output">法定办理时限：</span>
                            </div>
                            <div xid="col37">
                                <span class="x-output" id="fdterm">
                                </span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row13">
                            <div xid="col36" style="margin-left:15px;color:#FF8040;">
                                <span xid="span19" class="x-output">承诺办理时限：</span>
                            </div>
                            <div xid="col37">
                                <span class="x-output" id="cnterm">
                                </span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row14">
                            <div xid="col36" style="margin-left:15px;color:#FF8040;">
                                <span xid="span19" class="x-output" >办理形式：</span>
                            </div>
                            <div xid="col37">
                                <span class="x-output" id="bltype"></span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row15">
                            <div xid="col36" style="margin-left:15px;color:#FF8040;">
                                <span xid="span19" class="x-output">办理机构：</span>
                            </div>
                            <div xid="col37" >
                                <span class="x-output" id="blmechanism"></span>
                            </div>
                        </div>
                        <div component="$UI/system/components/justep/row/row" class="x-row" xid="row16">
                            <div xid="col36" style="margin-left:15px;color:#FF8040;">
                                <span xid="span19" class="x-output">办理地点：</span>
                            </div>
                            <div xid="col37" >
                                <span class="x-output" id="bladdress"></span>
                            </div>
                        </div>
                    </li>
                    <div class="layui-tab layui-tab-brief" lay-filter="tabtest">
                        <div class="frames"></div>
                        <ul class="layui-tab-title" style="">
                            <li class="layui-this">受理条件</li>
                            <li>办理材料</li>
                            <li>办理流程</li>
                        </ul>
                        <div class="frames"></div>
                        <div class="layui-tab-content"  style="padding:0">
                            <div class="layui-tab-item layui-show">
                                <div component="$UI/system/components/justep/row/row" class="x-row" xid="row18">
                                    <div class="x-col" xid="col41" style="padding-top:15px">
                                        <span xid="span21" style="margin-top:15px;" id="slcondition"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-tab-item ">
                                <div  v-for="sz in yVwuxBlclListDto" class="list_tables">
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
                                        <div class="x-col" xid="col4">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output"  >
                                                <![CDATA[材料名称:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="clname" style="display:inline;">{{sz.name}}</span>
                                        </div>
                                    </div>
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3">
                                        <div class="x-col" xid="col7">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[材料来源:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="clllyr" style="display:inline;">{{sz.llyr}}</span>
                                        </div>
                                    </div>
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row22">
                                        <div xid="col21" class="x-col">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[复印件:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="copy_num" style="display:inline;">{{sz.copy_num}}</span>
                                        </div>
                                        <div class="x-col" xid="col21">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[原件:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="num" style="display:inline;">{{sz.num}}</span>
                                        </div>
                                    </div>
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row23">
                                        <div class="x-col" xid="col21">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[是否为必备材料:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="isbibz" style="display:inline;">{{sz.isbibz}}</span>
                                        </div>
                                        <div class="x-col" xid="col21">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[是否需要电子版:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="isdmzi" style="display:inline;">{{sz.isdmzi}}</span>
                                        </div>
                                    </div>
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row24">
                                        <div class="x-col" xid="col21">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[申请表样：]]>
                                                <!-- <a bind-click="downLoadFiles" style="color:#3889FF" id="ex_file">下载</a> -->
                                                <span  onClick="downLoadFiles()" style="color:#3889FF">下载</span>
                                                <!-- <a bind-click="openFile" style="margin-left:10px" xid="a1">打开</a> -->
                                            </span>
                                        </div>
                                        <div class="x-col" xid="col21">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[材料表样：]]>
                                                <a bind-click="downLoadFile" style="color:#3889FF" id="cl_file">下载</a>
                                                <!-- <a bind-click="openFile" style="margin-left:10px">打开</a> -->
                                            </span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-tab-item">
                                <div  v-for="process in yVwuxLqifListDto" class="list_tables">
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row26">
                                        <div class="x-col" xid="col76">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[环节:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="hrjx" style="display:inline;">{{process.hrjx}}</span>
                                        </div>
                                        <div class="imgs">
                                            <a bind-click="downLoadFile">
                                                <img src="../../zupu/img/u71.png" />
                                            </a>
                                        </div>
                                    </div>
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3">
                                        <div class="x-col" xid="col7">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[承诺时间:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="in_date" style="display:inline;">{{process.in_date}}</span>
                                        </div>
                                    </div>
                                    <div component="$UI/system/components/justep/row/row" class="x-row" xid="row3">
                                        <div class="x-col" xid="col7">
                                            <span xid="span16" style="margin-left:15px;display:inline;" class="x-output">
                                                <![CDATA[说明:]]>
                                            </span>
                                            <span xid="span16" class="x-output" id="demo" style="display:inline;"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <li xid="li1" class="takeout-list-row">
                        <div style="height:50px" xid="div1" />
                    </li>
                </ul>
            </div>
        </div>
        <!-- <a component="$UI/system/components/justep/button/button" class="btn x-red pull-right" label="我要办理" xid="btnNewMatter"
            onClick="btnNewMatterClick" style="position:absolute;bottom:10px;right:10px;width:100px;height:100px;border-radius:50px;font-size:25px;"><i xid="i1" /><span xid="span1">我要</span><span xid="span2">办理</span></a> -->
        <a component="$UI/system/components/justep/button/button" class="btn x-red pull-right spans" onClick="btnNewMatterClick" >
            <p>
                <span xid="span1">我要</span>
            </p>
            <p>
                <span xid="span2">办理</span>
            </p>
        </a>
    </div>
</div>