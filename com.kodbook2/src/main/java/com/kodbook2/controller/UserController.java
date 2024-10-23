package com.kodbook2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook2.entities.User;
import com.kodbook2.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping("/signUp")
	public String addUser(@ModelAttribute User user) {
		
		//userExists
		String username=user.getUsername();
		String email=user.getEmail();
		boolean status = service.userExists(username,email);
		if(status==false)
		{
			service.addUser(user);
		}
		return "index";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password)
	{
		boolean status=service.validateUser(username,password);
		if(status==true)
		{
			return "home";
		}
		else {
			return "index";
		}
	}

}
