<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>苹果主要病虫害防治一览表管理</title>
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
		<li><a href="${ctx}/apple/agHorticulTreesDiseases/">苹果主要病虫害防治一览表列表</a></li>
		<li class="active"><a href="${ctx}/apple/agHorticulTreesDiseases/form?id=${agHorticulTreesDiseases.id}">苹果主要病虫害防治一览表<shiro:hasPermission name="apple:agHorticulTreesDiseases:edit">${not empty agHorticulTreesDiseases.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="apple:agHorticulTreesDiseases:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agHorticulTreesDiseases" action="${ctx}/apple/agHorticulTreesDiseases/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>苹果主要病虫害防治一览表</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
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
						地区：
					</td>
					<td>
							<form:input path="org_name" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						品种：
					</td>
					<td>
							<form:input path="varieties" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						防治时期：
					</td>
					<td>
							<form:textarea path="prevention_time" htmlEscape="false" rows="4" maxlength="20" class="input-xxlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						防治对象：
					</td>
					<td>
							<form:textarea path="prevention_treat" htmlEscape="false" rows="4" maxlength="500" class="input-xxlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						防治措施：
					</td>
					<td>
							<form:textarea path="prevention_methods" htmlEscape="false" rows="4" maxlength="500" class="input-xxlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						更新人：
					</td>
					<td>
							<form:input path="updata_by" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						更新日期：
					</td>
					<td>
							<form:input path="updata_date" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="apple:agHorticulTreesDiseases:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>