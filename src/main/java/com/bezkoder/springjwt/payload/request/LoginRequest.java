package com.bezkoder.springjwt.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

private String email;
	@NotBlank
	private String password;


	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
