package com.nc.ndvn.controller;

import java.util.HashSet;

import com.nc.model.MRole;
import com.nc.model.MUserLite;
import com.nc.model.MUserRoles;
import com.nc.model.User;
import com.nc.ndvn.service.MRoleDAO;
import com.nc.ndvn.service.MUserRoleDAO;
import com.nc.ndvn.service.RoleDAO;
import com.nc.ndvn.service.UserDAO;
import com.nc.pbackup.Role;

/**
 * @author diennv
 * Guide:
 * 	 Tạo role mới, hoặc tạo role cũ cùng ID
 *	 Account exists => khong update acc
 *	 Update user => tao user + id
 */
public class Controller {

	public static void main(String[] args) {
//		MRoleCall();
//		MUserRoleCall();
	}
	
	public static void MRoleCall() {
		MRoleDAO dao=new MRoleDAO();
		MRole mr=dao.findById(1);
	}

	public static void MUserRoleCall() {
		MUserRoleDAO dao=new MUserRoleDAO();
		MUserRoles mr=dao.findById(1);
	}

	public static void UserCall() {
	    UserDAO userDao=new UserDAO();
	    RoleDAO roleDao=new RoleDAO();
		System.out.println(MUserLite.class.getName());
		
		Role role = new Role("ADMIN_21");
		roleDao.save(role);
		Role role1 = new Role(12 ,"ADMIN_11");
		roleDao.save(role1);
		Role role2 = new Role("ADMIN_191");
//		roleDao.save(role2);
		
		User u = new User();
		u.setId(40);
        u.setEmail(role.getName()+"@ccd.ccc");
        u.setPassword("nc1234");
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);
        roles.add(role1);
        roles.add(role2);
        u.setRoles(roles);
//        userDao.save(u);
//        userDao.update(u);

//        CustomUserDetailsService cd=new CustomUserDetailsService();
//        UserDetails uds=cd.loadUserByUsername(role.getName()+"@ccd.ccc");
//        System.out.println(uds.getUsername()+"???"+uds.getPassword());
	}
}