package sugrado.hrmsproject.business.abstracts.candidates;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateCv;
import sugrado.hrmsproject.entities.dtos.CandidateCvPreviewDto;

import java.util.List;

public interface CandidateCvService {
    Result add(CandidateCv candidateCV);

    Result update(CandidateCv candidateCV);

    Result delete(CandidateCv candidateCV);

    DataResult<List<CandidateCv>> getAll();

    DataResult<CandidateCv> getById(int id);

    DataResult<CandidateCv> getByCandidateId(int candidateId);

    DataResult<CandidateCvPreviewDto> getDetailsByCandidateId(int candidateId);
}
