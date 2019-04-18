<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>2000年吉林省国有鹿场情况明细表管理</title>
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
		<li class="active"><a href="${ctx}/deer/agReclamScaleDeer/">2000年吉林省国有鹿场情况明细表列表</a></li>
		<shiro:hasPermission name="deer:agReclamScaleDeer:edit"><li><a href="${ctx}/deer/agReclamScaleDeer/form">2000年吉林省国有鹿场情况明细表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agReclamScaleDeer" action="${ctx}/deer/agReclamScaleDeer/" method="post" class="vus-form-inline form-search">
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
				<th>场名</th>
				<th>隶属关系</th>
				<th>社会从业人数（人）</th>
				<th>人口（人）</th>
				<th>鹿（头）</th>
				<th>鹿茸产量（公斤）</th>
				<th>年人均纯收入（元）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="deer:agReclamScaleDeer:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agReclamScaleDeer">
			<tr>
				<td><a href="${ctx}/deer/agReclamScaleDeer/form?id=${agReclamScaleDeer.id}">
					${agReclamScaleDeer.org_name}
				</a></td>
				<td>
					${agReclamScaleDeer.year}
				</td>
				<td>
					${agReclamScaleDeer.area}
				</td>
				<td>
					${agReclamScaleDeer.ftree_area}
				</td>
				<td>
					${agReclamScaleDeer.ftree_out}
				</td>
				<td>
					${agReclamScaleDeer.population}
				</td>
				<td>
					${agReclamScaleDeer.deer}
				</td>
				<td>
					${agReclamScaleDeer.velvet}
				</td>
				<td>
					${agReclamScaleDeer.income}
				</td>
				<td>
					${agReclamScaleDeer.update_by}
				</td>
				<td>
					${agReclamScaleDeer.update_date}
				</td>
				<shiro:hasPermission name="deer:agReclamScaleDeer:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/deer/agReclamScaleDeer/form?id=${agReclamScaleDeer.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/deer/agReclamScaleDeer/delete?id=${agReclamScaleDeer.id}" onclick="return confirmx('确认要删除该2000年吉林省国有鹿场情况明细表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>