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
		<title>Charge</title>
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
		

		<style type="text/css">
<!--
.STYLE3 {
	color: #FFFFFF;
	font-weight: bold;
}
-->
</style>

		<script type="text/javascript" language="javascript">
		function confirmDel(){
			if(confirm("确认删除？")){
				return true;
			}else{
				return false;
			}
		}	
		
		function checkMsg(){
			var Charge_Name = document.getElementById("Charge_Name").value;
			var Charge_ID = document.getElementById("Charge_ID").value;
			if(Charge_Name==""&& Charge_ID ==""){
				alert("费用名称与编号不能全部为空！");
				return false;
			}
		}
</script>
	</head>
	<body link="#73A822" alink="#73A822" vlink="#73A822">
		<font size="2">您现在的位置：>><a href="ChargeList">费用列表</a></font>
		<hr>
		<div align="center">
			<form action="ChargeList" method="POST" onSubmit="return checkMsg();">
				<font size="2">费用名称:</font>
				<input type="text" name="Charge_Name" id="Charge_Name" size="8">
				<input type="hidden" name="flag" value="findSomeone">
				<font size="2">费用编号:</font>
				<input type="text" name="Charge_ID" id="Charge_ID" size="8">
			
					<input type="submit" class="tb_top_1" value="立即查询">
			
			</form>
		</div>
		
		<br>
		<form action="Remove_charge" method="POST" onsubmit="return confirmDel();">
			<input type="hidden" name="flag" value="delete" >
			<table cellspacing="1" class="table" align="center">
				<tbody>
					<tr class="table_header">
						<td>
							<div align="center" class="STYLE3">
								选中
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								费用编号
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								费用名称
							</div>
						</td>
						
						<td>
							<div align="center" class="STYLE3">
								费用价格
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								操作
							</div>
						</td>
					</tr>
					<!-- 请注意:这里我们需要循环显示所有S的记录信息 -->
				
				<c:forEach var="c" items="${requestScope.list }">
						<tr align="center" class="row2" onMouseOver="this.className='row1'"	onMouseOut="this.className='row2'">
							<td>
								<input type="checkbox" name="ids" id="ids"  value="${c.chargeId }">
							</td>
							<td>${c.chargeId }</td>
							<td>${c.chargeName }</td>				
							<td>${c.charge }</td>
							<td><a href="Modify_charge?id=${c.chargeId }">修改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<div align="center">
				<br>
				<br>
				<p class="paging">
					查询到（${requestScope.rowcount }）条记录 |
					分页（${requestScope.page }/${requestScope.pagenum}） |
					<c:if test="${requestScope.page > 1}">
					<a href="ChargeList?page=${page-1}">上一页</a>
					</c:if>
						<c:forEach var="i" begin="1" end="${requestScope.pagenum}" step="1">
						
											
						[<a href="ChargeList?page=${i}">${i }</a>]
						</c:forEach>
					
					<c:if test="${requestScope.page != requestScope.pagenum}">
					<a href="ChargeList?page=${page+1}">下一页</a>
					</c:if>
				</p>
			</div>
		</form>
		<div align="center">
			<form action="">
				<input type="hidden" name="flag" value="managerOperator">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 跳转
				<input type="text" name="page" size="2" value="${requestScope.page }" id="pageid" 
					onkeyUp="if(value > ${requestScope.pagenum}) value='${requestScope.page }'">
				页
				<input type="submit" value="跳" >
			</form>
		</div>
		
	</body>
</html>

