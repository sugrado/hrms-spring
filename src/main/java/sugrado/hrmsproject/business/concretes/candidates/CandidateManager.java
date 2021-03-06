package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateDao;
import sugrado.hrmsproject.entities.concretes.candidates.Candidate;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;

    public CandidateManager(CandidateDao candidateDao) {
        super();
        this.candidateDao = candidateDao;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {

        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<Candidate> getById(int candidateId) {

        return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId).get(), Messages.listed);
    }

    @Override
    public DataResult<Candidate> getByIdentificationNumber(String identificationNumber) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentificationNumber(identificationNumber), Messages.listed);
    }

    @Override
    public Result add(Candidate candidate) {
        this.candidateDao.save(candidate);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Candidate candidate) {
        this.candidateDao.save(candidate);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Candidate candidate) {
        this.candidateDao.delete(candidate);
        return new SuccessResult(Messages.deleted);
    }

}
