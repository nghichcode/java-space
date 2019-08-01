package security.app.data;

import java.util.ArrayList;
import java.util.List;

public class User {
	public static final String MALE = "M";
	public static final String FEMALE = "F";

	private String uName;
	private String gender;
	private String password;
	private List<String> roles;	

	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public User() {}
	public User(String uName, String password,String gender,String... roles) {
		this.uName=uName;
		this.password=password;
		this.gender=gender;
		this.roles=new ArrayList<String>();
		if (roles!=null) {for (String r: roles) {this.roles.add(r);}}
	}
}
