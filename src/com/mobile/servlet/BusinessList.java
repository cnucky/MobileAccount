package com.mobile.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.BusinessDao;
import com.mobile.model.ModelInterface;
import com.mobile.utils.Tools;

public class BusinessList extends HttpServlet {
	public static final int PAGE_SIZE = 5;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bid = request.getParameter("Business_ID");
		String bname = request.getParameter("Business_Name");
		
		BusinessDao dao = new BusinessDao();
		if(bname != null || bid != null){
			List<ModelInterface> list = dao.query(bid, bname);
			request.setAttribute("list",list);
			}
		else{
			int rowcount = dao.getAll().size();
			int pagenum = (int)Math.ceil(rowcount/(float)PAGE_SIZE);
			
			String page = request.getParameter("page");
			if(page == null){
				page = "1";
			}
			List<ModelInterface> list = dao.query(Integer.parseInt(page), PAGE_SIZE);
			System.out.println(list);
			request.setAttribute("list", list);
			request.setAttribute("pagenum1", pagenum);
			request.setAttribute("rowcount1", rowcount);
			request.setAttribute("page1", page);
		}
		
		request.getRequestDispatcher("business_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
