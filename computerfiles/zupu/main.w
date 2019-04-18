<?xml version="1.0" encoding="utf-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" xid="window" class="window" component="$UI/system/components/justep/window/window"
  design="device:m;">  
  <div component="$UI/system/components/justep/model/model" xid="model" style="top:81px;left:341px;width:165px;height:280px;"
    onLoad="modelLoad" onActive="modelActive"> 
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="newsData" idColumn="fID" onCustomRefresh="productDataCustomRefresh"> 
      <column label="id" name="fID" type="String" xid="xid1"/>  
      <column label="标题" name="fTitle" type="String" xid="xid2"/>  
      <column label="图片" name="fImg" type="String" xid="xid3"/>  
      <column label="摘要" name="fOmit" type="String" xid="xid4"/>  
      <column label="跟帖" name="fPostNumber" type="Integer" xid="xid5"/>  
      <rule xid="rule1"> 
        <col name="fPostNumber" xid="ruleCol1"> 
          <calculate xid="calculate1"> 
            <expr xid="default1" style="display:none">$row.val("fPostNumber")&gt;=10000?$row.val("fPostNumber")+"跟贴":"1小时前";</expr> 
          </calculate> 
        </col> 
      </rule> 
    </div>  
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="navData" onCustomRefresh="navDataCustomRefresh"/>  
    <div component="$UI/system/components/justep/data/baasData" autoLoad="true"
      xid="baasTrends" queryAction="queryTrends" saveAction="saveTrends" url="/zupu/Trends"
      tableName="trends" idColumn="Id" orderBy="createdate:desc"> 
      <column label="Id" name="Id" type="Integer" xid="default2"/>  
      <column label="标题" name="title" type="String" xid="default3"/>  
      <column label="内容" name="content" type="String" xid="default4"/>  
      <column label="创建人" name="owner" type="String" xid="default5"/>  
      <column label="创建人姓名" name="ownerName" type="String" xid="default6"/>  
      <column label="创建人头像" name="titleimg" type="String" xid="default7"/>  
      <column label="创建时间" name="createdate" type="DateTime" xid="default8"/>  
      <column label="更新时间" name="updatetime" type="DateTime" xid="default9"/>  
      <column label="栏目" name="classname" type="String" xid="xid6"/>  
      <column label="置顶" name="top" type="String" xid="xid7"/>  
      <column label="附件" name="attach" type="String" xid="xid8"/>  
      <column isCalculate="true" label="格式后时间" name="updatetime2" type="DateTime"
        xid="xid9"/> 
    </div>  
    <div component="$UI/system/components/justep/data/baasData" autoLoad="true"
      xid="baasWorkhistory" queryAction="queryWorkhistory" saveAction="saveWorkhistory"
      url="/zupu/Workhistory" tableName="workhistory" idColumn="Id"> 
      <column label="Id" name="Id" type="Integer" xid="default10"/>  
      <column label="用户ID" name="userid" type="Integer" xid="default11"/>  
      <column label="公司" name="company" type="String" xid="default12"/>  
      <column label="部门" name="depart" type="String" xid="default13"/>  
      <column label="职位" name="job" type="String" xid="default14"/>  
      <column label="开始时间" name="starttime" type="Date" xid="default15"/>  
      <column label="结束时间" name="finishtime" type="Date" xid="default16"/>  
      <column label="工作时长" name="howlong" type="String" xid="default17"/> 
    </div>  
    <div component="$UI/system/components/justep/data/baasData" autoLoad="true"
      xid="baasData1" queryAction="queryEducationhistory" saveAction="saveEducationhistory"
      url="/zupu/Educationhistory" tableName="educationhistory" idColumn="Id"> 
      <column label="Id" name="Id" type="Integer" xid="default18"/>  
      <column label="用户ID" name="userid" type="Integer" xid="default19"/>  
      <column label="大学" name="school" type="String" xid="default20"/>  
      <column label="专业" name="subject" type="String" xid="default21"/>  
      <column label="学历" name="record" type="String" xid="default22"/>  
      <column label="开始时间" name="starttime" type="Date" xid="default23"/>  
      <column label="结束时间" name="finishtime" type="Date" xid="default24"/>  
      <column label="工作时长" name="howlong" type="String" xid="default25"/> 
    </div>  
    <div component="$UI/system/components/justep/data/baasData" autoLoad="true"
      xid="baasData2" queryAction="queryMarryhistory" saveAction="saveMarryhistory"
      url="/zupu/Marryhistory" tableName="marryhistory" idColumn="Id"> 
      <column label="用户ID" name="Id" type="Integer" xid="default30"/>  
      <column label="婚姻状态" name="married" type="String" xid="default31"/>  
      <column label="首婚时间" name="marriedFirst" type="Date" xid="default32"/>  
      <column label="夫妻关系" name="marriedReleation" type="String" xid="default33"/> 
    </div>  
    <div component="$UI/system/components/justep/data/baasData" autoLoad="true"
      xid="baasData3" queryAction="queryCensus" saveAction="saveCensus" url="/zupu/Census"
      tableName="census" idColumn="Id"> 
      <column label="Id" name="Id" type="Integer" xid="default44"/>  
      <column label="户号" name="code" type="String" xid="default45"/>  
      <column label="与户主关系" name="relation" type="String" xid="default46"/>  
      <column label="姓名" name="name" type="String" xid="default47"/>  
      <column label="身份证" name="idcard" type="String" xid="default48"/>  
      <column label="性别" name="sex" type="String" xid="default49"/>  
      <column label="出生日期" name="birthday" type="Date" xid="default50"/>  
      <column label="民族" name="nation" type="String" xid="default51"/>  
      <column label="村委会" name="village" type="String" xid="default52"/>  
      <column label="居民组" name="group" type="String" xid="default53"/> 
    </div>  
    <div component="$UI/system/components/justep/data/baasData" autoLoad="true"
      xid="baasFamilyMember" queryAction="queryFamilymember" saveAction="saveFamilymember"
      url="/zupu/FamilyMember" tableName="familymember" idColumn="ID" directDelete="true"
      confirmDelete="false" limit="100"> 
      <column label="标识" name="ID" type="Integer" xid="default55"/>  
      <column label="所属族谱" name="familyCode" type="String" xid="default56"/>  
      <column label="成员用户ID" name="memberID" type="Integer" xid="default57"/>  
      <column label="显示名称" name="memberName" type="String" xid="default58"/>  
      <column label="成员电话" name="memberPhone" type="String" xid="default59"/>  
      <column label="身份证" name="memberIDcard" type="String" xid="default60"/>  
      <column label="出生日期" name="memberBirthday" type="Date" xid="default61"/>  
      <column label="上级成员" name="parentMember" type="Integer" xid="default62"/>  
      <column label="parentRelation" name="parentRelation" type="String" xid="default63"/>  
      <column label="第几代" name="memberGeneration" type="Integer" xid="default64"/>  
      <column label="性别" name="memberSex" type="String" xid="default65"/>  
      <column label="健在" name="memberLiving" type="Integer" xid="default66"/>  
      <column label="成员状态" name="memberState" type="Integer" xid="default67"/>  
      <column label="亲人照片" name="memberPhoto" type="String" xid="default68"/> 
    </div>  
    <div component="$UI/system/components/justep/data/data" autoLoad="true"
      xid="data1" idColumn="value"> 
      <column label="值" name="value" type="Integer" xid="column1"/>  
      <column label="关系名称" name="name" type="String" xid="column2"/>  
      <column label="保存名称" name="dname" type="String" xid="xid10"/>  
      <data xid="default26">[{"value":1,"name":"父亲","dname":"父母"},{"value":2,"name":"母亲","dname":"父母"},{"value":3,"name":"丈夫","dname":"配偶"},{"value":4,"name":"妻子","dname":"配偶"},{"value":5,"name":"兄妹","dname":"兄妹"},{"value":6,"name":"儿子","dname":"儿女"},{"value":7,"name":"女儿","dname":"儿女"}]</data> 
    </div> 
  </div>  
  <div component="$UI/system/components/justep/popOver/popOver" class="x-popOver"
    direction="auto" xid="popOver1"> 
    <div class="x-popOver-overlay" xid="div6"/>  
    <div class="x-popOver-content" xid="div5"> 
      <div id="idOperation"> 
        <div component="$UI/system/components/justep/row/row" class="x-row"
          xid="row9"> 
          <div class="x-col" xid="col13"> 
            <img src="./img/invite.png" alt="" xid="imageInvite" style="width:60px;height:60px"
              bind-click="btnInvitClick"/> 
          </div>  
          <div class="x-col" xid="col16"> 
            <img src="./img/detail.png" alt="" xid="imageDetail" style="width:60px;height:60px"
              bind-click="btnShowMemberDetail"/> 
          </div>  
          <div class="x-col" xid="col9"> 
            <img src="./img/addmember.png" alt="" xid="imageAdd" style="width:60px;height:60px"
              bind-click="btnAddMember"/> 
          </div>  
          <div class="x-col" xid="col17"> 
            <img src="./img/viewrel.png" alt="" xid="imageViewRel" style="width:60px;height:60px"
              bind-click="btnViewRela"/> 
          </div> 
        </div>  
        <div component="$UI/system/components/justep/row/row" class="x-row"
          xid="row9"> 
          <div class="x-col" xid="col13" style="text-align:center;color:#EEFFE8;">邀请亲友</div>  
          <div class="x-col" xid="col16" style="text-align:center;color:#EEFFE8;">查看资料</div>  
          <div class="x-col" xid="col9" style="text-align:center;color:#EEFFE8;">添加亲人</div>  
          <div class="x-col" xid="col18" style="text-align:center;color:#EEFFE8;">查看关系</div> 
        </div> 
      </div> 
    </div> 
  </div>  
  <div component="$UI/system/components/justep/popOver/popOver" class="x-popOver x-wangyiOver"
    xid="popOverAdd" style="height:100%;" anchor="navMenuTop" direction="right-bottom"
    opacity="0.5"> 
    <div class="x-popOver-overlay" xid="div2"/>  
    <div xid="div4" class="x-full x-popOver-content"> 
      <h5 class="text-muted"/>  
      <div component="$UI/system/components/justep/row/row" class="x-row" xid="row12"
        style="height:100px;"> 
        <div class="x-col" xid="col12"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top pull-right"
            label="父亲" xid="menuAddFather" icon="linear linear-user" onClick="btnAddFatherClick"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">父亲</span> 
          </a> 
        </div>  
        <div class="x-col" xid="col19"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top"
            label="母亲" xid="menuAddMother" icon="linear linear-user" onClick="btnAddFatherClick"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">母亲</span> 
          </a> 
        </div> 
      </div>  
      <div component="$UI/system/components/justep/row/row" class="x-row" xid="row10"
        style="height:100px;"> 
        <div class="x-col" xid="col21"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top pull-right"
            label="兄妹" xid="menuAddBrotherAndSiste" icon="linear linear-user" onClick="btnAddFatherClick"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">兄妹</span> 
          </a> 
        </div>  
        <div class="x-col" xid="col22" style="text-align:center"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top"
            label="我" xid="menuSelect" icon="linear linear-user"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">我</span> 
          </a> 
        </div>  
        <div class="x-col" xid="col23"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top"
            label="妻子" xid="menuAddMate" icon="linear linear-user" onClick="btnAddFatherClick"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">妻子</span> 
          </a> 
        </div> 
      </div>  
      <div component="$UI/system/components/justep/row/row" class="x-row" xid="row11"
        style="height:100px;"> 
        <div class="x-col" xid="col24"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top pull-right"
            label="儿子" xid="button8" icon="linear linear-user" onClick="btnAddFatherClick"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">儿子</span> 
          </a> 
        </div>  
        <div class="x-col" xid="col25"> 
          <a component="$UI/system/components/justep/button/button" class="btn x-orange btn-icon-top"
            label="女儿" xid="button8" icon="linear linear-user" onClick="btnAddFatherClick"> 
            <i xid="i8" class="linear linear-user"/>  
            <span xid="span222">女儿</span> 
          </a> 
        </div> 
      </div> 
    </div> 
  </div>  
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full x-card top-trans"
    xid="panel1"> 
    <div class="x-panel-content x-cards" xid="content"> 
      <div component="$UI/system/components/justep/contents/contents" class="x-contents x-full"
        active="1" xid="contents1" wrap="false" swipe="false" routable="true"> 
        <div class="x-contents-content bdyground" xid="newsContent"> 
          <div class="ui_home"> 
            <div class="top_background"> 
              <div class="search"> 
                <div class="search_container"> 
                  <img src="$UI/zupu/img/33333.png" style="width:90%;height:100%;float:right;"/> 
                </div>  
                <span class="size_jilin">吉林市</span> 
              </div>  
              <div class="click_work"> 
                <div class="click_box_" bind-click="zfsx"> 
                  <div class="image_container_"> 
                    <img src="$UI/zupu/img/sx.png" alt="" xid="image1" class=" image_container_element"/> 
                  </div>  
                  <div class="span_container"> 
                    <span class="size_small font_weight">政府事项</span> 
                  </div> 
                </div>  
                <div class="click_box_" bind-click="appointment"> 
                  <div class="image_container_"> 
                    <img src="$UI/zupu/img/yuyue.png" alt="" xid="image1" class=" image_container_element"/> 
                  </div>  
                  <div class="span_container"> 
                    <span class="size_small font_weight">我的预约</span> 
                  </div> 
                </div>  
                <div class="click_box_" bind-click=""> 
                  <div class="image_container_"> 
                    <img src="$UI/zupu/img/home_group.png" alt="" xid="image1"
                      class=" image_container_element"/> 
                  </div>  
                  <div class="span_container"> 
                    <span class="size_small font_weight">咨询专题</span> 
                  </div> 
                </div>  
                <div class="click_box_" bind-click=""> 
                  <div class="image_container_"> 
                    <img src="$UI/zupu/img/family.png" alt="" xid="image1"
                      class=" image_container_element"/> 
                  </div>  
                  <div class="span_container"> 
                    <span class="size_small font_weight">更多</span> 
                  </div> 
                </div> 
              </div> 
            </div> 
          </div>  
          <div class="serve"> 
            <div class="up_center"> 
              <div class="trapezoid_left"/>  
              <div class="trapezoid_right"/>  
              <div class="trapezoid_middle"> 
                <span class="size-color size_small">服务推广</span> 
              </div> 
            </div>  
            <div class="click_"> 
              <div class="click_box"> 
                <div class="image_container"> 
                  <img src="$UI/zupu/img/u152.png" alt="" xid="image1" class=" image_container_element"/> 
                </div>  
                <span class="size_normal">户籍</span> 
              </div>  
              <div class="click_box"> 
                <div class="image_container"> 
                  <img src="$UI/zupu/img/u152.png" alt="" xid="image1" class=" image_container_element"/> 
                </div>  
                <span class="size_normal ">公积金</span> 
              </div>  
              <div class="click_box"> 
                <div class="image_container"> 
                  <img src="$UI/zupu/img/u152.png" alt="" xid="image1" class=" image_container_element"/> 
                </div>  
                <span class="size_normal ">医保</span> 
              </div>  
              <div class="click_box"> 
                <div class="image_container"> 
                  <img src="$UI/zupu/img/u152.png" alt="" xid="image1" class=" image_container_element"/> 
                </div>  
                <span class="size_normal">养老</span> 
              </div> 
            </div>  
            <a class="down"> 
              <img src="$UI/zupu/img/down.png"/> 
            </a> 
          </div>  
          <div class="news"> 
            <div class="news_titles"> 
              <span class="title_left">最新资讯</span>  
              <span href="" class="news_link">更多&gt;&gt;</span> 
            </div>  
            <div class="app"> 
              <div v-for="item in items"> 
                <div class="news_list"> 
                  <div class="news_left"> 
                    <span style="display:none" v-text="item.image" class="news_illustration"/>  
                    <img class="news_img" alt="新闻插图" src="$UI/zupu/img/news/1.png"/> 
                  </div>  
                  <div class="news_cont"> 
                    <div class="news_text" v-text="item.news">新闻内容</div>  
                    <div class="news_data" v-text="item.news_data">新闻日期</div> 
                  </div> 
                </div> 
              </div> 
            </div> 
          </div> 
        </div>  
        <div class="x-contents-content" xid="readContent" onActive="readContentActive"
          style="background-color:white; "> 
          <style type="text/css">body{margin:20px auto; padding:0; width:1000px } canvas{border:dashed 0px #ccc} span{font-size:16px; cursor:pointer}</style>  
          <script type="text/javascript">function $$(id){ return document.getElementById(id); } $("#test").html("初始化"); function drawRect(co){ var can = $$('can'); cans = can.getContext('2d'); cans.strokeStyle = co; cans.lineWidth = 3; cans.strokeRect(100,50,80,40); } function drawCircle(co){ cans.beginPath(); cans.arc(30,30,30,0,Math.PI*2,1); cans.closePath(); cans.strokeStyle = co; cans.lineWidth = 3; cans.stroke(); } function mv_click(){ var can = $$('can'); var cans = can.getContext('2d'); cans.clearRect(-200, -200, 800, 800); cans.translate(10,10); //drawRect('black'); } function zoom_click(){ var can = $$('can'); var cans = can.getContext('2d'); drawCircle('red'); cans.scale(1.1,1.1); drawCircle('green'); } function rotate_click(){ var can = $$('can'); var cans = can.getContext('2d'); cans.rotate(Math.PI*2/360*45); drawRect('green'); cans.rotate(-Math.PI/4); drawRect('black'); } drawCircle('red'); function abc() { $("#test").html($model.transURL('../img')); var can = $$('can'); cans = can.getContext('2d'); //cans.scale(1.1,1.1); cans.translate(10,10); //cans.fillStyle = 'red'; cans.clearRect(-100, -100, 800, 800); //cans.rect(50, 100, 200, 100); //cxt.stroke(); cans.fill(); cans.fillRect(0,0,22,22); var img = new Image(); img.src = "http://localhost:8080/x5/UI2/v_eb3e398a146e4c548e9bcc610a89699dl_zh_CNs_d_m/zupu/main/img/menu1.png"; cans.drawImage(img,10,10); }</script>  
          <style type="text/css">.abc { -webkit-transform:matrix(1,0,0,1,0,0); }</style>  
          <div id="divFamilyCanvas" style="width:500px;height:800px"> 
            <canvas id="can" width="500" height="800"/>  
            <a component="$UI/system/components/justep/button/button" class="btn btn-warning"
              label="我" xid="btnMyReleation" style="border-radius:100px;position:fixed;bottom:60px;right:20px;transform: translateZ(1em);"
              onClick="btnMyReleationClick"> 
              <i xid="i7"/>  
              <span xid="span2">我</span> 
            </a>  
            <div id="tet" class="abc" style="position:fixed;bottom:60px;right:80px; z-index:100px"/>  
            <br/>  
            <span id="test"/>  
            <a component="$UI/system/components/justep/button/button" class="btn btn-default"
              label="展示族谱" xid="button2" onClick="showFamily" bind-visible="false"> 
              <i xid="i1"/>  
              <span xid="span1">展示族谱</span> 
            </a>  
            <a component="$UI/system/components/justep/button/button" class="btn btn-default"
              label="button" xid="btnShowLocalFamily" onClick="btnShowLocalFamilyClick"
              bind-visible="false"> 
              <i xid="i5"/>  
              <span xid="span3"/> 
            </a> 
          </div>  
          <input id="hidMemberID" xid="hidMemberID" style="display:none" data="baasFamilyMember"
            bind-ref="$model.baasFamilyMember.ref(&quot;memberName&quot;)" bind-value="$model.baasFamilyMember.ref(&quot;ID&quot;)"
            disabled="true"/>  
          <div id="divViewMember"> 
            <ul xid="ul1" class="list-group" style="margin-top:20px;margin-left:20px;margin-right:20px"> 
              <li style="display:block"/>  
              <li class="list-group-item" xid="li1" style="border:0px"> 
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit3"> 
                  <label class="x-label" xid="label3"><![CDATA[姓名]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inNameView" bind-ref="$model.baasFamilyMember.ref(&quot;memberName&quot;)"
                    readonly="true"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit2"> 
                  <label class="x-label" xid="label2"><![CDATA[性别]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inputSexView" valueUpdateMode="input"
                    readonly="true" bind-ref="$model.baasFamilyMember.ref(&quot;memberSex&quot;)"/>  
                  <span component="$UI/system/components/justep/button/toggle"
                    class="x-toggle" xid="inSexView" ON="男" OFF="女" checked="true"
                    checkedValue="男" uncheckedValue="女" value="男" disabled="true"
                    bind-ref="$model.baasFamilyMember.ref(&quot;memberSex&quot;)"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit3"> 
                  <label class="x-label" xid="label3"><![CDATA[手机号]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inPhoneView" bind-ref="$model.baasFamilyMember.ref(&quot;memberPhone&quot;)"
                    readonly="true"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit3"> 
                  <label class="x-label" xid="label3"><![CDATA[出生]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inBirthView" bind-ref="$model.baasFamilyMember.ref(&quot;memberBirthday&quot;)"
                    readonly="true"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit2"> 
                  <label class="x-label" xid="label2"><![CDATA[健在]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inputLivingView" valueUpdateMode="input"
                    readonly="true" bind-value="&quot;键在&quot;" bind-ref="$model.baasFamilyMember.val(&quot;memberLiving&quot;)==1?&quot;健在&quot;:&quot;已故&quot;"/>  
                  <span component="$UI/system/components/justep/button/toggle"
                    class="x-toggle" xid="inLivingView" ON="键在" OFF="已故" checked="true"
                    checkedValue="1" uncheckedValue="0" value="1" bind-ref="$model.baasFamilyMember.ref(&quot;memberLiving&quot;)"
                    disabled="true"/> 
                </div> 
              </li>  
              <li class="list-group-item" xid="li1"> 
                <div component="$UI/system/components/justep/button/buttonGroup"
                  class="btn-group btn-group-justified" tabbed="true" xid="buttonGroup2"> 
                  <a component="$UI/system/components/justep/button/button"
                    class="btn btn-default" label="编辑资料" xid="btnEditX" onClick="btnEditMemberDetail"
                    style="background-color:rgb(234, 65, 60);;"> 
                    <i xid="i13"/>  
                    <span xid="span15">编辑资料</span> 
                  </a>  
                  <a component="$UI/system/components/justep/button/button"
                    class="btn btn-default" label="删除关系" xid="button6" onClick="btnDeleteClick"
                    style="background-color:rgb(234, 65, 60);;"> 
                    <i xid="i14"/>  
                    <span xid="span24">删除关系</span> 
                  </a>  
                  <a component="$UI/system/components/justep/button/button"
                    class="btn btn-default" label="返回族谱" xid="btnCloseX" onClick="btnCloseClick"
                    style="background-color:rgb(234, 65, 60);;"> 
                    <i xid="i15"/>  
                    <span xid="span26">返回族谱</span> 
                  </a> 
                </div> 
              </li> 
            </ul> 
          </div>  
          <div id="divEditMember"> 
            <ul xid="ul1" class="list-group" style="margin-top:20px;margin-left:20px;margin-right:20px;"> 
              <li class="list-group-item" xid="li1"> 
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelReleation"> 
                  <label class="x-label" xid="label1"><![CDATA[他的]]></label>  
                  <select component="$UI/system/components/justep/select/select"
                    class="form-control x-edit" xid="inReleation" bind-options="data1"
                    bind-optionsValue="dname" bind-optionsLabel="name"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit3"> 
                  <label class="x-label" xid="label3"><![CDATA[姓名]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inName"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit2"> 
                  <label class="x-label" xid="label2"><![CDATA[性别]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inputSex" valueUpdateMode="input"
                    readonly="true"/>  
                  <span component="$UI/system/components/justep/button/toggle"
                    class="x-toggle" xid="inSex" ON="男" OFF="女" checked="true" checkedValue="男"
                    uncheckedValue="女" value="男" onChange="inSexChange"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit3"> 
                  <label class="x-label" xid="label3"><![CDATA[手机号]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inPhone"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit3"> 
                  <label class="x-label" xid="label3"><![CDATA[出生]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inBirth" format="yyyy-MM-dd"
                    dataType="Date" bind-value="&quot;1985-01-01&quot;"/> 
                </div>  
                <div component="$UI/system/components/justep/labelEdit/labelEdit"
                  class="x-label-edit x-label30" xid="labelEdit2"> 
                  <label class="x-label" xid="label2"><![CDATA[健在]]></label>  
                  <input component="$UI/system/components/justep/input/input"
                    class="form-control x-edit" xid="inputLiving" valueUpdateMode="input"
                    readonly="true"/>  
                  <span component="$UI/system/components/justep/button/toggle"
                    class="x-toggle" xid="inLiving" ON="健在" OFF="已故" checked="true"
                    value="1" checkedValue="1" uncheckedValue="0" onChange="inLivingChange"/> 
                </div> 
              </li>  
              <li/>  
              <li/>  
              <li class="list-group-item"> 
                <div component="$UI/system/components/justep/button/buttonGroup"
                  class="btn-group btn-group-justified" tabbed="true" xid="buttonGroup3"> 
                  <a component="$UI/system/components/justep/button/button"
                    class="btn btn-default" label="提交" xid="btnSubmitX" onClick="btnSubmitClick"
                    style="background-color:rgb(234, 65, 60);"> 
                    <i xid="i16"/>  
                    <span xid="span27">提交</span> 
                  </a>  
                  <a component="$UI/system/components/justep/button/button"
                    class="btn btn-default" label="关闭" xid="btnCloseXX" onClick="btnCloseClick"
                    style="background-color:rgb(234, 65, 60);;"> 
                    <i xid="i17"/>  
                    <span xid="span28">关闭</span> 
                  </a> 
                </div> 
              </li> 
            </ul> 
          </div> 
        </div>  
        <div class="x-contents-content backcolor" xid="foundContent"> 
          <div component="$UI/system/components/justep/titleBar/titleBar" class="x-titlebar title"
            xid="titleBar1"> 
            <div class="x-titlebar-title" xid="title1"><![CDATA[我的预约]]></div> 
          </div>
          <div class="condition"> 
            <div class="chaxun"> 
              <span class="span_left "><![CDATA[地区]]></span>  
              <span class="span_right font-color"><![CDATA[吉林省]]></span>  
              <a> 
                <img src="$UI/zupu/img/sj.png" alt="" xid="image2"/> 
              </a> 
            </div>  
            <div class="chaxun" bind-click="bumenclick"> 
              <span class="span_left" id="bumen_leixing"><![CDATA[部门]]></span>  
              <span class="span_right font-color" id="bumen_classification">全部</span>  
              <a> 
                <img src="$UI/zupu/img/sj.png" alt=""/> 
              </a> 
            </div>  
            <div class="chaxun"> 
              <span class="span_left"><![CDATA[关键词]]> </span>  
              <input type="text" placeholder="请输入关键词,如教育等" class="input_css"/> 
            </div>  
            <div class="chaxun" style="padding-left:8%; padding-right:8%;"> 
              <div class="btn_" bind-click="search">查询</div> 
            </div> 
          </div> 
        </div>  
        <div class="x-contents-content" xid="userContent" onActive="userContentActive"
          onInactive="userContentInactive"> 
          <div component="$UI/system/components/bootstrap/carousel/carousel"
            class="x-carousel carousel x-banner " xid="carousel1"> 
            <div class="x-contents carousel-inner" role="listbox" component="$UI/system/components/justep/contents/contents"
              active="0" slidable="true" wrap="true" swipe="true" xid="bannerContents"> 
              <div class="top" bind-click="jump_edit"> 
                <div class="image_box"> 
                  <img src="$UI/zupu/img/women.png" class="image_paved" id="image_head"/> 
                </div>  
                <div class="media_right"> 
                  <span class="media-top size_name size-color" id="zupuname">某某某</span>  
                  <span class="size_normal  size-color " id="introduction">设置我的个人信息...</span> 
                </div> 
              </div> 
            </div> 
          </div>  
          <div class="middle"> 
            <div class="click_box"> 
              <div class="image_container"> 
                <img src="$UI/zupu/img/lishi.png" alt="" xid="image1" class=" image_container_element"/> 
              </div>  
              <span class="size_normal1 font_weight">历史事项</span> 
            </div>  
            <div class="click_box"> 
              <div class="image_container"> 
                <img src="$UI/zupu/img/daishen.png" alt="" xid="image1" class=" image_container_element"/> 
              </div>  
              <span class="size_normal1 font_weight">待审事项</span> 
            </div>  
            <div class="click_box"> 
              <div class="image_container"> 
                <img src="$UI/zupu/img/jieguo.jpg" alt="" xid="image1" class=" image_container_element"/> 
              </div>  
              <span class="size_normal1 font_weight">审核结果</span> 
            </div>  
            <div class="click_box"> 
              <div class="image_container"> 
                <img src="$UI/zupu/img/xiaoxi.png" alt="" xid="image1" class=" image_container_element"/> 
              </div>  
              <span class="size_normal1 font_weight">我的消息</span> 
            </div> 
          </div>  
          <div style="border-bottom: solid 0.5vw rgba(242, 242, 242, 1)"> 
            <div class="jump_table"> 
              <span class="size_normal1">我的二维码</span>  
              <div> 
                <img src="$UI/zupu/img/u13.png" clas=""/> 
              </div> 
            </div>  
            <div class="jump_table" bind-click="wdzj"> 
              <span class="size_normal1">我的证件</span>  
              <div> 
                <img src="$UI/zupu/img/u13.png" clas=""/> 
              </div> 
            </div>  
            <div class="jump_table"> 
              <span class="size_normal1">我的政务信息</span>  
              <div> 
                <img src="$UI/zupu/img/u13.png" clas=""/> 
              </div> 
            </div>  
            <div class="jump_table"> 
              <span class="size_normal1">我的收藏</span>  
              <div> 
                <img src="$UI/zupu/img/u13.png" clas=""/> 
              </div> 
            </div>  
            <div class="jump_table"> 
              <span class="size_normal1">我的建议</span>  
              <div> 
                <img src="$UI/zupu/img/u13.png" clas=""/> 
              </div> 
            </div> 
          </div>  
          <div class="jump_table margin_top" bind-click="div9Click"> 
            <span class="size_normal1">设置</span>  
            <div> 
              <img src="$UI/zupu/img/u13.png" clas=""/> 
            </div> 
          </div> 
        </div> 
      </div> 
    </div>  
    <div class="x-panel-bottom" xid="bottom1"> 
      <div component="$UI/system/components/justep/button/buttonGroup" class="btn-group btn-group-justified x-card x-wangyi"
        tabbed="true" xid="buttonGroup1"> 
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top active"
          label="首页" xid="newsBtn" icon="icon-android-note" target="newsContent"> 
          <i xid="i4" class="icon icon-android-note"/>  
          <span xid="span6">首页</span> 
        </a>  
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top"
          label="族谱" xid="readBtn" icon="icon-ios7-bookmarks-outline" target="readContent"> 
          <i xid="i3" class="icon icon-ios7-bookmarks-outline"/>  
          <span xid="span5">族谱</span> 
        </a>  
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top"
          label="预约" xid="foundBtn" icon="icon-android-locate" target="foundContent"> 
          <i xid="i3" class="icon icon-android-locate"/>  
          <span xid="span4">预约</span> 
        </a>  
        <a component="$UI/system/components/justep/button/button" class="btn btn-link btn-icon-top"
          label="我的" xid="userBtn" icon="icon-ios7-contact-outline" target="userContent"> 
          <i xid="i6" class="icon icon-ios7-contact-outline"/>  
          <span xid="span71">我的</span> 
        </a> 
      </div> 
    </div> 
  </div>  
  <div component="$UI/system/components/justep/model/model" xid="model1" style="position:absolute;top:69px;left:606px;width:77px;height:79px;"/>  
  <span component="$UI/system/components/justep/windowDialog/windowDialog" xid="dlgQrCode"
    src="$UI/zupu/my/myQRcode.w" style="top:679px;left:410px;"/> 
</div>