package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.OperatorDao;
import com.mobile.model.Operator;

public class Login extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String id = request.getParameter("operatorId");
			String pwd = request.getParameter("operatorPwd");
			
			Operator o = null;
			OperatorDao dao = new OperatorDao();
			
			o = dao.login(id, pwd);
			
			if(o == null){			
				response.sendRedirect("login.jsp?msg=error!!");
			}
			else{
				request.getSession().setAttribute("login_operator", o);
				response.sendRedirect("index.jsp"); 
			}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
