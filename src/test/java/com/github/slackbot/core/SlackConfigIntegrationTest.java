package com.github.slackbot.core;

import com.github.slackbot.SlackBotApplication;
import com.ullink.slack.simpleslackapi.SlackSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integration")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SlackBotApplication.class)
public class SlackConfigIntegrationTest {

    @Autowired
    SlackConfig slackConfig;

    @Test
    public void should_build_slack_config_with_botname() {
        final SlackClient slackClient = slackConfig.slackClient();

        assertThat(slackClient.getBotName()).isNotEmpty();
    }

    @Test
    public void should_build_slack_config_with_session() {
        final SlackSession slackSession = slackConfig.slackSession();

        assertThat(slackSession).isNotNull();
    }
}