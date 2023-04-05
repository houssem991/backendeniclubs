package com.bezkoder.springjwt.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SalleRequest {
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String name;

	private String local;



}
