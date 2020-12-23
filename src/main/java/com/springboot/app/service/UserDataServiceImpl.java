package com.springboot.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.app.dao.UserDAO;
import com.springboot.app.model.AuthResponse;
import com.springboot.app.model.UserData;

@Service
public class UserDataServiceImpl implements UserDataService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private JwtUtil jwtUtil;
	
		
	@Override
	public void register(UserData userRegistrationDetails) {
		// TODO Auto-generated method stub
		userDao.save(userRegistrationDetails);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserData> userData = userDao.findById(username);
		if(userData == null) {
			System.out.println("Unauthorized exception");
		}
		
		UserData user = userData.get();
		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

	@Override
	public UserData login(UserData userLoginCredentials) {
		// TODO Auto-generated method stub
		final UserDetails userDetails = loadUserByUsername(userLoginCredentials.getEmail());
		String uid = "";
		String authToken = "";
		if(userDetails.getPassword().equals(userLoginCredentials.getPassword())) {
			uid = userLoginCredentials.getEmail();
			authToken = jwtUtil.generateToken(userDetails);
			return new UserData(uid, null, null, authToken);
		}
		else {
			System.out.println("Unauthorized");
		}
		return userLoginCredentials;
	}

	@Override
	public AuthResponse getValidity(String token) {
		// TODO Auto-generated method stub
		AuthResponse res = new AuthResponse();
		if(jwtUtil.validateToken(token)) {
			res.setUid(jwtUtil.extractUsername(token));
			res.setValid(true);
			System.out.println(jwtUtil.extractUsername(token));
			res.setName(userDao.findById(jwtUtil.extractUsername(token)).get().getName());
		}
		else {
			res.setValid(false);
			System.out.println("invalid token");
		}
		return res;
	}
	
	
}
