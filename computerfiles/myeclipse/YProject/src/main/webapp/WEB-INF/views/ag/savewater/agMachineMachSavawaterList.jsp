<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>机械化节水保墒栽培技术项目完成情况统计表管理</title>
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
		<li class="active"><a href="${ctx}/savewater/agMachineMachSavawater/">机械化节水保墒栽培技术项目完成情况统计表列表</a></li>
		<shiro:hasPermission name="savewater:agMachineMachSavawater:edit"><li><a href="${ctx}/savewater/agMachineMachSavawater/form">机械化节水保墒栽培技术项目完成情况统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agMachineMachSavawater" action="${ctx}/savewater/agMachineMachSavawater/" method="post" class="vus-form-inline form-search">
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
				<th>计划面积（万亩）</th>
				<th>完成面积（万亩）</th>
				<th>投入机具（万台）</th>
				<th>亩均增产（公斤）</th>
				<th>新增总产（公斤）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="savewater:agMachineMachSavawater:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agMachineMachSavawater">
			<tr>
				<td><a href="${ctx}/savewater/agMachineMachSavawater/form?id=${agMachineMachSavawater.id}">
					${agMachineMachSavawater.org_name}
				</a></td>
				<td>
					${agMachineMachSavawater.year}
				</td>
				<td>
					${agMachineMachSavawater.plan_area}
				</td>
				<td>
					${agMachineMachSavawater.fin_area}
				</td>
				<td>
					${agMachineMachSavawater.machine}
				</td>
				<td>
					${agMachineMachSavawater.acre_increase}
				</td>
				<td>
					${agMachineMachSavawater.new_total}
				</td>
				<td>
					${agMachineMachSavawater.update_by}
				</td>
				<td>
					${agMachineMachSavawater.update_date}
				</td>
				<shiro:hasPermission name="savewater:agMachineMachSavawater:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/savewater/agMachineMachSavawater/form?id=${agMachineMachSavawater.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/savewater/agMachineMachSavawater/delete?id=${agMachineMachSavawater.id}" onclick="return confirmx('确认要删除该机械化节水保墒栽培技术项目完成情况统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>