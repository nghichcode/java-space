package com.nc.ndvn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nc.model.User;
import com.nc.ndvn.service.UserDAO;

@Controller
public class UserController {
	private UserDAO mdao = new UserDAO();
	
	@RequestMapping({"/admin","User/admin"})
	public String admin() {return "home-admin";}
	@RequestMapping({"/user_p","User/user_p"})
	public String user() {return "home-user";}
	
	@RequestMapping("/logout")  
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	    if (auth != null){new SecurityContextLogoutHandler().logout(request, response, auth);}
	    return "redirect:/";  
	}
    @RequestMapping({"/login","User/login/"}) 
    public String getLogin(@RequestParam(value = "error", required = false) final String error,final Model model) {
    	System.out.println("LOG--- "+error);
    	if (error!=null) {  model.addAttribute("message", "Login Failedlg!"); }
    	return "login";
	}

	@RequestMapping(value="/User/{id}/findid",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public User findById(@PathVariable int id) {
		return (User) mdao.findById(id);
	}
	@RequestMapping(value="/User/{email}/findemail",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public User findByEmail(@PathVariable String email) {
		return (User) mdao.findByEmail(email);
	}
	
}
