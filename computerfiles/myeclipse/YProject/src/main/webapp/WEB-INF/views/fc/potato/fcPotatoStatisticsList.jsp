<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>2000年吉林省各市县马铃薯统计表管理</title>
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
		<li class="active"><a href="${ctx}/potato/fcPotatoStatistics/">2000年吉林省各市县马铃薯统计表列表</a></li>
		<shiro:hasPermission name="potato:fcPotatoStatistics:edit"><li><a href="${ctx}/potato/fcPotatoStatistics/form">2000年吉林省各市县马铃薯统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="fcPotatoStatistics" action="${ctx}/potato/fcPotatoStatistics/" method="post" class="vus-form-inline form-search">
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
				<th>播种面积（万亩）</th>
				<th>总产量（万吨）</th>
				<th>亩单产（公斤）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="potato:fcPotatoStatistics:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="fcPotatoStatistics">
			<tr>
				<td><a href="${ctx}/potato/fcPotatoStatistics/form?id=${fcPotatoStatistics.id}">
					${fcPotatoStatistics.org_name}
				</a></td>
				<td>
					${fcPotatoStatistics.area_sown}
				</td>
				<td>
					${fcPotatoStatistics.total_output}
				</td>
				<td>
					${fcPotatoStatistics.mu_yield}
				</td>
				<td>
					${fcPotatoStatistics.update_by}
				</td>
				<td>
					${fcPotatoStatistics.update_time}
				</td>
				<shiro:hasPermission name="potato:fcPotatoStatistics:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/potato/fcPotatoStatistics/form?id=${fcPotatoStatistics.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/potato/fcPotatoStatistics/delete?id=${fcPotatoStatistics.id}" onclick="return confirmx('确认要删除该2000年吉林省各市县马铃薯统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>