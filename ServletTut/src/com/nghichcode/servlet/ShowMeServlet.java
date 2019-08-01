package com.nghichcode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nghichcode.libs.Constants;

@WebServlet("/showme")
public class ShowMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ShowMeServlet() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val=(String)req.getAttribute(Constants.ATTRIBUTE_USER_NAME_KEY);
		
		ServletOutputStream out=resp.getOutputStream();
		out.print("<h3>SHOW ME</h3>");
		out.print("Servlet DATA:"+val);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
