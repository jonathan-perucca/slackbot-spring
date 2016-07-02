package com.github.slackbot.core;

import com.ullink.slack.simpleslackapi.SlackMessageListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.Set;

public abstract class AbstractSlackbot {

    @Bean
    @ConditionalOnMissingBean(SlackListenerRegistrar.class)
    public SlackListenerRegistrar slackListenerRegistrar(SlackClient client) {
        final Set<SlackMessageListener> listeners = listeners(client);

        return SlackListenerRegistrar.builder()
                                     .slackClient(client)
                                     .build()
                                     .register(listeners);
    }

    public abstract Set<SlackMessageListener> listeners(SlackClient client);
}
