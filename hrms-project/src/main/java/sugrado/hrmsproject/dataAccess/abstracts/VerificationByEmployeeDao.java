package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.VerificationByEmployee;

public interface VerificationByEmployeeDao extends JpaRepository<VerificationByEmployee, Integer> {

}
