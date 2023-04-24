package professor.allocation.tulio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import professor.allocation.tulio.entity.Allocation;
import professor.allocation.tulio.service.AllocationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path = "/allocation")
public class AllocationController {

	@Autowired
	AllocationService allocationService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Allocation allocation) {
		return allocationService.save(allocation);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@RequestParam Integer id) {
		return allocationService.findAllocationById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Integer id) {
		return allocationService.delete(id);
	}

	public ResponseEntity<?> update(@RequestBody Allocation allocation, @PathVariable Integer id) {
		return allocationService.update(allocation, id);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return allocationService.findAll();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		return allocationService.deleteAll();
	}

}
