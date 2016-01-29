package com.codesanook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class HomeController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HomeController.class, args);
    }

    @Autowired
    private MailSender mailSender;

    @RequestMapping("/")
    @ResponseBody
    public String home() {

        try {

            SimpleMailMessage message = new SimpleMailMessage();
            String from = "admin@gmail.com";
            String to = "theeranitp@gmail.com";
            String subject = "hello world";
            String body = "Hello world theeranitp";
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            mailSender.send(message);
            return "email sent";

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "error";
    }


}
