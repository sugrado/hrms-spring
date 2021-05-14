package sugrado.hrmsproject.business.abstracts;

import java.util.List;

import sugrado.hrmsproject.entities.concretes.User;

public interface UserService {
	List<User> getAll();

	User getById(int userId);

	void add(User user);

	void update(User user);

	void delete(User user);
}
