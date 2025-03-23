package br.com.fiap.hackathon.mail.infra.config.bean;

import br.com.fiap.hackathon.mail.application.usecase.mail.impl.SendMailUseCaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class SendMailUseCaseConfigTest {

	@Mock
	JavaMailSender javaMailSender;

	@Mock
	TemplateEngine templateEngine;

	@InjectMocks
	private SendMailUseCaseConfig sendMailUseCaseConfig;

	@Test
	@DisplayName("Should Create a Singleton Instance Of SendMailUseCaseImpl")
	void shouldCreateSingletonInstanceOfSendMailUseCaseImpl() {
		var sendMailUseCaseImpl = sendMailUseCaseConfig.sendMailUseCaseImpl(javaMailSender, templateEngine);

		assertNotNull(sendMailUseCaseImpl);
		assertInstanceOf(SendMailUseCaseImpl.class, sendMailUseCaseImpl);
	}

}
