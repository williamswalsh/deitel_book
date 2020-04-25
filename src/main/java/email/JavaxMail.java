package email;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class JavaxMail {
    public static void main(String[] args) throws MessagingException, IOException {

//        Create SMTP properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

//        Username & App PWD
        String username = "william.stephen.walsh@gmail.com";
        String password = "jscsdjiytycprtzp";

//        Create Session using an properties & Authenticator
        Session mailSession = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("william.stephen.walsh@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("william.walsh@digitary.net"));
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress("pg0746711@gmail.com"));
        message.setSubject("Hello World Pete!");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();

//        Adding attachment
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(new File("/Users/will/Downloads/corona_meme.jpg"));
        multipart.addBodyPart(attachmentBodyPart);

        String msg = "Hey Peter, testing sending emails using javax.mail. I do you need you to confirm the test! :-D";
        mimeBodyPart.setContent(msg, "text/html");
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);
        Transport.send(message);
    }
}
