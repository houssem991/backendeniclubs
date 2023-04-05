package com.bezkoder.springjwt.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MembreRequest {
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String firstname;

	private String  lastname;
	@Email
	private String email;
	private int numtel;



}
