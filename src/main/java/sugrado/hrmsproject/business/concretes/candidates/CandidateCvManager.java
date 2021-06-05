package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateCvService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.CandidateCvDao;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateCv;

import java.util.List;

@Service
public class CandidateCvManager implements CandidateCvService {
    private CandidateCvDao candidateCVDao;

    @Autowired
    public CandidateCvManager(CandidateCvDao candidateCVDao) {
        this.candidateCVDao = candidateCVDao;
    }

    @Override
    public Result add(CandidateCv candidateCv) {
        this.candidateCVDao.save(candidateCv);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(CandidateCv candidateCv) {
        this.candidateCVDao.save(candidateCv);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(CandidateCv candidateCv) {
        this.candidateCVDao.delete(candidateCv);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<CandidateCv>> getAll() {
        return new SuccessDataResult<List<CandidateCv>>(this.candidateCVDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<CandidateCv> getById(int id) {
        return new SuccessDataResult<CandidateCv>(this.candidateCVDao.findById(id).get(), Messages.listed);
    }
}
