package com.nghichcode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nghichcode.libs.Constants;
import com.nghichcode.libs.UserInfo;;

@WebServlet("/loginz")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Login() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		UserInfo u= new UserInfo("Tin","VN",12);
		session.setAttribute(Constants.SESSION_USER_KEY, u);
		
		ServletOutputStream os=resp.getOutputStream();
		os.print("<html>");
		os.print("<head><meta charset='UTF-8'><title>Session ex</title></head>");
		os.print("<body><h1>Hello!!!!!</h1><a href='user'>USER</a></body>");
		os.print("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
