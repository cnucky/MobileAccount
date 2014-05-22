<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<title>AccountList</title>
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
		alert("客户名称与编号不能全部为空！");
		return false;
	}
	}
</script>
	</head>
	<body link="#73A822" alink="#73A822" vlink="#73A822">
		<font size="2">您现在的位置：>><a href="AccountList">账户列表</a></font>
		<hr>
		<div align="center">
			<!-- <form action="AccountList" method="POST" onSubmit="return checkMsg();">
				<font size="2">联系人姓名:</font>
				<input type="text" name="contact_person" id="contact_person" size="8">
				<input type="hidden" name="flag" value="findSomeone">
				<font size="2">账户编号:</font>
				<input type="text" name="Account_ID" id="Account_ID" size="8">
			
					<input type="submit" class="tb_top_1" value="立即查询">
			
			</form> -->
		</div>
		
		<br>
		
		<form action="AccountModify" method="POST" onsubmit="return confirmDel();">
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
								账户编号
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								联系人姓名
							</div>
						</td>
						
						<td>
							<div align="center" class="STYLE3">
								联系人地址
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								账户余额
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								操作
							</div>
						</td>
					</tr>
					<!-- 请注意:这里我们需要循环显示所有S的记录信息 -->
				
				<c:forEach var="a" items="${requestScope.list }">
						<tr align="center" class="row2" onMouseOver="this.className='row1'"	onMouseOut="this.className='row2'">
							<td>
								<input type="checkbox" name="ids" id="ids"  value="${a.accountId}">
							</td>
							<td>${a.accountId}</td>
							<td>${a.contactPerson }</td>
							<td>${a.contactAddress }</td>				
							<td>${a.accountBalance}</td>		
							<td><a href="Search_user?id=${a.accountId}">详情</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<br>
			<div align="center">
				<a href="new_account.jsp"><input type="button" class="tb_top_1" value="新增账户"></a>
				<p class="paging">
					
					查询到（${requestScope.rowcount }）条记录 |
					分页（${requestScope.page }/${requestScope.pagenum}） |
					【
						<c:forEach var="i" begin="1" end="${requestScope.pagenum}" step="1">
						[<a href="AccountList?page=${i}">${i }</a>]
						</c:forEach>
					】
					<c:if test="${requestScope.page < requestScope.pagenum }">
						<a href="AccountList?page=${page+1}">next</a>
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

