package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobile.dao.OperatorDao;
import com.mobile.model.Operator;
import com.mobile.utils.Tools;

public class New_Operator extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		if(request.getParameter("passwd").equals(request.getParameter("passwd1"))){
			Operator o = new Operator();
			o.setOperatorName(Tools.toUTF8(request.getParameter("username")));
			o.setOperatorId(request.getParameter("loadID"));
			o.setOperatorPwd(request.getParameter("passwd"));
			o.setIsAdmin(request.getParameter("manager"));
			
			if(new OperatorDao().add(o) != 0){
				out.println(Tools.alert("添加成功!!"));
				out.println(Tools.location("new_operator.jsp"));
			}
			else{
				out.println(Tools.alert("添加失败!!"));
				out.println(Tools.back());
			}
		}
		else{
			out.println(Tools.alert("输入的密码不一致"));
			out.println(Tools.back());
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
