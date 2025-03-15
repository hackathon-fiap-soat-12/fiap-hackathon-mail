package br.com.fiap.hackathon.mail.infra.config.bean;

import br.com.fiap.hackathon.mail.application.usecase.mail.impl.SendMailUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

@Configuration
public class SendMailUseCaseConfig {

	@Bean
	public SendMailUseCaseImpl sendMailUseCaseImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
		return new SendMailUseCaseImpl(javaMailSender, templateEngine);
	}

}
