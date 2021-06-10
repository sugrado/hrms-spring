package sugrado.hrmsproject.api.controllers.verifications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sugrado.hrmsproject.business.abstracts.verifications.VerificationByCodeService;
import sugrado.hrmsproject.core.utilities.results.DataResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByCode;

@RestController
@RequestMapping("/api/verificationsbycode")
@CrossOrigin
public class VerificationsByCodeController {
	private VerificationByCodeService verificationByCodeService;

	@Autowired
	public VerificationsByCodeController(VerificationByCodeService verificationByCodeService) {
		super();
		this.verificationByCodeService = verificationByCodeService;
	}

	@GetMapping("/getall")
	public DataResult<List<VerificationByCode>> getAll() {
		return this.verificationByCodeService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<VerificationByCode> getById(int id) {
		return this.verificationByCodeService.getById(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody VerificationByCode verificationByCode) {
		return this.verificationByCodeService.add(verificationByCode);
	}

	@PostMapping("/update")
	public Result update(@RequestBody VerificationByCode verificationByCode) {
		return this.verificationByCodeService.update(verificationByCode);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody VerificationByCode verificationByCode) {
		return this.verificationByCodeService.delete(verificationByCode);
	}
}
