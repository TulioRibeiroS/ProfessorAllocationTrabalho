package professor.allocation.tulio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import professor.allocation.tulio.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	List<Department> findByNameContainingIgnoreCase(String name);

	void deleteById(Integer id);

	Department findDepartmentById(Integer id);
}
