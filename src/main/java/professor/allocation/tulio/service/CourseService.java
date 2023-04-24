package professor.allocation.tulio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import professor.allocation.tulio.entity.Course;
import professor.allocation.tulio.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;

	public ResponseEntity<Course> save(Course course) {
		return new ResponseEntity<>(courseRepository.save(course), HttpStatus.CREATED);
	}

	public ResponseEntity<Course> findCourseById(Integer id) {
		return ResponseEntity.ok(courseRepository.findCourseById(id));
	}

	public ResponseEntity<?> delete(Integer id) {
		try {
			courseRepository.deleteById(id);
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Course> update(Course course, Integer id) {
		course.setId(id);
		return ResponseEntity.ok(courseRepository.save(course));
	}

	public ResponseEntity<List<Course>> findAll() {
		return ResponseEntity.ok(courseRepository.findAll());
	}

	public ResponseEntity<?> deleteAll() {
		try {
			courseRepository.deleteAll();
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}
	}

}
