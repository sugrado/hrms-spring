package sugrado.hrmsproject.dataAccess.abstracts.verifications;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.verifications.Verification;

public interface VerificationDao extends JpaRepository<Verification, Integer> {

}
