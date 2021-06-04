package sugrado.hrmsproject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmailAddress(String email);
}
