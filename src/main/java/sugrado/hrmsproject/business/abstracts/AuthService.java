package sugrado.hrmsproject.business.abstracts;

import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.dto.CandidateForRegisterDto;
import sugrado.hrmsproject.entities.dto.EmployerForRegisterDto;

public interface AuthService {
	Result registerCandidate(CandidateForRegisterDto candidateForRegisterDto);
	Result registerEmployer(EmployerForRegisterDto employerForRegisterDto);
    Result userExist(String email, String identificationNumber);
}
