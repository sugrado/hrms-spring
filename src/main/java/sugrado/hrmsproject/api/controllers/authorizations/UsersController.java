package sugrado.hrmsproject.api.controllers.authorizations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import sugrado.hrmsproject.business.abstracts.authorizations.UserService;
import sugrado.hrmsproject.business.abstracts.types.ImageService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.entities.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {
	private UserService userService;
	private ImageService imageService;

	@Autowired
	public UsersController(UserService userService, ImageService imageService) {
		this.userService = userService;
		this.imageService = imageService;
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

	@PostMapping("/upload-image")
	public Result uploadImage(int userId, MultipartFile file) {
		return this.imageService.add(userId, file);
	}
}
