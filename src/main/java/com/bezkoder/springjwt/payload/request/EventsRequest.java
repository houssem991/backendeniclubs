package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.EEvent;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class EventsRequest {
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String name;

	private String description;
	private LocalDate date;
	private String heure;
	private long idsalle;
	private Set<String> nameClubs;
	private Set<String> nameMateriels;



}
