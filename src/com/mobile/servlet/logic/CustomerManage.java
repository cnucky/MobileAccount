package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobile.dao.AccountDao;
import com.mobile.dao.CustomerDao;
import com.mobile.dao.MobilesDao;
import com.mobile.dao.UserDao;
import com.mobile.model.Account;
import com.mobile.model.Customer;
import com.mobile.model.ModelInterface;
import com.mobile.model.User;
import com.mobile.utils.Tools;

public class CustomerManage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		final int SIZE = 5;
		
		String step = request.getParameter("step");
		CustomerDao cusd = new CustomerDao();
		int rows = 0;
		
		if(step == null){
			step = "1";
		}
		
		if(step.equals("1")){
			
			ArrayList<ModelInterface> cuslist = cusd.getAll();
			
			rows = cuslist.size();
			int pages = (int)Math.ceil(rows/(float)SIZE);
			
			String page = request.getParameter("page");
			
			if(page == null){
				page = "1";
			}
			
			int pg = Integer.parseInt(page);
			if(pg > pages){
				pg = pages;
				page = pg+"";
			}
			if(pg < 1){
				pg = 1;
				page = pg+"";
			}
			
			cuslist = cusd.select(pg, SIZE);
			
			request.setAttribute("page", page);
			request.setAttribute("pages", pages);
			request.setAttribute("rows", rows);
			request.setAttribute("list", cuslist);
			
			request.getRequestDispatcher("customer_step1.jsp").forward(request, response);
		}
		else if(step.equals("2")){
			//添加客户页面
			
			request.getRequestDispatcher("customer_step2.jsp").forward(request, response);
		}
		else if(step.equals("3")){
			//用户列表
			int customerId = Integer.parseInt(request.getParameter("ID"));
			
			request.getRequestDispatcher("UserManage?step=1&customerID="+customerId).forward(request, response);
		}
		else if(step.equals("4")){
			//添加用户
			User u = new User();
			u.setAccountId(Integer.parseInt(request.getParameter("account")));
			u.setComLevel(request.getParameter("grade"));
			u.setCustomerId(Integer.parseInt(request.getParameter("id")));
			u.setMobileNumber(request.getParameter("mobileNum"));
			u.setRoamingStatus(request.getParameter("zt"));
			if(new UserDao().add(u) == 0){
				out.println(Tools.alert("添加失败！！"));
			}
			else{
				out.println(Tools.alert("添加成功！！"));
			}
			
			out.println(Tools.location("CustomerManage?step=3&ID="+request.getParameter("id")));
		}
		else if(step.equals("5")){
			//添加客户操作
			Customer c = new Customer();
			c.setCustomerAddress(Tools.toUTF8(request.getParameter("customerAddress")));
			c.setCustomerBirthday(request.getParameter("birthday_year")+"-"+request.getParameter("birthday_month")+"-"+request.getParameter("birthday_day"));
			c.setCustomerName(Tools.toUTF8(request.getParameter("customerName")));
			c.setCustomerSex(request.getParameter("customerSex"));
			c.setIdNumber(request.getParameter("idNumber"));
			c.setIdType(request.getParameter("idType"));
			
			if(cusd.add(c)==0){
				out.println(Tools.alert("添加失败！！"));
			}
			else{
				out.println(Tools.alert("添加成功！！"));
			}
			
			out.println(Tools.location("CustomerManage"));
			//request.getRequestDispatcher("CustomerManage").forward(request, response);
		}
		else if(step.equals("6")){
			//修改客户信息
			String cid = request.getParameter("ID");
			Customer c = (Customer) cusd.getObjectById(cid);
			request.setAttribute("customer", c);
			String[] birthday = c.getCustomerBirthday().split("-");
			request.setAttribute("birthday_year", birthday[0]);
			request.setAttribute("birthday_month", birthday[1]);
			request.setAttribute("birthday_day", birthday[2]);
			request.getRequestDispatcher("edit_customer.jsp").forward(request, response);
		}
		else if(step.equals("7")){
			//修改客户信息操作
			Customer c = new Customer();
			c.setCustomerId(request.getParameter("customer_id"));
			c.setCustomerAddress(Tools.toUTF8(request.getParameter("customerAddress")));
			c.setCustomerBirthday(request.getParameter("birthday_year")+"-"+request.getParameter("birthday_month")+"-"+request.getParameter("birthday_day"));
			c.setCustomerName(Tools.toUTF8(request.getParameter("customerName")));
			c.setCustomerSex(request.getParameter("customerSex"));
			c.setIdNumber(request.getParameter("idNumber"));
			c.setIdType(request.getParameter("idType"));
			
			if(cusd.update(c)==0){
				out.println(Tools.alert("修改失败！！"));
			}
			else{
				out.println(Tools.alert("修改成功！！"));
			}
			
			out.println(Tools.location("CustomerManage?step=6&ID="+request.getParameter("customer_id")));
		}
		else if(step.equals("8")){
			//添加账户
			String name = request.getParameter("addName");
			String addr = request.getParameter("addAddress");
			Double balance = 0.0;
			if(request.getParameter("addBalance") == null || request.getParameter("addBalance").equals("")){
				balance = Double.parseDouble(request.getParameter("addBalance"));
			}
			Account a = new Account();
			a.setAccountAddress(Tools.toUTF8(addr));
			a.setAccountName(Tools.toUTF8(name));
			a.setAccountBalance(balance);
			new AccountDao().add(a);
			request.getRequestDispatcher("CustomerManage?step=9").forward(request, response);
		}
		else if(step.equals("9")){
			//添加用户
			
			
			String prenum = request.getParameter("prenum");
			String type = request.getParameter("type");
			if(request.getParameter("prenum") == null || request.getParameter("prenum").equals("")){
				prenum = "%";
			}
			if(request.getParameter("type") == null || request.getParameter("type").equals("")){
				type = "SIM";
			}
			
			ArrayList<ModelInterface> numberlist = new MobilesDao().availNum(prenum, type);
			ArrayList<ModelInterface> acclist = new AccountDao().getAll();
			
			
			request.setAttribute("acclist", acclist);
			
			request.setAttribute("numberlist", numberlist);
			request.setAttribute("prenum", prenum);
			request.setAttribute("type", type);
			
			
			request.getRequestDispatcher("new_user.jsp").forward(request, response);
		}
		else if(step.equals("10")){
			
		}
		
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
