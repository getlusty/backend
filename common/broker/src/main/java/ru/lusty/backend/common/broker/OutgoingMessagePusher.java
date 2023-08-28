package ru.lusty.backend.common.broker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor
public class OutgoingMessagePusher {
    private final RabbitTemplate rabbitTemplate;
    private final OutgoingMessageRepository outgoingMessageRepository;

    public void push() {
        var messages = outgoingMessageRepository.findUnpublishedFor(Duration.ofSeconds(10));
        if (messages.size() > 0) {
            log.warn("There are {} hanged messages", messages.size());
        }
        for (OutgoingMessage message : messages) {
            message.getRoutingKey().ifPresentOrElse(
                r -> rabbitTemplate.convertAndSend(message.getExchange(), r, message.getJson()),
                () -> rabbitTemplate.convertAndSend(message.getExchange(), message.getJson())
            );
            outgoingMessageRepository.delete(message);
        }
    }
}
