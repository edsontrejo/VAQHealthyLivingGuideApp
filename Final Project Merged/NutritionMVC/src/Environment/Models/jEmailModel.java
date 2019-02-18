/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Models;

import java.io.File;
import java.io.IOException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author JacobS
 */
public class jEmailModel {
    private String file;
    private String host;
    private String port;
    private String userName;
    private String password;
    private String toAddress;
    private String subject;
    private String message;
    
    public jEmailModel(){
        this.host = "";
        this.port = "";
        this.userName = "";
        this.password = "";
        this.toAddress = "";
        this.subject = "";
        this.message = "";
        this.file="";
    };
    
    jEmailModel(String host, String port, String userName
    , String password, String toAddress, String subject, String message)
    {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
        this.toAddress = toAddress;
        this.subject = subject;
        this.message = message;
        this.file="";
    }

  
   
    

    public String getFile() {
        return file;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getToAddress() {
        return toAddress;
    }

    public String getSubject() {
        return subject;
    }
    
    public String getMessage() {
        return message;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public void sendEmail()
            throws AddressException, MessagingException
    {
        
        
        String SSL_FACTORY="javax.net.ssl.SSLSocketFactory";
        Properties prop = System.getProperties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        prop.put("mail.smtp.host", host);
        prop.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        
        prop.put("mail.smtp.port", port);
        prop.setProperty("mail.smtp.socketFactory.port", port);
        
        prop.put("mail.smtps.quitwait", "false");
        
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        
        prop.put("mail.user", userName);
        prop.put("mail.password", password);
        
        Authenticator auth = new Authenticator(){
            @Override
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session = Session.getInstance(prop, auth);

        Message msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        msg.setRecipients(Message.RecipientType.TO, toAddresses);

        String[] ccEmails ={};
        int ccLength=0;
        if (ccEmails != null) {
                ccLength = ccEmails.length;
        }
        for (int i = 0; i < ccLength; i++) {
                msg.addRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmails[i], false));
          }
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        
        MimeBodyPart msgBPart = new MimeBodyPart();
        msgBPart.setContent(message, "text/html");
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(msgBPart);
        
        MimeBodyPart attachPart = new MimeBodyPart();
        try{
            attachPart.attachFile(file.toString());
        }catch(IOException ex){
            
        }
        multipart.addBodyPart(attachPart);
        
        msg.setContent(multipart);
        
        Transport.send(msg);
    }
}
