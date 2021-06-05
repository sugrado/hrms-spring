package sugrado.hrmsproject.business.abstracts.authorizations;

import java.util.List;

import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.entities.User;

public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getById(int userId);

    DataResult<User> getByMail(String email);

    Result add(User user);

    Result update(User user);

    Result delete(User user);
}
