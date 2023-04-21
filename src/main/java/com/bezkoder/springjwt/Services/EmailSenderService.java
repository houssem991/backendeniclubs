package com.bezkoder.springjwt.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
public class EmailSenderService {

    @Autowired
    private final JavaMailSender javaMailSender;


    public EmailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendcodevalidation(String code , String email ,String api) throws Exception{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("housssembenmoussa@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Notification de code validation");
        String htmlMsg = "<h2>code</h2>"+
                "<h4> code :"+code+"</h4>"+
                "<a href='"+api+"'> Valider votre Compte </a>"
                ;

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);
    }
    public void sendConfirmationEmail(){

        SimpleMailMessage  message = new SimpleMailMessage();
        message.setFrom("housssembenmoussa@gmail.com");
        message.setTo("housssembenmoussa@gmail.com");
        message.setSubject("fsd");
        message.setText("fwdsfsdffvdsv");
        javaMailSender.send(message);

    }
    public void sendpassword(String email , String api ) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("housssembenmoussa@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Notification de réinitialisation du mot de passe");
        String htmlMsg = "<h2>Nous vous avons envoyé par email le lien de réinitialisation du mot de passe !</h2>"+
                "<h4> Pour réinitialisation votre mot de passe :</h4>"+
                "<a href='"+api+"'> réinitialiser mot de passe </a>" +
                "<p>Ce lien de réinitialisation du mot de passe expirera dans 30 minutes.</p> ";

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }
    public void senddemand(String email , String nameevent ,String nameclub, String nameresp ,float score) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom(email);
        mailMessage.setTo("housssembenmoussa@gmail.com");
        mailMessage.setSubject("Demande de l'evenemnet "+nameevent);
        String htmlMsg = "<h2>  Madame,Monsieur  </h2>"+
                "<h4> Une demande d un evenement "+nameevent+" a été deposé par le responsable du club "+nameclub+nameresp+"." +
                " avec un score de "+score+"</h4>"+
                "<p>Merci de consulter et repondre à cette demande</p> ";

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }
    public void sendAcceptation(String email , String nameevent ,String nameresp, String nameclub ) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("housssembenmoussa@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Reponse à la demande de l'evenment "+nameevent);
        String htmlMsg = "<h2> Bonjour Mr "+nameresp+" </h2>"+
                "<h4> Nous vous informons que votre demande de l'evenement "+nameevent+" de votre club  "+nameclub+" a été accepter ." ;

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }
    public void sendRefus(String email , String nameevent ,String nameresp, String nameclub) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("housssembenmoussa@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Reponse à la demande de l'evenement "+nameevent);
        String htmlMsg = "<h2> Bonjour Mr "+nameresp+" </h2>"+
                "<h4> Nous avons le regret de vous inforer que votre demande pour l'evenment "+nameevent+" de votre club  "+nameclub+" n'a pas été accepter ."

                ;

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }

}