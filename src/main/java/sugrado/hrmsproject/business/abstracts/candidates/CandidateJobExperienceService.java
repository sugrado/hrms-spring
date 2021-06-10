package sugrado.hrmsproject.business.abstracts.candidates;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateJobExperience;

import java.util.List;

public interface CandidateJobExperienceService {
    Result add(CandidateJobExperience candidateJobExperience);

    Result update(CandidateJobExperience candidateJobExperience);

    Result delete(CandidateJobExperience candidateJobExperience);

    DataResult<List<CandidateJobExperience>> getAll();

    DataResult<CandidateJobExperience> getById(int id);

    DataResult<List<CandidateJobExperience>> getAllByCandidateCvId(int candidateCvId);

}
