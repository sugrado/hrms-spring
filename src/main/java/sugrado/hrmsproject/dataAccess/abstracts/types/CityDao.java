package sugrado.hrmsproject.dataAccess.abstracts.types;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.types.City;

public interface CityDao extends JpaRepository<City, Integer> {
    City getAllById(int id);
}
