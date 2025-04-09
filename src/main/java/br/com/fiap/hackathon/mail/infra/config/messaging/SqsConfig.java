package br.com.fiap.hackathon.mail.infra.config.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

import java.net.URI;

@Configuration
public class SqsConfig {

	@Bean
	public SqsAsyncClient sqsAsyncClient() {
		return SqsAsyncClient.builder()
			.region(Region.US_EAST_1)
			// .endpointOverride(URI.create("https://localhost.localstack.cloud:4566"))
			.build();
	}

}