package sugrado.hrmsproject.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.*;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.adapters.kpsAdapter.MernisService;
import sugrado.hrmsproject.core.adapters.kpsAdapter.dto.CitizenCard;
import sugrado.hrmsproject.core.utilities.business.BusinessRules;
import sugrado.hrmsproject.core.utilities.email.Mail;
import sugrado.hrmsproject.core.utilities.email.StringGenerator;
import sugrado.hrmsproject.core.utilities.results.ErrorResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.entities.concretes.Candidate;
import sugrado.hrmsproject.entities.concretes.Employer;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;
import sugrado.hrmsproject.entities.concretes.VerificationByEmployee;
import sugrado.hrmsproject.entities.dto.CandidateForRegisterDto;
import sugrado.hrmsproject.entities.dto.EmployerForRegisterDto;

@Service
public class AuthManager implements AuthService {

    final UserService userService;
    final CandidateService candidateService;
    final EmployerService employerService;
    final MernisService mernisService;
    final VerificationByCodeService verificationByCodeService;
    final VerificationByEmployeeService verificationByEmployeeService;
    final ModelMapper mapper;
    final Mail mail;

    @Autowired
    public AuthManager(UserService userService,
                       CandidateService candidateService,
                       EmployerService employerService,
                       MernisService mernisService,
                       VerificationByCodeService verificationByCodeService,
                       VerificationByEmployeeService verificationByEmployeeService,
                       ModelMapper mapper,
                       Mail mail) {
        this.userService = userService;
        this.candidateService = candidateService;
        this.employerService = employerService;
        this.mernisService = mernisService;
        this.verificationByCodeService = verificationByCodeService;
        this.verificationByEmployeeService = verificationByEmployeeService;
        this.mapper = mapper;
        this.mail = mail;
    }

    @Override
    public Result registerCandidate(CandidateForRegisterDto candidateForRegisterDto) {
        if(candidateForRegisterDto.getPassword() == null ||
            candidateForRegisterDto.getEmailAddress() == null ||
            candidateForRegisterDto.getPasswordConfirm() == null ||
            candidateForRegisterDto.getIdentificationNumber() == null ||
            candidateForRegisterDto.getBirthDate() == null ||
            candidateForRegisterDto.getFirstName() == null ||
            candidateForRegisterDto.getLastName() == null){
            return new ErrorResult(Messages.hasEmptyRows);
        }
        var citizen = this.mapper.map(candidateForRegisterDto, CitizenCard.class);
        Result result = BusinessRules.run(this.userExist(candidateForRegisterDto.getEmailAddress(),
                                                         candidateForRegisterDto.getIdentificationNumber()),
                                          this.isPasswordMatch(candidateForRegisterDto.getPassword(),
                                                               candidateForRegisterDto.getPasswordConfirm()),
                                          this.checkIfValidCitizen(citizen));

        if (result != null) {
            return result;
        }

        var candidate = mapper.map(candidateForRegisterDto, Candidate.class);
        var addCandidate = this.candidateService.add(candidate);
        if (!addCandidate.isSuccess()) {
            return new ErrorResult(Messages.candidateNotRegistered);
        }

        var code = StringGenerator.generateRandomString(6);
        VerificationByCode verifyCodeEntity = new VerificationByCode(candidate.getId(), code);

        this.verificationByCodeService.add(verifyCodeEntity);
        this.mail.sendMail(candidateForRegisterDto.getEmailAddress(), code);
        return new SuccessResult(Messages.candidateRegistered);
    }

    @Override
    public Result registerEmployer(EmployerForRegisterDto employerForRegisterDto) {
        // TODO: E-mail - web site address compatibility will be checked
        if(employerForRegisterDto.getPassword() == null ||
                employerForRegisterDto.getEmailAddress() == null ||
                employerForRegisterDto.getPasswordConfirm() == null ||
                employerForRegisterDto.getCompanyName() == null ||
                employerForRegisterDto.getWebAddress() == null ||
                employerForRegisterDto.getPhoneNumber() == null){
            return new ErrorResult(Messages.hasEmptyRows);
        }

        Result result = BusinessRules.run(this.userExist(employerForRegisterDto.getEmailAddress(),null),
                                          this.isPasswordMatch(employerForRegisterDto.getPassword(),
                                                               employerForRegisterDto.getPasswordConfirm()));

        if (result != null) {
            return result;
        }

        var employer = mapper.map(employerForRegisterDto, Employer.class);
        var addEmployer = this.employerService.add(employer);
        if (!addEmployer.isSuccess()) {
            return new ErrorResult(Messages.employerNotRegistered);
        }

        var code = StringGenerator.generateRandomString(6);
        var verifyCodeEntity = new VerificationByCode(employer.getId(), code);
        var verifyEmployeeEntity = new VerificationByEmployee(employer.getId(), null);

        this.verificationByCodeService.add(verifyCodeEntity);
        this.verificationByEmployeeService.add(verifyEmployeeEntity);
        this.mail.sendMail(employerForRegisterDto.getEmailAddress(), code);
        return new SuccessResult(Messages.candidateRegistered);
    }

    @Override
    public Result userExist(String email, String identificationNumber) {
        if (this.userService.getByMail(email).getData() == null &&
                this.candidateService.getByIdentificationNumber(identificationNumber).getData() == null) {
            return new SuccessResult(Messages.userNotExist);
        }
        return new ErrorResult(Messages.userExist);
    }

    private Result isPasswordMatch(String password, String passwordConfirm) {
        if (passwordConfirm.equals(password)) {
            return new SuccessResult();
        }
        return new ErrorResult(Messages.passwordsNotMatch);
    }

    private Result checkIfValidCitizen(CitizenCard citizen) {
        var res = this.mernisService.validateCitizen(citizen);
        if (res)
            return new SuccessResult();
        return new ErrorResult(Messages.notFoundCitizen);
    }
}
