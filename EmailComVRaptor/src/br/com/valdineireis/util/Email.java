package br.com.valdineireis.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.apache.commons.mail.HtmlEmail;

public class Email {

	private static final String SMTP = "smtp.gmail.com";
	private static final String SMTP_USUARIO = "valdineimtz@gmail.com";
	private static final String NOME_USUARIO = "Valdinei Reis da Silva";
	private static final String SMTP_SENHA = "sua-senha-aqui";

	public static void enviar(String to, String subject, String body) throws Exception {
		try {
			HtmlEmail email = new HtmlEmail();

			Authenticator auth = new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
			    	return new PasswordAuthentication(SMTP_USUARIO, SMTP_SENHA);
			    }
			};
			
			email.setAuthenticator(auth);
			email.setHostName(SMTP);
			email.setSSL(true);
			email.setSmtpPort(465);
			
			email
			.setHtmlMsg(body)
			.setFrom(SMTP_USUARIO, NOME_USUARIO)
			.addTo(to)
			.setSubject(subject)
			.send();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao enviar e-mail", e);
		}
	}
	
}
