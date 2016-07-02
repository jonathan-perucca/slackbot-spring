package com.github.slackbot.core.listener;

import com.github.slackbot.core.AbstractListener;
import com.github.slackbot.core.SlackClient;
import lombok.Getter;

import java.util.regex.Pattern;

/**
 * SlackClient can listen onto a matching pattern
 */
@Getter
public abstract class AbstractPatternListener extends AbstractListener{

    private final Pattern pattern;

    public AbstractPatternListener(SlackClient client, String pattern) {
        super(client);
        this.pattern = Pattern.compile(pattern);
    }
}
