<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>配置业务费用</title>
    <link href="style/stylet.css"
			rel="stylesheet" type="text/css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<!--
	配置业务费用
	-->
	
  <script type="text/javascript" language="javascript">
	  function checkSubmit(){
	  	return confirm("确认提交？");
	  }
  </script>

  </head> 
  
 <body >
    <font size="2">您现在的位置:>>配置业务</font>&nbsp;<br><hr width="95%" size="2" align="center">
    
    <form action="Business_Charge" method="post" name="chargeform" >
      
    <dir style="font-size:18px">收费细项</dir>
    <input type="hidden" name="flag" value="findv"> <!-- 用于查询收费细项的金额 -->    
    收费项目:    
    <select name="gmtyp" onChange="document.chargeform.submit()">
    
    <option value="A">开户费</option>
    
    <option value="B">漫游费</option>
    
    <option value="C">押金</option>
    
    <option value="D">入网费</option>
    
    <option value="E">选号费</option>
    
    </select>
    <br> 
    <br>
    
    收费金额: <input type="text" name="money" value=请选择收费项目><br><br>
    <input type="button" class="tb_top_1"  value="修改收费金额" onClick="location.replace('../charge/update_charge.jsp')">
    <input type="reset" class="tb_top_1"  value="全部重写">
    </form>
 <font color="#FF00FF">  </font>
  
    <hr width="100%" size="2">     
    <form action="Business_Charge" onsubmit="checkSubmit();">
    <input type="hidden" name="flag" value="updatecharge2">
    <dir style="font-size:18px">业务收费</dir>
    业务:
    <select name="businessID" onchange="window.location='Business_Conf?id='+this.value">
    <c:forEach items="${requestScope.blist }" var="b">
    	<option value="${b.businessID }" <c:if test="${b.businessID eq requestScope.id }">selected="selected"</c:if>>${b.businessName }</option>
    </c:forEach>
    </select>
    <br><br>
    收费项目:
    <c:forEach items="${requestScope.clist }" var="c">
    	
    	<input type="checkbox" name="chargeID" value="${c.chargeID }" 
	    	<c:forEach items="${requestScope.bclist }" var="bc">
	    		<c:if test="${bc.chargeID eq c.chargeID }">
	    			checked
	    		</c:if>
	    	</c:forEach>>${c.chargeName }
    </c:forEach>
    
    <br>
    <input type="submit" class="tb_top_1"  value="提交">
    <input type="reset" class="tb_top_1"  value="全部重写">
  
    </form>
   <font color=""></font>    
      
  </body>
</html>
