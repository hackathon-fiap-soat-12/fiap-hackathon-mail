package br.com.fiap.hackathon.mail.infra.entrypoint.consumer;

import br.com.fiap.hackathon.mail.application.usecase.mail.SendMailUseCase;
import br.com.fiap.hackathon.mail.application.usecase.mail.dto.MailDTO;
import br.com.fiap.hackathon.mail.infra.entrypoint.consumer.dto.MailPushDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MailPushConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MailPushConsumer.class);

	private final SendMailUseCase sendMailUseCase;

	private final ObjectMapper objectMapper;

	public MailPushConsumer(SendMailUseCase sendMailUseCase, ObjectMapper objectMapper) {
		this.sendMailUseCase = sendMailUseCase;
		this.objectMapper = objectMapper;
	}

	@SqsListener("${sqs.queue.mail.push.consumer}")
	public void receiveMessage(String message) throws JsonProcessingException, MessagingException {
		LOGGER.info("Received Message: {}", message);
		sendMailUseCase.send(new MailDTO(objectMapper.readValue(message, MailPushDTO.class)));
	}

}