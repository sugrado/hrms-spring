package sugrado.hrmsproject.core.utilities.email;

import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.VerificationByCodeService;
import sugrado.hrmsproject.business.constants.Messages;
import sugrado.hrmsproject.dataAccess.abstracts.VerificationByCodeDao;
import sugrado.hrmsproject.entities.concretes.VerificationByCode;

import java.util.Random;

@Service
public class Mail {
    private VerificationByCodeService verificationByCodeService;

    public Mail(VerificationByCodeService verificationByCodeService) {
        this.verificationByCodeService = verificationByCodeService;
    }

    public void sendMail(String emailAddress, String code) {
        System.out.println("E-mail sent to " + emailAddress + Messages.checkMailBox);
        // TODO: Code will be sent to email
    }
}
