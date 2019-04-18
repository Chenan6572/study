<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>1986-2000年吉林省水稻面积产量统计信息表管理</title>
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
		<li><a href="${ctx}/rice/fcRiceProduction/">1986-2000年吉林省水稻面积产量统计信息表列表</a></li>
		<li class="active"><a href="${ctx}/rice/fcRiceProduction/form?id=${fcRiceProduction.id}">1986-2000年吉林省水稻面积产量统计信息表<shiro:hasPermission name="rice:fcRiceProduction:edit">${not empty fcRiceProduction.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rice:fcRiceProduction:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="fcRiceProduction" action="${ctx}/rice/fcRiceProduction/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>1986-2000年吉林省水稻面积产量统计信息表</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
				<tr>
					<td>
						更新时间：
					</td>
					<td>
							<input name="update_date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
								value="<fmt:formatDate value="${fcRiceProduction.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
						亩产量：
					</td>
					<td>
							<form:input path="area_yield" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						面积（万亩）：
					</td>
					<td>
							<form:input path="area" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						总产量（万吨）：
					</td>
					<td>
							<form:input path="total_output" htmlEscape="false" class="input-xlarge "/>
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
			<td></td>
			<td>
				<shiro:hasPermission name="rice:fcRiceProduction:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>