package sugrado.hrmsproject.business.abstracts.authorizations;

import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.entities.dtos.CandidateForRegisterDto;
import sugrado.hrmsproject.entities.dtos.EmployerForRegisterDto;

public interface AuthService {
	Result registerCandidate(CandidateForRegisterDto candidateForRegisterDto);
	Result registerEmployer(EmployerForRegisterDto employerForRegisterDto);
    Result userExist(String email, String identificationNumber);
}
