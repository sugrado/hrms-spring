package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.Verification;

public interface VerificationService {
	List<Verification> getAll();

	Verification getById(int verificationId);

	void add(Verification verification);

	void update(Verification verification);

	void delete(Verification verification);
}
