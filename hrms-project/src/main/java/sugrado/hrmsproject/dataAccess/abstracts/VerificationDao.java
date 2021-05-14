package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.Verification;

public interface VerificationDao extends JpaRepository<Verification, Integer> {

}
