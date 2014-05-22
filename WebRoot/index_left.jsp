<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>中国移动业务计费系统</title>
		<link href="style/style.css" rel="stylesheet" type="text/css" />
		<style>
a {
	text-decoration: none;
}
</style>
		
	</head>
	<body alink="black" vlink="black" link="black" bgcolor="#E5F2F3" style="margin:20px">
		<div id="box">
			<div id="left">
				<script type="text/javascript" language="javascript">
					function show(id){
						var tr = document.getElementById(id);
						//window.alert(tr.style.display);
						if(tr.style.display == "none"){
							tr.style.display = "block";
						}
						else{
							tr.style.display = "none";
						}
					}
					
					
				</script>
				

				<table cellSpacing="0" cellPadding="0" align="left" border="0">
					<tr>
						<td valign="top">
						
							<!-- 系统管理会员专属权限 -->
							<c:if test="${sessionScope.login_operator.isAdmin  eq 'Y' }">
								<table cellSpacing="0" cellPadding="0" width="165">
									<tr style="CURSOR: pointer"  onclick="show('tr1')">
										<td class=list_title id=list1			
											background="images/title_show.gif" height=25>
											<span>操作员管理</span>
										</td>
									</tr>
									<tr id="tr1" style="dispay:block">
										<td valign="middle">
											<div class=sec_menu id=menu1
												style="width: 165px; ">
												<table cellSpacing="0" cellPadding="0" width=152
													align="center" background="images/bg.gif"
													style="padding-left: 5px">
													<tr>
														<td height=25>
															<a href="new_operator.jsp"	target="right">新增操作员</a>
														</td>
													</tr>
													<tr>
														<td height=25>
															<a href="OperatorList" target="right">操作员列表</a>
														</td>
													</tr>

												</table>
											</div>
										</td>
									</tr>
								</table>
								<table cellSpacing="0" cellPadding="0" width=165>
									<tr style="CURSOR: pointer" onclick="show('tr2')">
										<td class=list_title id=list2
											onmouseover="this.typename='list_title2';"											
											onmouseout="this.typename='list_title';"
											background="images/title_show.gif" height=25>
											<span>资源管理</span>
										</td>
									</tr>
									
									<tr style="display:none" id="tr2">
										<td>
											<div class=sec_menu id=menu2>
												<table cellSpacing=2 cellPadding="0" width=152
													background="images/bg.gif" style="padding-left: 5px">
													<tr>
														<td height=25>
															<a href="new_resource.jsp"
																target="right">新增资源</a>
														</td>
													</tr>
													<!-- <tr>
														<td height=25>
															<a href=""
																target="right">扩展功能</a>
														</td>
													</tr> -->
												</table>
											</div>
										</td>
									</tr>
								</table>
								<table cellSpacing="0" cellPadding="0" width=165>
	
									<tr style="CURSOR: pointer" onclick="show('tr3')">
										<td class=list_title id=list10
											onmouseover="this.typename='list_title2';"
											onclick=chang(menu10,50,list10);
											onmouseout="this.typename='list_title';"
											background="images/title_show.gif" height=25>
											<span>业务管理</span>
										</td>
									</tr>
									<tr style="display:none" id="tr3">
										<td valign="middle">
											<div class=sec_menu id=menu10>
												<table width=152 cellPadding="0" cellSpacing=2
													background="images/bg.gif" style="padding-left: 5px">
													<tr>
														<td height=25>
															<a href="new_charge.jsp" target="right">添加费用</a>
														</td>
													</tr>
													<tr>
														<td height=25>
															<a href="new_business.jsp" target="right">添加业务</a>
														</td>
													</tr>
													<tr>
														<td height=25>
															<a href="Business_Conf" target="right">配置业务</a>
														</td>
													</tr>
													<!-- <tr>
														<td height=25>
															<a href="" target="right">扩展功能</a>
														</td>
													</tr> -->
												</table>
											</div>
										</td>
									</tr>
								</table>
							</c:if>
						
							<!-- ---------- -->

							<table cellSpacing="0" cellPadding="0" width=165>
								<tr style="CURSOR: pointer" onclick="show('tr4')">
									<td class=list_title id=list4
										onmouseover="this.typename='list_title2';"
										onclick=chang(menu10,50,list10);
										onmouseout="this.typename='list_title';"
										background="images/title_show.gif" height=25>
										<span>业务处理</span>
										</a>
									</td>
								</tr>
									<tr style="display:none" id="tr4">
									<td valign="middle">
										<div class=sec_menu id=menu10
											 width: 165px; height: 0px">
											<table width=152 cellPadding="0" cellSpacing=2
												background="images/bg.gif" style="padding-left: 5px" >
												<tr >
													<td height=25>
														<a href="CustomerManage" target="right">客户管理</a>
													</td>
												</tr>
												<tr>
													<td height=25>
														<a href="AccountList" target="right">账户管理</a>
													</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
							<script language="javascript">
								  var nopen="";
								  var whichContinue="";
							</script>
							<table width=165 cellPadding="0" cellSpacing="0">

								<tr style="CURSOR: hand">
									<td class=list_title id=list7
										onmouseover="this.typename='list_title2';"
										onclick=chang(menu7,25,list7);
										onmouseout="this.typename='list_title';"
										background="images/title_show.gif" height=25>
										<a href="" target="right"><span>系统帮助</span> </a>
									</td>
								</tr>
							</table>
							<table width=165 cellPadding="0" cellSpacing="0">

								<tr style="CURSOR: hand">
									<td class=list_title id=list7
										onmouseover="this.typename='list_title2';"
										onclick=chang(menu7,25,list7);
										onmouseout="this.typename='list_title';"
										background="images/title_show.gif" height=25>
										<span>查询信息</span>
									</td>
								</tr>
							</table>
							<table cellSpacing="0" cellPadding="0" width=165>
								<tr style="CURSOR: hand">
									<td class=list_title id=list57
										onmouseover="this.typename='list_title2';"
										onclick=chang(menu57,30,list57);
										onmouseout="this.typename='list_title';"
										background="images/title_show.gif" height=25>
										<a href="Logout" target="_top" onclick="return confirm('确认退出？');">退出系统 </a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>

