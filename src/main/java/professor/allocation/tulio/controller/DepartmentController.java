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

import professor.allocation.tulio.entity.Department;
import professor.allocation.tulio.service.DepartmentService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Department department) {
		return departmentService.save(department);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@RequestParam Integer id) {
		return departmentService.findDepartmentById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Integer id) {
		return departmentService.delete(id);
	}

	public ResponseEntity<?> update(@RequestBody Department department, @PathVariable Integer id) {
		return departmentService.update(department, id);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return departmentService.findAll();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		return departmentService.deleteAll();
	}
}