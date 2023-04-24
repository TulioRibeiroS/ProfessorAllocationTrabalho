package professor.allocation.tulio.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false)
	DayOfWeek dayOfWeek;
	
	LocalDate startHour;
	LocalDate endHour;
	//Integer professorId;
	//Long curseId;
	
	@ManyToOne
	@JoinColumn(name = "professor_id", referencedColumnName = "id")
	Professor professor;
	@ManyToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	Course course;
}
