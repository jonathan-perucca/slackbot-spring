package com.github.slackbot.core;

import com.ullink.slack.simpleslackapi.SlackMessageListener;
import com.ullink.slack.simpleslackapi.SlackSession;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Builder
@Getter
public class SlackListenerRegistrar {

    private SlackClient slackClient;

    public SlackListenerRegistrar register(Collection<SlackMessageListener> listeners) {
        final SlackSession session = slackClient.getSession();

        listeners.stream().forEach(session::addMessageListener);

        return this;
    }

}
