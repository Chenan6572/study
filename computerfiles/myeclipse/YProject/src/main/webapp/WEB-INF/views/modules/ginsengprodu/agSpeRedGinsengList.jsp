<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人（园）参生产情况管理</title>
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
		<li class="active"><a href="${ctx}/ginsengprodu/agSpeRedGinseng/">人（园）参生产情况列表</a></li>
		<shiro:hasPermission name="ginsengprodu:agSpeRedGinseng:edit"><li><a href="${ctx}/ginsengprodu/agSpeRedGinseng/form">人（园）参生产情况添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agSpeRedGinseng" action="${ctx}/ginsengprodu/agSpeRedGinseng/" method="post" class="vus-form-inline form-search">
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
				<th>品种</th>
				<th>品名</th>
				<th>规格及等级</th>
				<th>价格</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="ginsengprodu:agSpeRedGinseng:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agSpeRedGinseng">
			<tr>
				<td><a href="${ctx}/ginsengprodu/agSpeRedGinseng/form?id=${agSpeRedGinseng.id}">
					${agSpeRedGinseng.org_name}
				</a></td>
				<td>
					${agSpeRedGinseng.year}
				</td>
				<td>
					${agSpeRedGinseng.varieties}
				</td>
				<td>
					${agSpeRedGinseng.goods}
				</td>
				<td>
					${agSpeRedGinseng.specifications_grades}
				</td>
				<td>
					${agSpeRedGinseng.price}
				</td>
				<td>
					${agSpeRedGinseng.update_by}
				</td>
				<td>
					${agSpeRedGinseng.update_date}
				</td>
				<shiro:hasPermission name="ginsengprodu:agSpeRedGinseng:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/ginsengprodu/agSpeRedGinseng/form?id=${agSpeRedGinseng.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/ginsengprodu/agSpeRedGinseng/delete?id=${agSpeRedGinseng.id}" onclick="return confirmx('确认要删除该人（园）参生产情况吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>