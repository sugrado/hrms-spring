package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateImage;

public interface CandidateImageDao extends JpaRepository<CandidateImage, Integer> {
    CandidateImage getById(int imageId);
    CandidateImage getByCandidateId(int candidateId);
}
