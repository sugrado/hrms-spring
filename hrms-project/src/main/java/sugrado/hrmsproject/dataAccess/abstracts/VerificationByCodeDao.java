package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.VerificationByCode;

public interface VerificationByCodeDao extends JpaRepository<VerificationByCode, Integer> {

}
