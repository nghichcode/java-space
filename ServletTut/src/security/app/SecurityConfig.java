package security.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {
	public static final String ROLE_MANAGER= "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	
	private static final Map<String, List<String>> mapConfig=new HashMap<String, List<String>>();
	static {init();}

	private static void init() {
		List<String> urlPattern1=new ArrayList<String>();
		urlPattern1.add("/userinfo");
		urlPattern1.add("/employeeTask");
		mapConfig.put(ROLE_EMPLOYEE, urlPattern1);
		
		List<String> urlPattern2=new ArrayList<String>();
		urlPattern2.add("/userinfo");
		urlPattern2.add("/managerTask");
		mapConfig.put(ROLE_EMPLOYEE, urlPattern2);
	}
	
	public static Set<String> getAllRoles() {return mapConfig.keySet();}
	public static List<String> getUrlPatternsForRole(String role) {return mapConfig.get(role);}
}
