package security.app.Utils;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class UrlPatternUtils {
	private static boolean hasUrlPattern(ServletContext ctx,String urlPattern) {
		Map<String, ? extends ServletRegistration> map=ctx.getServletRegistrations();
		
		for (String name: map.keySet()) {
			ServletRegistration sr=map.get(name);
			Collection<String> mappings=sr.getMappings();
			if (mappings.contains(urlPattern)) {return true;}
		}
		return false;
	}
	
	public static String getUrlPattern(HttpServletRequest request) {
		ServletContext ctx=request.getServletContext();
		String sPath=request.getServletPath();
		String pathInfo=request.getPathInfo();
		
		if (pathInfo!=null) {return sPath+"/*";}
		String urlPattern=sPath;
		if (hasUrlPattern(ctx, urlPattern)) {return urlPattern;}
		
		int i=sPath.lastIndexOf('.');
		if (i!=-1) {
			String ext=sPath.substring(i+1);
			if (hasUrlPattern(ctx, "*."+ext)) {return "*."+ext;}
		}
		return "/";
	}
}
