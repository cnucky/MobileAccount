<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'newcustomer.jsp' starting page</title>
<link href="style/stylet.css"
			rel="stylesheet" type="text/css">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<!--
	新增用户第一步：录入用户证件类型和证件号码，判断用户是否存在，若存在显示详细信息，若不存在，进入第二步。
	-->

	</head>
	<script type="text/javascript">
  var flag = false;
 function check(){
   var username = document.getElementById("username").value;
   var address = document.getElementById("address").value;	
  	if(flag != true){
  		window.alert("证件号码输入违法，请重新输入！");
		return false;
  	}else if(username == ""){
  		window.alert("姓名不能为空，请重新输入！");
		return false;
  	}else if(address == ""){
  		window.alert("地址不能为空，请重新输入！");
		return false;
  	}else{
  		return true;
  		}
   	}
  function checkNum(){
  	var number = add.number.value;
  	var type = add.selectType.value;
  	if(type == "D"){
  		if(number.length ==15 || number.length ==18){
  		document.getElementById("numspan").innerHTML = "<font color = 'green'>输入正确</font>";
  		flag = true;
  		}else{
  		document.getElementById("numspan").innerHTML = "<font color = 'red'>身份证号码长度错误！</font>";
  		flag = false;
  		}
  	}
  	if(type == "P"){
  		if(number.length==8 || number.length == 9){
  		document.getElementById("numspan").innerHTML = "<font color = 'green'>输入正确</font>";
  		flag = true;
  		}else{
  		document.getElementById("numspan").innerHTML = "<font color = 'red'>护照号码长度错误！</font>";
  		flag = false;
   		}
  	}
  	if(type == "A"){
  		if(number.length==7){
  		document.getElementById("numspan").innerHTML = "<font color = 'green'>输入正确</font>";
  		flag = true;
  		}else{
  		document.getElementById("numspan").innerHTML = "<font color = 'red'>军官证号码长度错误！</font>";
  		flag = false;
  		}
  	}
  
  }
  </script>
	<body >

		<font size="2">您现在的位置:新增用户</font>

		<br>
		<hr width="100%" size="2">
		<div class="right_1">
		<form action="Add_Customer" method="post"
			onSubmit="return check();" id = "add">
			证件类型:
			<select name="zhengjian" id = "selectType">
				<option value="D" id="identity_card">
					居民身份证
				</option>
				<option value="P" id="passport">
					护照
				</option>
				<option value="A" id="military_id">
					军官证
				</option>
			</select>
			<br><br>
			证件号码:
			<input type="text" name="number" id="number" onblur="checkNum()">
			<span id="numspan"></span>
			<br>
			<br>
			姓&nbsp;&nbsp;&nbsp;&nbsp;名:
			<input type="text" name="username" id="username">
			<br>
			<br>
			性&nbsp;&nbsp;&nbsp;&nbsp;别:
			<input type="radio" name="sex" value="M" checked="checked">
			男
			<input type="radio" name="sex" value="F">
			女
			<br>
			<br>
			生&nbsp;&nbsp;&nbsp;&nbsp;日:
			
			<select name="birthday_year">
			<c:forEach var="y" begin = "1900" end="2000" step="1">
				<option value="${y}">
				${y }
				</option>
			</c:forEach>
			</select>
			年
			<select name="birthday_month" >
			<c:forEach var="m" begin = "1" end="12" step="1" >
				<option value="${m }">
				${m }
				</option>
			</c:forEach>	
			</select>
			月
			<select name="birthday_day">
			<c:forEach var="d" begin = "1" end="31" step="1" >	
				<option value="1">
					${d }
				</option>
			</c:forEach>
			</select>
			日
			<br>
			<br>
			联系地址:
			<input type="text" name="address" id="address">
			<br>
			<br>
			
			<input type="submit" class="tb_top_1" value="提交">
			<input type="reset" class="tb_top_1" value="全部重写">
		</form>
		
		<br>
		<br>
		<font size="2" color="#73A822">
		请正确填写证件号码<br>
		1.身份证15位或18位<br>
		2.护照8位或9位<br>
		3.军官证7位<br>
		</font>
		</div>
		
	</body>
</html>
