package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.OperatorDao;
import com.mobile.model.Operator;
import com.mobile.utils.Tools;

public class AddOperator extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Operator o = new Operator();
		OperatorDao dao = new OperatorDao();
		
		o.setOperatorId(request.getParameter("operatorId"));
		o.setOperatorName(request.getParameter("operatorName"));
		o.setOperatorPwd(request.getParameter("operatorPwd"));
		String isadmin = request.getParameter("isAdmin");
		if(isadmin == null) isadmin = "N";
		o.setIsAdmin(isadmin);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if(dao.add(o) == 1){
			out.print(Tools.alert("添加成功！"));
		}
		else{
			out.print(Tools.alert("添加失败！"));
		}
		
		out.print(Tools.location("new_operator.jsp"));
		
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
