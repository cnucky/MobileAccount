<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'resource.jsp' starting page</title>
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
function checkMsg(){
	var begin=document.getElementById("begin").value;
	var end=document.getElementById("end").value;
	if((begin=="" && end=="")){
		alert("请至少输入一个号码！！");
		return false;
	}
	if(begin > end && end != ""){
		alert("前面的号码大于后者，请确认输入是否有误！");
	}
	else{
		return true;
	}
	return confirm("确认提交？");
}

function checkFile(){
	return confirm("确认提交？");
}
</script>
  </head>  
  <body  link="#73A822" alink="#73A822" vlink="#73A822">
   <font size="2"> 您现在的位置:>>新增资源</font><br><hr width="100%" size="2">
    <form action="New_Mobiles" method="post" onSubmit="checkMsg();" name="resource" id="resource">
    <input type="hidden" name="flag" value="submitresource">    
    号码类型:<input type="radio" name="num" value="SIM" checked="checked">SIM
    <input type="radio" name="num" value="UIM">UIM<br><br>
    指定号段:从<input type="text" name="begin" id="begin">到<input type="text" name="end" id="end">
     <br>
     <br>   
    <input type="submit" class="tb_top_1" value="提交">
    <input type="reset" class="tb_top_1" value="全部重写">   
    </form>
    
  <br>
  <hr>
  <form action="Upload_Mobiles" enctype="multipart/form-data" method="post" onSubmit="checkFile();">
   <input type="hidden" name="flag" value="gettxt">
  从制定文件中导入：<input type="file" name="txtfile" id="txtfile"><br><br>
  <input type="submit" class="tb_top_1" value="提交">
  <input type="reset" class="tb_top_1" value="重置">
  <br><br>
  说明：<ol>
  		<li>只支持txt格式文档的导入！</li>
  		<li>请注明号码类型为SIM或是UIM！</li>
  		<li><a href="show_eg.jsp" target="_self"> 查看示例！</a></li>
  	</ol>
  </form>
   
  </body>
</html>
