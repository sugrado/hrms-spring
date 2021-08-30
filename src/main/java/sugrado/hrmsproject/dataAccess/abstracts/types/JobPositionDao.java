package sugrado.hrmsproject.dataAccess.abstracts.types;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.types.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition findAllByName(String name);
}
