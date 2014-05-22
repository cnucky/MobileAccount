package com.mobile.servlet.logic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobile.dao.OperatorDao;
import com.mobile.model.Operator;
import com.mobile.utils.Tools;

public class OperatorModify extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("operatorId");
		String flag = request.getParameter("flag");
		OperatorDao dao = new OperatorDao();
		Operator o = null;
		
		System.out.println(id);
		System.out.println(flag);
		
		if( flag != null || flag == "" ){
			if(flag.equals("operatormodify") && id != null){
				o = (Operator)dao.getObjectById(Integer.parseInt(id));
				o.setOperatorName(request.getParameter("operatorName"));
				o.setOperatorPwd(request.getParameter("operatorPwd"));
				String isadmin = request.getParameter("isAdmin");
				if(isadmin == null) isadmin = "N";
				o.setIsAdmin(isadmin);

				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				if(dao.update(o) == 1){
					out.print(Tools.alert("修改成功！"));
				}
				else{
					out.print(Tools.alert("修改失败！"));
				}
			}
			if(flag.equals("delete")){
				String[] ids = request.getParameterValues("ids");
				
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				out.print(Tools.alert(ids.length + ""));
				System.out.print(ids.length);
				if(ids.length == 0) out.print(Tools.alert("未选中任何条目！"));
				else{
					int i;
					for(i = 0; i < ids.length; i++){
						if(dao.remove(ids[i]) == 0 ) break;
					}
					if(i == ids.length) out.print(Tools.alert("删除成功！"));
					else out.print(Tools.alert("删除失败！"));
				}
			}
			response.sendRedirect("OperatorList");
		}
		else {
			o = (Operator)dao.getObjectById(Integer.parseInt(id));
			request.setAttribute("operatorId", o.getOperatorId());
			request.setAttribute("operatorName", o.getOperatorName());
			request.setAttribute("operatorPwd", o.getOperatorPwd());
			request.setAttribute("isAdmin", o.getIsAdmin());
			request.getRequestDispatcher("operator_modify.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
