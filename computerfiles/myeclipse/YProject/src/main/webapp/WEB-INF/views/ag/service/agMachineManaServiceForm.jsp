<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>吉林省乡、村农机化服务组织服务情况统计表管理</title>
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
		<li><a href="${ctx}/service/agMachineManaService/">吉林省乡、村农机化服务组织服务情况统计表列表</a></li>
		<li class="active"><a href="${ctx}/service/agMachineManaService/form?id=${agMachineManaService.id}">吉林省乡、村农机化服务组织服务情况统计表<shiro:hasPermission name="service:agMachineManaService:edit">${not empty agMachineManaService.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="service:agMachineManaService:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agMachineManaService" action="${ctx}/service/agMachineManaService/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>吉林省乡、村农机化服务组织服务情况统计表</legend>
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
						乡镇数：
					</td>
					<td>
							<form:input path="towns" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						建管理服务站：
					</td>
					<td>
							<form:input path="mana_serivce" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						村数：
					</td>
					<td>
							<form:input path="village" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						农机队或合作社：
					</td>
					<td>
							<form:input path="cooperative" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						农机协会：
					</td>
					<td>
							<form:input path="association" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						农机管理员：
					</td>
					<td>
							<form:input path="administrator" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						农机户：
					</td>
					<td>
							<form:input path="nongjihu" htmlEscape="false" class="input-xlarge  number"/>
					</td>
				</tr>
				<tr>
					<td>
						其中农机专业户：
					</td>
					<td>
							<form:input path="pro_nongjihu" htmlEscape="false" class="input-xlarge  number"/>
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
								value="<fmt:formatDate value="${agMachineManaService.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="service:agMachineManaService:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>