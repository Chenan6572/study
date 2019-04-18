<?xml version="1.0" encoding="UTF-8"?>

<div xmlns="http://www.w3.org/1999/xhtml" xid="window" class="window" component="$UI/system/components/justep/window/window" design="device:m;">  
  <div component="$UI/system/components/justep/model/model" xid="model" onLoad="modelLoad" style="top:89px;left:474px;height:auto;"><div component="$UI/system/components/justep/data/data" autoLoad="true" xid="data1" idColumn="value"><column label="值" name="value" type="Integer" xid="xid1"></column>
  <column label="名称" name="name" type="String" xid="xid2"></column>
  <data xid="default1">[{&quot;value&quot;:1,&quot;name&quot;:&quot;父母&quot;},{&quot;value&quot;:3,&quot;name&quot;:&quot;配偶&quot;},{&quot;value&quot;:5,&quot;name&quot;:&quot;兄妹&quot;},{&quot;value&quot;:7,&quot;name&quot;:&quot;儿女&quot;}]</data></div>
  <div component="$UI/system/components/justep/data/baasData" autoLoad="false" xid="baasFamilyMember" queryAction="queryFamilymember" saveAction="saveFamilymember " url="/zupu/FamilyMember" tableName="familymember" idColumn="ID"><column label="标识" name="ID" type="Integer" xid="default2"></column>
  <column label="所属族谱" name="familyCode" type="String" xid="default3"></column>
  <column label="成员用户ID" name="memberID" type="Integer" xid="default4"></column>
  <column label="显示名称" name="memberName" type="String" xid="default5"></column>
  <column label="成员电话" name="memberPhone" type="String" xid="default6"></column>
  <column label="身份证" name="memberIDcard" type="String" xid="default7"></column>
  <column label="出生日期" name="memberBirthday" type="Date" xid="default8"></column>
  <column label="上级成员" name="parentMember" type="Integer" xid="default9"></column>
  <column label="parentRelation" name="parentRelation" type="String" xid="default10"></column>
  <column label="第几代" name="memberGeneration" type="Integer" xid="default11"></column>
  <column label="性别" name="memberSex" type="String" xid="default12"></column>
  <column label="健在" name="memberLiving" type="Integer" xid="default13"></column>
  <column label="成员状态" name="memberState" type="Integer" xid="default14"></column>
  <column label="亲人照片" name="memberPhoto" type="String" xid="default15"></column></div></div> 
    
<div component="$UI/system/components/justep/popOver/popOver" class="x-popOver" direction="auto" xid="popOver1">
   <div class="x-popOver-overlay" xid="div1"></div>
<div class="x-popOver-content" xid="div2">
<div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
   <div class="x-col" xid="col4"><img src="$UI/zupu/img/h12.png"   alt="" xid="imageInvite" style="width:100px;" bind-click="btnInvitClick" ></img></div>
   <div class="x-col" xid="col5"><img src="$UI/zupu/img/h13.png"   alt="" xid="imageDetail" style="width:100px;" bind-click="btnShowMemberDetail"></img></div>
   <div class="x-col" xid="col6"><img src="$UI/zupu/img/h14.png"   alt="" xid="imageAdd" style="width:100px;" bind-click="btnAddMember"></img></div>
</div>
<div component="$UI/system/components/justep/row/row" class="x-row" xid="row2">
   <div class="x-col" xid="col4" style="text-align:center"><![CDATA[邀请亲友]]></div>
   <div class="x-col" xid="col5" style="text-align:center"><![CDATA[查看资料]]></div>
   <div class="x-col" xid="col6" style="text-align:center"><![CDATA[添加亲人]]></div>
</div>

</div></div>
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel2">
   <div class="x-panel-top" xid="top2"></div>
   <div class="x-panel-content" xid="content4"><div component="$UI/system/components/justep/contents/contents" class="x-contents x-full" active="0" xid="contents3">
   <div class="x-contents-content" xid="content5">
  <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel4">
  
  
   <div class="x-panel-content" xid="content6">
   	
   <input id="hidMemberID" xid="hidMemberID"  style="display:block" data="baasFamilyMember" bind-ref='$model.baasFamilyMember.ref("memberName")' bind-value='$model.baasFamilyMember.ref("ID")' disabled="true"></input>
   <div id="divViewMember">
			
			 <ul xid="ul1" class="list-group"> 
					 <li style="display:block">
					 	
					  </li>
					 <li class="list-group-item" xid="li1"> 
							<div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit3">
							   <label class="x-label" xid="label3"><![CDATA[姓名]]></label>
							   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="inNameView" bind-ref='$model.baasFamilyMember.ref("memberName")' readonly="true"></input>
							 </div>
						  	 <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit2">
							   <label class="x-label" xid="label2"><![CDATA[性别]]></label>
							   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="input1" valueUpdateMode="input" style="visibility:hidden;"></input>   
							   <span component="$UI/system/components/justep/button/toggle" class="x-toggle" xid="inSexView" ON="男" OFF="女" checked="true" checkedValue="男" uncheckedValue="女" value="男" bind-ref='$model.baasFamilyMember.ref("memberSex")' disabled="true"></span>
							</div>
							 <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit3">
							   <label class="x-label" xid="label3"><![CDATA[手机号]]></label>
							   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="inPhoneView" bind-ref='$model.baasFamilyMember.ref("memberPhone")' readonly="true"></input>
							 </div>
							 <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit3">
							   <label class="x-label" xid="label3"><![CDATA[出生]]></label>
							   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="inBirthView" bind-ref='$model.baasFamilyMember.ref("memberBirthday")' readonly="true"></input>
							 </div>
							 <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit2">
							   <label class="x-label" xid="label2"><![CDATA[健在]]></label>
							   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="input1" valueUpdateMode="input" style="visibility:hidden;"></input>   
							   <span component="$UI/system/components/justep/button/toggle" class="x-toggle" xid="inLivingView" ON="键在" OFF="已故" checked="true" checkedValue="1" uncheckedValue="0" value="1" bind-ref='$model.baasFamilyMember.ref("memberLiving")' disabled="true"></span>
							</div>
			 	 </li>
			 	 
			 	 
			 	 <li class="list-group-item" xid="li1"> 
						<a component="$UI/system/components/justep/button/button" class="btn btn-default" label="编辑" xid="btnEdit" onClick="btnEditMemberDetail">
					   <i xid="i1"></i>
					   <span xid="span1">编辑</span></a>
					   
					   <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="关闭" xid="btnClose" onClick="btnCloseClick">
						   <i xid="i1"></i>
						   <span xid="span1">关闭</span></a>
						   
			 	 </li>
			 </ul>
		   
   </div>
   
   <div id="divEditMember">
      
   <ul xid="ul1" class="list-group"> 
        	 
          <li class="list-group-item" xid="li1"> 
          
          
			<div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelReleation">
			   <label class="x-label" xid="label1"><![CDATA[他的]]></label>
			   <select component="$UI/system/components/justep/select/select" class="form-control x-edit" xid="inReleation" bind-options="data1" bind-optionsValue="value" bind-optionsLabel="name"></select>
			</div>
			
		
		   
			 <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit3">
			   <label class="x-label" xid="label3"><![CDATA[姓名]]></label>
			   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="inName"></input>
			 </div>
			   
		  
		 
			
		   <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit2">
			   <label class="x-label" xid="label2"><![CDATA[性别]]></label>
			   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="input1" valueUpdateMode="input" style="visibility:hidden;"></input>   
			   <span component="$UI/system/components/justep/button/toggle" class="x-toggle" xid="inSex" ON="男" OFF="女" checked="true" checkedValue="男" uncheckedValue="女" value="男"></span>
			</div>

		 <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit3">
			   <label class="x-label" xid="label3"><![CDATA[手机号]]></label>
			   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="inPhone"></input>
			 </div>
 
    </li>
    
    <li>
    
     <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit3">
	   <label class="x-label" xid="label3"><![CDATA[出生]]></label>
	   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="inBirth" format="yyyy-MM-dd" dataType="Date" bind-value='"1985-01-01"'></input>
 	</div>
    </li>
    
    
    <li>
    	  <div component="$UI/system/components/justep/labelEdit/labelEdit" class="x-label-edit x-label30" xid="labelEdit2">
	   <label class="x-label" xid="label2"><![CDATA[健在]]></label>
	   <input component="$UI/system/components/justep/input/input" class="form-control x-edit" xid="input1" valueUpdateMode="input" style="visibility:hidden;"></input>   
	   <span component="$UI/system/components/justep/button/toggle" class="x-toggle" xid="inLiving" ON="健在" OFF="已故" checked="true" value="1" checkedValue="1" uncheckedValue="0"></span>
	</div>
    
    </li>
    
    <li>
    
  
   
    	
    <a component="$UI/system/components/justep/button/button" class="btn btn-default" label="提交" xid="btnSubmit" onClick="btnSubmitClick">
   <i xid="i1"></i>
   <span xid="span1">提交</span></a>
   
   	<a component="$UI/system/components/justep/button/button" class="btn btn-default" label="关闭" xid="btnClose" onClick="btnCloseClick">
		   <i xid="i1"></i>
		   <span xid="span1">关闭</span></a>
			   </li>
	</ul>

	</div>

  </div>
  
  
 </div>
   
   
   <div component="$UI/system/components/justep/panel/panel" class="x-panel x-full" xid="panel1">
   <div class="x-panel-content" xid="content2">
  <canvas id="can" width="500" height="800"></canvas>
   </div>
   </div></div>
  </div></div>
   </div></div>