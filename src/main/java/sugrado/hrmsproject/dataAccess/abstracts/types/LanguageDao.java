package sugrado.hrmsproject.dataAccess.abstracts.types;

import org.springframework.data.jpa.repository.JpaRepository;
import sugrado.hrmsproject.entities.concretes.types.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
}
