<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>水利治理信息管理</title>
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
		<li><a href="${ctx}/conservancy/agFarmConservancy/">水利治理信息列表</a></li>
		<li class="active"><a href="${ctx}/conservancy/agFarmConservancy/form?id=${agFarmConservancy.id}">水利治理信息<shiro:hasPermission name="conservancy:agFarmConservancy:edit">${not empty agFarmConservancy.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="conservancy:agFarmConservancy:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agFarmConservancy" action="${ctx}/conservancy/agFarmConservancy/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>水利治理信息</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
				<tr>
					<td>
						更新时间：
					</td>
					<td>
							<input name="update_date" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
								value="<fmt:formatDate value="${agFarmConservancy.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
						盐碱耕地改良面积：
					</td>
					<td>
							<form:input path="saline_alkali_cultivated" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						占盐碱耕地面积的比重（%）：
					</td>
					<td>
							<form:input path="proportion_saline_alkali" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						盐碱耕地面积：
					</td>
					<td>
							<form:input path="saline_alkali" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						占易涝面积的比重（%）：
					</td>
					<td>
							<form:input path="proportion_waterlogged" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						易涝面积：
					</td>
					<td>
							<form:input path="flood" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						除涝面积：
					</td>
					<td>
							<form:input path="waterlogged" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						小流域治理面积：
					</td>
					<td>
							<form:input path="small_watershed" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						占水土流失面积比重（%）：
					</td>
					<td>
							<form:input path="proportion_soil" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						当年造林面积：
					</td>
					<td>
							<form:input path="annual_afforestation" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						水土流失治理面积：
					</td>
					<td>
							<form:input path="control" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						水土流失面积：
					</td>
					<td>
							<form:input path="soil_erosion" htmlEscape="false" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						年度：
					</td>
					<td>
							<form:input path="year" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="conservancy:agFarmConservancy:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>