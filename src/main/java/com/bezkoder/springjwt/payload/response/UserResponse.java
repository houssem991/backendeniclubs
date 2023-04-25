package com.bezkoder.springjwt.payload.response;


import com.bezkoder.springjwt.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class UserResponse {

	private Long id;


	private String username;
	private String firstname;
	private String lastname;
	private String cin;
	private LocalDate datenaissance;


	private String email;


	private String password;
	private String image;
	private long idclub;


	private Set<Role> roles = new HashSet<>();

	public UserResponse() {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.cin = cin;
		this.datenaissance = datenaissance;
		this.email = email;
		this.password = password;
		this.image = image;
		this.idclub = idclub;
		this.roles = roles;
	}
}
