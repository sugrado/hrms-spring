package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    JobAdvertisement getAllById(int id);

    List<JobAdvertisement> getAllByStatusIsTrueAndEmployerId(int employerId);

    List<JobAdvertisement> getAllByStatusIsTrue();
}
