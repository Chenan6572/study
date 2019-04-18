<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>吉林省水稻分区面积统计表管理</title>
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
		<li><a href="${ctx}/area/fcRiceArea/">吉林省水稻分区面积统计表列表</a></li>
		<li class="active"><a href="${ctx}/area/fcRiceArea/form?id=${fcRiceArea.id}">吉林省水稻分区面积统计表<shiro:hasPermission name="area:fcRiceArea:edit">${not empty fcRiceArea.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="area:fcRiceArea:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="fcRiceArea" action="${ctx}/area/fcRiceArea/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>吉林省水稻分区面积统计表</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
				<tr>
					<td>
						更新时间：
					</td>
					<td>
							<input name="update_date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
								value="<fmt:formatDate value="${fcRiceArea.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
						西部合计：
					</td>
					<td>
							<form:input path="west_sum" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						西部：
					</td>
					<td>
							<form:input path="west" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						中部合计：
					</td>
					<td>
							<form:input path="middle_sum" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						中部：
					</td>
					<td>
							<form:input path="middle" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						东部合计：
					</td>
					<td>
							<form:input path="east_sum" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						东部：
					</td>
					<td>
							<form:input path="east" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						全省合计：
					</td>
					<td>
							<form:input path="province_sum" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						全省：
					</td>
					<td>
							<form:input path="province" htmlEscape="false" maxlength="20" class="input-xlarge "/>
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
						区域：
					</td>
					<td>
							<form:input path="area" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="area:fcRiceArea:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>