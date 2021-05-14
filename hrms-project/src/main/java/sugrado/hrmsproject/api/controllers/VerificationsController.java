package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.VerificationService;
import sugrado.hrmsproject.entities.concretes.Verification;

@RestController
@RequestMapping("/api/verifications")
public class VerificationsController {
	private VerificationService verificationService;

	@Autowired
	public VerificationsController(VerificationService verificationService) {
		super();
		this.verificationService = verificationService;
	}

	@GetMapping("/getall")
	public List<Verification> getAll() {
		return this.verificationService.getAll();
	}

	@GetMapping("/getbyid")
	public Verification getById(@RequestBody int id) {
		return this.verificationService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Verification verification) {
		this.verificationService.add(verification);
	}

	@PostMapping("/update")
	public void update(@RequestBody Verification verification) {
		this.verificationService.update(verification);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody Verification verification) {
		this.verificationService.delete(verification);
	}
}
