package br.com.fiap.hackathon.mail.infra.config.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
@Profile("!local")
public class SqsConfig {

	@Bean
	public SqsAsyncClient sqsAsyncClient() {
		return SqsAsyncClient.builder().region(Region.US_EAST_1).build();
	}

}