package professor.allocation.tulio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import professor.allocation.tulio.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Integer> {

	List<Allocation> findByProfessorId(Long professorId);

	void deleteById(Integer id);

	Allocation findAllocationById(Integer id);

}
