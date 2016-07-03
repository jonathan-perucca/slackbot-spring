package com.github.slackbot.core.listener;

import com.github.slackbot.component.pattern.PatternListener;
import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackMessage;
import com.ullink.slack.simpleslackapi.SlackUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AbstractListenerTest {

    @Mock
    SlackClient client;

    PatternListener listener;

    @Test
    public void should_handle_message_when_is_not_self_message() {
        listener = new PatternListener(client);
        final AbstractListener spy = spy(listener);
        final SlackMessage message = mock(SlackMessage.class);
        doReturn(false).when(spy).isSelf(message);
        doNothing().when(spy).handleMessage(message);

        spy.onMessage(message);

        verify(spy).handleMessage(message);
    }

    @Test
    public void should_recognized_itself_message() {
        final String BOT_NAME = "jumpy";
        final SlackUser slackUser = mock(SlackUser.class);
        listener = new PatternListener(client);
        SlackMessage message = mock(SlackMessage.class);

        when(slackUser.getUserName()).thenReturn(BOT_NAME);
        when(message.getSender()).thenReturn(slackUser);
        when(client.getBotName()).thenReturn(BOT_NAME);

        final boolean result = listener.isSelf(message);

        assertThat(result).isTrue();
    }
}