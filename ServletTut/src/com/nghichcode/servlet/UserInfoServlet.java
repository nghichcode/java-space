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

@WebServlet("/user")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserInfoServlet() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		UserInfo user=(UserInfo)session.getAttribute(Constants.SESSION_USER_KEY);
		
		if (user==null) {
			resp.sendRedirect(this.getServletContext().getContextPath()+"/login");
			return;
		}
		
		ServletOutputStream os=resp.getOutputStream();
		os.print("<html>");
		os.print("<head><meta charset='UTF-8'><title>Session ex</title></head><body>");
		os.print("<h1>User info</h1>");
		os.print("<p>User name: </p>"+user.getUserName());
		os.print("<p>User country: </p>"+user.getCountry());
		os.print("<p>User post: </p>"+user.getPost());
		os.print("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
