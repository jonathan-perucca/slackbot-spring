package com.github.slackbot;

import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.slf4j.LoggerFactory.getLogger;

@SpringBootApplication
public class SlackBotApplication {

	private static final Logger logger = getLogger(SlackBotApplication.class);

	@Autowired
	SlackClient client;

	@Bean
	public InitializingBean startup() {
		return () -> {
			SlackSession session = client.getSession();

			session.getUsers()
				   .stream()
				   .forEach(slackUser -> logger.info(slackUser.getRealName()));
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(SlackBotApplication.class, args);
	}
}
