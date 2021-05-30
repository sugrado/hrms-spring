package sugrado.hrmsproject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sugrado.hrmsproject.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmailAddress(String email);
}
