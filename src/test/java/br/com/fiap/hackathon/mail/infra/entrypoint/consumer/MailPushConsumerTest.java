package br.com.fiap.hackathon.mail.infra.entrypoint.consumer;

import br.com.fiap.hackathon.mail.application.usecase.mail.SendMailUseCase;
import br.com.fiap.hackathon.mail.application.usecase.mail.dto.MailDTO;
import br.com.fiap.hackathon.mail.infra.entrypoint.consumer.dto.MailPushDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MailPushConsumerTest {

	@Mock
	private SendMailUseCase sendMailUseCaser;

	@Mock
	private ObjectMapper objectMapper;

	private MailPushConsumer mailPushConsumer;

	private MailPushDTO mailPushDTO;

	@BeforeEach
	public void setUp() {
		mailPushConsumer = new MailPushConsumer(sendMailUseCaser, objectMapper);
		this.buildArranges();
	}

	@Test
    @DisplayName("Should Receive Message Of MailPushDTO")
    void shouldReceiveMessageOfPaymentMailPushDTO() throws JsonProcessingException, MessagingException {
        when(objectMapper.readValue(mailPushDTO.toString(), MailPushDTO.class))
                .thenReturn(mailPushDTO);

        assertDoesNotThrow(() -> mailPushConsumer.receiveMessage(mailPushDTO.toString()));

        verify(sendMailUseCaser).send(any(MailDTO.class));
    }

	private void buildArranges() {
		var email = "test@example.com";
		var status = "PROCESSED";
		var videoName = "video.mp4";

		mailPushDTO = new MailPushDTO(email, status, videoName);
	}

}
