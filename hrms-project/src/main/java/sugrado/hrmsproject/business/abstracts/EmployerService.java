package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();

	Employer getById(int employerId);

	void add(Employer employer);

	void update(Employer employer);

	void delete(Employer employer);
}
