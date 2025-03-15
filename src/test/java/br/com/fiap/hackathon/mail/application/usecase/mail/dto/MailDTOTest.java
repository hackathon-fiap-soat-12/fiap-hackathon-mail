package br.com.fiap.hackathon.mail.application.usecase.mail.dto;

import br.com.fiap.hackathon.mail.infra.entrypoint.consumer.dto.MailPushDTO;
import br.com.fiap.hackathon.mail.models.enums.MailEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailDTOTest {

	@Test
	@DisplayName("Should return MailDTO attributes as the object was created by the constructor")
	void shouldReturnMailDTOAttributesAsTheObjectCreatedByTheConstructor() {
		// Arrange
		var email = "test@example.com";
		var status = "FAILED";
		var videoName = "video.mp4";

		// Act
		var mailDTO = new MailDTO(email, MailEnum.valueOf(status.toUpperCase()), videoName);

		// Assert
		assertEquals(email, mailDTO.email());
		assertEquals(status, mailDTO.status().name());
		assertEquals(videoName, mailDTO.videoName());
		assertFalse(mailDTO.status().isSuccess());
	}

	@Test
	@DisplayName("Should return MailDTO attributes as the object was created by the constructor passing the MailPushDTO")
	void shouldReturnMailDTOAttributesAsTheObjectCreatedByTheConstructorPassingTheMailPushDTO() {
		// Arrange
		var email = "test@example.com";
		var status = "PROCESSED";
		var videoName = "video.mp4";
		var mailPushDTO = new MailPushDTO(email, status, videoName);

		// Act
		var mailDTO = new MailDTO(mailPushDTO);

		// Assert
		assertEquals(email, mailDTO.email());
		assertEquals(status, mailDTO.status().name());
		assertEquals(videoName, mailDTO.videoName());
		assertTrue(mailDTO.status().isSuccess());
	}

}
