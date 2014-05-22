<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>My JSP 'newOperator.jsp' starting page</title>
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
		   var flag = null;
		   function check(){
				var chgname = document.getElementById("chgname").value;
				var chg = document.getElementById("chg").value;
				if(chgname==""&& chg ==""){
					alert("不能为空！");
					return false;
				}else if(chgname==""){
					alert("收费项目不能为空！");
					return false;
				}else if(chg==""){
					alert("收费金额不能为空！");
					return false;
				}else if(flag.indexOf("Y")== -1 ){
					window.alert("项目名称已被占用，请重新输入！");
					return false;
				}else{
					return true;
				}
		   }
		   function newXMLHTTPRequst() {
			  var xmlreq = false;
				if (window.XMLHttpRequest) {
					xmlreq = new XMLHttpRequest();
				} else if (window.ActiveXobject) {
					try{
						xmlreq=new ActiveXObject("Msxm12.XMLHTTP");
					} catch (e1) {
						try {
							xmlreq = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e2) {
					}
				}
			}
			return xmlreq;
			}	
	
		   var request = null;
		   function checkName(){
		   	  var name = add.chgname.value;
		   	  request = newXMLHTTPRequst();
		  
		   	  request.open("post","http://localhost:8080/MobileAccount/CheckChargeNameAjax?name="+name,true);
		   	
		   	  request.onreadystatechange = response;
		      request.send();
		   }
		   function response(){
		   	 if(request.readyState == 4){
		   		if(request.status == 200){
		   			flag = request.responseText;
		   			if(request.responseText.indexOf("Y")!= -1){
		   				document.getElementById("namespan").innerHTML = "<font color = 'green'>项目名称可用</font>";
		   			}else{
		   				document.getElementById("namespan").innerHTML = "<font color = 'red'>该名称已被占用</font>";
		   			}
		   		}
		   	 }
		  }
   </script>

		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD height=25>
						<font size="2">您现在的位置：>>添加费用</font>
						<hr>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TR align="top">
			<TD height="600" bgColor=#f1f3f9>
				<form method="POST" action="AddCharge" onSubmit="return check();" id="add">
					<input type="hidden" name="flag" value="submitnewoperator">
					<table  cellspacing="1" class="form_table1" align="center">
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;收费项目：
							</td>
							<td class="formtb_right">
								<input type="text" name="chgname" id="chgname" onkeyup="checkName()">
								*
								<span id="namespan"></span>
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;收费金额：
							</td>
							<td class="formtb_right">
								<input type="text" name="chg" id="chg">
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
						<a href="ChargeList"><input type="button" value="收费项目查询">
					</p>
				</form>
			</TD>
		</TR>
		<font color="red">
		  </font>
	</body>
</html>