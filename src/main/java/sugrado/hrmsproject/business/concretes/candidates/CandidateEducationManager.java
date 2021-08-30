package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateEducationService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateEducationDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;

import java.util.List;

@Service
public class CandidateEducationManager implements CandidateEducationService {
    private final CandidateEducationDao candidateEducationDao;

    public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
        this.candidateEducationDao = candidateEducationDao;
    }

    @Override
    public Result add(CandidateEducation candidateEducation) {
        this.candidateEducationDao.save(candidateEducation);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(CandidateEducation candidateEducation) {
        this.candidateEducationDao.save(candidateEducation);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(CandidateEducation candidateEducation) {
        this.candidateEducationDao.delete(candidateEducation);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<CandidateEducation>> getAll() {
        return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<CandidateEducation> getById(int id) {
        return new SuccessDataResult<CandidateEducation>(this.candidateEducationDao.findById(id).get(), Messages.listed);
    }

    @Override
    public DataResult<List<CandidateEducation>> getAllByCandidateCvId(int candidateCvId) {
        return new SuccessDataResult<List<CandidateEducation>>
                (this.candidateEducationDao.getAllByCandidateCvId(candidateCvId), Messages.listed);
    }
}
