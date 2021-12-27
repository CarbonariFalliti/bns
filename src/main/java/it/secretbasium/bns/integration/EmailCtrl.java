package it.secretbasium.bns.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailCtrl {
    final String[] DEVELOPER_EMAIL = {
        "edo17maggio@gmail.com",
        "amedeofresia@gmail.com"
    };
    @Autowired
    private JavaMailSender javaMailSender;



    @RequestMapping(value = "/ticket", method = RequestMethod.POST)
    public void ticketOpener(
        @RequestParam String email,
        @RequestParam String title,
        @RequestParam String description,
        @RequestParam String priority
    ) {
        System.out.println("sono in ticket");
        SimpleMailMessage emailObject= new SimpleMailMessage(); 
                emailObject.setTo(email);
                emailObject.setBcc(DEVELOPER_EMAIL);
                emailObject.setSubject("TICKET:[["+priority+"]] "+title);
                emailObject.setText(email+" ha scritto:\n"+description);
                javaMailSender.send(emailObject);
        
    }




    
}
