package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();

	JobPosition getById(int jobPositionId);

	void add(JobPosition jobPosition);

	void update(JobPosition jobPosition);

	void delete(JobPosition jobPosition);
}
