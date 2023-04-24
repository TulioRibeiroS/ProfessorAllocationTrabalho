package professor.allocation.tulio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import professor.allocation.tulio.entity.Allocation;
import professor.allocation.tulio.repository.AllocationRepository;

@Service
public class AllocationService {

	@Autowired
	AllocationRepository allocationRepository;

	public ResponseEntity<Allocation> save(Allocation allocation) {
		return new ResponseEntity<>(allocationRepository.save(allocation), HttpStatus.CREATED);
	}

	public ResponseEntity<Allocation> findAllocationById(Integer id) {
		return ResponseEntity.ok(allocationRepository.findAllocationById(id));
	}

	public ResponseEntity<?> delete(Integer id) {
		try {
			allocationRepository.deleteById(id);
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<Allocation> update(Allocation department, Integer id) {
		department.setId(id);
		return ResponseEntity.ok(allocationRepository.save(department));
	}

	public ResponseEntity<List<Allocation>> findAll() {
		return ResponseEntity.ok(allocationRepository.findAll());
	}

	public ResponseEntity<?> deleteAll() {
		try {
			allocationRepository.deleteAll();
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}
	}
}
