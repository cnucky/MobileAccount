<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>新增账户</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		  <LINK href="style/style.css" type=text/css rel=stylesheet>
	</head>

	<body >
		<script type="text/javascript" language="javascript">
   function check(){
	var address = document.getElementById("contact_address").value;
	var name = document.getElementById("contact_person").value;
	var balance = document.getElementById("balance").value;
	if(address==""){
		alert("联系人地址不能为空！");
		return false;
	}else if(name== "" ){
		window.alert("联系人姓名不能为空！");
		return false;
	}else if(balance== "" ){
		window.alert("余额不能为空！");
		return false;
	}
	else{
		return true;
   }
   }
   
   
   </script>

		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD height=25>
						<font size="2">您现在的位置：>>添加账户</font>
						<hr>
					</TD>
				</TR>

			</TBODY>
		</TABLE>
		<TR align="top">
			<TD height="600" bgColor=#f1f3f9>
				<form method="POST" action="AddAccount" onSubmit="return check();">
					<input type="hidden" name="flag" value="submitnewoperator">
					<table  cellspacing="1" class="form_table1" align="center">
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;联系人姓名：
							</td>
							<td class="formtb_right">
								<input type="text" name="contact_person" id="contact_person">
								*
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;联系人地址：
							</td>
							<td class="formtb_right">
								<input type="text" name="contact_address" id="contact_address">
								*
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;账户余额：
							</td>
							<td class="formtb_right">
								<input type="text" name="balance" id="balance">
								*
							</td>
						</tr>
					</table>
					<br>
					<br>
					<p align="center">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" value="提交">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="全部重写">
						&nbsp;&nbsp;&nbsp;
					</p>
				</form>
			</TD>
		</TR>
		<font color="red">
		  </font>
	</body>
</html>