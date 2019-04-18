<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>农垦外贸出口商品情况统计表管理</title>
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
		<li class="active"><a href="${ctx}/export/agReclamEnterpriseExport/">农垦外贸出口商品情况统计表列表</a></li>
		<shiro:hasPermission name="export:agReclamEnterpriseExport:edit"><li><a href="${ctx}/export/agReclamEnterpriseExport/form">农垦外贸出口商品情况统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agReclamEnterpriseExport" action="${ctx}/export/agReclamEnterpriseExport/" method="post" class="vus-form-inline form-search">
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
				<th>出口商品名称</th>
				<th>计量单位</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="export:agReclamEnterpriseExport:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agReclamEnterpriseExport">
			<tr>
				<td><a href="${ctx}/export/agReclamEnterpriseExport/form?id=${agReclamEnterpriseExport.id}">
					${agReclamEnterpriseExport.org_name}
				</a></td>
				<td>
					${agReclamEnterpriseExport.year}
				</td>
				<td>
					${agReclamEnterpriseExport.commodity}
				</td>
				<td>
					${agReclamEnterpriseExport.measuer}
				</td>
				<td>
					${agReclamEnterpriseExport.update_by}
				</td>
				<td>
					${agReclamEnterpriseExport.update_date}
				</td>
				<shiro:hasPermission name="export:agReclamEnterpriseExport:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/export/agReclamEnterpriseExport/form?id=${agReclamEnterpriseExport.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/export/agReclamEnterpriseExport/delete?id=${agReclamEnterpriseExport.id}" onclick="return confirmx('确认要删除该农垦外贸出口商品情况统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>