package br.com.fiap.hackathon.mail.application.usecase.mail.impl;

import br.com.fiap.hackathon.mail.application.usecase.mail.SendMailUseCase;
import br.com.fiap.hackathon.mail.application.usecase.mail.dto.MailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Transactional
public class SendMailUseCaseImpl implements SendMailUseCase {

	private static final Logger log = LoggerFactory.getLogger(SendMailUseCaseImpl.class);

	private JavaMailSender mailSender;

	private TemplateEngine templateEngine;

	public SendMailUseCaseImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}

	@Override
	public void send(MailDTO input) throws MessagingException {
		MimeMessage mensagem = mailSender.createMimeMessage();
		String template = templateMail(input);

		helperMail(mensagem, input, template);

		mailSender.send(mensagem);
		log.info("E-mail enviado com sucesso para {}", input.email());
	}

	private String templateMail(MailDTO input) {
		String template = input.status().isSuccess() ? "email-success" : "email-failure";
		Map<String, Object> variaveis = new HashMap<>();
		variaveis.put("videoName", input.videoName());

		Context contexto = new Context();
		contexto.setVariables(variaveis);

		return templateEngine.process(template, contexto);
	}

	private void helperMail(MimeMessage mensagem, MailDTO input, String template) throws MessagingException {
		MimeMessageHelper helper = new MimeMessageHelper(mensagem, true, StandardCharsets.UTF_8.name());

		helper.setTo(input.email());
		helper.setSubject(
				input.status().isSuccess() ? "✅ Processamento do Video Concluído" : "❌ Erro no Processamento do Video");
		helper.setText(template, true);
		helper.setFrom("soatfiap@gmail.com");

	}

}
