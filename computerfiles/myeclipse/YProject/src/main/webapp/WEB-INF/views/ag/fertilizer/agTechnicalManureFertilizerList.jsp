<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>农业化肥施用量统计表管理</title>
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
		<li class="active"><a href="${ctx}/fertilizer/agTechnicalManureFertilizer/">农业化肥施用量统计表列表</a></li>
		<shiro:hasPermission name="fertilizer:agTechnicalManureFertilizer:edit"><li><a href="${ctx}/fertilizer/agTechnicalManureFertilizer/form">农业化肥施用量统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agTechnicalManureFertilizer" action="${ctx}/fertilizer/agTechnicalManureFertilizer/" method="post" class="vus-form-inline form-search">
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
				<th>城市</th>
				<th>年份</th>
				<th>实物量合计（万吨）</th>
				<th>折纯量合计（万吨）</th>
				<th>施肥方式</th>
				<th>氮肥（万吨）</th>
				<th>磷肥（万吨）</th>
				<th>钾肥（万吨）</th>
				<th>复合肥（万吨）</th>
				<th>亩均施化肥量（万吨）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="fertilizer:agTechnicalManureFertilizer:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agTechnicalManureFertilizer">
			<tr>
				<td><a href="${ctx}/fertilizer/agTechnicalManureFertilizer/form?id=${agTechnicalManureFertilizer.id}">
					${agTechnicalManureFertilizer.org_name}
				</a></td>
				<td>
					${agTechnicalManureFertilizer.year}
				</td>
				<td>
					${agTechnicalManureFertilizer.total_physical}
				</td>
				<td>
					${agTechnicalManureFertilizer.total_refractive}
				</td>
				<td>
					${agTechnicalManureFertilizer.way}
				</td>
				<td>
					${agTechnicalManureFertilizer.nitrogen}
				</td>
				<td>
					${agTechnicalManureFertilizer.phosphate}
				</td>
				<td>
					${agTechnicalManureFertilizer.potash}
				</td>
				<td>
					${agTechnicalManureFertilizer.compound}
				</td>
				<td>
					${agTechnicalManureFertilizer.per_mu}
				</td>
				<td>
					${agTechnicalManureFertilizer.update_by}
				</td>
				<td>
					${agTechnicalManureFertilizer.update_date}
				</td>
				<shiro:hasPermission name="fertilizer:agTechnicalManureFertilizer:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/fertilizer/agTechnicalManureFertilizer/form?id=${agTechnicalManureFertilizer.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/fertilizer/agTechnicalManureFertilizer/delete?id=${agTechnicalManureFertilizer.id}" onclick="return confirmx('确认要删除该农业化肥施用量统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>