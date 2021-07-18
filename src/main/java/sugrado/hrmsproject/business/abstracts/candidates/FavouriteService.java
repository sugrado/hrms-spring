package sugrado.hrmsproject.business.abstracts.candidates;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.Favourite;

import java.util.List;

public interface FavouriteService {
    Result add(Favourite favourite);

    Result update(Favourite favourite);

    Result delete(Favourite favourite);

    DataResult<List<Favourite>> getAll();

    DataResult<Favourite> getById(int favouriteId);

    DataResult<List<Favourite>> getByCandidateId(int candidateId);

    DataResult<List<Favourite>> getByJobAdvertisementId(int jobAdvertisementId);

    DataResult<Favourite> checkCandidateAdvert(int candidateId, int jobAdvertId);
}
