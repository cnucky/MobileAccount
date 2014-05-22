package com.mobile.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.OperatorDao;
import com.mobile.model.ModelInterface;
import com.mobile.model.Operator;
import com.mobile.utils.*;

public class OperatorList extends HttpServlet {

	public static final int PAGE_SIZE = 4;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String id = request.getParameter("operatorId");
			String name = request.getParameter("operatorName");
			
			OperatorDao dao = new OperatorDao();
			
			
			if(id !=null || name!=null) 
			{
				ArrayList<ModelInterface> list = dao.query(id, name);
				request.setAttribute("list", list);
			}
			else{
				int rowcount = dao.getAll().size();			
				int pagenum = (int)Math.ceil(rowcount/(float)PAGE_SIZE);
				
				String page = request.getParameter("page");
				if(page == null){
					page = "1";
				}
				
				ArrayList<ModelInterface> list = dao.query(Integer.parseInt(page), PAGE_SIZE);
				request.setAttribute("list", list);
				request.setAttribute("pagenum", pagenum);
				request.setAttribute("rowcount", rowcount);
				request.setAttribute("page", page);
				
			}
			
			request.getRequestDispatcher("operator_list.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request, response);
	}

}
