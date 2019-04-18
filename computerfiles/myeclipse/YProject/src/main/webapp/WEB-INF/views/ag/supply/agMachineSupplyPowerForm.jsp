<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>农机供应系统排灌动力机械统计表管理</title>
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
		<li><a href="${ctx}/supply/agMachineSupplyPower/">农机供应系统排灌动力机械统计表列表</a></li>
		<li class="active"><a href="${ctx}/supply/agMachineSupplyPower/form?id=${agMachineSupplyPower.id}">农机供应系统排灌动力机械统计表<shiro:hasPermission name="supply:agMachineSupplyPower:edit">${not empty agMachineSupplyPower.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="supply:agMachineSupplyPower:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agMachineSupplyPower" action="${ctx}/supply/agMachineSupplyPower/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>农机供应系统排灌动力机械统计表</legend>
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
						柴油机（台）：
					</td>
					<td>
							<form:input path="diesel_engine" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						汽油机（台）：
					</td>
					<td>
							<form:input path="gasoline_engine" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						电动机（台）：
					</td>
					<td>
							<form:input path="motor" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						大泵（台）：
					</td>
					<td>
							<form:input path="large_pump" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						深井泵（台）：
					</td>
					<td>
							<form:input path="deep_pump" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						纯购进（万元）：
					</td>
					<td>
							<form:input path="purchases" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						纯销售（万元）：
					</td>
					<td>
							<form:input path="sales" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						年末库存（万元）：
					</td>
					<td>
							<form:input path="inventory" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
					</td>
				</tr>
				<tr>
					<td>
						经营利润（万元）：
					</td>
					<td>
							<form:input path="operating" htmlEscape="false" maxlength="20" class="input-xlarge  digits"/>
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
								value="<fmt:formatDate value="${agMachineSupplyPower.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="supply:agMachineSupplyPower:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>