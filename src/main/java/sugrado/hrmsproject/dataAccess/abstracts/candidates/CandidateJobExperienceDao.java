package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateEducation;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateJobExperience;

import java.util.List;

public interface CandidateJobExperienceDao extends JpaRepository<CandidateJobExperience, Integer> {
    List<CandidateJobExperience> getAllByCandidateCvId(int candidateCvId);
}
