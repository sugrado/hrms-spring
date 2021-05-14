package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.VerificationByCode;

public interface VerificationByCodeService {
	List<VerificationByCode> getAll();

	VerificationByCode getById(int verificationByCodeId);

	void add(VerificationByCode verificationByCode);

	void update(VerificationByCode verificationByCode);

	void delete(VerificationByCode verificationByCode);
}
