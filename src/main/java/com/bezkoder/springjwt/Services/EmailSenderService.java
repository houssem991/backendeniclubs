package com.bezkoder.springjwt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;


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
        mailMessage.setFrom("benmoussahoussem690@gmail.com");
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
        message.setFrom("benmoussahoussem690@gmail.com");
        message.setTo("benmoussahoussem690@gmail.com");
        message.setSubject("fsd");
        message.setText("fwdsfsdffvdsv");
        javaMailSender.send(message);

    }
    public void sendpassword(String email , String api ) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("benmoussahoussem690@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Notification de réinitialisation du mot de passe");
        String htmlMsg = "<h2>Nous vous avons envoyé par email le lien de réinitialisation du mot de passe !</h2>"+
                "<h4> Pour réinitialisation votre mot de passe :</h4>"+
                "<a href='"+api+"'> réinitialiser mot de passe </a>" +
                "<p>Ce lien de réinitialisation du mot de passe expirera dans 30 minutes.</p> ";

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }
    public void sendCandidature(String email , String concours ,String namecand, String nameposte ,float score) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("benmoussahoussem690@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Postulation dans le concours "+concours);
        String htmlMsg = "<h2> Bonjour Mr "+namecand+" </h2>"+
                "<h4> Votre postulation dans le concours "+concours+" dans le poste "+nameposte+"a été retenu avec succés." +
                " avec un score de "+score+"</h4>"+
                "<p>Merci d'imprimer votre postulation de notre site web</p> ";

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }
    public void sendAcceptation(String email , String concours ,String namecand, String nameposte ) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("benmoussahoussem690@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Postulation dans le concours "+concours);
        String htmlMsg = "<h2> Bonjour Mr "+namecand+" </h2>"+
                "<h4> Nous vous informons que votre candidature dans le concours "+concours+" dans le poste "+nameposte+" a été accepter ." +

                "<p>Merci de deposer votre dossier dans notre siége</p> ";

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }
    public void sendRefus(String email , String concours ,String namecand, String nameposte) throws Exception{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mailMessage = new MimeMessageHelper(message, true);
        mailMessage.setFrom("benmoussahoussem690@gmail.com");
        mailMessage.setTo(email);
        mailMessage.setSubject("Postulation dans le concours "+concours);
        String htmlMsg = "<h2> Bonjour Mr "+namecand+" </h2>"+
                "<h4> Nous avons le regret de vous inforer que votre candidature dans le concours "+concours+" dans le poste "+nameposte+" n'a pas été accepter ."

                ;

        message.setContent(htmlMsg, "text/html");

        javaMailSender.send(message);



    }

}