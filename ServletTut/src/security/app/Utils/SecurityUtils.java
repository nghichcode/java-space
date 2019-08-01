package security.app.Utils;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import security.app.SecurityConfig;

public class SecurityUtils {
	public static boolean isSecurityPage(HttpServletRequest request) {
		String urlPattern=UrlPatternUtils.getUrlPattern(request);
		
		Set<String> roles=SecurityConfig.getAllRoles();
		for (String r: roles) {
			List<String> urlPatterns=SecurityConfig.getUrlPatternsForRole(r);
			if (urlPatterns!=null && urlPatterns.contains(urlPattern)) {return true;}
		}
		return false;
	}
	
	public static boolean hasPermission(HttpServletRequest request) {
		String urlPattern=UrlPatternUtils.getUrlPattern(request);
		
		Set<String> aLLRoles=SecurityConfig.getAllRoles();
		for (String r: aLLRoles) {
			if (!request.isUserInRole(r)) {continue;}
			List<String> urlPatterns=SecurityConfig.getUrlPatternsForRole(r);
			if (urlPatterns!=null && urlPatterns.contains(urlPattern)) {return true;}
		}
		return false;
		
	}
}
