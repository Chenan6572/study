<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省重点建设农垦工业企业情况统计表管理</title>
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
		<li class="active"><a href="${ctx}/main/agReclamEnterprisesMain/">吉林省重点建设农垦工业企业情况统计表列表</a></li>
		<shiro:hasPermission name="main:agReclamEnterprisesMain:edit"><li><a href="${ctx}/main/agReclamEnterprisesMain/form">吉林省重点建设农垦工业企业情况统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agReclamEnterprisesMain" action="${ctx}/main/agReclamEnterprisesMain/" method="post" class="vus-form-inline form-search">
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
				<th>项目</th>
				<th>建设地点</th>
				<th>建设规模</th>
				<th>建设年限</th>
				<th>资金来源</th>
				<th>总投资</th>
				<th>计划</th>
				<th>实际</th>
				<th>产值</th>
				<th>利润</th>
				<th>税金</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="main:agReclamEnterprisesMain:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agReclamEnterprisesMain">
			<tr>
				<td><a href="${ctx}/main/agReclamEnterprisesMain/form?id=${agReclamEnterprisesMain.id}">
					${agReclamEnterprisesMain.year}
				</a></td>
				<td>
					${agReclamEnterprisesMain.project}
				</td>
				<td>
					${agReclamEnterprisesMain.org_name}
				</td>
				<td>
					${agReclamEnterprisesMain.scale}
				</td>
				<td>
					${agReclamEnterprisesMain.fixed}
				</td>
				<td>
					${agReclamEnterprisesMain.source}
				</td>
				<td>
					${agReclamEnterprisesMain.investment}
				</td>
				<td>
					${agReclamEnterprisesMain.plan}
				</td>
				<td>
					${agReclamEnterprisesMain.actual}
				</td>
				<td>
					${agReclamEnterprisesMain.output}
				</td>
				<td>
					${agReclamEnterprisesMain.profits}
				</td>
				<td>
					${agReclamEnterprisesMain.tax}
				</td>
				<td>
					${agReclamEnterprisesMain.update_by}
				</td>
				<td>
					${agReclamEnterprisesMain.update_date}
				</td>
				<shiro:hasPermission name="main:agReclamEnterprisesMain:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/main/agReclamEnterprisesMain/form?id=${agReclamEnterprisesMain.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/main/agReclamEnterprisesMain/delete?id=${agReclamEnterprisesMain.id}" onclick="return confirmx('确认要删除该吉林省重点建设农垦工业企业情况统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>