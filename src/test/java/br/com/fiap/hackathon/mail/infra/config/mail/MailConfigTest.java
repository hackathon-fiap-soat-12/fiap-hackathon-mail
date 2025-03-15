package br.com.fiap.hackathon.mail.infra.config.mail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class MailConfigTest {

	@InjectMocks
	private MailConfig mailConfig;

	@Test
	@DisplayName("Should Create a Singleton Instance Of JavaMailSender")
	void shouldCreateSingletonInstanceOfJavaMailSender() {
		var javaMailSender = mailConfig.javaMailSender();

		assertNotNull(javaMailSender);
		assertInstanceOf(JavaMailSender.class, javaMailSender);
	}

}
