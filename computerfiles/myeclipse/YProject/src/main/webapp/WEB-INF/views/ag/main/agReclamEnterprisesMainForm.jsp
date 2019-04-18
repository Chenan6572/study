<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>吉林省重点建设农垦工业企业情况统计表管理</title>
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
		<li><a href="${ctx}/main/agReclamEnterprisesMain/">吉林省重点建设农垦工业企业情况统计表列表</a></li>
		<li class="active"><a href="${ctx}/main/agReclamEnterprisesMain/form?id=${agReclamEnterprisesMain.id}">吉林省重点建设农垦工业企业情况统计表<shiro:hasPermission name="main:agReclamEnterprisesMain:edit">${not empty agReclamEnterprisesMain.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="main:agReclamEnterprisesMain:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agReclamEnterprisesMain" action="${ctx}/main/agReclamEnterprisesMain/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>吉林省重点建设农垦工业企业情况统计表</legend>
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
						项目：
					</td>
					<td>
							<form:input path="project" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						建设地点：
					</td>
					<td>
							<form:input path="org_name" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						建设规模：
					</td>
					<td>
							<form:input path="scale" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						建设年限：
					</td>
					<td>
							<form:input path="fixed" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						资金来源：
					</td>
					<td>
							<form:input path="source" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						总投资：
					</td>
					<td>
							<form:input path="investment" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						计划：
					</td>
					<td>
							<form:input path="plan" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						实际：
					</td>
					<td>
							<form:input path="actual" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						产值：
					</td>
					<td>
							<form:input path="output" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						利润：
					</td>
					<td>
							<form:input path="profits" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						税金：
					</td>
					<td>
							<form:input path="tax" htmlEscape="false" maxlength="20" class="input-xlarge "/>
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
								value="<fmt:formatDate value="${agReclamEnterprisesMain.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="main:agReclamEnterprisesMain:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>