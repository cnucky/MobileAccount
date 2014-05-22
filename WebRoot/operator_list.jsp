<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>操作员列表</title>
		<style>
			a {
				text-decoration: none
			}
		</style>

		<base href="<%=basePath%>">
		<link href="style/stylet.css" rel="stylesheet" type="text/css">
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

		<script type="text/javascript" language="javascript">
			function confirmDel(){
				var id = document.getElementById("ids") ;
				alert(id.length);
				for(var i=0; i < id.length; i++){
				 	if(id[i].checked){
				 		return confirm("确定删除？");
				 	}
				}
				alert("未选中任何操作员!");
				return false;
			}	
			
		</script>
	</head>
	<body link="#73A822" alink="#73A822" vlink="#73A822">
		<font size="2">您现在的位置：>>操作员列表</font>
		<hr>
		<div align="center" >
			<form action="OperatorList " method="POST">
				<font size="2">操作员姓名:</font>
				<input type="text" name="operatorName" id="Operator_Name" size="8">
		
				<font size="2">操作员编号:</font>
				<input type="text" name="operatorId" id="Operator_ID" size="8">
			
					<input type="submit" class="tb_top_1" value="立即查询">
			
			</form>
		</div>

		<br>
		<form action="OperatorModify" method="POST" onsubmit="return confirm('确实要删除？');">
			<input type="hidden" name="flag" value="delete">
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
								编号
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								姓名
							</div>
						</td>
						
						<td>
							<div align="center" class="STYLE3">
								是否为管理员
							</div>
						</td>
						<td>
							<div align="center" class="STYLE3">
								操作
							</div>
						</td>
					</tr>
					<!-- 请注意:这里我们需要循环显示所有的记录信息 -->
					<c:forEach var="o" items="${requestScope.list }">
						<tr align="center" class="row2" onMouseOver="this.className='row1'"	onMouseOut="this.className='row2'">
							<td>
								<input type="checkbox" name="ids" id="ids" value="${o.operatorId }" >
							</td>
							<td>${o.operatorId }</td>
							<td>${o.operatorName }</td>				
							<td>${o.isAdmin }</td>
							<td><a href="OperatorModify?operatorId=${o.operatorId}">修改</a></td>
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
					
					查询到（${requestScope.rowcount }）条记录 |
					分页（${requestScope.page }/${requestScope.pagenum}） |
					【
						<c:forEach var="i" begin="1" end="${requestScope.pagenum}" step="1">
						[<a href="OperatorList?page=${i}">${i }</a>]
						</c:forEach>
					】
					<c:if test="${requestScope.page < requestScope.pagenum }">
						<a href="OperatorList?page=${page+1}">next</a>
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
