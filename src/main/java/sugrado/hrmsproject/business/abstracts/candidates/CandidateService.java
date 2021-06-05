package sugrado.hrmsproject.business.abstracts.candidates;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();

	DataResult<Candidate> getById(int candidateId);

	DataResult<Candidate> getByIdentificationNumber(String identificationNumber);

	Result add(Candidate candidate);

	Result update(Candidate candidate);

	Result delete(Candidate candidate);

}
