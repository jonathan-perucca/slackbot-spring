package com.github.slackbot.core.listener;

import com.github.slackbot.component.pattern.PatternListener;
import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackMessage;
import com.ullink.slack.simpleslackapi.SlackSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatternListenerMockTest {

    PatternListener listener;

    @Mock
    SlackClient client;

    @Captor
    ArgumentCaptor<String> responseCaptor;

    @Test
    public void should_handle_when_matching_pattern() {
        final SlackMessage slackMessage = mock(SlackMessage.class);
        when(slackMessage.getMessageContent()).thenReturn("donne one info");
        when(client.getSession()).thenReturn(mock(SlackSession.class));
        listener = new PatternListener(client);
        AbstractPatternListener spiedListener = spy(listener);

        spiedListener.handleMessage(slackMessage);

        verify(spiedListener).sendMessage(any(), responseCaptor.capture());
        assertThat(responseCaptor.getValue()).isEqualTo("Pattern listened one");
    }
}