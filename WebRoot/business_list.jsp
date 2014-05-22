<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<title>My JSP 'ListAllCharges.jsp' starting page</title>
		<style>
a {
	text-decoration: none
}
</style>
		<link href="style/stylet.css"
			rel="stylesheet" type="text/css">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
    	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!--
	查询所有操作员
	-->

		<style type="text/css">
<!--
.STYLE3 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>

		<script type="text/javascript">
	function confirmDel(){
		if(confirm("确认删除？")){
			return true;
		}else{
			return false;
		}
	}	
	
	function checkMsg(){
	var Business_Name = document.getElementById("Business_Name").value;
	var Business_ID = document.getElementById("Business_ID").value;
	if(Business_Name==""&& Business_ID ==""){
		alert("业务名称与编号不能全部为空！");
		return false;
	}
	}
</script>
	</head>
	<body link="#73A822" alink="#73A822" vlink="#73A822">
		<font size="2">您现在的位置：>><a href="BusinessList">业务列表</a></font>
		<hr>
		<div align="center">
			<form action="BusinessList" method="POST" onSubmit="return checkMsg();">
				<font size="2">业务名称:</font>
				<input type="text" name="Business_Name" id="Business_Name" size="8">
				<input type="hidden" name="flag" value="findSomeone">
				<font size="2">业务编号:</font>
				<input type="text" name="Business_ID" id="Business_ID" size="8">
			
					<input type="submit" class="tb_top_1" value="立即查询">
			
			</form>
		</div>
		
		<br>
		<form action="Remove_business" method="POST" onsubmit="return confirmDel();">
			<input type="hidden" name="flag" value="delete" >
			<table cellspacing="1" class="table1" align="center">
				<tbody>
					<tr class="table_header">
						<td>
							<div align="center" class="STYLE3">
								选中
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								业务编号
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								业务名称
							</div>
						</td>
						
						<td>
							<div align="center" class="STYLE3">
								业务介绍
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								操作
							</div>
						</td>
					</tr>
					<!-- 请注意:这里我们需要循环显示所有S的记录信息 -->
				
				<c:forEach var="b" items="${requestScope.list }">
						<tr align="center" class="row2" onMouseOver="this.className='row1'"	onMouseOut="this.className='row2'">
							<td>
								<input type="checkbox" name="ids" id="ids"  value="${b.businessId }">
							</td>
							<td>${b.businessId }</td>
							<td>${b.businessName }</td>				
							<td>${b.businessDe }</td>
							<td><a href="Modify_business?id=${b.businessId }">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<div align="center">

				
					<input type="submit" class="tb_top_1" value="立即删除">
				

				<br>
				<br>
				<p class="paging">
					查询到（${requestScope.rowcount1 }）条记录 |
					分页（${requestScope.page1 }/${requestScope.pagenum1}） |
					<c:if test="${requestScope.page1 > 1}">
					<a href="BusinessList?page=${page1-1}">上一页</a>
					</c:if>
						<c:forEach var="i" begin="1" end="${requestScope.pagenum1}" step="1">
						
											
						[<a href="BusinessList?page=${i}">${i }</a>]
						</c:forEach>
					
					<c:if test="${requestScope.page1 != requestScope.pagenum1}">
					<a href="BusinessList?page=${page1+1}">下一页</a>
					</c:if>
				</p>
			</div>
		</form>
		<div align="center">
			<form action="">
				<input type="hidden" name="flag" value="managerOperator">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 跳转
				<input type="text" name="page" size="2" value="1">
				页
				<input type="submit" value="跳转">
			</form>
		</div>
		<font color="#0033FF"> </font>
		
	</body>
</html>

