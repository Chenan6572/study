<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>农委（农业厅）指数事业单位编制统计表管理</title>
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
		<li class="active"><a href="${ctx}/compile/agManageProvenceCompile/">农委（农业厅）指数事业单位编制统计表列表</a></li>
		<shiro:hasPermission name="compile:agManageProvenceCompile:edit"><li><a href="${ctx}/compile/agManageProvenceCompile/form">农委（农业厅）指数事业单位编制统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agManageProvenceCompile" action="${ctx}/compile/agManageProvenceCompile/" method="post" class="vus-form-inline form-search">
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
				<th>单位名称</th>
				<th>年份</th>
				<th>编制（1986年）</th>
				<th>编制（2000年）</th>
				<th>实有</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="compile:agManageProvenceCompile:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agManageProvenceCompile">
			<tr>
				<td><a href="${ctx}/compile/agManageProvenceCompile/form?id=${agManageProvenceCompile.id}">
					${agManageProvenceCompile.org_name}
				</a></td>
				<td>
					${agManageProvenceCompile.name_entity}
				</td>
				<td>
					${agManageProvenceCompile.year}
				</td>
				<td>
					${agManageProvenceCompile.compile_one}
				</td>
				<td>
					${agManageProvenceCompile.compile_two}
				</td>
				<td>
					${agManageProvenceCompile.ftree_out}
				</td>
				<td>
					${agManageProvenceCompile.update_by}
				</td>
				<td>
					${agManageProvenceCompile.update_date}
				</td>
				<shiro:hasPermission name="compile:agManageProvenceCompile:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/compile/agManageProvenceCompile/form?id=${agManageProvenceCompile.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/compile/agManageProvenceCompile/delete?id=${agManageProvenceCompile.id}" onclick="return confirmx('确认要删除该农委（农业厅）指数事业单位编制统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>