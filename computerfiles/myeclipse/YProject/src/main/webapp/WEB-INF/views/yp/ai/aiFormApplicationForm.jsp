<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>	
<html>
<head>
	<title>百度AI开放平台管理</title>
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
		<li><a href="${ctx}/ai/aiFormApplication/">百度AI开放平台列表</a></li>
		<li class="active"><a href="${ctx}/ai/aiFormApplication/form?id=${aiFormApplication.id}">百度AI开放平台<shiro:hasPermission name="ai:aiFormApplication:edit">${not empty aiFormApplication.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="ai:aiFormApplication:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<form:form id="inputForm" modelAttribute="aiFormApplication" action="${ctx}/ai/aiFormApplication/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<legend>百度AI开放平台</legend>
		<sys:message content="${message}"/>	
		<table class="vus-table">	
				<tr>
					<td>
						申请类型：
					</td>
					<td>
							<form:input path="application_type" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						行业选择：
					</td>
					<td>
							<form:input path="industry_choose" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						意向技术：
					</td>
					<td>
							<form:input path="intention_technology" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						是否使用：
					</td>
					<td>
							<form:input path="whether_use" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						公司名称：
					</td>
					<td>
							<form:input path="company_name" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						公司网址：
					</td>
					<td>
							<form:input path="company_website" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						业务描述：
					</td>
					<td>
							<form:textarea path="business_description" htmlEscape="false" rows="4" class="input-xxlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						合作期望：
					</td>
					<td>
							<form:textarea path="cooperation_expected" htmlEscape="false" rows="4" class="input-xxlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						注册资本：
					</td>
					<td>
							<form:input path="registered_capital" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						雇员人数：
					</td>
					<td>
							<form:input path="employees" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						公司地址：
					</td>
					<td>
							<form:input path="company_address" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						公司电话：
					</td>
					<td>
							<form:input path="company_tel" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						联系人姓名：
					</td>
					<td>
							<form:input path="contact_name" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						联系人职务：
					</td>
					<td>
							<form:input path="contact_persion" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						联系人手机：
					</td>
					<td>
							<form:input path="contact_phone" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						联系人邮箱：
					</td>
					<td>
							<form:input path="contact_email" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						密钥：
					</td>
					<td>
							<form:input path="key" htmlEscape="false" maxlength="20" class="input-xlarge "/>
					</td>
				</tr>
				<tr>
					<td>
						审核时间：
					</td>
					<td>
							<form:input path="audit_time" htmlEscape="false" maxlength="20" class="input-xlarge "/>
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
								value="<fmt:formatDate value="${aiFormApplication.update_date}" pattern="yyyy-MM-dd HH:mm:ss"/>"
								onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
					</td>
				</tr>
		<tr>
			<td></td>
			<td>
				<shiro:hasPermission name="ai:aiFormApplication:edit"><input id="btnSubmit" class="vus-btn v-outline v--primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
				<input id="btnCancel" class="vus-btn v-outline v--primary" type="button" value="返 回" onclick="history.go(-1)"/>
			</td>
		</tr>
		</table>
	</form:form>
</body>
</html>