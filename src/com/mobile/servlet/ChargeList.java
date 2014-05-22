package com.mobile.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.*;
import com.mobile.model.*;
import com.mobile.utils.Tools;

public class ChargeList extends HttpServlet {
	public static final int PAGE_SIZE = 5;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cname = request.getParameter("Charge_Name");
		String cid = request.getParameter("Charge_ID");
		
		ChargeDao dao = new ChargeDao();
		if(cname != null || cid != null){
			
			List<ModelInterface> list = dao.query(cid, cname);
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
			//System.out.print(list);
			//System.out.print(request.getParameter("Charge_ID"));
			request.setAttribute("list", list);
			request.setAttribute("pagenum", pagenum);
			request.setAttribute("rowcount", rowcount);
			request.setAttribute("page", page);
		}
		
		request.getRequestDispatcher("charge_list.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
