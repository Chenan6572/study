<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>农垦企业畜牧业生产情况统计表管理</title>
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
		<li class="active"><a href="${ctx}/husbandry/agReclamhusbandry/">农垦企业畜牧业生产情况统计表列表</a></li>
		<shiro:hasPermission name="husbandry:agReclamhusbandry:edit"><li><a href="${ctx}/husbandry/agReclamhusbandry/form">农垦企业畜牧业生产情况统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agReclamhusbandry" action="${ctx}/husbandry/agReclamhusbandry/" method="post" class="vus-form-inline form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>区域（城市）：</label>
				<form:input path="org_name" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>年份：</label>
				<form:input path="year" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="vus-btn v-outline v--info" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="vus-table">
			<tr>
				<th>区域（城市）</th>
				<th>年份</th>
				<th>业种类</th>
				<th>大牲畜</th>
				<th>牛（万头）</th>
				<th>猪（万头）</th>
				<th>羊（万头）</th>
				<th>鹿（万头）</th>
				<th>肉类（吨）</th>
				<th>牛奶（吨）</th>
				<th>禽蛋（吨）</th>
				<th>鹿茸（公斤）</th>
				<shiro:hasPermission name="husbandry:agReclamhusbandry:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agReclamhusbandry">
			<tr>
				<td><a href="${ctx}/husbandry/agReclamhusbandry/form?id=${agReclamhusbandry.id}">
					${agReclamhusbandry.org_name}
				</a></td>
				<td>
					${agReclamhusbandry.year}
				</td>
				<td>
					${agReclamhusbandry.varieties}
				</td>
				<td>
					${agReclamhusbandry.livestock}
				</td>
				<td>
					${agReclamhusbandry.cow}
				</td>
				<td>
					${agReclamhusbandry.pig}
				</td>
				<td>
					${agReclamhusbandry.goat}
				</td>
				<td>
					${agReclamhusbandry.deer}
				</td>
				<td>
					${agReclamhusbandry.meat}
				</td>
				<td>
					${agReclamhusbandry.milk}
				</td>
				<td>
					${agReclamhusbandry.eggs}
				</td>
				<td>
					${agReclamhusbandry.antler}
				</td>
				<shiro:hasPermission name="husbandry:agReclamhusbandry:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/husbandry/agReclamhusbandry/form?id=${agReclamhusbandry.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/husbandry/agReclamhusbandry/delete?id=${agReclamhusbandry.id}" onclick="return confirmx('确认要删除该农垦企业畜牧业生产情况统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>