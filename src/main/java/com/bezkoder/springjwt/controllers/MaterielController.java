package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Services.IMaterielService;
import com.bezkoder.springjwt.models.Materiel;
import com.bezkoder.springjwt.payload.request.MaterielRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/materiel")
public class MaterielController {

	@Autowired
	IMaterielService iMaterielService;

	@GetMapping("/all")
	public List<Materiel> all() {
		return iMaterielService.findall();
	}

	@GetMapping("/find/{id}")
	public Materiel find(@PathVariable("id") long id)
	{
		Materiel v=iMaterielService.findbyId(id);

		return v;
	}


	@PostMapping("/add")
	public String add(@Valid @RequestBody MaterielRequest v) {
		iMaterielService.add(v);
		return "oki";
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") long id ,@Valid @RequestBody MaterielRequest p) {
		iMaterielService.update(id , p);
		return "Materiel modifieé avec succes";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") long id ) {
		iMaterielService.delete(id);
		return "oki";
	}
}
