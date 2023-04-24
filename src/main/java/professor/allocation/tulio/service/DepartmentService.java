package professor.allocation.tulio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import professor.allocation.tulio.entity.Department;
import professor.allocation.tulio.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public ResponseEntity<Department> save(Department department) {
		return new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
	}

	public ResponseEntity<Department> findDepartmentById(Integer id) {
		return ResponseEntity.ok(departmentRepository.findDepartmentById(id));
	}

	public ResponseEntity<?> delete(Integer id) {
		try {
			departmentRepository.deleteById(id);
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar. Id não encontrado!", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<Department> update(Department department, Integer id) {
		department.setId(id);
		return ResponseEntity.ok(departmentRepository.save(department));
	}

	public ResponseEntity<List<Department>> findAll() {
		return ResponseEntity.ok(departmentRepository.findAll());
	}

	public ResponseEntity<?> deleteAll() {

		try {
			departmentRepository.deleteAll();
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}

	}
}
