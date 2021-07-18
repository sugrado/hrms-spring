package sugrado.hrmsproject.dataAccess.abstracts.candidates;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sugrado.hrmsproject.entities.concretes.candidates.Favourite;

import java.util.List;

public interface FavouriteDao extends JpaRepository<Favourite, Integer> {
    List<Favourite> getByCandidateId(int candidateId);

    List<Favourite> getByJobAdvertisementId(int jobAdvertisementId);

    @Query("From Favourite where candidate.id=:candidateId and jobAdvertisement.id=:jobAdvertId")
    Favourite checkCandidateAdvert(int candidateId, int jobAdvertId);
}
