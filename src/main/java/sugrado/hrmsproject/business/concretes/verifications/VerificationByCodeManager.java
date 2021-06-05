package sugrado.hrmsproject.business.concretes.verifications;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.verifications.VerificationByCodeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.business.BusinessRules;
import sugrado.hrmsproject.core.utilities.results.*;
import sugrado.hrmsproject.dataAccess.abstracts.verifications.VerificationByCodeDao;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByCode;

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
        return new SuccessDataResult<VerificationByCode>
                (this.verificationByCodeDao.findById(verificationByCodeId).get(), Messages.listed);
    }

    @Override
    public Result add(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.save(verificationByCode);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(VerificationByCode verificationByCode) {
        var codeForValidate = this.getByUserId(verificationByCode.getUserId()).getData();

        var result = BusinessRules.run(
                this.checkVerificationCode(codeForValidate.getCode(), verificationByCode.getCode()));
        if(result != null)
            return result;

        codeForValidate.setStatus(true);
        codeForValidate.setVerifiedDate(LocalDateTime.now());
        this.verificationByCodeDao.save(codeForValidate);
        return new SuccessResult(Messages.userVerified);
    }

    @Override
    public Result delete(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.delete(verificationByCode);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<VerificationByCode> getByUserId(int userId) {
        return new SuccessDataResult<VerificationByCode>
                (this.verificationByCodeDao.getByUserId(userId), Messages.listed);
    }

    private Result checkVerificationCode(String trueCode, String inComingCode){
        if(inComingCode.equals(trueCode))
            return new SuccessResult();
        return new ErrorResult("Verification code does not match.");
    }
}
