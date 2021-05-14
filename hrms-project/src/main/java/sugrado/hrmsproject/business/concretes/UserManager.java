package sugrado.hrmsproject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sugrado.hrmsproject.business.abstracts.UserService;
import sugrado.hrmsproject.dataAccess.abstracts.UserDao;
import sugrado.hrmsproject.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public User getById(int userId) {
		return this.userDao.findById(userId).get();
	}

	@Override
	public void add(User user) {
		this.userDao.save(user);
	}

	@Override
	public void update(User user) {
		this.userDao.save(user);
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}

}
