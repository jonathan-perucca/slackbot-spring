package com.github.slackbot.core.listener;

import com.github.slackbot.component.hello.HelloWorldListener;
import com.github.slackbot.core.SlackClient;
import com.ullink.slack.simpleslackapi.SlackMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldListenerTest {

    @Mock
    SlackClient client;

    @Captor
    ArgumentCaptor<String> responseCaptor;

    @Test
    public void should_send_helloworld_message() {
        final HelloWorldListener spy = spy(new HelloWorldListener(client));
        SlackMessage message = mock(SlackMessage.class);
        doReturn(true).when(spy).isSelf(message);
        doNothing().when(spy).sendMessage(eq(message), anyString());

        spy.handleMessage(message);

        verify(spy).sendMessage(eq(message), responseCaptor.capture());
        assertThat(responseCaptor.getValue()).isEqualTo("Hello world");
    }
}