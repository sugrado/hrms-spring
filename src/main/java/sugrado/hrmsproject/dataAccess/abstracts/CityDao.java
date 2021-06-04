package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
    City getAllById(int id);
}
