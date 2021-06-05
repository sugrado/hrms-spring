package sugrado.hrmsproject.business.concretes.types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.types.LanguageService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.types.LanguageDao;
import sugrado.hrmsproject.entities.concretes.types.Language;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Language language) {
        this.languageDao.save(language);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Language language) {
        this.languageDao.delete(language);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), Messages.listed);
    }

    @Override
    public SuccessDataResult<Language> getById(int id) {
        return new SuccessDataResult<Language>(this.languageDao.findById(id).get(), Messages.listed);
    }
}
