package professor.allocation.tulio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import professor.allocation.tulio.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository <Professor, Long> {

	List<Professor> findByNameContainingIgnoreCase(String name);
	List<Professor> findByDepartmentId(Long departmentId);
}
