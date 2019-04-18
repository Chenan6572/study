<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>病虫害发生防治面积和农药使用量统计表管理</title>
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
		<li class="active"><a href="${ctx}/yaoxie/agTechnicalProtectionYaoxie/">病虫害发生防治面积和农药使用量统计表列表</a></li>
		<shiro:hasPermission name="yaoxie:agTechnicalProtectionYaoxie:edit"><li><a href="${ctx}/yaoxie/agTechnicalProtectionYaoxie/form">病虫害发生防治面积和农药使用量统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agTechnicalProtectionYaoxie" action="${ctx}/yaoxie/agTechnicalProtectionYaoxie/" method="post" class="vus-form-inline form-search">
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
				<th>病虫害发生面积（万亩次）</th>
				<th>防治面积（万亩次）</th>
				<th>农药使用量（吨）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="yaoxie:agTechnicalProtectionYaoxie:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agTechnicalProtectionYaoxie">
			<tr>
				<td><a href="${ctx}/yaoxie/agTechnicalProtectionYaoxie/form?id=${agTechnicalProtectionYaoxie.id}">
					${agTechnicalProtectionYaoxie.org_name}
				</a></td>
				<td>
					${agTechnicalProtectionYaoxie.year}
				</td>
				<td>
					${agTechnicalProtectionYaoxie.disease}
				</td>
				<td>
					${agTechnicalProtectionYaoxie.prevention}
				</td>
				<td>
					${agTechnicalProtectionYaoxie.pesticide}
				</td>
				<td>
					${agTechnicalProtectionYaoxie.update_by}
				</td>
				<td>
					${agTechnicalProtectionYaoxie.update_date}
				</td>
				<shiro:hasPermission name="yaoxie:agTechnicalProtectionYaoxie:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/yaoxie/agTechnicalProtectionYaoxie/form?id=${agTechnicalProtectionYaoxie.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/yaoxie/agTechnicalProtectionYaoxie/delete?id=${agTechnicalProtectionYaoxie.id}" onclick="return confirmx('确认要删除该病虫害发生防治面积和农药使用量统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>