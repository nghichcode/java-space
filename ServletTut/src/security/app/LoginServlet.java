package security.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.app.Utils.AppUtils;
import security.app.data.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {super();}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Map<String, User> mapUsers = new HashMap<String, User>();
		User emp=new User("emp","1111",User.MALE,SecurityConfig.ROLE_EMPLOYEE);
		User mng=new User("mng","1234",User.MALE,SecurityConfig.ROLE_EMPLOYEE,SecurityConfig.ROLE_MANAGER);
		mapUsers.put(emp.getuName(), emp);
		mapUsers.put(mng.getuName(), mng);
		User u=mapUsers.get(userName);

		User user=null;
		if (u!=null && u.getPassword().equals(password)) {user=u;}

		if (user == null) {
			RequestDispatcher dispatcher=this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		AppUtils.storeLoginedUser(request.getSession(), user);

		int redirectId = -1;
		try {redirectId = Integer.parseInt(request.getParameter("redirectId"));
		} catch (Exception e) {System.out.println(e);}
		
		String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		if (requestUri != null) {response.sendRedirect(requestUri);
		} else {response.sendRedirect(request.getContextPath() + "/userinfo");}

	}
}