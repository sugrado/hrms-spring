package sugrado.hrmsproject.api.controllers.authorizations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sugrado.hrmsproject.business.abstracts.authorizations.AuthService;
import sugrado.hrmsproject.core.utilities.results.ErrorResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.entities.dtos.CandidateForRegisterDto;
import sugrado.hrmsproject.entities.dtos.EmployerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/register-candidate")
	public Result registerCandidate(@RequestBody CandidateForRegisterDto candidateForRegisterDto) {
		var registerResult = this.authService.registerCandidate(candidateForRegisterDto);
		if(registerResult.isSuccess()){
			return new SuccessResult(registerResult.getMessage());
		}
		return new ErrorResult(registerResult.getMessage());
	}

	@PostMapping("/register-employer")
	public Result registerEmployer(@RequestBody EmployerForRegisterDto employerForRegisterDto) {
		var registerResult = this.authService.registerEmployer(employerForRegisterDto);
		if(registerResult.isSuccess()){
			return new SuccessResult(registerResult.getMessage());
		}
		return new ErrorResult(registerResult.getMessage());
	}
}
