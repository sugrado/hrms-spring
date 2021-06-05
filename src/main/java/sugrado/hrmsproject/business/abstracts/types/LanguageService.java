package sugrado.hrmsproject.business.abstracts.types;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.Language;

import java.util.List;

public interface LanguageService {
    Result add(Language language);

    Result update(Language language);

    Result delete(Language language);

    DataResult<List<Language>> getAll();

    DataResult<Language> getById(int id);
}
