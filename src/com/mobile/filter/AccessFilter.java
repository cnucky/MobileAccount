package com.mobile.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AccessFilter destroy....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			
			String url = ( (HttpServletRequest)request).getRequestURL().toString();
			System.out.println(url);
			String page = url.substring(url.lastIndexOf("/") + 1);
			System.out.println(page);
			
			HttpSession session =  ( (HttpServletRequest)request).getSession();
			
			if( !page.equals("login.jsp") && 
					!page.equals("Login") && 
					url.indexOf("images/") ==-1 && 
					url.indexOf("style/")==-1 && 
					
					session.getAttribute("login_operator") == null){
				
				((HttpServletResponse)response).sendRedirect("login.jsp");
			}
			else{
				chain.doFilter(request, response);
			}
			
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("AccessFilter init....");
	}

}
