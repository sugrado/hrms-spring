package sugrado.hrmsproject.api.controllers.candidates;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.candidates.FavouriteService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.candidates.Favourite;

import java.util.List;

@RestController
@RequestMapping("/api/favourites")
@CrossOrigin
public class FavouritesController {
    private final FavouriteService favouriteService;

    public FavouritesController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping("/get-all")
    public DataResult<List<Favourite>> getAll() {
        return this.favouriteService.getAll();
    }

    @GetMapping("/get-by-candidate-id")
    public DataResult<List<Favourite>> getByCandidateId(int candidateId) {
        return this.favouriteService.getByCandidateId(candidateId);
    }

    @GetMapping("/get-by-advert-id")
    public DataResult<List<Favourite>> getByJobAdvertisementId(int jobAdvertisementId) {
        return this.favouriteService.getByJobAdvertisementId(jobAdvertisementId);
    }

    @GetMapping("/get-by-id")
    public DataResult<Favourite> getById(int id) {
        return this.favouriteService.getById(id);
    }

    @GetMapping("/check-candidate-advert")
    public DataResult<Favourite> checkCandidateAdvert(int candidateId, int jobAdvertisementId) {
        return this.favouriteService.checkCandidateAdvert(candidateId, jobAdvertisementId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Favourite favourite) {
        return this.favouriteService.add(favourite);
    }

    @PutMapping("update")
    public Result update(@RequestBody Favourite favourite) {
        return this.favouriteService.update(favourite);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Favourite favourite) {
        return this.favouriteService.delete(favourite);
    }

}
