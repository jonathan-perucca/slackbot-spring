package com.github.slackbot.component;

import com.github.slackbot.component.hello.HelloWorldListener;
import com.github.slackbot.component.pattern.PatternListener;
import com.github.slackbot.core.SlackClient;
import com.github.slackbot.core.SlackListenerRegistrar;
import com.ullink.slack.simpleslackapi.SlackMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Configuration
public class ComponentConfig {

    @Bean
    public SlackListenerRegistrar slackListenerRegistrar(SlackClient client) {
        final Set<SlackMessageListener> listeners = listeners(client);

        return SlackListenerRegistrar.builder()
                                     .slackClient(client)
                                     .build()
                                     .register(listeners);
    }

    public Set<SlackMessageListener> listeners(SlackClient client) {
        return Stream.of(new HelloWorldListener(client), new PatternListener(client))
                     .collect(toSet());
    }
}
