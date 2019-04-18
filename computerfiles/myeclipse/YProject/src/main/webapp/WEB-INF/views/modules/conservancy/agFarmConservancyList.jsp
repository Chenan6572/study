<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>水利治理信息管理</title>
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
		<li class="active"><a href="${ctx}/conservancy/agFarmConservancy/">水利治理信息列表</a></li>
		<shiro:hasPermission name="conservancy:agFarmConservancy:edit"><li><a href="${ctx}/conservancy/agFarmConservancy/form">水利治理信息添加</a></li></shiro:hasPermission>
	</ul>
	<div class="form-arrow">
		<div class="arrow-down"></div>
	</div>
	<form:form id="searchForm" modelAttribute="agFarmConservancy" action="${ctx}/conservancy/agFarmConservancy/" method="post" class="vus-form-inline form-search">
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
				<th>占盐碱耕地面积的比重（%）</th>
				<th>盐碱耕地改良面积</th>
				<th>盐碱耕地面积</th>
				<th>除涝面积</th>
				<th>占易涝面积的比重（%）</th>
				<th>易涝面积</th>
				<th>小流域治理面积</th>
				<th>占水土流失面积比重（%）</th>
				<th>当年造林面积</th>
				<th>水土流失面积</th>
				<th>年度</th>
				<shiro:hasPermission name="conservancy:agFarmConservancy:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		<c:forEach items="${page.list}" var="agFarmConservancy">
			<tr>
				<td><a href="${ctx}/conservancy/agFarmConservancy/form?id=${agFarmConservancy.id}">
					${agFarmConservancy.update_date}
				</a></td>
				<td>
					${agFarmConservancy.update_by}
				</td>
				<td>
					${agFarmConservancy.proportion_saline_alkali}
				</td>
				<td>
					${agFarmConservancy.saline_alkali_cultivated}
				</td>
				<td>
					${agFarmConservancy.saline_alkali}
				</td>
				<td>
					${agFarmConservancy.waterlogged}
				</td>
				<td>
					${agFarmConservancy.proportion_waterlogged}
				</td>
				<td>
					${agFarmConservancy.flood}
				</td>
				<td>
					${agFarmConservancy.small_watershed}
				</td>
				<td>
					${agFarmConservancy.proportion_soil}
				</td>
				<td>
					${agFarmConservancy.annual_afforestation}
				</td>
				<td>
					${agFarmConservancy.soil_erosion}
				</td>
				<td>
					${agFarmConservancy.year}
				</td>
				<shiro:hasPermission name="conservancy:agFarmConservancy:edit"><td>
    				<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/conservancy/agFarmConservancy/form?id=${agFarmConservancy.id}">修改</a>
					<a class="vus-btn v-outline v--primary" style="font-size: 12px;" href="${ctx}/conservancy/agFarmConservancy/delete?id=${agFarmConservancy.id}" onclick="return confirmx('确认要删除该水利治理信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>