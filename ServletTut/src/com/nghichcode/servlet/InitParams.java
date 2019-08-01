package com.nghichcode.servlet;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String emailGlob;
	public InitParams() {}
	
	@Override
	public void init(ServletConfig cf) throws ServletException {
		super.init(cf);
		this.emailGlob = cf.getInitParameter("emailGlob");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emailLoc = this.getServletConfig().getInitParameter("emailLoc");
		ServletOutputStream os = resp.getOutputStream();
		
		os.print("<html><head><meta charset='UTF-8'><title>Hello</title></head><body>");
		os.print("<h1>Hello!!!!!</h1>");
		os.print("<p>Email Glob: "+this.emailGlob+"</p>");
		os.print("<p>Email Locl: "+emailLoc+"</p>");
		os.print("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
