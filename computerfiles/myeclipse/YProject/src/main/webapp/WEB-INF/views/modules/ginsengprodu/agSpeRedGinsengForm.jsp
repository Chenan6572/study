<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>人（园）参生产情况管理</title>
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
		<li><a href="${ctx}/ginsengprodu/agSpeRedGinseng/">人（园）参生产情况列表</a></li>
		<li class="active"><a href="${ctx}/ginsengprodu/agSpeRedGinseng/form?id=${agSpeRedGinseng.id}">人（园）参生产情况<shiro:hasPermission name="ginsengprodu:agSpeRedGinseng:edit">${not empty agSpeRedGinseng.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ginsengprodu:agSpeRedGinseng:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="agSpeRedGinseng" action="${ctx}/ginsengprodu/agSpeRedGinseng/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>人（园）参生产情况</legend>
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
						品种：
					</td>
					<td>
							<form:input path="varieties" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						品名：
					</td>
					<td>
							<form:input path="goods" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						规格及等级：
					</td>
					<td>
							<form:input path="specifications_grades" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						价格：
					</td>
					<td>
							<form:input path="price" htmlEscape="false" maxlength="20" class="input-xlarge "/>
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
								value="<fmt:formatDate value="${agSpeRedGinseng.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="ginsengprodu:agSpeRedGinseng:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>