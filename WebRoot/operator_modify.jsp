<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">	
		<title>修改操作员</title>
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
			var id_flag = null;
		
			function check(obj){
				
				if(obj.operatorName.value.length < 1){
					alert("名字不能为空");
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
		</script>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD height=25>
						<font size="2">您现在的位置：>>修改操作员</font>
						<hr>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TR align="top">
			<TD height="600" bgColor=#f1f3f9>
				<form method="POST" action="OperatorModify" name="add" id="add" onSubmit="return check(this)">
					<input type="hidden" name="flag" value="operatormodify">
					<table  cellspacing="1" class="form_table1" align="center">
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;登录ID：
							</td>
							<td class="formtb_right">
								<input type="text" disabled="disabled" name="operatorId" value="${requestScope.operatorId}" onkeyup="checkId();">
								*不可更改
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;姓&nbsp; 名：
							</td>
							<td class="formtb_right">
								<input type="text" name="operatorName" value="${requestScope.operatorName}">
								*不超过20位
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;密&nbsp; 码：
							</td>
							<td class="formtb_right">
								<input type="password" name="operatorPwd" value="${requestScope.operatorPwd}">
								*至少六位数字
							</td>
						</tr>
						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;密码确认：
							</td>
							<td class="formtb_right">
								<input type="password" name="passwd1" value="${requestScope.operatorPwd}">
								*至少六位数字
							</td>
						</tr>


						<tr>
							<td width="20%">
								&nbsp;&nbsp;&nbsp;是否管理员：
							</td>
							<td class="formtb_right">
								<input type="radio" value="Y" name="isAdmin" id="radio1" > <%-- checked="return isAdminchk('${requestScope.isAdmin }');" --%>
								是 &nbsp;
								<input type="radio" value="N" name="isAdmin" id="radio2" >
								否
							</td>
							<%-- <c:choose>
								<c:when test="${resquestScope.isAdmin eq 'Y' }"><c:set></c:set></c:when>
								<c:otherwise>this.radio2.checked="checked"</c:otherwise>
							</c:choose> --%>
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
