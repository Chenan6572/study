<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>百度AI开放平台管理</title>
	<meta name="decorator" content="default"/>
	<link href="${ctxStatic}/vusui/css/ncloud.css" rel="stylesheet" />
	<script type="text/javascript">
		$(document).ready(function() {
			reSizeParentIframe();
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/ai/aiFormApplication/">百度AI开放平台列表</a></li>
		<shiro:hasPermission name="ai:aiFormApplication:edit"><li><a href="${ctx}/ai/aiFormApplication/form">百度AI开放平台添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="aiFormApplication" action="${ctx}/ai/aiFormApplication/" method="post" class="vus-form-inline form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="vus-btn v-outline v--info" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="vus-table">
			<tr>
				<th>申请类型</th>
				<th>行业选择</th>
				<th>意向技术</th>
				<th>是否使用</th>
				<th>公司名称</th>
				<th>公司网址</th>
				<th>业务描述</th>
				<th>合作期望</th>
				<th>注册资本</th>
				<th>雇员人数</th>
				<th>公司地址</th>
				<th>公司电话</th>
				<th>联系人姓名</th>
				<th>联系人职务</th>
				<th>联系人手机</th>
				<th>联系人邮箱</th>
				<th>密钥</th>
				<th>审核时间</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="ai:aiFormApplication:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="aiFormApplication">
			<tr>
				<td><a href="${ctx}/ai/aiFormApplication/form?id=${aiFormApplication.id}">
					${aiFormApplication.application_type}
				</a></td>
				<td>
					${aiFormApplication.industry_choose}
				</td>
				<td>
					${aiFormApplication.intention_technology}
				</td>
				<td>
					${aiFormApplication.whether_use}
				</td>
				<td>
					${aiFormApplication.company_name}
				</td>
				<td>
					${aiFormApplication.company_website}
				</td>
				<td>
					${aiFormApplication.business_description}
				</td>
				<td>
					${aiFormApplication.cooperation_expected}
				</td>
				<td>
					${aiFormApplication.registered_capital}
				</td>
				<td>
					${aiFormApplication.employees}
				</td>
				<td>
					${aiFormApplication.company_address}
				</td>
				<td>
					${aiFormApplication.company_tel}
				</td>
				<td>
					${aiFormApplication.contact_name}
				</td>
				<td>
					${aiFormApplication.contact_persion}
				</td>
				<td>
					${aiFormApplication.contact_phone}
				</td>
				<td>
					${aiFormApplication.contact_email}
				</td>
				<td>
					${aiFormApplication.key}
				</td>
				<td>
					${aiFormApplication.audit_time}
				</td>
				<td>
					${aiFormApplication.update_by}
				</td>
				<td>
					${aiFormApplication.update_date}
				</td>
				<shiro:hasPermission name="ai:aiFormApplication:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/ai/aiFormApplication/form?id=${aiFormApplication.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/ai/aiFormApplication/delete?id=${aiFormApplication.id}" onclick="return confirmx('确认要删除该百度AI开放平台吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>