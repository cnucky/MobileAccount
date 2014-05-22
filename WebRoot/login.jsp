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
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	
		<title>欢迎使用移动计费系统</title>
		<link href="style/stylet.css"	rel="stylesheet" type="text/css">
	</head>
	<!-- 进行用户名和密码以及验证码是否为空判断 -->
	<script type="text/javascript" language="javascript">
	   function checknull(){
			if(document.getElementById("userid").value==""){
				alert("用户名不能为空！");
				return false;
			}
			else if(document.getElementById("passwd").value==""){
				alert("密码不能为空！");
				return false;
			}
			else return true;
	  }
   </script>

	<body>
		<font color="red" size="6">${param.msg }</font>
		<div id="box1" style="overflow:hidden">
			<div id="tab_box">
				<form action="Login" method="post" name="login" onsubmit="return checknull();"	>
					<span class="denglu_font_title">欢迎登录</span>
					<br />
					<br />
					<label for="userid" class="yonghuming_font">
						用户：
					</label>
					<input name="operatorId" type="text" id="userid" accesskey="n"
						tabindex="1"
						style="font-family: '宋体'; font-size: 12px; color: #575757" />
					<br />
					<br />
					<label for="passwd" class="yonghuming_font">
						密码：
					</label>
					<input name="operatorPwd" type="password" id="passwd" tabindex="2"
						style="font-family: '宋体'; font-size: 12px; color: #575757" />
					<br />
					<br />
					
			
					<input name="denglu_tijiao" type="submit" id="denglu_tijiao"
						tabindex="3" value="确认" />
					<input name="denglu_chongzi" type="reset" id="denglu_reset"
						tabindex="4" value="重置" />
					<input type="hidden" name="flag" value="login">
				</form>
				<font color='red'>  </font>
			</div>
		</div>
	</body>
</html>

