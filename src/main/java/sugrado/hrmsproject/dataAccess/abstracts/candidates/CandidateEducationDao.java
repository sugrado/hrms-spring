package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;

import java.util.List;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation, Integer> {
    List<CandidateEducation> getAllByCandidateCvId(int candidateCvId);
}
