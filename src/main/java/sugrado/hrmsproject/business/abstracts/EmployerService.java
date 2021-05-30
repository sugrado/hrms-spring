package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<Employer> getById(int employerId);

	Result add(Employer employer);

	Result update(Employer employer);

	Result delete(Employer employer);
}
