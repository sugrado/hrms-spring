package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;

public interface VerificationByCodeDao extends JpaRepository<VerificationByCode, Integer> {
    VerificationByCode getByUserId(int userId);
}
