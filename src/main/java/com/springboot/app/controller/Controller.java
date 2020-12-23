package com.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.AuthResponse;
import com.springboot.app.model.UserData;
import com.springboot.app.service.UserDataServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	private UserDataServiceImpl userDataService;
	
	@Value("${spring.application.name}")
	String appName;
	
	
	@RequestMapping("/helloworld")
	public String check() {
		return "hello world";
	}
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
		return "home";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserData userRegistrationDetails) {
		userDataService.register(userRegistrationDetails);
		return "registration is successfull";
	}
	
	@PostMapping("/login")
	public UserData login(@RequestBody UserData userLoginCredentials) {
		return userDataService.login(userLoginCredentials);
	}
	
	@GetMapping("/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") final String token) {
		return userDataService.getValidity(token);
		
	}

}
