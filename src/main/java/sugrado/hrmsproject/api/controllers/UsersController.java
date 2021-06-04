package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.UserService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.entities.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<User> getById(int id) {
		return this.userService.getById(id);
	}

	@PostMapping("/update")
	public Result update(@RequestBody User user) {
		return this.userService.update(user);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody User user) {
		return this.userService.delete(user);
	}
}
