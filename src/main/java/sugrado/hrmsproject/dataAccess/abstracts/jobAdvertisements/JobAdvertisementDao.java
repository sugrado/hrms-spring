package sugrado.hrmsproject.dataAccess.abstracts.jobAdvertisements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sugrado.hrmsproject.entities.concretes.jobAdvertisements.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    JobAdvertisement getAllById(int id);

    List<JobAdvertisement> getAllByStatusIsTrueAndEmployerId(int employerId);

    List<JobAdvertisement> getAllByStatusIsTrue();
}
