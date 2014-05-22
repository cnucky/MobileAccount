package com.mobile.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.AccountDao;
import com.mobile.model.ModelInterface;
import com.mobile.utils.Tools;

public class AccountList extends HttpServlet {
	public static final int PAGE_SIZE = 5;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String contact_person = null;
		if(request.getParameter("contact_person")!=null){
			contact_person = Tools.toUTF8(request.getParameter("contact_person"));
		}
		
		int account_id = 0;
		if(request.getParameter("Account_ID")!=null && request.getParameter("Account_ID")!=""){
			account_id = Integer.parseInt(request.getParameter("Account_ID"));
		}
		AccountDao dao = new AccountDao();
		if(contact_person !=null || account_id !=0){
			List<ModelInterface> list = dao.query(account_id, contact_person);
			request.setAttribute("list",list);
			}
		else{
			int rowcount=0;
			if(dao.getAll() !=null)
				rowcount = dao.getAll().size();
			int pagenum = (int)Math.ceil(rowcount/(float)PAGE_SIZE);
			
			String page = request.getParameter("page");
			if(page == null){
				page = "1";
			}
			List<ModelInterface> list = dao.query(Integer.parseInt(page), PAGE_SIZE);
			System.out.println(list);
			request.setAttribute("list", list);
			request.setAttribute("pagenum", pagenum);
			request.setAttribute("rowcount", rowcount);
			request.setAttribute("page", page);
		}
		
		request.getRequestDispatcher("account_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
