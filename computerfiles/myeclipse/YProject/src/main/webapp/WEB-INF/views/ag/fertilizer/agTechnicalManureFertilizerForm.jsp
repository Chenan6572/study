<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>农业化肥施用量统计表管理</title>
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
		<li><a href="${ctx}/fertilizer/agTechnicalManureFertilizer/">农业化肥施用量统计表列表</a></li>
		<li class="active"><a href="${ctx}/fertilizer/agTechnicalManureFertilizer/form?id=${agTechnicalManureFertilizer.id}">农业化肥施用量统计表<shiro:hasPermission name="fertilizer:agTechnicalManureFertilizer:edit">${not empty agTechnicalManureFertilizer.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="fertilizer:agTechnicalManureFertilizer:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agTechnicalManureFertilizer" action="${ctx}/fertilizer/agTechnicalManureFertilizer/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>农业化肥施用量统计表</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
				<tr>
					<td>
						城市：
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
						实物量合计（万吨）：
					</td>
					<td>
							<form:input path="total_physical" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						折纯量合计（万吨）：
					</td>
					<td>
							<form:input path="total_refractive" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						施肥方式：
					</td>
					<td>
							<form:input path="way" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						氮肥（万吨）：
					</td>
					<td>
							<form:input path="nitrogen" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						磷肥（万吨）：
					</td>
					<td>
							<form:input path="phosphate" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						钾肥（万吨）：
					</td>
					<td>
							<form:input path="potash" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						复合肥（万吨）：
					</td>
					<td>
							<form:input path="compound" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						亩均施化肥量（万吨）：
					</td>
					<td>
							<form:input path="per_mu" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						更新人：
					</td>
					<td>
							<form:input path="update_by" htmlEscape="false" maxlength="19" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						更新时间：
					</td>
					<td>
							<input name="update_date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
								value="<fmt:formatDate value="${agTechnicalManureFertilizer.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="fertilizer:agTechnicalManureFertilizer:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>