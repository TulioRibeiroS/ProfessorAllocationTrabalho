package professor.allocation.tulio.repository;

import static org.mockito.ArgumentMatchers.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import professor.allocation.tulio.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	public void save_create() {
		// Arrange
		Department department = new Department();
		department.setId(null);
		department.setName("Department teste");

		// ACT
		department = departmentRepository.save(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void findAll() {
		// Act
		List<Department> departments = departmentRepository.findAll();

		// Print
		departments.forEach(System.out::println);
	}

	@Test
	public void save_update() {
		// Arrange
		Department department = new Department();
		department.setId(1);
		department.setName("Qualquer um outro");

		// Act
		department = departmentRepository.save(department);

		// Print
		System.out.println(department);
	}

	@Test
	public void findById() {

		// Act
		Department department = departmentRepository.findById(anyInt()).orElse(null);

		// Print
		System.out.println(department);
	}

	@Test
	public void deleteById() {

		// Act
		departmentRepository.deleteById(anyInt());
	}
}