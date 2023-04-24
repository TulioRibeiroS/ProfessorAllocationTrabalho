package professor.allocation.tulio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import professor.allocation.tulio.entity.Professor;
import professor.allocation.tulio.service.ProfessorService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Professor professor) {
		return professorService.save(professor);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@RequestParam Integer id) {
		return professorService.findProfessorById(id);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return professorService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		return professorService.delete(id);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		return professorService.deleteAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Professor professor, @PathVariable Integer id) {
		return professorService.update(professor, id);
	}

}