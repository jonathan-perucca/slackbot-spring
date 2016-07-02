package com.github.slackbot.core;

import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackConfig {

    @Value("${slack.token}")
    private String authToken;

    @Value("${slack.bot-name}")
    private String botName;

    @Bean
    public SlackClient slackClient() {
        final SlackSession session = slackSession();

        return SlackClient.builder()
                          .session(session)
                          .botName(botName)
                          .build();
    }

    public SlackSession slackSession() {
        final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(authToken);
        session.connect();

        return session;
    }
}
