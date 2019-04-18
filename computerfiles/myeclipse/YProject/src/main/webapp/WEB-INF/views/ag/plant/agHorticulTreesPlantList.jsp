<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省果树栽植情况统计表管理</title>
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
		<li class="active"><a href="${ctx}/plant/agHorticulTreesPlant/">吉林省果树栽植情况统计表列表</a></li>
		<shiro:hasPermission name="plant:agHorticulTreesPlant:edit"><li><a href="${ctx}/plant/agHorticulTreesPlant/form">吉林省果树栽植情况统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agHorticulTreesPlant" action="${ctx}/plant/agHorticulTreesPlant/" method="post" class="vus-form-inline form-search">
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
				<th>更新时间</th>
				<th>更新人</th>
				<th>与1985年比较增减</th>
				<th>水果总产量(万吨)</th>
				<th>栽植面积（万亩）</th>
				<th>年份</th>
				<th>区域（城市）</th>
				<shiro:hasPermission name="plant:agHorticulTreesPlant:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agHorticulTreesPlant">
			<tr>
				<td><a href="${ctx}/plant/agHorticulTreesPlant/form?id=${agHorticulTreesPlant.id}">
					${agHorticulTreesPlant.update_date}
				</a></td>
				<td>
					${agHorticulTreesPlant.update_by}
				</td>
				<td>
					${agHorticulTreesPlant.inorde}
				</td>
				<td>
					${agHorticulTreesPlant.fruit_production}
				</td>
				<td>
					${agHorticulTreesPlant.area}
				</td>
				<td>
					${agHorticulTreesPlant.year}
				</td>
				<td>
					${agHorticulTreesPlant.org_name}
				</td>
				<shiro:hasPermission name="plant:agHorticulTreesPlant:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/plant/agHorticulTreesPlant/form?id=${agHorticulTreesPlant.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/plant/agHorticulTreesPlant/delete?id=${agHorticulTreesPlant.id}" onclick="return confirmx('确认要删除该吉林省果树栽植情况统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>