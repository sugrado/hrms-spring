package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.UserService;
import sugrado.hrmsproject.entities.concretes.User;

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
	public List<User> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("/getbyid")
	public User getById(int id) {
		return this.userService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody User user) {
		this.userService.add(user);
	}

	@PostMapping("/update")
	public void update(@RequestBody User user) {
		this.userService.update(user);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody User user) {
		this.userService.delete(user);
	}
}
