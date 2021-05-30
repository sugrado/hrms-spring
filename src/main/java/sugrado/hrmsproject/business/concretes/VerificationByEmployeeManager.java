package sugrado.hrmsproject.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.VerificationByEmployeeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.VerificationByEmployeeDao;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;
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
	public DataResult<List<VerificationByEmployee>> getAll() {
		return new SuccessDataResult<List<VerificationByEmployee>>(this.verificationByEmployeeDao.findAll(),
				Messages.listed);
	}

	@Override
	public DataResult<VerificationByEmployee> getById(int verificationByEmployeeId) {
		return new SuccessDataResult<VerificationByEmployee>(
				this.verificationByEmployeeDao.findById(verificationByEmployeeId).get(), Messages.listed);
	}

	@Override
	public Result add(VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeDao.save(verificationByEmployee);
		return new SuccessResult(Messages.added);
	}

	@Override
	public Result update(VerificationByEmployee verificationByEmployee, int employeeId) {
		var vEmployeeEntity = this.getByEmployerId(verificationByEmployee.getEmployerId()).getData();
		vEmployeeEntity.setStatus(true);
		vEmployeeEntity.setVerifiedDate(LocalDateTime.now());
		vEmployeeEntity.setEmployeeId(employeeId);
		this.verificationByEmployeeDao.save(vEmployeeEntity);
		// TODO: Personel doğrulama yapınca veritabanına 1 tane daha ekleniyor düzeltilecek
		return new SuccessResult(Messages.updated);
	}

	@Override
	public Result delete(VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeDao.delete(verificationByEmployee);
		return new SuccessResult(Messages.deleted);
	}

	@Override
	public DataResult<VerificationByEmployee> getByEmployerId(int employerId) {
		return new SuccessDataResult<VerificationByEmployee>(this.verificationByEmployeeDao.getByEmployerId(employerId), Messages.listed);
	}
}
