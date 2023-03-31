package professor.allocation.tulio.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Column
	String name;
	@Column
	String cpf;
	//@Column
	//Integer departmentId;
	
	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	Department department;
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "professor")
	List<Allocation> allocations;
	
	
}
