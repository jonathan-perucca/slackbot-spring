package com.github.slackbot.component.pattern;

import com.github.slackbot.core.AbstractListener;
import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternListener extends AbstractListener {

    private final Pattern pattern;

    public PatternListener(SlackClient client) {
        super(client);
        this.pattern = Pattern.compile("donne (.*) info");
    }

    @Override
    public void handleMessage(SlackMessage message) {
        final Matcher matcher = pattern.matcher(message.getMessageContent());
        if (matcher.matches()) {
            final String response = "Pattern listened ".concat(matcher.group(1));

            sendMessage(message, response);
        }
    }
}
