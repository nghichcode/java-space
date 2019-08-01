package filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

@WebFilter(urlPatterns= {"*.png"}, initParams= {
	@WebInitParam(name="notFoundImg",value="/img/notfound.png")
})
public class LogFilterNext implements Filter {
	private String notFoundImg;
	public LogFilterNext() {}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.notFoundImg = filterConfig.getInitParameter("notFoundImg");
		System.out.println("Init next: "+notFoundImg);
	}
	@Override
	public void destroy() {
		System.out.println("Destroy N");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String sPath = ((HttpServletRequest)request).getServletPath();
		String realRootPath = request.getServletContext().getRealPath("");
		String imgPath = realRootPath+sPath;
		System.out.println(imgPath);
				
		File file = new File(imgPath);
		if (file.exists()) {chain.doFilter(request, response);}
		else if (!sPath.equals(this.notFoundImg)) {
			String s=((HttpServletRequest)request).getContextPath()+this.notFoundImg;
			System.out.println(s);
			((HttpServletResponse)response).sendRedirect(s);
		}
	}
}
