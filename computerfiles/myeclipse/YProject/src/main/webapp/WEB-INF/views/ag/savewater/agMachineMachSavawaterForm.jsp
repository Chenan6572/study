<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>机械化节水保墒栽培技术项目完成情况统计表管理</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic}/vusui/css/ncloud.css" rel="stylesheet" />
	<script type="text/javascript">
		$(document).ready(function() {
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/savewater/agMachineMachSavawater/">机械化节水保墒栽培技术项目完成情况统计表列表</a></li>
		<li class="active"><a href="${ctx}/savewater/agMachineMachSavawater/form?id=${agMachineMachSavawater.id}">机械化节水保墒栽培技术项目完成情况统计表<shiro:hasPermission name="savewater:agMachineMachSavawater:edit">${not empty agMachineMachSavawater.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="savewater:agMachineMachSavawater:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agMachineMachSavawater" action="${ctx}/savewater/agMachineMachSavawater/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>机械化节水保墒栽培技术项目完成情况统计表</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
				<tr>
					<td>
						区域（城市）：
					</td>
					<td>
							<form:input path="org_name" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						年份：
					</td>
					<td>
							<form:input path="year" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						计划面积（万亩）：
					</td>
					<td>
							<form:input path="plan_area" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						完成面积（万亩）：
					</td>
					<td>
							<form:input path="fin_area" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						投入机具（万台）：
					</td>
					<td>
							<form:input path="machine" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						亩均增产（公斤）：
					</td>
					<td>
							<form:input path="acre_increase" htmlEscape="false" maxlength="255" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						新增总产（公斤）：
					</td>
					<td>
							<form:input path="new_total" htmlEscape="false" maxlength="255" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						更新人：
					</td>
					<td>
							<form:input path="update_by" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						更新时间：
					</td>
					<td>
							<input name="update_date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
								value="<fmt:formatDate value="${agMachineMachSavawater.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="savewater:agMachineMachSavawater:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>