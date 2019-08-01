package security.app.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.app.UserRoleRequestWrapper;
import security.app.Utils.AppUtils;
import security.app.Utils.SecurityUtils;
import security.app.data.User;

@WebFilter("/*")
public class SecurityFilter implements Filter {
	public SecurityFilter() {}
	public void destroy() {}
	
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)rsp;
		
		String spath=request.getServletPath();
		User loginedUser=AppUtils.getLoginedUser(request.getSession());
		if (spath.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}
		HttpServletRequest wrapReq=request;
		if (loginedUser!=null) {
			String userName=loginedUser.getuName();
			List<String> roles=loginedUser.getRoles();
			wrapReq=new UserRoleRequestWrapper(userName, roles, request);
		}
		if (SecurityUtils.isSecurityPage(request)) {
			if (loginedUser==null) {
				String reqUri=request.getRequestURI();
				int redirectId=AppUtils.storeRedirectAfterLoginUrl(request.getSession(), reqUri);
				response.sendRedirect(wrapReq.getContextPath()+"/login?redirectId="+redirectId);
				return;
			}
			boolean hasPermission=SecurityUtils.hasPermission(wrapReq);
			if (!hasPermission) {
				RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDenied.jsp");
				dispatcher.forward(request, response);
				return;
			}
		}
		chain.doFilter(wrapReq, response);
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
