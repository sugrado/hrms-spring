package sugrado.hrmsproject.dataAccess.abstracts.people;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.people.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
