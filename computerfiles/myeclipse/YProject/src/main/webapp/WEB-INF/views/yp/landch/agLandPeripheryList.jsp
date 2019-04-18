<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>土地利用信息管理</title>
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
		<li class="active"><a href="${ctx}/landch/agLandPeriphery/">土地利用信息列表</a></li>
		<shiro:hasPermission name="landch:agLandPeriphery:edit"><li><a href="${ctx}/landch/agLandPeriphery/form">土地利用信息添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agLandPeriphery" action="${ctx}/landch/agLandPeriphery/" method="post" class="vus-form-inline form-search">
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
				<th>城市</th>
				<th>年份</th>
				<th>增减</th>
				<th>合计</th>
				<th>有林地</th>
				<th>其他林地</th>
				<th>林草小计</th>
				<th>水域</th>
				<th>城镇</th>
				<th>农村居民地</th>
				<th>水田</th>
				<th>旱田</th>
				<th>耕地小计</th>
				<th>未利用地</th>
				<th>草地</th>
				<th>沼泽地</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="landch:agLandPeriphery:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agLandPeriphery">
			<tr>
				<td><a href="${ctx}/landch/agLandPeriphery/form?id=${agLandPeriphery.id}">
					${agLandPeriphery.org_name}
				</a></td>
				<td>
					${agLandPeriphery.year}
				</td>
				<td>
					${agLandPeriphery.increase_od}
				</td>
				<td>
					${agLandPeriphery.sum}
				</td>
				<td>
					${agLandPeriphery.forestland}
				</td>
				<td>
					${agLandPeriphery.other_fd}
				</td>
				<td>
					${agLandPeriphery.forest_gp}
				</td>
				<td>
					${agLandPeriphery.waters}
				</td>
				<td>
					${agLandPeriphery.town}
				</td>
				<td>
					${agLandPeriphery.rural_residential}
				</td>
				<td>
					${agLandPeriphery.paddy_field}
				</td>
				<td>
					${agLandPeriphery.dry_farmland}
				</td>
				<td>
					${agLandPeriphery.cultivated_land}
				</td>
				<td>
					${agLandPeriphery.unused_land}
				</td>
				<td>
					${agLandPeriphery.grassland}
				</td>
				<td>
					${agLandPeriphery.marshland}
				</td>
				<td>
					${agLandPeriphery.update_by}
				</td>
				<td>
					${agLandPeriphery.update_date}
				</td>
				<shiro:hasPermission name="landch:agLandPeriphery:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/landch/agLandPeriphery/form?id=${agLandPeriphery.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/landch/agLandPeriphery/delete?id=${agLandPeriphery.id}" onclick="return confirmx('确认要删除该土地利用信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>