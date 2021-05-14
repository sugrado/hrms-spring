package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.JobPositionService;
import sugrado.hrmsproject.dataAccess.abstracts.JobPositionDao;
import sugrado.hrmsproject.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}

	@Override
	public JobPosition getById(int jobPositionId) {
		return this.jobPositionDao.findById(jobPositionId).get();
	}

	@Override
	public void add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
	}

	@Override
	public void update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
	}

	@Override
	public void delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
	}

}
