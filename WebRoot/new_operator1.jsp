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
		<script type="text/javascript">
			var flag = null;
		
			function check(obj){
				if(obj.operatorId.value.length < 4){
					alert("id长度不够");
					return false;
				}
				
				if(flag != 1){
					alert("请输入一个没有被占用的ID");
					return false;
				}
				
				if(obj.operatorName.value.length > 20){
					alert("名字太长");
					return false;
				}
				
				if(obj.operatorPwd.value.length < 6){
					alert("密码太短!!");
					return false;
				}
				
				if(obj.passwd1.value != obj.operatorPwd.value ){
					alert("两次密码输入不同");
					return false;
				}
				
				return  true;
		   }  
		   
		   ///测试ID的异步请求函数
		   var request = null;
		   function checkId(){
			 if(add.operatorId.value.length >=4){
				var id = add.operatorId.value;
		   		if(window.XMLHttpRequest){
					request = new XMLHttpRequest(); 
				}else if(window.ActiveXobject){
					try{
						request = new ActiveXObject("Msxm12.XMLHTTP");
					} catch (e1) {
						try {
							request = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e2) {}
					}
				}
			   	request.open("post", "http://localhost:8080/MobileAccount/CheckOperatorIdAjax?id="+id, true);		   		
			   		
			   	request.onreadystatechange = response;
			   		
			   	request.send();
				}
		   }
		   
		   //异步响应函数
		   function  response(){
		   		if(request.readyState == 4){
		   			if(request.status == 200){
		   				flag = request.responseText;
		   				if( request.responseText.indexOf("1") != -1){
		   					document.getElementById("myspan").innerHTML = "<font color='green'>该用户名可以使用</font>";
		   				}
		   				else{
		   					document.getElementById("myspan").innerHTML = "<font color='red'>用户名已被占用</font>";
		   				}
		   			}
		   		}
		   }
   		</script>

		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD height=25>
						<font size="2">您现在的位置：>>新增操作员</font>
						<hr>
					</TD>
				</TR>
		</TABLE>
		<TR align="top">
			<TD height="600" bgColor=#f1f3f9>
				<form method="POST" action="AddOperator" name="faddo" id="faddo">
					<input type="hidden" name="flag" value="submitnewoperator">
					<table  cellspacing="1" class="form_table1" align="center">
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;登录ID：
							</td>
							<td class="formtb_right">
								<input type="text" name="operatorId" onkeyUp="checkId();" onblur="check('faddo')">
								*至少四位数字
								<span id="myspan"></span>
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;姓&nbsp; 名：
							</td>
							<td class="formtb_right">
								<input type="text" name="operatorName">
								*不超过20位
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;密&nbsp; 码：
							</td>
							<td class="formtb_right">
								<input type="password" name="operatorPwd">
								*至少六位数字
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;密码确认：
							</td>
							<td class="formtb_right">
								<input type="password" name="passwd1">
								*至少六位数字
							</td>
						</tr>


						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;是否管理员：
							</td>
							<td class="formtb_right">
								<input type="radio" value="Y" name="isAdmin">
								是 &nbsp;
								<input type="radio" value="N" name="isAdmin" checked="checked">
								否
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
					</p>
				</form>
			</TD>
		</TR>
		<font color="red">
		  </font>
	</body>
</html>
