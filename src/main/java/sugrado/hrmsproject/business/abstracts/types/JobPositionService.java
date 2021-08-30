package sugrado.hrmsproject.business.abstracts.types;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.JobPosition;

import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();

    DataResult<JobPosition> getById(int jobPositionId);

    Result add(JobPosition jobPosition);

    Result update(JobPosition jobPosition);

    Result delete(JobPosition jobPosition);
}
