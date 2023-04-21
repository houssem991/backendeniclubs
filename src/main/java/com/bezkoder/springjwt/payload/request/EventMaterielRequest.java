package com.bezkoder.springjwt.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EventMaterielRequest {
	private Long idevent;


	private Long idmateriel;

	private int quantite;



}
