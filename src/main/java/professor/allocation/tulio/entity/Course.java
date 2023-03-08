package professor.allocation.tulio.entity;

import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String name;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@OneToMany(mappedBy = "course")
	Set<Allocation> allocations;
}
