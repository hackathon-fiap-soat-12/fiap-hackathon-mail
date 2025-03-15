package br.com.fiap.hackathon.mail.application.usecase.mail;

import br.com.fiap.hackathon.mail.application.usecase.mail.dto.MailDTO;
import jakarta.mail.MessagingException;

public interface SendMailUseCase {

	void send(MailDTO input) throws MessagingException;

}
