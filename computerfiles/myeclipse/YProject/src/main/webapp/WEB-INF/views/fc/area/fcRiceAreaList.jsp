<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>吉林省水稻分区面积统计表管理</title>
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
		<li class="active"><a href="${ctx}/area/fcRiceArea/">吉林省水稻分区面积统计表列表</a></li>
		<shiro:hasPermission name="area:fcRiceArea:edit"><li><a href="${ctx}/area/fcRiceArea/form">吉林省水稻分区面积统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="fcRiceArea" action="${ctx}/area/fcRiceArea/" method="post" class="vus-form-inline form-search">
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
				<th>西部合计</th>
				<th>西部</th>
				<th>中部合计</th>
				<th>中部</th>
				<th>东部合计</th>
				<th>东部</th>
				<th>全省合计</th>
				<th>全省</th>
				<th>年份</th>
				<th>区域</th>
				<shiro:hasPermission name="area:fcRiceArea:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="fcRiceArea">
			<tr>
				<td><a href="${ctx}/area/fcRiceArea/form?id=${fcRiceArea.id}">
					${fcRiceArea.update_date}
				</a></td>
				<td>
					${fcRiceArea.update_by}
				</td>
				<td>
					${fcRiceArea.west_sum}
				</td>
				<td>
					${fcRiceArea.west}
				</td>
				<td>
					${fcRiceArea.middle_sum}
				</td>
				<td>
					${fcRiceArea.middle}
				</td>
				<td>
					${fcRiceArea.east_sum}
				</td>
				<td>
					${fcRiceArea.east}
				</td>
				<td>
					${fcRiceArea.province_sum}
				</td>
				<td>
					${fcRiceArea.province}
				</td>
				<td>
					${fcRiceArea.year}
				</td>
				<td>
					${fcRiceArea.area}
				</td>
				<shiro:hasPermission name="area:fcRiceArea:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/area/fcRiceArea/form?id=${fcRiceArea.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/area/fcRiceArea/delete?id=${fcRiceArea.id}" onclick="return confirmx('确认要删除该吉林省水稻分区面积统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>