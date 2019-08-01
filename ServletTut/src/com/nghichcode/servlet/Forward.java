package com.nghichcode.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nghichcode.libs.Constants;

@WebServlet("/forward")
public class Forward extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Forward() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String forward = req.getParameter("forward");
		String redirect = req.getParameter("redirect");
		if("true".equals(forward)){
			System.out.println("Forward.....");
			req.setAttribute(Constants.ATTRIBUTE_USER_NAME_KEY, "OKKKKKKK");
			RequestDispatcher dp=req.getServletContext().getRequestDispatcher("/showme");
			dp.forward(req, resp);
			return;
		}
		if("true".equals(redirect)){
			System.out.println("Redirect.....");
//			RequestDispatcher dp=req.getServletContext().getRequestDispatcher("/showme");
//			dp.forward(req, resp);
			String context=req.getContextPath();
			resp.sendRedirect(context+"/showme");
			return;
		}
		ServletOutputStream out=resp.getOutputStream();
		out.print("<h3>Text forward</h3>");
		out.print("Servlet Path:"+req.getServletPath());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
