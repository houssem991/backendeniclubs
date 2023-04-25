package com.bezkoder.springjwt.payload.response;


import com.bezkoder.springjwt.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class EventMAtResponse {

private String nameevent;
private String namemateriel;
private int quantite;

	public EventMAtResponse() {
		this.nameevent = nameevent;
		this.namemateriel = namemateriel;
		this.quantite = quantite;
	}
}
