package sugrado.hrmsproject.business.abstracts.verifications;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.Verification;

import java.util.List;

public interface VerificationService {
    DataResult<List<Verification>> getAll();

    DataResult<Verification> getById(int verificationId);

    Result add(Verification verification);

    Result update(Verification verification);

    Result delete(Verification verification);
}
