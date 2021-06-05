package sugrado.hrmsproject.business.abstracts;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);

    Result update(JobAdvertisement jobAdvertisement);

    Result delete(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<JobAdvertisement> getById(int id);

    DataResult<List<JobAdvertisement>> getAllByStatusIsTrueAndEmployerId(int employerId);

    DataResult<List<JobAdvertisement>> getAllByDateSorted();

    DataResult<List<JobAdvertisement>> getAllByStatusIsTrue();
}
