package sugrado.hrmsproject.business.concretes.verifications;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByEmployeeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.verifications.VerificationByEmployeeDao;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VerificationByEmployeeManager implements VerificationByEmployeeService {

    private final VerificationByEmployeeDao verificationByEmployeeDao;

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
    public Result approve(VerificationByEmployee verificationByEmployee) {
        var vEmployeeEntity = this.getByEntityId(verificationByEmployee.getEntityId()).getData();
        vEmployeeEntity.setStatus(true);
        vEmployeeEntity.setVerifiedDate(LocalDateTime.now());
        vEmployeeEntity.setEmployeeId(verificationByEmployee.getEmployeeId());
        this.verificationByEmployeeDao.saveAndFlush(vEmployeeEntity);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(VerificationByEmployee verificationByEmployee) {
        this.verificationByEmployeeDao.delete(verificationByEmployee);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<VerificationByEmployee> getByEntityId(int entityId) {
        return new SuccessDataResult<VerificationByEmployee>(this.verificationByEmployeeDao.getByEntityId(entityId), Messages.listed);
    }
}
