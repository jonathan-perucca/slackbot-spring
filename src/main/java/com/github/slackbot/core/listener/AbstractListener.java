package com.github.slackbot.core.listener;

import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackAttachment;
import com.ullink.slack.simpleslackapi.SlackMessage;
import com.ullink.slack.simpleslackapi.SlackMessageListener;
import com.ullink.slack.simpleslackapi.SlackSession;
import lombok.Getter;

@Getter
public abstract class AbstractListener implements SlackMessageListener {

    private final SlackClient client;

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

    public abstract void handleMessage(SlackMessage slackMessage);

    protected void sendMessage(SlackMessage message, String response) {
        getClient().getSession().sendMessage(message.getChannel(), response, new SlackAttachment(), "", "");
    }
}
