<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省黑木耳产量统计表管理</title>
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
		<li class="active"><a href="${ctx}/blackfungus/agSpeFungusBlack/">吉林省黑木耳产量统计表列表</a></li>
		<shiro:hasPermission name="blackfungus:agSpeFungusBlack:edit"><li><a href="${ctx}/blackfungus/agSpeFungusBlack/form">吉林省黑木耳产量统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agSpeFungusBlack" action="${ctx}/blackfungus/agSpeFungusBlack/" method="post" class="vus-form-inline form-search">
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
				<th>城市</th>
				<th>总产量（吨）</th>
				<th>产量（吨）</th>
				<th>操作人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="blackfungus:agSpeFungusBlack:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agSpeFungusBlack">
			<tr>
				<td><a href="${ctx}/blackfungus/agSpeFungusBlack/form?id=${agSpeFungusBlack.id}">
					${agSpeFungusBlack.year}
				</a></td>
				<td>
					${agSpeFungusBlack.org_name}
				</td>
				<td>
					${agSpeFungusBlack.total_ou}
				</td>
				<td>
					${agSpeFungusBlack.production}
				</td>
				<td>
					${agSpeFungusBlack.update_by}
				</td>
				<td>
					${agSpeFungusBlack.update_date}
				</td>
				<shiro:hasPermission name="blackfungus:agSpeFungusBlack:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/blackfungus/agSpeFungusBlack/form?id=${agSpeFungusBlack.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/blackfungus/agSpeFungusBlack/delete?id=${agSpeFungusBlack.id}" onclick="return confirmx('确认要删除该吉林省黑木耳产量统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>