package sugrado.hrmsproject.api.controllers.types;

import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.types.CityService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
    private final CityService cityService;

    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<City> getById(@RequestParam int id) {
        return this.cityService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city) {
        return this.cityService.add(city);
    }

    @PutMapping("/update")
    public Result update(@RequestBody City city) {
        return this.cityService.update(city);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody City city) {
        return this.cityService.delete(city);
    }
}
