package sugrado.hrmsproject.business.abstracts.candidates;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateLanguage;

import java.util.List;

public interface CandidateLanguageService {
    Result add(CandidateLanguage candidateLanguage);

    Result update(CandidateLanguage candidateLanguage);

    Result delete(CandidateLanguage candidateLanguage);

    DataResult<List<CandidateLanguage>> getAll();

    DataResult<CandidateLanguage> getById(int id);
}
