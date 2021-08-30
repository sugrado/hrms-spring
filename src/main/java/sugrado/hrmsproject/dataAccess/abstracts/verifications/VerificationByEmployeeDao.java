package sugrado.hrmsproject.dataAccess.abstracts.verifications;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;

public interface VerificationByEmployeeDao extends JpaRepository<VerificationByEmployee, Integer> {
    VerificationByEmployee getByEntityId(int entityId);
}
