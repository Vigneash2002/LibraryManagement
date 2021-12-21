/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendBook;

/**
 *
 * @author nsivaakumaar
 */
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
class SendMail{  
 public static void sendbook(SendBookBean ob){  
     Properties props = new Properties();
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.put("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.socketFactory.class",
             "javax.net.ssl.SSLSocketFactory");
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.port", "465");
     //get Session   
     Session session = Session.getDefaultInstance(props,
             new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication("librarymanagement.boot@gmail.com","skct@123");
         }
     });
  //2) compose message     
  try{  
    MimeMessage message = new MimeMessage(session);  
    message.setFrom(new InternetAddress("librarymanagement.boot@gmail.com"));  
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(ob.getemail()));  
    message.setSubject("E Book Request");  
      
    //3) create MimeBodyPart object and set your message text     
    BodyPart messageBodyPart1 = new MimeBodyPart();  
    messageBodyPart1.setText("This is the copy of your requested ebook");  
      
    //4) create new MimeBodyPart object and set DataHandler object to this object      
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
    DataSource source = new FileDataSource(ob.getfile_path());  
    messageBodyPart2.setDataHandler(new DataHandler(source));  
    messageBodyPart2.setFileName(ob.getbook_name()+".pdf");  
     
     
    //5) create Multipart object and add MimeBodyPart objects to this object      
    Multipart multipart = new MimeMultipart();  
    multipart.addBodyPart(messageBodyPart1);  
    multipart.addBodyPart(messageBodyPart2);  
  
    //6) set the multiplart object to the message object  
    message.setContent(multipart );  
     
    //7) send message  
    Transport.send(message);  
   
   System.out.println("message sent....");  
   }catch (MessagingException ex) {ex.printStackTrace();}  
 }  
}  
