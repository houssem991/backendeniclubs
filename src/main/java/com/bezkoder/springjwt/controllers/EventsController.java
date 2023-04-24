package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.Services.IEventsService;
import com.bezkoder.springjwt.models.Events;
import com.bezkoder.springjwt.payload.request.EventsRequest;

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


	@GetMapping("/all")
	public List<Events> all() {
		return iEventsService.findall();
	}

	@GetMapping("/find/{id}")
	public Events find(@PathVariable("id") long id)
	{
		Events v=iEventsService.findbyId(id);

		return v;
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
	@PutMapping("/sendA/{iduser}/{idevent}")
	public String sendAcceptation(@PathVariable("iduser") long iduser,@PathVariable("idevent") long idevent ) throws Exception {
		return	iEventsService.sendacceptation(iduser,idevent);

	}
	@PutMapping("/sendR/{iduser}/{idevent}")
	public String sendRefus(@PathVariable("iduser") long iduser,@PathVariable("idevent") long idevent ) throws Exception {
		return	iEventsService.sendRefus(iduser,idevent);

	}
}
