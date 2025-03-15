package br.com.fiap.hackathon.mail.infra.entrypoint.consumer.dto;

public record MailPushDTO(String email, String status, String videoName) {
}