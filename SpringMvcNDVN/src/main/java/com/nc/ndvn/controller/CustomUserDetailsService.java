package com.nc.ndvn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nc.ndvn.service.UserDAO;
import com.nc.pbackup.Role;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	private UserDAO userDAO=new UserDAO();

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
	 	com.nc.model.User u=userDAO.findByEmail(email);
	 	if(u==null) {return null;}
	 	System.out.println(u.getEmail()+"::CustomUserDetailsService::"+u.getPassword());
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		System.out.println("Role!!!");
		List<GrantedAuthority> authorities=new ArrayList<>();
		for (Role r : u.getRoles()) {authorities.add(new SimpleGrantedAuthority(r.getName()));System.out.println(r.getName());}
		
		return new User(u.getEmail(), u.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities); 
	 }
	
}
