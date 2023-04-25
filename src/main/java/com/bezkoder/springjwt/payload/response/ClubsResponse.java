package com.bezkoder.springjwt.payload.response;


import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ClubsResponse {
	private Long id;
	private String name;

	private int nbmembers;
	private String image;
    private String nameresp;

	public ClubsResponse() {
		this.id = id;
		this.name = name;
		this.nbmembers = nbmembers;
		this.image = image;
		this.nameresp = nameresp;
	}
}
