package sugrado.hrmsproject.entities.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class CandidateForRegisterDto {
	private String emailAddress;
	private String password;
	private String passwordConfirm;
	private String firstName;
	private String lastName;
	private String identificationNumber;
	private LocalDate birthDate;
}
