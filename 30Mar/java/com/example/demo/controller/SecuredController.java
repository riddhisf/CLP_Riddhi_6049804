package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MyUser;
import com.example.demo.service.UserService;

@RestController
public class SecuredController {
	@Autowired
	UserService service;
	@GetMapping("/publicEndPoint")
	public String forPublic() {
		return "this is the open endPoint for public.";
	}
	@GetMapping("/securedUserEndPoint")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String forUsers() {
		return "this is the secured endPoint for users only.";
	}
	@GetMapping("/securedAdminEndPoint")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String forAdmin() {
		return "this is the secured endPoint for admin only.";
	}
	@PostMapping("/user") 
	public MyUser addUser(@RequestBody MyUser user){
		return service.addUser(user);
	}
	@PostMapping("/authenticateuser")
	public String authenticateUser(MyUser user) {
		return service.authenticateUser(user);
	}
}
