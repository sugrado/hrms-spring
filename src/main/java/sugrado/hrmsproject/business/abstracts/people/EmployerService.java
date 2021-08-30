package sugrado.hrmsproject.business.abstracts.people;

import com.fasterxml.jackson.core.JsonProcessingException;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.people.Employer;
import sugrado.hrmsproject.entities.dtos.CompareEmployerInfoDto;
import sugrado.hrmsproject.entities.dtos.EmployerUpdateRequestDto;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();

    DataResult<Employer> getById(int employerId);

    Result add(Employer employer);

    Result update(Employer employer);

    Result delete(Employer employer);

    Result updateRequest(EmployerUpdateRequestDto employerUpdateRequestDto);

    Result approveUpdateRequest(int employerId) throws JsonProcessingException;

    Result cancelUpdateRequest(int employerId);

    DataResult<List<CompareEmployerInfoDto>> listUpdateRequest();
}
