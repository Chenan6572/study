<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>1986-2000年吉林省甜菜生产统计表管理</title>
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
		<li><a href="${ctx}/sugerbeet/ecSugerbeetProduction/">1986-2000年吉林省甜菜生产统计表列表</a></li>
		<li class="active"><a href="${ctx}/sugerbeet/ecSugerbeetProduction/form?id=${ecSugerbeetProduction.id}">1986-2000年吉林省甜菜生产统计表<shiro:hasPermission name="sugerbeet:ecSugerbeetProduction:edit">${not empty ecSugerbeetProduction.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sugerbeet:ecSugerbeetProduction:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="ecSugerbeetProduction" action="${ctx}/sugerbeet/ecSugerbeetProduction/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>1986-2000年吉林省甜菜生产统计表</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
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
						年份：
					</td>
					<td>
							<form:input path="year" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						播种面积（万亩）：
					</td>
					<td>
							<form:input path="area_sown" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						总产量（万吨）：
					</td>
					<td>
							<form:input path="total_output" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						平均亩产（公斤）：
					</td>
					<td>
							<form:input path="mu_yield" htmlEscape="false" maxlength="20" class="input-xlarge "/>
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
							<form:input path="update_time" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="sugerbeet:ecSugerbeetProduction:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>