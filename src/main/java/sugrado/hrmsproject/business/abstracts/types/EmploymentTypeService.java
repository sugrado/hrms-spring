package sugrado.hrmsproject.business.abstracts.types;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.EmploymentType;

import java.util.List;

public interface EmploymentTypeService {
    Result add(EmploymentType employmentType);

    Result update(EmploymentType employmentType);

    Result delete(EmploymentType employmentType);

    DataResult<List<EmploymentType>> getAll();

    DataResult<EmploymentType> getById(int id);
}
