package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.BusinessChargeDao;
import com.mobile.model.BusinessCharge;
import com.mobile.utils.Tools;

public class Business_Charge extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		int id = Integer.parseInt(request.getParameter("businessID"));
		String[] chargeids = request.getParameterValues("chargeID");
		System.out.println(id);
		System.out.println(chargeids[0]);
		//删除
		BusinessChargeDao bcd = new BusinessChargeDao();
		int r = bcd.remove(id+"");
		//插入
		String msg = ""; 
		for(int i=0;i<chargeids.length;i++){
			BusinessCharge bc = new BusinessCharge(id, Integer.parseInt(chargeids[i]));
			System.out.println(bc);
			if(bcd.add(bc) == 0){
				msg += "(" + chargeids[i] + ")";
			}
		}
		if(chargeids.length == 0){
			bcd.add(new BusinessCharge(id, 0));
		}
		//跳转
		if(r == 0 || msg != ""){
			Tools.alert("修改出错！");
		}
		else{
			out.println(Tools.alert("修改完成！"));
		}
		out.println(Tools.location("Business_Conf?id="+id));
		
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
