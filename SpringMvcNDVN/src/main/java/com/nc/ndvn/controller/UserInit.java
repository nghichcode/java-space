package com.nc.ndvn.controller;

import java.util.HashSet;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.nc.model.User;
import com.nc.ndvn.service.RoleDAO;
import com.nc.ndvn.service.UserDAO;
import com.nc.pbackup.Role;

public class UserInit {
    private UserDAO userDao=new UserDAO();
    private RoleDAO roleDao=new RoleDAO();

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserInit() {
    	System.out.println("Hello!!!");
        // Roles
        if (roleDao.findByName("ROLE_ADMIN") == null) {roleDao.save(new Role("ROLE_ADMIN"));}
        if (roleDao.findByName("ROLE_MEMBER") ==null) {roleDao.save(new Role("ROLE_MEMBER"));}
        // Admin account
        String mail="admin@gmail.com";
        if (userDao.findByEmail(mail) == null) {
        	System.out.println("AD!!!");
            User admin = new User();
            admin.setEmail(mail);
            admin.setPassword(passwordEncoder.encode("abc123"));

            HashSet<Role> roles = new HashSet<>();
            roles.add(roleDao.findByName("ROLE_ADMIN"));
            roles.add(roleDao.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            userDao.save(admin);
        }
        // Member account
        mail="member@gmail.com";
        if (userDao.findByEmail(mail) == null) {
        	System.out.println("MB!!!");
            User user = new User();
            user.setEmail(mail);
            user.setPassword(passwordEncoder.encode("abc123"));
            
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleDao.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
          userDao.save(user);
        }
    }
        
}