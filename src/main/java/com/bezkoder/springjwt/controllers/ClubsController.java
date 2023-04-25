package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Services.IClubService;
import com.bezkoder.springjwt.models.Clubs;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.ClubsRequest;
import com.bezkoder.springjwt.payload.response.ClubsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clubs")
public class ClubsController {

	@Autowired
	IClubService iClubService;

	@GetMapping("/all")
	public List<ClubsResponse> all() {
		return iClubService.findall();
	}
	@GetMapping("/allr")
	public List<User> allresp() {
		return iClubService.findresp();
	}

	@GetMapping("/find/{id}")
	public Clubs find(@PathVariable("id") long id)
	{
		Clubs v=iClubService.findbyId(id);

		return v;
	}


	@PostMapping("/add")
	public String add(@Valid @RequestBody ClubsRequest v) {
		iClubService.add(v);
		return "oki";
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") long id ,@Valid @RequestBody ClubsRequest p) {
		iClubService.update(id , p);
		return "Club modifieé avec succes";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id ) {
		iClubService.delete(id);
		return "oki";
	}
}
