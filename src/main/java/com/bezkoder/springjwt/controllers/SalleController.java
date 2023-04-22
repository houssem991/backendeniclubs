package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Services.ISalleService;
import com.bezkoder.springjwt.models.Salle;
import com.bezkoder.springjwt.payload.request.SalleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/salle")
public class SalleController {

	@Autowired
	ISalleService iSalleService;

	@GetMapping("/all")
	public List<Salle> all() {
		return iSalleService.findall();
	}

	@GetMapping("/find/{id}")
	public Salle find(@PathVariable("id") long id)
	{
		Salle v=iSalleService.findbyId(id);

		return v;
	}


	@PostMapping("/add")
	public String add(@Valid @RequestBody SalleRequest v) {
		iSalleService.add(v);
		return "oki";
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") long id ,@Valid @RequestBody SalleRequest p) {
		iSalleService.update(id , p);
		return "Salle modifieé avec succes";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id ) {
		iSalleService.delete(id);
		return "oki";
	}
}
