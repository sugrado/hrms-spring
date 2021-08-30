package sugrado.hrmsproject.entities.dtos;

import lombok.Data;
import sugrado.hrmsproject.entities.concretes.people.Employer;

@Data
public class CompareEmployerInfoDto {
    private Employer oldContent;
    private Employer newContent;
}
