package com.github.slackbot.component.hello;

import com.github.slackbot.core.AbstractListener;
import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackMessage;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 *  React on all received messages
 */
public class HelloWorldListener extends AbstractListener {

    private static final Logger logger = getLogger(HelloWorldListener.class);

    public HelloWorldListener(SlackClient client) {
        super(client);
    }

    @Override
    public void handleMessage(SlackMessage message) {
        logger.info("MESSAGE RECEIVED - '{}'", message.getMessageContent());

        sendMessage(message, "Hello world");
    }
}
