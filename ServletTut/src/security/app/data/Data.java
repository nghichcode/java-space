package security.app.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import security.app.SecurityConfig;

public class Data {
	private static Map<String, User> mapUsers = new HashMap<String, User>();
	static {initUsers();}
	
	private static void initUsers() {
		User emp=new User("emp","1111",User.MALE,SecurityConfig.ROLE_EMPLOYEE);
		User mng=new User("mng","1234",User.MALE,SecurityConfig.ROLE_EMPLOYEE,SecurityConfig.ROLE_MANAGER);
		
		mapUsers.put(emp.getuName(), emp);
		mapUsers.put(mng.getuName(), mng);
	}
	
	public static User findUser(String uName,String password) {
		System.out.println("--------------------------");
		Set<String> ks=mapUsers.keySet();
		for (String k: ks) {
			System.out.println(k);
		}
		System.out.println("--------------------------");
		User u=mapUsers.get(uName);
		if (u!=null && u.getPassword().equals(password)) {return u;}
		return null;
	}
}
