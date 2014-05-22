package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.AccountDao;
import com.mobile.model.Account;
import com.mobile.model.ModelInterface;
import com.mobile.utils.Tools;

public class AccountManage extends HttpServlet {

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

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		final int SIZE = 5;
		
		String step = request.getParameter("step");
		AccountDao accd = new AccountDao();
		int rows = 0;
		
		if(step == null){
			step = "1";
		}
		
		if(step.equals("1")){
			
			ArrayList<ModelInterface> acclist = accd.getAll();
			
			rows = acclist.size();
			int pages = (int)Math.ceil(rows/(float)SIZE);
			
			String page = request.getParameter("page");
			
			if(page == null){
				page = "1";
			}
			
			int pg = Integer.parseInt(page);
			if(pg > pages){
				pg = pages;
				page = pg+"";
			}
			if(pg < 1){
				pg = 1;
				page = pg+"";
			}
			
			acclist = accd.select(pg, SIZE);
			
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("rows", rows);
			request.setAttribute("list", acclist);
			
			request.getRequestDispatcher("list_account.jsp").forward(request, response);
		}
		else if(step.equals("2")){
			//添加账户
			request.getRequestDispatcher("new_account.jsp").forward(request, response);
		}
		else if(step.equals("3")){
			//添加账户处理
			Account a = new Account();
			double balance = 0;
			if(request.getParameter("money") != null && request.getParameter("money") != ""){
				balance = Double.parseDouble(request.getParameter("money"));
			}
			a.setAccountAddress(request.getParameter("Contact_Address"));
			a.setAccountBalance(balance);
			a.setAccountName(request.getParameter("Contact_Person"));
			if(accd.add(a)==0){
				out.println(Tools.alert("添加失败！！"));
			}
			else{
				out.println(Tools.alert("添加成功！！"));
			}
			out.println(Tools.location("AccountManage"));
		}
		else if(step.equals("4")){
			
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		doGet(request, response);
	}

}
