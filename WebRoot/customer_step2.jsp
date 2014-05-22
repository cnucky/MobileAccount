<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
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
  function check(obj){
	return confirm("确认添加？");
  }
  </script>
	<body >

		<font size="2">您现在的位置:新增用户&gt;第一步</font>

		<br>
		<hr width="100%" size="2">
		<div class="right_1">
		<form action="CustomerManage?flag=newcustomer&step=5" method="post" onsubmit="check(this);">
			证件类型:
			<select name="idType">
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
			<input type="text" name="idNumber" id="idNumber">
			<br>
			<br>
			姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
			<input type="text" name="customerName" id="customerName">
			<br>
			<br>
			性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:
			<input type="radio" name="customerSex" value="M" checked>
			男
			<input type="radio" name="customerSex" value="F">
			女
			<br>
			<br>
			生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日:
			<select name="birthday_year">
				<option value="1980">
					1980
				</option>
				<option value="1981">
					1981
				</option>
				<option value="1982">
					1982
				</option>
				<option value="1983">
					1983
				</option>
				<option value="1984">
					1984
				</option>
				<option value="1985">
					1985
				</option>
				<option value="1986">
					1986
				</option>
				<option value="1987">
					1987
				</option>
				<option value="1988">
					1988
				</option>
				<option value="1989">
					1989
				</option>
				<option value="1990">
					1990
				</option>
				<option value="1991">
					1991
				</option>
				<option value="1992">
					1992
				</option>
				<option value="1993">
					1993
				</option>
			</select>
			年
			<select name="birthday_month">
				<option value="1">
					1
				</option>
				<option value="2">
					2
				</option>
				<option value="3">
					3
				</option>
				<option value="4">
					4
				</option>
				<option value="5">
					5
				</option>
				<option value="6">
					6
				</option>
				<option value="7">
					7
				</option>
				<option value="8">
					8
				</option>
				<option value="9">
					9
				</option>
				<option value="10">
					10
				</option>
				<option value="11">
					11
				</option>
				<option value="12">
					12
				</option>
			</select>
			月
			<select name="birthday_day">
				<option value="1">
					1
				</option>
				<option value="2">
					2
				</option>
				<option value="3">
					3
				</option>
				<option value="4">
					4
				</option>
				<option value="5">
					5
				</option>
				<option value="6">
					6
				</option>
				<option value="7">
					7
				</option>
				<option value="8">
					8
				</option>
				<option value="9">
					9
				</option>
				<option value="10">
					10
				</option>
				<option value="11">
					11
				</option>
				<option value="12">
					12
				</option>
				<option value="13">
					13
				</option>
				<option value="14">
					14
				</option>
				<option value="15">
					15
				</option>
				<option value="16">
					16
				</option>
				<option value="17">
					17
				</option>
				<option value="18">
					18
				</option>
				<option value="19">
					19
				</option>
				<option value="20">
					20
				</option>
				<option value="21">
					21
				</option>
				<option value="22">
					22
				</option>
				<option value="23">
					23
				</option>
				<option value="24">
					24
				</option>
				<option value="25">
					25
				</option>
				<option value="26">
					26
				</option>
				<option value="27">
					27
				</option>
				<option value="28">
					28
				</option>
				<option value="29">
					29
				</option>
				<option value="30">
					30
				</option>
				<option value="31">
					31
				</option>
			</select>
			日
			<br>
			<br>
			联系地址:
			<input type="text" name="customerAddress" id="customerAddress">
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