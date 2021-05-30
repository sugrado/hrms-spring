package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.CandidateService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.*;
import sugrado.hrmsproject.dataAccess.abstracts.CandidateDao;
import sugrado.hrmsproject.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;

    @Autowired
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
