<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'set_customer.jsp' starting page</title>
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
  function check(obj){
	return confirm("确认添加？");
  }
  </script>
	<body >

		<font size="2">您现在的位置&gt;修改用户</font>

		<br>
		<hr width="100%" size="2">
		<div class="right_1">
		<form action="CustomerManage?flag=newcustomer&step=5" method="post" onsubmit="check(this);">
			证件类型:
			<select name="idType">
				<option value="D" id="identity_card" <c:if test="${requestScope.customer.idType eq 'D' }">selected</c:if>>
					居民身份证
				</option>
				<option value="P" id="passport" <c:if test="${requestScope.customer.idType eq 'P' }">selected</c:if>>
					护照
				</option>
				<option value="A" id="military_id" <c:if test="${requestScope.customer.idType eq 'A' }">selected</c:if>>
					军官证
				</option>
			</select>
			<br><br>
			证件号码:
			<input type="text" name="idNumber" id="idNumber" value="${requestScope.customer.idNumber }">
			<br>
			<br>
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
			<input type="text" name="customerName" id="customerName" value="${requestScope.customer.customerName }">
			<br>
			<br>
			性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
			<input type="radio" name="customerSex" value="M" <c:if test="${requestScope.customer.customerSex eq 'M' }">checked</c:if>>
			男
			<input type="radio" name="customerSex" value="F" <c:if test="${requestScope.customer.customerSex eq 'F' }">checked</c:if>>
			女
			<br>
			<br>
			生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日:
			<select name="birthday_year">
				<c:forEach begin="1980" end="1993" step="1" var="i">
					<option value="i" <c:if test="${requestScope.birthday_year eq i }">selected</c:if>>
					${i }
					</option>
				</c:forEach>
			</select>
			年
			<select name="birthday_month">
				<c:forEach begin="1" end="12" step="1" var="i">
					<option value="i" <c:if test="${requestScope.birthday_month eq i }">selected</c:if>>
					${i }
					</option>
				</c:forEach>
			</select>
			月
			<select name="birthday_day">
				<c:forEach begin="1" end="31" step="1" var="i">
				<option value="i" <c:if test="${requestScope.birthday_day eq i }">selected</c:if>>
					${i }
					</option>
				</c:forEach>
			</select>
			日
			<br>
			<br>
			联系地址:
			<input type="text" name="customerAddress" id="customerAddress" value="${requestScope.customer.customerAddress }">
			<br>
			<br>
			<input type="submit" class="tb_top_1" value="下一步>>">
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