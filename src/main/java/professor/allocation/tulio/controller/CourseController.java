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

import professor.allocation.tulio.entity.Course;
import professor.allocation.tulio.service.CourseService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService courseService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Course course) {
		return courseService.save(course);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@RequestParam Integer id) {
		return courseService.findCourseById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Integer id) {
		return courseService.delete(id);

	}

	public ResponseEntity<?> update(@RequestBody Course course, @PathVariable Integer id) {
		return courseService.update(course, id);
	}

	@GetMapping
	public ResponseEntity<?> findAll() {
		return courseService.findAll();
	}

	@DeleteMapping
	public ResponseEntity<?> deleteAll() {
		return courseService.deleteAll();
	}

}
