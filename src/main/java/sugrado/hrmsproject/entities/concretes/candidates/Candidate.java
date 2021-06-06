package sugrado.hrmsproject.entities.concretes.candidates;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sugrado.hrmsproject.core.entities.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {

	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;

	@Column(name = "identification_number")
	@NotBlank
	@NotNull
	private String identificationNumber;

	@Column(name = "birth_date")
	@NotBlank
	@NotNull
	private LocalDate birthDate;

	@OneToOne(mappedBy = "candidate")
	@JsonIgnore
	private CandidateCv candidateCv;
}
