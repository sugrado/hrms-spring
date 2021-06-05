package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.candidates.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer> {
}
