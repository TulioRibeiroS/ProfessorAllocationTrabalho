package professor.allocation.tulio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import professor.allocation.tulio.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findByNameContainingIgnoreCase(String name);

	void deleteById(Integer id);

	Course findCourseById(Integer id);
}
