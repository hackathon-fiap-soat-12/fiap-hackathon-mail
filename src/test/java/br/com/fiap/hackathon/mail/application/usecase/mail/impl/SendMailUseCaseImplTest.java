package br.com.fiap.hackathon.mail.application.usecase.mail.impl;

import br.com.fiap.hackathon.mail.application.usecase.mail.dto.MailDTO;
import br.com.fiap.hackathon.mail.models.enums.MailEnum;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SendMailUseCaseImplTest {

	@Mock
	private JavaMailSender mailSender;

	@Mock
	private TemplateEngine templateEngine;

	@Mock
	private MimeMessage mimeMessage;

	@InjectMocks
	private SendMailUseCaseImpl sendMailUseCase;

	@BeforeEach
    void setUp() {
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        when(templateEngine.process(anyString(), any(Context.class)))
                .thenReturn("<html>Email Content</html>");
    }

	@Test
	@DisplayName("Should Send Mail Type Processed")
	void shouldSendMailTypeProcessed() {
		// Arrange
		var mailDTO = new MailDTO("test@example.com", MailEnum.PROCESSED, "video.mp4");

		// Act
		assertDoesNotThrow(() -> sendMailUseCase.send(mailDTO));

		// Assert
		assertTrue(mailDTO.status().isSuccess());
		verify(mailSender).send(mimeMessage);
	}

	@Test
	@DisplayName("Should Send Mail Type Failed")
	void shouldSendMailTypeFailed() {
		// Arrange
		var mailDTO = new MailDTO("test@example.com", MailEnum.FAILED, "video.mp4");

		// Act
		assertDoesNotThrow(() -> sendMailUseCase.send(mailDTO));

		// Assert
		assertFalse(mailDTO.status().isSuccess());
		verify(mailSender).send(mimeMessage);
	}

}
