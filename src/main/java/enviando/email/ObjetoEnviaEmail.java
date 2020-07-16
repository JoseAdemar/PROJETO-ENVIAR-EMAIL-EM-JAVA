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

public class ObjetoEnviaEmail {
	
	
    // ATRIBUTOS DA CLASSE 
	private String userName = "aqui vai o email"; 
	private String senha = "aqui vai a senha do email";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	
	
	// CONSTRUTOR COM ARGUMENTOS 

    public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
		super();
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
	}


	// METODO PARA ENVIAR EMAIL PELO JAVA
	public void enviarEmail(boolean envioHTML) {
		

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
			
			Address[] toUser = InternetAddress.parse(listaDestinatarios);
			
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(userName, nomeRemetente));
			
			message.setRecipients(Message.RecipientType.TO, toUser);
			
			message.setSubject(assuntoEmail);
			
			
			if(envioHTML) {
				
				message.setContent(textoEmail, "text/html); charset=utf-8");
				
			}else {
			
			message.setText(textoEmail);
			
			}
			
			Transport.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
