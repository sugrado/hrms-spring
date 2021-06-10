package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateLanguageService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateLanguageDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateLanguage;

import java.util.List;

@Service
public class CandidateLanguageManager implements CandidateLanguageService {
    private CandidateLanguageDao candidateLanguageDao;

    @Autowired
    public CandidateLanguageManager(CandidateLanguageDao candidateLanguageDao) {
        this.candidateLanguageDao = candidateLanguageDao;
    }

    @Override
    public Result add(CandidateLanguage candidateLanguage) {
        this.candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(CandidateLanguage candidateLanguage) {
        this.candidateLanguageDao.save(candidateLanguage);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(CandidateLanguage candidateLanguage) {
        this.candidateLanguageDao.delete(candidateLanguage);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAll() {
        return new SuccessDataResult<List<CandidateLanguage>>(this.candidateLanguageDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<CandidateLanguage> getById(int id) {
        return new SuccessDataResult<CandidateLanguage>(this.candidateLanguageDao.findById(id).get(), Messages.listed);
    }

    @Override
    public DataResult<List<CandidateLanguage>> getAllByCandidateCvId(int candidateCvId) {
        return new SuccessDataResult<List<CandidateLanguage>>
                (this.candidateLanguageDao.getAllByCandidateCvId(candidateCvId), Messages.listed);
    }
}
