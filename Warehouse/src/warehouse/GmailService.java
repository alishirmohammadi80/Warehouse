/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author RASHA
 */
public class GmailService {
    
     private Properties properties;
   private Session session;
    private MimeMessage message;
    private Transport transport;
    
    public GmailService(){
    properties=System.getProperties();
    properties.put("mail.smtp.port",587);
     properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");  
        
        session=Session.getDefaultInstance(properties,null);
    
}
    public void send(String subject,String to,String messageBody) throws MessagingException{
   message=new MimeMessage(session);
   message.setSubject(subject);
     
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to)); 
         message.setContent(messageBody,"text/html;charset=UTF-8");
         transport=session.getTransport("smtp");
         transport.connect("smtp.gmail.com","ali.smi80@gmail.com" , "09182971024@");
         transport.sendMessage(message,message.getAllRecipients() );
         transport.close();
    }
    
    
    
}