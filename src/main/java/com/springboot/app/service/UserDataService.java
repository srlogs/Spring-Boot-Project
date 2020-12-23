package com.springboot.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.springboot.app.model.AuthResponse;
import com.springboot.app.model.UserData;

public interface UserDataService extends UserDetailsService {
	
	public void register(@RequestBody UserData userRegistrationDetails);
	
	public UserData login(@RequestBody UserData userLoginCredentials);
	
	public AuthResponse getValidity(@RequestHeader("Authorization") final String token);
}
