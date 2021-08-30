package sugrado.hrmsproject.dataAccess.abstracts.verifications;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByCode;

public interface VerificationByCodeDao extends JpaRepository<VerificationByCode, Integer> {
    VerificationByCode getByUserId(int userId);
}
