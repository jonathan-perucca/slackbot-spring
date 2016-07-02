package com.github.slackbot.component.pattern;

import com.github.slackbot.core.SlackClient;
import com.github.slackbot.core.listener.AbstractPatternListener;
import com.ullink.slack.simpleslackapi.SlackMessage;

import java.util.regex.Matcher;

/**
 * Reply the word between "donne" and "info"
 */
public class PatternListener extends AbstractPatternListener {

    public PatternListener(SlackClient client) {
        super(client, "donne (.*) info");
    }

    @Override
    protected void handleMessage(SlackMessage message, Matcher matcher) {
        final String response = "Pattern listened ".concat(matcher.group(1));

        sendMessage(message, response);
    }
}
