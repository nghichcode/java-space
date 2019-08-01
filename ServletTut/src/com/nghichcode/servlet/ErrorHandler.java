package com.nghichcode.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ErrorHandler() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream os = resp.getOutputStream();
		
		os.print("<html>");
		os.print("<head><meta charset='UTF-8'><title>Error</title></head>");
		os.print("<body><h1>Hello!!!!! PAGE NOT FOUND!</h1></body>");
		os.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
