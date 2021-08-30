package sugrado.hrmsproject.business.abstracts.authorizations;

import sugrado.hrmsproject.core.entities.User;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getById(int userId);

    DataResult<User> getByMail(String email);

    Result add(User user);

    Result update(User user);

    Result delete(User user);
}
