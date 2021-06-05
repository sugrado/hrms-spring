package sugrado.hrmsproject.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.JobAdvertisementService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.JobAdvertisementDao;
import sugrado.hrmsproject.entities.concretes.JobAdvertisement;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;
    private ModelMapper mapper;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, ModelMapper mapper) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.mapper = mapper;
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>
                (this.jobAdvertisementDao.getAllById(id), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatusIsTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByStatusIsTrueAndEmployerId(employerId), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByDateSorted() {
        Sort sortedList = Sort.by(Sort.Direction.ASC, "releaseDate");
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(sortedList), Messages.listed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatusIsTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getAllByStatusIsTrue(), Messages.listed);
    }
}
