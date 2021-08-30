package sugrado.hrmsproject.business.concretes.types;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.types.JobPositionService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.types.JobPositionDao;
import sugrado.hrmsproject.entities.concretes.types.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {
    private final JobPositionDao jobPositionDao;

    public JobPositionManager(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<JobPosition> getById(int jobPositionId) {
        return new SuccessDataResult<JobPosition>(this.jobPositionDao.findById(jobPositionId).get(), Messages.listed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult(Messages.deleted);
    }

}
