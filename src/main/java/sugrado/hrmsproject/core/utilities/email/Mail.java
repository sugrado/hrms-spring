package sugrado.hrmsproject.core.utilities.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sugrado.hrmsproject.business.abstracts.verifications.VerificationByCodeService;
import sugrado.hrmsproject.business.constants.Messages;

@Service
public class Mail {
    private JavaMailSender emailSender;

    @Autowired
    public Mail(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMail(String emailAddress, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(emailAddress);
        message.setSubject("HRMS System Verification Code");
        message.setText("Welcome to HRMS System.\nYour verification code: " + code);
        emailSender.send(message);
    }
}
