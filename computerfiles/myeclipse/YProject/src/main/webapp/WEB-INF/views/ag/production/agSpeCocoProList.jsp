<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省蚕茧生产情况统计管理</title>
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
		<li class="active"><a href="${ctx}/production/agSpeCocoPro/">吉林省蚕茧生产情况统计列表</a></li>
		<shiro:hasPermission name="production:agSpeCocoPro:edit"><li><a href="${ctx}/production/agSpeCocoPro/form">吉林省蚕茧生产情况统计添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agSpeCocoPro" action="${ctx}/production/agSpeCocoPro/" method="post" class="vus-form-inline form-search">
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
				<th>桑蚕茧总产量</th>
				<th>桑园面积（亩）</th>
				<th>柞蚕茧总产量（公斤）</th>
				<th>当年放养面积（亩）</th>
				<th>当年新增面积（亩）</th>
				<th>柞坡面积（亩）</th>
				<th>蚕茧总产量（公斤）</th>
				<th>年份</th>
				<th>城市</th>
				<shiro:hasPermission name="production:agSpeCocoPro:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agSpeCocoPro">
			<tr>
				<td><a href="${ctx}/production/agSpeCocoPro/form?id=${agSpeCocoPro.id}">
					${agSpeCocoPro.update_date}
				</a></td>
				<td>
					${agSpeCocoPro.update_by}
				</td>
				<td>
					${agSpeCocoPro.mulberry_cocoon}
				</td>
				<td>
					${agSpeCocoPro.field_area}
				</td>
				<td>
					${agSpeCocoPro.tussah_cocoon}
				</td>
				<td>
					${agSpeCocoPro.acreage}
				</td>
				<td>
					${agSpeCocoPro.new_area}
				</td>
				<td>
					${agSpeCocoPro.slope_area}
				</td>
				<td>
					${agSpeCocoPro.coc_production}
				</td>
				<td>
					${agSpeCocoPro.year}
				</td>
				<td>
					${agSpeCocoPro.org_name}
				</td>
				<shiro:hasPermission name="production:agSpeCocoPro:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/production/agSpeCocoPro/form?id=${agSpeCocoPro.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/production/agSpeCocoPro/delete?id=${agSpeCocoPro.id}" onclick="return confirmx('确认要删除该吉林省蚕茧生产情况统计吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>