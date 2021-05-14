package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.VerificationByEmployee;

public interface VerificationByEmployeeService {
	List<VerificationByEmployee> getAll();

	VerificationByEmployee getById(int verificationByEmployeeId);

	void add(VerificationByEmployee verificationByEmployee);

	void update(VerificationByEmployee verificationByEmployee);

	void delete(VerificationByEmployee verificationByEmployee);
}
