package sugrado.hrmsproject.business.abstracts.types;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.types.City;

import java.util.List;

public interface CityService {
    Result add(City city);

    Result update(City city);

    Result delete(City city);

    DataResult<List<City>> getAll();

    DataResult<City> getById(int id);
}
