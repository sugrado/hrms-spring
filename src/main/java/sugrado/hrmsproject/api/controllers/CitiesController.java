package sugrado.hrmsproject.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sugrado.hrmsproject.business.abstracts.CityService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.City;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private CityService cityService;

    @Autowired
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

    @PostMapping("/update")
    public Result update(@RequestBody City city) {
        return this.cityService.update(city);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody City city) {
        return this.cityService.delete(city);
    }
}
