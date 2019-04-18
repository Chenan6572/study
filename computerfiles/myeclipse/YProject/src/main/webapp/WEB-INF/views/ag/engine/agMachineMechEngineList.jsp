<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省各市州农用动力机统计表管理</title>
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
		<li class="active"><a href="${ctx}/engine/agMachineMechEngine/">吉林省各市州农用动力机统计表列表</a></li>
		<shiro:hasPermission name="engine:agMachineMechEngine:edit"><li><a href="${ctx}/engine/agMachineMechEngine/form">吉林省各市州农用动力机统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agMachineMechEngine" action="${ctx}/engine/agMachineMechEngine/" method="post" class="vus-form-inline form-search">
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
				<th>柴油机</th>
				<th>汽油机</th>
				<th>电动机</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="engine:agMachineMechEngine:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agMachineMechEngine">
			<tr>
				<td><a href="${ctx}/engine/agMachineMechEngine/form?id=${agMachineMechEngine.id}">
					${agMachineMechEngine.org_name}
				</a></td>
				<td>
					${agMachineMechEngine.year}
				</td>
				<td>
					${agMachineMechEngine.diesel_engine}
				</td>
				<td>
					${agMachineMechEngine.gasoline_engine}
				</td>
				<td>
					${agMachineMechEngine.motor}
				</td>
				<td>
					${agMachineMechEngine.update_by}
				</td>
				<td>
					${agMachineMechEngine.update_date}
				</td>
				<shiro:hasPermission name="engine:agMachineMechEngine:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/engine/agMachineMechEngine/form?id=${agMachineMechEngine.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/engine/agMachineMechEngine/delete?id=${agMachineMechEngine.id}" onclick="return confirmx('确认要删除该吉林省各市州农用动力机统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>