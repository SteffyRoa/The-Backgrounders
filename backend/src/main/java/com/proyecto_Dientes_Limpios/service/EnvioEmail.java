package com.proyecto_Dientes_Limpios.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnvioEmail {

	//Importante hacer la inyecci�n de dependencia de JavaMailSender:
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    PdfService pdfService;

    //Pasamos por parametro: destinatario, asunto y el mensaje
    public void sendEmail(String to, String subject, String content, String emailTo ) {

    	 SimpleMailMessage message = new SimpleMailMessage();
         	
		try {
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(content);
	        mailSender.send(message);
			
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    
    
	
}
