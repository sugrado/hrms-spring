package sugrado.hrmsproject.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.VerificationByCodeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.VerificationByCodeDao;
import sugrado.hrmsproject.entities.concretes.User;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;

@Service
public class VerificationByCodeManager implements VerificationByCodeService {

    private VerificationByCodeDao verificationByCodeDao;

    @Autowired
    public VerificationByCodeManager(VerificationByCodeDao verificationByCodeDao) {
        super();
        this.verificationByCodeDao = verificationByCodeDao;
    }

    @Override
    public DataResult<List<VerificationByCode>> getAll() {
        return new SuccessDataResult<List<VerificationByCode>>(this.verificationByCodeDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<VerificationByCode> getById(int verificationByCodeId) {
        return new SuccessDataResult<VerificationByCode>(this.verificationByCodeDao.findById(verificationByCodeId).get(), Messages.listed);
    }

    @Override
    public Result add(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.save(verificationByCode);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(VerificationByCode verificationByCode) {
        var codeEntity = this.getByUserId(verificationByCode.getUserId()).getData();
        codeEntity.setStatus(true);
        codeEntity.setVerifiedDate(LocalDateTime.now());
        this.verificationByCodeDao.save(codeEntity);
        return new SuccessResult(Messages.userVerified);
        // TODO: Kullanıcıdan kod girilerek aktifleştirme işlemi yapılacak.
    }

    @Override
    public Result delete(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.delete(verificationByCode);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<VerificationByCode> getByUserId(int userId) {
        return new SuccessDataResult<VerificationByCode>(this.verificationByCodeDao.getByUserId(userId), Messages.listed);
    }
}
