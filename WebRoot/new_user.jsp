<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'newuser.jsp' starting page</title>
		<base href="<%=basePath%>">
		<link href="style/stylet.css"
			rel="stylesheet" type="text/css">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
    	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!--
	新增客户成功后会跳至本页面，新增用户信息。
	-->

	</head>
	<script type="text/javascript">
  
  </script>

	<body>
		
		<font size="2">您现在的位置:新增用户</font>
		<br>
		<hr width="100%" size="2">

		<font color="red">  </font>
		<form action="Add_User" method="post"
			onsubmit="return check(this)">
			<input type="hidden" name="flag" value="newuser">
			<input type="hidden" name="custId" value = "${requestScope.id }">
		客户ID:&nbsp;&nbsp;
			<b>${requestScope.id }</b>
			<br><br>
		号码类型:
			<input type="radio" name="type" value="SIM" <c:if test="${requestScope.type1 eq 'SIM' }">checked</c:if> onchange="location.replace('Available_num?part=${requestScope.part1 }&id=${requestScope.id }&type='+this.value)">
			SIM
			<input type="radio" name="type" value="UIM" <c:if test="${requestScope.type1 eq 'UIM' }">checked</c:if> onchange="location.replace('Available_num?part=${requestScope.part1 }&id=${requestScope.id }&type='+this.value)">
			UIM
		<br>
		<br>
		筛选号段：
		<c:if test="${requestScope.type1 eq 'SIM' }">
		<select name ="part" onchange="location.replace('Available_num?type=${requestScope.type1 }&id=${requestScope.id }&part='+this.value)">
			<option value = "0" <c:if test="${requestScope.part1 eq '%' }">selected</c:if>>全部号段</option>
			<option value = "137" <c:if test="${requestScope.part1 eq '137%' }">selected</c:if>>137</option>
			<option value = "138" <c:if test="${requestScope.part1 eq '138%' }">selected</c:if>>138</option>
			<option value = "139" <c:if test="${requestScope.part1 eq '139%' }">selected</c:if>>139</option>
		</select>
		</c:if>
		<c:if test="${requestScope.type1 eq 'UIM' }">
		<select name ="part" onchange="location.replace('Available_num?type=${requestScope.type1 }&id=${requestScope.id }&part='+this.value)">
			<option value = "0" <c:if test="${requestScope.part1 eq '%' }">selected</c:if>>全部号段</option>
			<option value = "159" <c:if test="${requestScope.part1 eq '159%' }">selected</c:if>>159</option>
			<option value = "186" <c:if test="${requestScope.part1 eq '186%' }">selected</c:if>>186</option>
		</select>
		</c:if>
		手机号码:
		<select name="mobileNumber" >
    	<c:forEach items="${requestScope.availableNum }" var="a">
    		<option value="${a}">${a}</option>
   		</c:forEach>
    	</select>
			<br>
			<br>
			漫游状态:
			<input type="radio" name="zt" value="P" checked>
			省内漫游
			<input type="radio" name="zt" value="D">
			国内漫游
			<input type="radio" name="zt" value="I">
			国际漫游
			<br>
			<br>
			通话级别:
			<input type="radio" name="grade" value="L" checked>
			本地通话
			<input type="radio" name="grade" value="D">
			国内长途
			<input type="radio" name="grade" value="I">
			国际长途
			<br>
			<br>
			帐号:
			<select name ="accountId">
				<c:forEach items="${requestScope.accountList }" var="a">
    				<option value="${a.accountId}">${a.accountId}|${a.contactPerson}</option>
   				</c:forEach>
			</select>
			<input type="button" id = "" class = "tb_top_1"  value = "创建账号" onclick="add(${requestScope.id})">
			<br>
			<br>
			<input type="submit" class = "tb_top_1" value="提交">
			<input type="reset" class="tb_top_1" value="全部重写">
			<br>
			<br>
		</form>
	</body>

</html>
