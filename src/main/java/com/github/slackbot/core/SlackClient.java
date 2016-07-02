package com.github.slackbot.core;

import com.ullink.slack.simpleslackapi.SlackSession;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SlackClient {

    private String botName;
    private SlackSession session;
}
