package sugrado.hrmsproject.business.abstracts.candidates;

import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateImage;

import java.util.List;

public interface CandidateImageService {
    Result add(CandidateImage candidateImage, MultipartFile file);

    Result update(CandidateImage candidateImage);

    Result delete(int id);

    DataResult<CandidateImage> getById(int id);

    DataResult<List<CandidateImage>> getAll();

    DataResult<CandidateImage> getByCandidateId(int id);
}
