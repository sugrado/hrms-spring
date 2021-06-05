package sugrado.hrmsproject.business.abstracts.verifications;

import java.util.List;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.Verification;

public interface VerificationService {
	DataResult<List<Verification>> getAll();

	DataResult<Verification> getById(int verificationId);

	Result add(Verification verification);

	Result update(Verification verification);

	Result delete(Verification verification);
}
