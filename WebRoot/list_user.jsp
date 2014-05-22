<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'ListUsers.jsp' starting page</title>
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
	查询所有客户
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
		return confirm("确认要删除吗？");
	}	
	
	function checkMsg(){
		
	}
	
</script>
	</head>
	<body link="#73A822" alink="#73A822" vlink="#73A822">
		<font size="2">您现在的位置：>>用户列表</font>
		
		<hr>		
		
		<div align="center">
			<form action="AccountManage" method="get">
				
				<input type="hidden" name="flag" value="findSomeone">
				<c:if test="${requestScope.accountID != null }">账户编号:${requestScope.accountID }</c:if>
				<c:if test="${requestScope.customerID != null }">客户编号:${requestScope.customerID }</c:if>
				
				<input type="button" class="tb_top_1" value="添加用户" onclick="window.location='CustomerManage?step=9&ID=${requestScope.customerID }'">
				
				
						
			</form>
		</div>
			
		<br>
		<c:choose>
			<c:when test="${empty requestScope.list }">
				<table cellspacing="1" class="table" align="center">
					<tr>
						<td>
							<h3>o(︶︿︶)o 没有符合的结果！！</h3>
							<a href="CustomerManage">返回</a>
						</td>
					</tr>
				</table>
			</c:when>
			
			<c:otherwise>
					<div align="center">
						共${requestScope.rows }个结果
					</div>
					<form action="Rm_User" method="POST" onsubmit="confirmDel();">
						<input type="hidden" name="flag" value="delete">
						<table cellspacing="1" class="tableb" align="center">
							<tbody>
								<tr class="table_header">
									<td>
										<div align="center" class="STYLE3">
											选中
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											编号
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											电话号码
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											漫游状态
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											通讯等级
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											账户编号
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											客户编号
										</div>
									</td>
									<td>
										<div align="center" class="STYLE3">
											操作
										</div>
									</td>
								</tr>
								<!-- 请注意:这里我们需要循环显示所有的记录信息 -->
								
								<c:forEach items="${requestScope.list }" var="i">
									<tr align="center" class="row2" onMouseOver="this.className='row1'"
										onMouseOut="this.className='row2'">
				
										<td>
											<input type="checkbox" name="ids" id="ids" value="${i.userId }">
										</td>
										<td>
											${i.userId }
										</td>
										<td>
											${i.mobileNumber }
										</td>
										<td>
											${i.roamingStatus }
										</td>
										<td>
											${i.comLevel }
										</td>
										<td>
											${i.accountId }
										</td>
										<td>
											${i.customerId }
										</td>
										<td>
											<a href="UserManage?step=2&userID=${i.userId }&customerID=${i.customerId }">修改</a>
										</td>
				
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
								
								
								
								
								<c:if test="${requestScope.page != null}">
								
									<a href="AccountManage?page=1">首页</a>|
									
									<c:if test="${requestScope.page > 1}">
										<a href="AccountManage?page=${requestScope.page-1 }">&lt;上一页&lt;</a>
									</c:if>

									|第${requestScope.page }页|共${requestScope.pages }页|

									<c:if test="${requestScope.page < requestScope.pages}">
										<a href="AccountManage?page=${requestScope.page+1 }">&gt;下一页&gt;</a>
									</c:if>
									
									|<a href="AccountManage?page=${requestScope.pages }">尾页</a>
									
								</c:if>
			
							</p>
						</div>
					</form>
					<div align="center">
						
					</div>
		
				</c:otherwise>
			</c:choose>
			
		<font color="#0033FF"> </font>
		
	</body>
</html>
