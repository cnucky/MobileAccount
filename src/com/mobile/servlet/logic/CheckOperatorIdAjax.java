package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.OperatorDao;
import com.mobile.model.Operator;

public class CheckOperatorIdAjax extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		OperatorDao dao = new OperatorDao();
		if(dao.getObjectById(Integer.parseInt(id)) == null){
			//out.print("<font color='green'>ID可以使用</font>");
			out.print("0");
		}
		else{
			//out.print("<font color='red'>ID已被占用</font>");
			out.print("1");
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request, response);
	}
}
