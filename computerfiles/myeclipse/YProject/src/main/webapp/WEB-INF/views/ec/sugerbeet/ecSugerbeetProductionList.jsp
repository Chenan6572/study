<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>1986-2000年吉林省甜菜生产统计表管理</title>
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
		<li class="active"><a href="${ctx}/sugerbeet/ecSugerbeetProduction/">1986-2000年吉林省甜菜生产统计表列表</a></li>
		<shiro:hasPermission name="sugerbeet:ecSugerbeetProduction:edit"><li><a href="${ctx}/sugerbeet/ecSugerbeetProduction/form">1986-2000年吉林省甜菜生产统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="ecSugerbeetProduction" action="${ctx}/sugerbeet/ecSugerbeetProduction/" method="post" class="vus-form-inline form-search">
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
				<th>地区</th>
				<th>年份</th>
				<th>播种面积（万亩）</th>
				<th>总产量（万吨）</th>
				<th>平均亩产（公斤）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="sugerbeet:ecSugerbeetProduction:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="ecSugerbeetProduction">
			<tr>
				<td><a href="${ctx}/sugerbeet/ecSugerbeetProduction/form?id=${ecSugerbeetProduction.id}">
					${ecSugerbeetProduction.org_name}
				</a></td>
				<td>
					${ecSugerbeetProduction.year}
				</td>
				<td>
					${ecSugerbeetProduction.area_sown}
				</td>
				<td>
					${ecSugerbeetProduction.total_output}
				</td>
				<td>
					${ecSugerbeetProduction.mu_yield}
				</td>
				<td>
					${ecSugerbeetProduction.update_by}
				</td>
				<td>
					${ecSugerbeetProduction.update_time}
				</td>
				<shiro:hasPermission name="sugerbeet:ecSugerbeetProduction:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/sugerbeet/ecSugerbeetProduction/form?id=${ecSugerbeetProduction.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/sugerbeet/ecSugerbeetProduction/delete?id=${ecSugerbeetProduction.id}" onclick="return confirmx('确认要删除该1986-2000年吉林省甜菜生产统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>