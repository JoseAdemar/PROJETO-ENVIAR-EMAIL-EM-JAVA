package enviando.email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class AppTest {
	
	
	private String userName = "aqui vai o seu email";
	private String senha = "aqui vai a sua senha";

	@org.junit.Test
	public void testeEmail() {
		

		try {

			Properties properties = new Properties();
			
			properties.put("mail.smtp.ssl.trust", "*");

			properties.put("mail.smtp.auth", "true");

			properties.put("mail.smtp.startls", "true");

			properties.put("mail.smtp.host", "smtp.gmail.com");

			properties.put("mail.smtp.port", "465");

			properties.put("mail.smtp.socketFactory.port", "465");

			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			Session session = Session.getInstance(properties, new Authenticator() {
				
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication(userName, senha);
				}
			});
			
			Address[] toUser = InternetAddress.parse("jniostrc@gmail.com,joseademarti@gmail.com");
			
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(userName));
			
			message.setRecipients(Message.RecipientType.TO, toUser);
			
			message.setSubject("Chegou e-mail enviado com java");
			
			message.setText("Ol� voc� recebeu o email enviado pelo java novamente");
			
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
