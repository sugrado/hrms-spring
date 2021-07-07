package sugrado.hrmsproject.dataAccess.abstracts.types;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.types.EmploymentType;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {
}
