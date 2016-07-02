package com.github.slackbot.core;

import com.ullink.slack.simpleslackapi.SlackAttachment;
import com.ullink.slack.simpleslackapi.SlackMessage;
import com.ullink.slack.simpleslackapi.SlackMessageListener;
import com.ullink.slack.simpleslackapi.SlackSession;

public abstract class AbstractListener implements SlackMessageListener {

    private SlackClient client;

    public AbstractListener(SlackClient client) {
        this.client = client;
    }

    @Override
    public void onMessage(SlackMessage message) {
        if(isSelf(message)) return;

        handleMessage(message);
    }

    @Override
    public void onSessionLoad(SlackSession session) {}

    public boolean isSelf(SlackMessage message) {
        return getClient().getBotName().equalsIgnoreCase(message.getSender().getUserName());
    }

    public SlackClient getClient() {
        return client;
    }

    protected void sendMessage(SlackMessage message, String response) {
        getClient().getSession().sendMessage(message.getChannel(), response, new SlackAttachment(), "", "");
    }

    public abstract void handleMessage(SlackMessage slackMessage);
}
