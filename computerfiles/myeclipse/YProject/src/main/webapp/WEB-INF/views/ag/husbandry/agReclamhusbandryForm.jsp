<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>农垦企业畜牧业生产情况统计表管理</title>
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
		<li><a href="${ctx}/husbandry/agReclamhusbandry/">农垦企业畜牧业生产情况统计表列表</a></li>
		<li class="active"><a href="${ctx}/husbandry/agReclamhusbandry/form?id=${agReclamhusbandry.id}">农垦企业畜牧业生产情况统计表<shiro:hasPermission name="husbandry:agReclamhusbandry:edit">${not empty agReclamhusbandry.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="husbandry:agReclamhusbandry:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agReclamhusbandry" action="${ctx}/husbandry/agReclamhusbandry/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>农垦企业畜牧业生产情况统计表</legend>
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
						业种类：
					</td>
					<td>
							<form:input path="varieties" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						大牲畜：
					</td>
					<td>
							<form:input path="livestock" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						牛（万头）：
					</td>
					<td>
							<form:input path="cow" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						猪（万头）：
					</td>
					<td>
							<form:input path="pig" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						羊（万头）：
					</td>
					<td>
							<form:input path="goat" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						鹿（万头）：
					</td>
					<td>
							<form:input path="deer" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						肉类（吨）：
					</td>
					<td>
							<form:input path="meat" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						牛奶（吨）：
					</td>
					<td>
							<form:input path="milk" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						禽蛋（吨）：
					</td>
					<td>
							<form:input path="eggs" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						鹿茸（公斤）：
					</td>
					<td>
							<form:input path="antler" htmlEscape="false" maxlength="255" class="input-xlarge "/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="husbandry:agReclamhusbandry:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>