package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.BusinessChargeDao;
import com.mobile.dao.BusinessDao;
import com.mobile.dao.ChargeDao;
import com.mobile.model.ModelInterface;

public class Business_Conf extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String id;
		if(request.getParameter("id") != null){
			id = request.getParameter("id");
		}
		else{		
			id = "1";
		}
		
		BusinessChargeDao bcd = new BusinessChargeDao();
		ArrayList<ModelInterface> bclist = bcd.getAll(id);
		
		ChargeDao cd = new ChargeDao();
		ArrayList<ModelInterface> clist = cd.getAll();
		
		BusinessDao bd = new BusinessDao();
		ArrayList<ModelInterface> blist = bd.getAll();
		
		request.setAttribute("bclist", bclist);
		request.setAttribute("clist", clist);
		request.setAttribute("blist", blist);
		request.setAttribute("id", id);
		
		request.getRequestDispatcher("business_conf.jsp").forward(request, response);
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
