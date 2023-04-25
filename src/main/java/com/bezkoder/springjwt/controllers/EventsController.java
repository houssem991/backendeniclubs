package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.Services.IEventsService;
import com.bezkoder.springjwt.models.Events;
import com.bezkoder.springjwt.payload.request.EventsRequest;

import com.bezkoder.springjwt.payload.response.EventsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/events")
public class EventsController {

	@Autowired
	IEventsService iEventsService;


	@GetMapping("/allA")
	public List<EventsResponse> allEnattente() {
		return iEventsService.findallenattente();
	}
	@GetMapping("/allr")
	public List<EventsResponse> allR() {
		return iEventsService.findallRepondu();
	}
	@GetMapping("/allnv/{username}")
	public List<EventsResponse> allNV(@PathVariable("username") String username) {
		return iEventsService.findallnonvalide(username);
	}

	@GetMapping("/find/{id}")
	public EventsResponse find(@PathVariable("id") long id)
	{


		return iEventsService.findbyId(id);
	}


	@PostMapping("/add")
	public String add(@Valid @RequestBody EventsRequest v) {
		iEventsService.add(v);
		return "oki";
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") long id ,@Valid @RequestBody EventsRequest p) {
		iEventsService.update(id , p);
		return "Event modifieé avec succes";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id ) {
		iEventsService.delete(id);
		return "oki";
	}
	@PutMapping("/sendA/{nameuser}/{idevent}")
	public String sendAcceptation(@PathVariable("nameuser") String nameuser,@PathVariable("idevent") long idevent ) throws Exception {
		return	iEventsService.sendacceptation(nameuser,idevent);

	}
	@PutMapping("/sendR/{nameuser}/{idevent}")
	public String sendRefus(@PathVariable("nameuser") String nameuser,@PathVariable("idevent") long idevent ) throws Exception {
		return	iEventsService.sendRefus(nameuser,idevent);

	}
}
