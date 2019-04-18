<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>苹果主要病虫害防治一览表管理</title>
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
		<li class="active"><a href="${ctx}/apple/agHorticulTreesDiseases/">苹果主要病虫害防治一览表列表</a></li>
		<shiro:hasPermission name="apple:agHorticulTreesDiseases:edit"><li><a href="${ctx}/apple/agHorticulTreesDiseases/form">苹果主要病虫害防治一览表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agHorticulTreesDiseases" action="${ctx}/apple/agHorticulTreesDiseases/" method="post" class="vus-form-inline form-search">
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
				<th>年份</th>
				<th>地区</th>
				<th>品种</th>
				<th>防治时期</th>
				<th>防治对象</th>
				<th>防治措施</th>
				<th>更新人</th>
				<th>更新日期</th>
				<shiro:hasPermission name="apple:agHorticulTreesDiseases:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agHorticulTreesDiseases">
			<tr>
				<td><a href="${ctx}/apple/agHorticulTreesDiseases/form?id=${agHorticulTreesDiseases.id}">
					${agHorticulTreesDiseases.year}
				</a></td>
				<td>
					${agHorticulTreesDiseases.org_name}
				</td>
				<td>
					${agHorticulTreesDiseases.varieties}
				</td>
				<td>
					${agHorticulTreesDiseases.prevention_time}
				</td>
				<td>
					${agHorticulTreesDiseases.prevention_treat}
				</td>
				<td>
					${agHorticulTreesDiseases.prevention_methods}
				</td>
				<td>
					${agHorticulTreesDiseases.updata_by}
				</td>
				<td>
					${agHorticulTreesDiseases.updata_date}
				</td>
				<shiro:hasPermission name="apple:agHorticulTreesDiseases:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/apple/agHorticulTreesDiseases/form?id=${agHorticulTreesDiseases.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/apple/agHorticulTreesDiseases/delete?id=${agHorticulTreesDiseases.id}" onclick="return confirmx('确认要删除该苹果主要病虫害防治一览表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>