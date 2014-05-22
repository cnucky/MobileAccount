package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.MobilesDao;
import com.mobile.model.Mobiles;
import com.mobile.utils.Tools;

public class New_Mobiles extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		String type = request.getParameter("num");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		
		if(begin != "" && end != ""){
			long b = Long.parseLong(begin);
			long e = Long.parseLong(end);
			long n = e-b;
			out.println(Tools.alert(b+""));
			out.println(Tools.alert(e+""));
			if(n<0){
				long t=b;
				b=e;
				e=t;
				n=-n;
			}
			n++;
			String msg = "";
			for(int i=0;i<n;i++){
				Mobiles m = new Mobiles();
				m.setMobileNum(b+i+"");
				m.setMobileType(type);
				m.setCardNum("");
				m.setIsAvail("Y");
				if(new MobilesDao().add(m)==0){
					msg += "("+(b+i)+")";
				}
			}
			if(msg == ""){
				out.println(Tools.alert("添加成功"));
				out.println(Tools.location("new_resource.jsp"));
			}
			else{
				out.println(Tools.alert("号码:"+msg+"添加失败!"));
				out.println(Tools.location("new_resource.jsp"));
			}
		}
		else{
			Mobiles m = new Mobiles();
			if(begin == ""){
				m.setMobileNum(end);
			}else{
				m.setMobileNum(begin);
			}
			m.setMobileType(type);
			m.setCardNum("");
			m.setIsAvail("Y");
			if(new MobilesDao().add(m)==0){
				out.println(Tools.alert("添加失败!"));
				out.println(Tools.location("new_resource.jsp"));
			}
			else{
				out.println(Tools.alert("添加成功!"));
				out.println(Tools.location("new_resource.jsp"));
			}
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
