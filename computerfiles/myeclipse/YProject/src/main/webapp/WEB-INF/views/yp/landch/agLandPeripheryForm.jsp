<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>土地利用信息管理</title>
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
		<li><a href="${ctx}/landch/agLandPeriphery/">土地利用信息列表</a></li>
		<li class="active"><a href="${ctx}/landch/agLandPeriphery/form?id=${agLandPeriphery.id}">土地利用信息<shiro:hasPermission name="landch:agLandPeriphery:edit">${not empty agLandPeriphery.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="landch:agLandPeriphery:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agLandPeriphery" action="${ctx}/landch/agLandPeriphery/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>土地利用信息</legend>
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
						增减：
					</td>
					<td>
							<form:input path="increase_od" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						合计：
					</td>
					<td>
							<form:input path="sum" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						有林地：
					</td>
					<td>
							<form:input path="forestland" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						其他林地：
					</td>
					<td>
							<form:input path="other_fd" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						林草小计：
					</td>
					<td>
							<form:input path="forest_gp" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						水域：
					</td>
					<td>
							<form:input path="waters" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						城镇：
					</td>
					<td>
							<form:input path="town" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						农村居民地：
					</td>
					<td>
							<form:input path="rural_residential" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						水田：
					</td>
					<td>
							<form:input path="paddy_field" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						旱田：
					</td>
					<td>
							<form:input path="dry_farmland" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						耕地小计：
					</td>
					<td>
							<form:input path="cultivated_land" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						未利用地：
					</td>
					<td>
							<form:input path="unused_land" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						草地：
					</td>
					<td>
							<form:input path="grassland" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						沼泽地：
					</td>
					<td>
							<form:input path="marshland" htmlEscape="false" class="input-xlarge "/>
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
								value="<fmt:formatDate value="${agLandPeriphery.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="landch:agLandPeriphery:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>