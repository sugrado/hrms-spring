package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.candidates.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
    Candidate getByIdentificationNumber(String identificationNumber);
}
