<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省乡、村农机化服务组织服务情况统计表管理</title>
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
		<li class="active"><a href="${ctx}/service/agMachineManaService/">吉林省乡、村农机化服务组织服务情况统计表列表</a></li>
		<shiro:hasPermission name="service:agMachineManaService:edit"><li><a href="${ctx}/service/agMachineManaService/form">吉林省乡、村农机化服务组织服务情况统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agMachineManaService" action="${ctx}/service/agMachineManaService/" method="post" class="vus-form-inline form-search">
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
				<th>区域（城市）</th>
				<th>年份</th>
				<th>乡镇数</th>
				<th>建管理服务站</th>
				<th>村数</th>
				<th>农机队或合作社</th>
				<th>农机协会</th>
				<th>农机管理员</th>
				<th>农机户</th>
				<th>其中农机专业户</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="service:agMachineManaService:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agMachineManaService">
			<tr>
				<td><a href="${ctx}/service/agMachineManaService/form?id=${agMachineManaService.id}">
					${agMachineManaService.org_name}
				</a></td>
				<td>
					${agMachineManaService.year}
				</td>
				<td>
					${agMachineManaService.towns}
				</td>
				<td>
					${agMachineManaService.mana_serivce}
				</td>
				<td>
					${agMachineManaService.village}
				</td>
				<td>
					${agMachineManaService.cooperative}
				</td>
				<td>
					${agMachineManaService.association}
				</td>
				<td>
					${agMachineManaService.administrator}
				</td>
				<td>
					${agMachineManaService.nongjihu}
				</td>
				<td>
					${agMachineManaService.pro_nongjihu}
				</td>
				<td>
					${agMachineManaService.update_by}
				</td>
				<td>
					${agMachineManaService.update_date}
				</td>
				<shiro:hasPermission name="service:agMachineManaService:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/service/agMachineManaService/form?id=${agMachineManaService.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/service/agMachineManaService/delete?id=${agMachineManaService.id}" onclick="return confirmx('确认要删除该吉林省乡、村农机化服务组织服务情况统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>