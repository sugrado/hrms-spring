package sugrado.hrmsproject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.CityService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessDataResult;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.dataAccess.abstracts.CityDao;
import sugrado.hrmsproject.entities.concretes.City;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult(Messages.added);
    }

    @Override
    public Result update(City city) {
        this.cityDao.save(city);
        return new SuccessResult(Messages.updated);
    }

    @Override
    public Result delete(City city) {
        this.cityDao.delete(city);
        return new SuccessResult(Messages.deleted);
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(), Messages.listed);
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.getAllById(id), Messages.listed);
    }
}
