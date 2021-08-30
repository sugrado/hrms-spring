package sugrado.hrmsproject.business.concretes.verifications;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.verifications.VerificationDao;
import sugrado.hrmsproject.entities.concretes.verifications.Verification;

import java.util.List;

@Service
public class VerificationManager implements VerificationService {

    private final VerificationDao verificatinoDao;

    public VerificationManager(VerificationDao verificatinoDao) {
        super();
        this.verificatinoDao = verificatinoDao;
    }

    @Override
    public DataResult<List<Verification>> getAll() {
        return new SuccessDataResult<List<Verification>>(this.verificatinoDao.findAll());
    }

    @Override
    public DataResult<Verification> getById(int verificationId) {
        return new SuccessDataResult<Verification>(this.verificatinoDao.findById(verificationId).get());
    }

    @Override
    public Result add(Verification verification) {
        this.verificatinoDao.save(verification);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Verification verification) {
        this.verificatinoDao.save(verification);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Verification verification) {
        this.verificatinoDao.delete(verification);
        return new SuccessResult(Messages.deleted);
    }

}
