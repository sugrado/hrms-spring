package sugrado.hrmsproject.core.utilities.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Mail {
    private final JavaMailSender emailSender;

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
