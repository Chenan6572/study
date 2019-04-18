<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>1986-2000年吉林省谷子播种面积及产量统计表管理</title>
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
		<li class="active"><a href="${ctx}/millet/fcMilletMilletarea/">1986-2000年吉林省谷子播种面积及产量统计表列表</a></li>
		<shiro:hasPermission name="millet:fcMilletMilletarea:edit"><li><a href="${ctx}/millet/fcMilletMilletarea/form">1986-2000年吉林省谷子播种面积及产量统计表添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="fcMilletMilletarea" action="${ctx}/millet/fcMilletMilletarea/" method="post" class="vus-form-inline form-search">
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
				<th>年度</th>
				<th>播种面积（万亩）</th>
				<th>总产量（万吨）</th>
				<th>亩产量（公斤）</th>
				<th>更新人</th>
				<th>更新时间</th>
				<shiro:hasPermission name="millet:fcMilletMilletarea:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="fcMilletMilletarea">
			<tr>
				<td><a href="${ctx}/millet/fcMilletMilletarea/form?id=${fcMilletMilletarea.id}">
					${fcMilletMilletarea.org_name}
				</a></td>
				<td>
					${fcMilletMilletarea.year}
				</td>
				<td>
					${fcMilletMilletarea.sown_area}
				</td>
				<td>
					${fcMilletMilletarea.output}
				</td>
				<td>
					${fcMilletMilletarea.area_yield}
				</td>
				<td>
					${fcMilletMilletarea.update_by}
				</td>
				<td>
					${fcMilletMilletarea.update_date}
				</td>
				<shiro:hasPermission name="millet:fcMilletMilletarea:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/millet/fcMilletMilletarea/form?id=${fcMilletMilletarea.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/millet/fcMilletMilletarea/delete?id=${fcMilletMilletarea.id}" onclick="return confirmx('确认要删除该1986-2000年吉林省谷子播种面积及产量统计表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>