package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateJobExperienceService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateJobExperienceDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateJobExperience;

import java.util.List;

@Service
public class CandidateJobExperienceManager implements CandidateJobExperienceService {
    private final CandidateJobExperienceDao candidateJobExperienceDao;

    public CandidateJobExperienceManager(CandidateJobExperienceDao candidateJobExperienceDao) {
        this.candidateJobExperienceDao = candidateJobExperienceDao;
    }

    @Override
    public Result add(CandidateJobExperience candidateJobExperience) {
        this.candidateJobExperienceDao.save(candidateJobExperience);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(CandidateJobExperience candidateJobExperience) {
        this.candidateJobExperienceDao.save(candidateJobExperience);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(CandidateJobExperience candidateJobExperience) {
        this.candidateJobExperienceDao.delete(candidateJobExperience);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<CandidateJobExperience>> getAll() {
        return new SuccessDataResult<List<CandidateJobExperience>>
                (this.candidateJobExperienceDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<CandidateJobExperience> getById(int id) {
        return new SuccessDataResult<CandidateJobExperience>
                (this.candidateJobExperienceDao.findById(id).get(), Messages.listed);
    }

    @Override
    public DataResult<List<CandidateJobExperience>> getAllByCandidateCvId(int candidateCvId) {
        return new SuccessDataResult<List<CandidateJobExperience>>
                (this.candidateJobExperienceDao.getAllByCandidateCvId(candidateCvId), Messages.listed);
    }
}
