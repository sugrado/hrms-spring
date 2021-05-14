package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.VerificationByEmployeeService;
import sugrado.hrmsproject.dataAccess.abstracts.VerificationByEmployeeDao;
import sugrado.hrmsproject.entities.concretes.VerificationByEmployee;

@Service
public class VerificationByEmployeeManager implements VerificationByEmployeeService {

	private VerificationByEmployeeDao verificationByEmployeeDao;

	@Autowired
	public VerificationByEmployeeManager(VerificationByEmployeeDao verificationByEmployeeDao) {
		super();
		this.verificationByEmployeeDao = verificationByEmployeeDao;
	}

	@Override
	public List<VerificationByEmployee> getAll() {
		return this.verificationByEmployeeDao.findAll();
	}

	@Override
	public VerificationByEmployee getById(int verificationByEmployeeId) {
		return this.verificationByEmployeeDao.findById(verificationByEmployeeId).get();
	}

	@Override
	public void add(VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeDao.save(verificationByEmployee);
	}

	@Override
	public void update(VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeDao.save(verificationByEmployee);
	}

	@Override
	public void delete(VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeDao.delete(verificationByEmployee);
	}

}
