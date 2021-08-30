package sugrado.hrmsproject.business.abstracts.verifications;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

import java.util.List;

public interface VerificationByEmployeeService {
    DataResult<List<VerificationByEmployee>> getAll();

    DataResult<VerificationByEmployee> getById(int verificationByEmployeeId);

    DataResult<VerificationByEmployee> getByEntityId(int entityId);

    Result add(VerificationByEmployee verificationByEmployee);

    Result approve(VerificationByEmployee verificationByEmployee);

    Result delete(VerificationByEmployee verificationByEmployee);
}
