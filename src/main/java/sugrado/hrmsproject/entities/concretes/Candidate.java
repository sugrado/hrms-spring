package sugrado.hrmsproject.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{

	@NotEmpty(message = "İsim boş olamaz.")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "Soyisim boş olamaz.")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "TC no boş olamaz.")
	@Column(name = "identification_number")
	private String identificationNumber;

	@NotEmpty(message = "Doğum yılı boş olamaz.")
	@Column(name = "birth_date")
	private LocalDate birthDate;

}
