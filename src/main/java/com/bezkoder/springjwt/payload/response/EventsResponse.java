package com.bezkoder.springjwt.payload.response;


import com.bezkoder.springjwt.models.EEvent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@Getter
@Setter
public class EventsResponse {
	private Long id;

	private String name;

	private String description;

	private EEvent etat;
	private LocalDate date;
	private String heure;

	private Set<String> namemateriels;

	private String namesalle;
	private Set<String> namerespclubs ;

	public EventsResponse() {
		this.id = id;
		this.name = name;
		this.description = description;
		this.etat = etat;
		this.date = date;
		this.heure = heure;
		this.namesalle = namesalle;
		this.namerespclubs = namerespclubs;
	}
}
