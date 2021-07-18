package sugrado.hrmsproject.business.concretes.candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.candidates.FavouriteService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.*;
import sugrado.hrmsproject.dataAccess.abstracts.candidates.FavouriteDao;
import sugrado.hrmsproject.entities.concretes.candidates.Favourite;

import java.util.List;

@Service
public class FavouriteManager implements FavouriteService {
    private FavouriteDao favouriteDao;

    @Autowired
    public FavouriteManager(FavouriteDao favouriteDao) {
        this.favouriteDao = favouriteDao;
    }

    @Override
    public Result add(Favourite favourite) {
        var check = this.
                checkCandidateAdvert(favourite.getCandidate().getId(), favourite.getJobAdvertisement().getId());
        if (check.getData() != null) {
            return new ErrorResult("The advert is already in your favourites.");
        }
        this.favouriteDao.save(favourite);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(Favourite favourite) {
        this.favouriteDao.saveAndFlush(favourite);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(Favourite favourite) {
        this.favouriteDao.delete(favourite);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<Favourite>> getAll() {
        return new SuccessDataResult<List<Favourite>>
                (this.favouriteDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<Favourite> getById(int favouriteId) {
        return new SuccessDataResult<Favourite>
                (this.favouriteDao.findById(favouriteId).get(), Messages.listed);
    }

    @Override
    public DataResult<List<Favourite>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<List<Favourite>>
                (this.favouriteDao.getByCandidateId(candidateId), Messages.listed);
    }

    @Override
    public DataResult<List<Favourite>> getByJobAdvertisementId(int jobAdvertisementId) {
        return new SuccessDataResult<List<Favourite>>
                (this.favouriteDao.getByJobAdvertisementId(jobAdvertisementId), Messages.listed);
    }

    @Override
    public DataResult<Favourite> checkCandidateAdvert(int candidateId, int jobAdvertId) {
        return new SuccessDataResult<Favourite>
                (this.favouriteDao.checkCandidateAdvert(candidateId, jobAdvertId), Messages.listed);
    }
}
