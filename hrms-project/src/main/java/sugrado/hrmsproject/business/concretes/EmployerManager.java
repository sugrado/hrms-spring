package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.EmployerService;
import sugrado.hrmsproject.dataAccess.abstracts.EmployerDao;
import sugrado.hrmsproject.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Employer getById(int employerId) {
		return this.employerDao.findById(employerId).get();
	}

	@Override
	public void add(Employer employer) {
		this.employerDao.save(employer);
	}

	@Override
	public void update(Employer employer) {
		this.employerDao.save(employer);
	}

	@Override
	public void delete(Employer employer) {
		this.employerDao.delete(employer);
	}

}
