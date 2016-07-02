package com.github.slackbot.core;

import com.ullink.slack.simpleslackapi.SlackMessage;

public abstract class AbstractListener {

    private SlackClient client;

    public AbstractListener(SlackClient client) {
        this.client = client;
    }

    public boolean isSelf(SlackMessage message) {
        return getClient().getBotName().equalsIgnoreCase(message.getSender().getUserName());
    }

    public SlackClient getClient() {
        return client;
    }
}
