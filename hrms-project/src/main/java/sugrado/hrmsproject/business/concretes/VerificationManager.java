package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.VerificationService;
import sugrado.hrmsproject.dataAccess.abstracts.VerificationDao;
import sugrado.hrmsproject.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService {

	private VerificationDao verificatinoDao;

	@Autowired
	public VerificationManager(VerificationDao verificatinoDao) {
		super();
		this.verificatinoDao = verificatinoDao;
	}

	@Override
	public List<Verification> getAll() {
		return this.verificatinoDao.findAll();
	}

	@Override
	public Verification getById(int verificationId) {
		return this.verificatinoDao.findById(verificationId).get();
	}

	@Override
	public void add(Verification verification) {
		this.verificatinoDao.save(verification);
	}

	@Override
	public void update(Verification verification) {
		this.verificatinoDao.save(verification);
	}

	@Override
	public void delete(Verification verification) {
		this.verificatinoDao.delete(verification);
	}

}
