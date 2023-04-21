package com.bezkoder.springjwt.controllers;



import com.bezkoder.springjwt.models.Events;

import com.bezkoder.springjwt.repository.EventsRepository;
import com.bezkoder.springjwt.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/events")
public class EventsController {

	/*@Autowired
	IVehiculeService iVehiculeService;*/
	@Autowired
	EventsRepository eventsRepository;

	@GetMapping("/all")
	public List<Events> all() {
		return eventsRepository.findAll();
	}

	/*@GetMapping("/find/{id}")
	public Vehicule find(@PathVariable("id") long id)
	{
		Vehicule v=iVehiculeService.findbyId(id);

		return v;
	}


	@PostMapping("/add")
	public String add(@Valid @RequestBody VehiculeRequest v) {
		iVehiculeService.add(v);
		return "oki";
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") long id ,@Valid @RequestBody VehiculeRequest p) {
		iVehiculeService.update(id , p);
		return "vehicule modifieé avec succes";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id ) {
		iVehiculeService.delete(id);
		return "oki";
	}*/
}
