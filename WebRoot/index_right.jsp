<%@ page language="java" import="java.util.*"	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>登陆成功！</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	    	<link href="style/stylet.css"	rel="stylesheet" type="text/css">
    </head>

	<body >
	
		<TR>
			<TD height=25>
		  您现在的位置：登录成功!</TD>
		</TR>
		<TR>
			<TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" width=1></TD>
		</TR>
	<hr width="100%" size="1">
	<div id="dengluchenggong">
	  <div id="dengluchenggongimg">
	    <div id="dengluchenggongword">欢迎您 <font color="#73A822">
			  ${sessionScope.login_operator.operatorName }</font>!
		</div>您的权限为：
		<font color="#73A822"> 
		  <c:choose>
				<c:when test="${sessionScope.login_operator.isAdmin eq  'Y'  }">
					管理员
				</c:when>
			<c:otherwise>
					操作员
				</c:otherwise>
			</c:choose>
		</font>
	</div>
   </div>
  </body>
</html>
