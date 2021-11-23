package grsu.lection.jms.sender;

import grsu.lection.jms.message.SimpleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class JmsSender {
    private final JmsTemplate jmsTemplate;

    public void sendMessage(SimpleMessage message) {
        jmsTemplate.convertAndSend(message);
    }
}
