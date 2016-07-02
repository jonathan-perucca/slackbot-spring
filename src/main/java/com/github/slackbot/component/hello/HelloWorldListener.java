package com.github.slackbot.component.hello;

import com.github.slackbot.core.AbstractListener;
import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackAttachment;
import com.ullink.slack.simpleslackapi.SlackMessage;
import com.ullink.slack.simpleslackapi.SlackMessageListener;
import com.ullink.slack.simpleslackapi.SlackSession;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

class HelloWorldListener extends AbstractListener implements SlackMessageListener{

    private static final Logger logger = getLogger(HelloWorldListener.class);

    public HelloWorldListener(SlackClient client) {
        super(client);
    }

    @Override
    public void onSessionLoad(SlackSession session) {}

    @Override
    public void onMessage(SlackMessage message) {
        if (isSelf(message)) return;

        final SlackSession session = getClient().getSession();

        logger.info("MESSAGE RECEIVED - '{}'", message.getMessageContent());

        session.sendMessage(message.getChannel(), "Hello world", new SlackAttachment(), "", "");
    }
}
