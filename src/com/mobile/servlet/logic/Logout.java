package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
        if(session!=null){
          session.invalidate();
        }
      
       //从客户请求中得到cookie。
        Cookie[] cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
	        Cookie cookie=cookies[i];
	        if(cookie.getName().equals("myname")){
	            cookie.setMaxAge(0);
	            break;
	        }
        }
        
        response.sendRedirect("login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
