package sugrado.hrmsproject.business.abstracts.verifications;

import java.util.List;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByCode;

public interface VerificationByCodeService {
	DataResult<List<VerificationByCode>> getAll();

	DataResult<VerificationByCode> getById(int verificationByCodeId);

	Result add(VerificationByCode verificationByCode);

	Result approve(VerificationByCode verificationByCode);

	Result delete(VerificationByCode verificationByCode);

	DataResult<VerificationByCode> getByUserId(int userId);
}
