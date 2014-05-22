package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.MobilesDao;
import com.mobile.model.Mobiles;
import com.mobile.utils.Tools;

public class Upload_Mobiles extends HttpServlet {

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
		
		//System.out.println("Upload");
		//System.out.println(request.getContentLength());
		
ServletInputStream sis = request.getInputStream();
		
		byte[] buffer = new byte[1024];
		int len = 0;
		int line = 0;
		int byteCount = request.getContentLength();
		int recCount = 0;
		String msg = "";
		MobilesDao md = new MobilesDao();
		String test = "";
		
		while((len = sis.readLine(buffer, 0, buffer.length)) != -1){
			line++;
			byteCount -= len;
			if(line > 8 && byteCount > 0){
				String record = "";
				System.out.println("line=" + line);
				for(int i=0;i<len;i++){
					record += (char)buffer[i];
				}
				System.out.print(record);
				String[] s = record.split(",");
				if(s.length != 4){
					System.out.println(s.length);
					out.println(Tools.alert("文件格式有误！！！"));
				}
				else{
					Mobiles m = new Mobiles();
					m.setMobileNum(s[0]);
					m.setMobileType(s[1]);
					m.setCardNum(s[2]);
					m.setIsAvail(s[3]);
					if(md.add(m)==0){
						msg += "("+s[0]+")";
					}
					else{
						recCount++;
					}
				}
				
			}
		}
		if(msg == "" && recCount != 0){
			out.println(Tools.alert("添加成功！！！"));
		}
		else{
			out.println(Tools.alert("号码:" + msg + "添加失败！！！"));
		}
		
		sis.close();
		
		out.println(Tools.location("new_resource.jsp"));
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
