package sugrado.hrmsproject.core.adapters.kpsAdapter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenCard {
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
