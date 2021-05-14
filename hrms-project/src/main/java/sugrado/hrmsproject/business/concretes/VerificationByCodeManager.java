package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.VerificationByCodeService;
import sugrado.hrmsproject.dataAccess.abstracts.VerificationByCodeDao;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;

@Service
public class VerificationByCodeManager implements VerificationByCodeService{

	private VerificationByCodeDao verificationByCodeDao;
	
	@Autowired
	public VerificationByCodeManager(VerificationByCodeDao verificationByCodeDao) {
		super();
		this.verificationByCodeDao = verificationByCodeDao;
	}

	@Override
	public List<VerificationByCode> getAll() {
		return this.verificationByCodeDao.findAll();
	}

	@Override
	public VerificationByCode getById(int verificationByCodeId) {
		return this.verificationByCodeDao.findById(verificationByCodeId).get();
	}

	@Override
	public void add(VerificationByCode verificationByCode) {
		this.verificationByCodeDao.save(verificationByCode);
	}

	@Override
	public void update(VerificationByCode verificationByCode) {
		this.verificationByCodeDao.save(verificationByCode);
	}

	@Override
	public void delete(VerificationByCode verificationByCode) {
		this.verificationByCodeDao.delete(verificationByCode);
	}

}
