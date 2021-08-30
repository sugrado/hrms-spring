package sugrado.hrmsproject.business.concretes.authorizations;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.authorizations.AuthService;
import sugrado.hrmsproject.business.abstracts.authorizations.UserService;
import sugrado.hrmsproject.business.abstracts.candidates.CandidateService;
import sugrado.hrmsproject.business.abstracts.people.EmployerService;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByCodeService;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByEmployeeService;
import sugrado.hrmsproject.business.adapters.kpsAdapter.MernisService;
import sugrado.hrmsproject.business.adapters.kpsAdapter.dto.CitizenCard;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.core.utilities.business.BusinessRules;
import sugrado.hrmsproject.core.utilities.email.Mail;
import sugrado.hrmsproject.core.utilities.email.StringGenerator;
import sugrado.hrmsproject.core.utilities.results.ErrorResult;
import sugrado.hrmsproject.core.utilities.results.Result;
import sugrado.hrmsproject.core.utilities.results.SuccessResult;
import sugrado.hrmsproject.entities.concretes.candidates.Candidate;
import sugrado.hrmsproject.entities.concretes.people.Employer;
import sugrado.hrmsproject.entities.concretes.types.VerificationTypeEnum;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByCode;
import sugrado.hrmsproject.entities.concretes.verifications.VerificationByEmployee;
import sugrado.hrmsproject.entities.dtos.CandidateForRegisterDto;
import sugrado.hrmsproject.entities.dtos.EmployerForRegisterDto;

@Service
public class AuthManager implements AuthService {

    private final UserService userService;
    private final CandidateService candidateService;
    private final EmployerService employerService;
    private final MernisService mernisService;
    private final VerificationByCodeService verificationByCodeService;
    private final VerificationByEmployeeService verificationByEmployeeService;
    private final ModelMapper mapper;
    private final Mail mail;

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
        var citizen = this.mapper.map(candidateForRegisterDto, CitizenCard.class);
        var result = BusinessRules.run(this.userExist(candidateForRegisterDto.getEmailAddress(),
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
        var result = BusinessRules.run(this.userExist(employerForRegisterDto.getEmailAddress(), null),
                this.isPasswordMatch(employerForRegisterDto.getPassword(),
                        employerForRegisterDto.getPasswordConfirm()),
                this.checkEmailMatch(employerForRegisterDto));

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
        var verifyEmployeeEntity = new VerificationByEmployee(employer.getId(), VerificationTypeEnum.EmployerRegistration);

        this.verificationByCodeService.add(verifyCodeEntity);
        this.verificationByEmployeeService.add(verifyEmployeeEntity);
        this.mail.sendMail(employerForRegisterDto.getEmailAddress(), code);
        return new SuccessResult(Messages.employerRegistered);
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

    private Result checkEmailMatch(EmployerForRegisterDto employerForRegisterDto) {
        var mailDomain = employerForRegisterDto.getEmailAddress().split("@")[1];
        return mailDomain.equals(employerForRegisterDto.getWebAddress()) ? new SuccessResult() :
                new ErrorResult("E-mail domain and web address does not match.");
    }
}
