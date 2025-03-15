package br.com.fiap.hackathon.mail.infra.entrypoint.consumer.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MailPushDTOTest {

	@Test
	@DisplayName("Should return MailPushDTO attributes as the object was created by the constructor")
	void shouldReturnMailPushDTOAttributesAsTheObjectCreatedByTheConstructor() {
		// Arrange
		var email = "test@example.com";
		var status = "PROCESSED";
		var videoName = "video.mp4";

		// Act
		var dto = new MailPushDTO(email, status, videoName);

		// Assert
		assertEquals(email, dto.email());
		assertEquals(status, dto.status());
		assertEquals(videoName, dto.videoName());
	}

}
