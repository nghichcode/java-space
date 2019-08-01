package filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

public class LogFilter implements Filter {
	public LogFilter() {}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init");
	}
	@Override
	public void destroy() {
		System.out.println("Destroy");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String path=req.getServletPath();
		System.out.println("INFO: "+new Date()+" - Path: "+path+" - URL: "+req.getRequestURL());
		chain.doFilter(request, response);
	}
}
