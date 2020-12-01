package iotpanel.CE.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component

public class EmailService {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    public void sendMessage(String email,String name,String message){
        System.out.println(port);
        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(2525);
        mailSender.setUsername("e2180061899e58");
        mailSender.setPassword("5c17a4b1e9a420");

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email);
        mailMessage.setTo("keshim95@gmail.com");
        mailMessage.setSubject("New feedback from " + name);
        mailMessage.setText(message);

        // Send mail
        mailSender.send(mailMessage);
    }

}
