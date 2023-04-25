package com.bezkoder.springjwt.payload.request;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClubsRequest {
	private String name;

	private int nbmembers;
    private long idresp;


}
