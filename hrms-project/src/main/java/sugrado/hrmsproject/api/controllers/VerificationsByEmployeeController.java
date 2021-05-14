package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.VerificationByEmployeeService;
import sugrado.hrmsproject.entities.concretes.VerificationByEmployee;

@RestController
@RequestMapping("/api/verificationsbyemployee")
public class VerificationsByEmployeeController {
	private VerificationByEmployeeService verificationByEmployeeService;

	@Autowired
	public VerificationsByEmployeeController(VerificationByEmployeeService verificationByEmployeeService) {
		super();
		this.verificationByEmployeeService = verificationByEmployeeService;
	}

	@GetMapping("/getall")
	public List<VerificationByEmployee> getAll() {
		return verificationByEmployeeService.getAll();
	}

	@GetMapping("/getbyid")
	public VerificationByEmployee getById(@RequestBody int id) {
		return verificationByEmployeeService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeService.add(verificationByEmployee);
	}

	@PostMapping("/update")
	public void update(@RequestBody VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeService.update(verificationByEmployee);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody VerificationByEmployee verificationByEmployee) {
		this.verificationByEmployeeService.delete(verificationByEmployee);
	}
}
