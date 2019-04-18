<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>1986-2000年吉林省水稻面积产量统计信息表管理</title>
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
		<li class="active"><a href="${ctx}/rice/fcRiceProduction/">1986-2000年吉林省水稻面积产量统计信息表列表</a></li>
		<shiro:hasPermission name="rice:fcRiceProduction:edit"><li><a href="${ctx}/rice/fcRiceProduction/form">1986-2000年吉林省水稻面积产量统计信息表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="fcRiceProduction" action="${ctx}/rice/fcRiceProduction/" method="post" class="vus-form-inline form-search">
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
				<th>亩产量</th>
				<th>面积（万亩）</th>
				<th>总产量（万吨）</th>
				<th>年份</th>
				<shiro:hasPermission name="rice:fcRiceProduction:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="fcRiceProduction">
			<tr>
				<td><a href="${ctx}/rice/fcRiceProduction/form?id=${fcRiceProduction.id}">
					${fcRiceProduction.update_date}
				</a></td>
				<td>
					${fcRiceProduction.update_by}
				</td>
				<td>
					${fcRiceProduction.area_yield}
				</td>
				<td>
					${fcRiceProduction.area}
				</td>
				<td>
					${fcRiceProduction.total_output}
				</td>
				<td>
					${fcRiceProduction.year}
				</td>
				<shiro:hasPermission name="rice:fcRiceProduction:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/rice/fcRiceProduction/form?id=${fcRiceProduction.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/rice/fcRiceProduction/delete?id=${fcRiceProduction.id}" onclick="return confirmx('确认要删除该1986-2000年吉林省水稻面积产量统计信息表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>