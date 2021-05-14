package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
