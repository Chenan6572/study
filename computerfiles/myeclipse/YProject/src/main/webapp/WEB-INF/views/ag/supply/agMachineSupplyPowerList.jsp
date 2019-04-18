<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>农机供应系统排灌动力机械统计表管理</title>
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
		<li class="active"><a href="${ctx}/supply/agMachineSupplyPower/">农机供应系统排灌动力机械统计表列表</a></li>
		<shiro:hasPermission name="supply:agMachineSupplyPower:edit"><li><a href="${ctx}/supply/agMachineSupplyPower/form">农机供应系统排灌动力机械统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agMachineSupplyPower" action="${ctx}/supply/agMachineSupplyPower/" method="post" class="vus-form-inline form-search">
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
				<th>柴油机（台）</th>
				<th>汽油机（台）</th>
				<th>电动机（台）</th>
				<th>大泵（台）</th>
				<th>深井泵（台）</th>
				<th>纯购进（万元）</th>
				<th>纯销售（万元）</th>
				<th>年末库存（万元）</th>
				<th>经营利润（万元）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="supply:agMachineSupplyPower:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agMachineSupplyPower">
			<tr>
				<td><a href="${ctx}/supply/agMachineSupplyPower/form?id=${agMachineSupplyPower.id}">
					${agMachineSupplyPower.org_name}
				</a></td>
				<td>
					${agMachineSupplyPower.year}
				</td>
				<td>
					${agMachineSupplyPower.diesel_engine}
				</td>
				<td>
					${agMachineSupplyPower.gasoline_engine}
				</td>
				<td>
					${agMachineSupplyPower.motor}
				</td>
				<td>
					${agMachineSupplyPower.large_pump}
				</td>
				<td>
					${agMachineSupplyPower.deep_pump}
				</td>
				<td>
					${agMachineSupplyPower.purchases}
				</td>
				<td>
					${agMachineSupplyPower.sales}
				</td>
				<td>
					${agMachineSupplyPower.inventory}
				</td>
				<td>
					${agMachineSupplyPower.operating}
				</td>
				<td>
					${agMachineSupplyPower.update_by}
				</td>
				<td>
					${agMachineSupplyPower.update_date}
				</td>
				<shiro:hasPermission name="supply:agMachineSupplyPower:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/supply/agMachineSupplyPower/form?id=${agMachineSupplyPower.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/supply/agMachineSupplyPower/delete?id=${agMachineSupplyPower.id}" onclick="return confirmx('确认要删除该农机供应系统排灌动力机械统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>