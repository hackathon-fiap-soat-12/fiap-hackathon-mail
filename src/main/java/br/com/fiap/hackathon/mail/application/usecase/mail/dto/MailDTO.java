package br.com.fiap.hackathon.mail.application.usecase.mail.dto;

import br.com.fiap.hackathon.mail.infra.entrypoint.consumer.dto.MailPushDTO;
import br.com.fiap.hackathon.mail.models.enums.MailEnum;

public record MailDTO(String email, MailEnum status, String videoName) {
	public MailDTO(MailPushDTO dto) {
		this(dto.email(), MailEnum.valueOf(dto.status().toUpperCase()), dto.videoName());
	}
}