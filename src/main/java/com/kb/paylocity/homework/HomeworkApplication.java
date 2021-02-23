package com.kb.paylocity.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HomeworkApplication {
	
	private static Logger log = LoggerFactory.getLogger(HomeworkApplication.class);

	public static void main(String[] args) {
		log.info("*********************************** Starting HomeworkApplication ***********************************");
		SpringApplication.run(HomeworkApplication.class, args);
		log.info("*********************************** Started HomeworkApplication  ***********************************");
	}
	
	/**
	 * For local testing purposes this cors configuration is done for brevity sake. In a production environment this would be far more secure
	 * 
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
					.addMapping("/**")
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.allowedOrigins("*")
					.allowedHeaders("*");
			}
		};
	}
}
