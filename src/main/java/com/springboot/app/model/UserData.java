package com.springboot.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@Table
public class UserData {

	public UserData(String uid, Object object, Object object2, String generateToken) {
		// TODO Auto-generated constructor stub
		this.email = uid;
		this.authToken = generateToken;
	}

	@Id
	@Column(name = "email", nullable = false, unique = true, length = 50)
	private String email;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "password", length = 150)
	private String password;
	
	@Column(name = "phone", length=150)
	private long phone;
	
	@Column(name = "address", length=400)
	private String address;
	
	private String authToken;

}
