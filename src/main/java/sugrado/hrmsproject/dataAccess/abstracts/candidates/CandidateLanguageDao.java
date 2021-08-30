package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateLanguage;

import java.util.List;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {
    List<CandidateLanguage> getAllByCandidateCvId(int candidateCvId);
}
