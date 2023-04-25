package com.bezkoder.springjwt.controllers;


import com.bezkoder.springjwt.Services.IEventMaterielService;
import com.bezkoder.springjwt.payload.request.EventMaterielRequest;
import com.bezkoder.springjwt.payload.response.EventMAtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/eventMateriel")
public class EventMaterielController {

	@Autowired
	IEventMaterielService iEventMaterielService;

	@GetMapping("/all/{idevent}")
	public List<EventMAtResponse> all(@PathVariable("idevent") long idevent) {
		return iEventMaterielService.findall(idevent);
	}

	@GetMapping("/find/{idevent}/{idmateriel}")
	public Optional<Events_Materiel> find(@PathVariable("idevent") long idevent, @PathVariable("idmateriel") long idmateriel)
	{
		Optional<Events_Materiel> v=iEventMaterielService.findbyId(idevent,idmateriel);

		return v;
	}


	@PostMapping("/add")
	public String add(@Valid @RequestBody EventMaterielRequest v) {
		iEventMaterielService.add(v);
		return "oki";
	}
	@PutMapping("/update")
	public String update(@Valid @RequestBody EventMaterielRequest p) {
		iEventMaterielService.update(p);
		return "EventMateriel modifieé avec succes";
	}
	@DeleteMapping("/delete/{idevent}/{idmateriel}")
	public String delete(@PathVariable("idevent") long idevent, @PathVariable("idmateriel") long idmateriel ) {
		iEventMaterielService.delete(idevent,idmateriel);
		return "oki";
	}
}*/
