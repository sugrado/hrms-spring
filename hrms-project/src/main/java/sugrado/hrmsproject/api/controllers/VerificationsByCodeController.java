package sugrado.hrmsproject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sugrado.hrmsproject.business.abstracts.VerificationByCodeService;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;

@RestController
@RequestMapping("/api/verificationsbycode")
public class VerificationsByCodeController {
	private VerificationByCodeService verificationByCodeService;

	@Autowired
	public VerificationsByCodeController(VerificationByCodeService verificationByCodeService) {
		super();
		this.verificationByCodeService = verificationByCodeService;
	}

	@GetMapping("/getall")
	public List<VerificationByCode> getAll() {
		return this.verificationByCodeService.getAll();
	}

	@GetMapping("/getbyid")
	public VerificationByCode getById(int id) {
		return this.verificationByCodeService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody VerificationByCode verificationByCode) {
		this.verificationByCodeService.add(verificationByCode);
	}

	@PostMapping("/update")
	public void update(@RequestBody VerificationByCode verificationByCode) {
		this.verificationByCodeService.update(verificationByCode);
	}

	@PostMapping("/delete")
	public void delete(@RequestBody VerificationByCode verificationByCode) {
		this.verificationByCodeService.delete(verificationByCode);
	}
}
