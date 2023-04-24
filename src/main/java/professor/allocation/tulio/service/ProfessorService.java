package professor.allocation.tulio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import professor.allocation.tulio.entity.Professor;
import professor.allocation.tulio.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public ResponseEntity<Professor> save(Professor professor) {
		return new ResponseEntity<>(professorRepository.save(professor), HttpStatus.CREATED);
	}

	public ResponseEntity<Professor> findProfessorById(Integer id) {
		return ResponseEntity.ok(getProfessorById(id));
	}

	private Professor getProfessorById(Integer id) {
		return professorRepository.findProfessorById(id);
	}

	public ResponseEntity<?> delete(Integer id) {
		try {
			professorRepository.deleteById(id);
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> deleteAll() {
		try {
			professorRepository.deleteAll();
			return new ResponseEntity<>("Deletado com sucesso!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Não é possível deletar!", HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<?> update(Professor professor, Integer id) {
		professor.setId(id);
		Professor professorCadastrado = getProfessorById(id);

		if (professorCadastrado.getAllocations().stream().map(s -> s.getStartHour().toString()).toArray()[0]
				.equals(professor.getAllocations().stream().map(s -> s.getStartHour().toString()).toArray()[0])) {
			return new ResponseEntity<>("Data de inicio conflitante", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(professorRepository.save(professor), HttpStatus.OK);
	}

	public ResponseEntity<List<Professor>> findAll() {
		return ResponseEntity.ok(professorRepository.findAll());
	}

}
