package sugrado.hrmsproject.business.abstracts.candidates;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;

import java.util.List;

public interface CandidateEducationService {
    Result add(CandidateEducation candidateEducation);

    Result update(CandidateEducation candidateEducation);

    Result delete(CandidateEducation candidateEducation);

    DataResult<List<CandidateEducation>> getAll();

    DataResult<CandidateEducation> getById(int id);
}
