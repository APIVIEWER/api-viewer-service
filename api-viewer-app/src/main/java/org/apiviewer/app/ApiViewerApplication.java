package org.apiviewer.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Boot App -Entry Class.
 * 
 * @author hitesh.bargujar
 */
@SpringBootApplication
@ComponentScan("org.apiviewer")
@Configuration
public class ApiViewerApplication {

	private final Logger log = LoggerFactory.getLogger(ApiViewerApplication.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApiViewerApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
