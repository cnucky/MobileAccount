<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'show_eg.jsp' starting page</title>
    <LINK href="style/stylet.css" type=text/css rel=stylesheet>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	资源管理
	-->
<script type="text/javascript">

</script>
  </head>  
  <body  link="#73A822" alink="#73A822" vlink="#73A822">
   <font size="2"> 您现在的位置:>>文本示例</font><br><hr width="100%" size="2">
<textarea name="text" cols="30" rows="7">
12345678901,SIM,,Y
12345678912,SIM,,Y
12345678923,SIM,,N
12345678934,UIM,,Y
12345678945,SIM,,Y
</textarea>
	<br>
	<a href="new_resource.jsp">返回</a>
   
  </body>
</html>
