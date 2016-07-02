package com.github.slackbot.component.hello;

import com.github.slackbot.core.SlackClient;
import com.github.slackbot.core.SlackListenerRegistrar;
import com.ullink.slack.simpleslackapi.SlackMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Configuration
public class HelloWorldConfig {

    @Bean
    public SlackListenerRegistrar slackListenerRegistrar(SlackClient client) {
        final Set<SlackMessageListener> listeners = listeners(client);

        return SlackListenerRegistrar.builder()
                                     .slackClient(client)
                                     .build()
                                     .register(listeners);
    }

    public Set<SlackMessageListener> listeners(SlackClient client) {
        return Stream.of(new HelloWorldListener(client))
                     .collect(toSet());
    }
}
