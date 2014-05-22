package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.BusinessDao;
import com.mobile.dao.ChargeDao;
import com.mobile.model.Business;
import com.mobile.model.Charge;
import com.mobile.utils.Tools;

public class AddBusiness extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initPackageHead(response);
		PrintWriter out = response.getWriter();
		Business b=deal(request);
		BusinessDao dao = new BusinessDao();
		if(dao.add(b)!=0){
			out.println(Tools.alert("ok!"));
			out.println(Tools.location("BusinessList"));
		}else{
			out.println(Tools.alert("error!"));
			out.println(Tools.location("new_business.jsp"));
		}
		out.flush();
		out.close();
	}

	public void initPackageHead(HttpServletResponse response){
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
	}
	
	public Business deal(HttpServletRequest request){
		String businessname = Tools.toUTF8(request.getParameter("businame"));
		String businessdetail = null;
		if(Tools.toUTF8(request.getParameter("busidetail"))!=null){
			
			businessdetail = Tools.toUTF8(request.getParameter("busidetail"));
		}
		Business b = new Business();
		b.setBusinessName(businessname);
		b.setInstruction(businessdetail);
		return b;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
