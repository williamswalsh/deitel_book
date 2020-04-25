package email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaEmail {

    Session mailSession;

    public static void main(String args[]) throws AddressException, MessagingException {
        JavaEmail javaEmail = new JavaEmail();
        javaEmail.setMailServerProperties();
        javaEmail.sendEmail();
    }

    private void setMailServerProperties() {
        Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "586");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getDefaultInstance(emailProperties, null);
    }

    private MimeMessage draftEmailMessage() throws AddressException, MessagingException {
        String[] toEmails = {"william.walsh@digitary.net"};
        String emailSubject = "Test email subject";
        String emailBody = "This is an email sent by <b>//howtodoinjava.com</b>.";
        MimeMessage emailMessage = new MimeMessage(mailSession);

        for (String emailAddr: toEmails) {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddr));
        }
        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");
        //emailMessage.setText(emailBody);// for a text only email
        return emailMessage;
    }

    private void sendEmail() throws AddressException, MessagingException {

        String fromUser = "william.stephen.walsh@gmail.com";
        String fromUserEmailPassword = "jscsdjiytycprtzp";

        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", fromUser, fromUserEmailPassword);

        MimeMessage emailMessage = draftEmailMessage();
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
}

