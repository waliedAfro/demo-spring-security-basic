package com.afro.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@GetMapping("/")
	public String greeting()
	{
		return "Helow Security";
	}
	
	@GetMapping("/add")
	public String addUSer()
	{
		return " please change the method to Post and Implement add user " ;
	}
	
	
	@GetMapping("/update")
	public String updateUser()
	{
		return "please change the method to Post and Implement update user" ;
	}
	
	@GetMapping("/show")
	public String listUser()
	{
		return "list all users ";
	}

}
