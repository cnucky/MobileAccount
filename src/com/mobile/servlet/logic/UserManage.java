package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.MobilesDao;
import com.mobile.dao.UserDao;
import com.mobile.model.ModelInterface;
import com.mobile.model.User;

public class UserManage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String step = request.getParameter("step");
		UserDao userd = new UserDao();
		String accountId = null;
		String customerId = null;
		String idstr = null;
		String userId = null;
		ArrayList<ModelInterface> userlist = new ArrayList<ModelInterface>();
		
		int rows = 0;
		
		if(step == null){
			step = "1";
		}
		
		if(step.equals("1")){
			
			if(request.getParameter("accountID") != null){
				accountId = request.getParameter("accountID");
				userlist = userd.selectAccId(accountId);
				idstr = "accountID=" + accountId;
			}
			else if(request.getParameter("customerID") != null){
				customerId = request.getParameter("customerID");
				userlist = userd.selectCusId(customerId);
				idstr = "customerID=" + customerId;
			}
			
			rows = userlist.size();
			System.out.println(userlist);
			
			request.setAttribute("rows", rows);
			request.setAttribute("list", userlist);
			
			request.getRequestDispatcher("list_user.jsp?"+idstr).forward(request, response);
		}
		else if(step.equals("2")){
			
			if(request.getParameter("customerID") != null){
				customerId = request.getParameter("customerID");
				userlist = userd.selectCusId(customerId);
				idstr = "customerID=" + customerId;
			}
			
			User u = new User();
			userId = request.getParameter("userID");
			u = (User) userd.getObjectById(userId);
			request.setAttribute("user", u);
			request.getRequestDispatcher("edit_user.jsp").forward(request, response);
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
