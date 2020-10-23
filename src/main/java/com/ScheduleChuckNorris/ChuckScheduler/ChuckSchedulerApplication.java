package com.ScheduleChuckNorris.ChuckScheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class ChuckSchedulerApplication {
	private static final Logger log = LoggerFactory.getLogger(ChuckSchedulerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChuckSchedulerApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run (RestTemplate restTemplate) throws Exception {
		return args -> {
			reportCurrentTime();
		};
	}
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {

		RestTemplate template = new RestTemplate();
		Quote quote = template.getForObject(
				"https://api.chucknorris.io/jokes/random", Quote.class);
		log.info(quote.toString());
	};
	}


