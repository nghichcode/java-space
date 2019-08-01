package jstl.core;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jstl.beans.Dept;
import jstl.utils.DBUtils;

@WebServlet("/core01")
public class JstlCore01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public JstlCore01() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Dept> list = DBUtils.queryDepartments();
		req.setAttribute("departments", list);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jstl/JstlCore01.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}