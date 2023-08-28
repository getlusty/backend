package ru.lusty.backend.common.broker;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
public class BrokerTransactionTemplate {

    private final TransactionTemplate transactionTemplate;
    private final RabbitTemplate rabbitTemplate;
    private final OutgoingMessageRepository repository;

    public void transaction(Consumer<TransactionalRabbitTemplate> consumer) {
        var rabbit = new TransactionalRabbitTemplate();
        transactionTemplate.executeWithoutResult((s) -> {
            consumer.accept(rabbit);
            saveMessagesToDb(rabbit.getOutgoingMessages());
        });
        sendMessagesToRabbitMq(rabbit.getOutgoingMessages());
        cleanMessagesFromDb(rabbit.getOutgoingMessages());
    }

    private void sendMessagesToRabbitMq(List<OutgoingMessage> messages) {
        for (OutgoingMessage message : messages) {
            message.getRoutingKey().ifPresentOrElse(
                r -> rabbitTemplate.convertAndSend(message.getExchange(), r, message.getJson()),
                () -> rabbitTemplate.convertAndSend(message.getExchange(), message.getJson())
            );
        }
    }

    private void saveMessagesToDb(List<OutgoingMessage> messages) {
        for (OutgoingMessage message : messages) {
            repository.insert(message);
        }
    }

    private void cleanMessagesFromDb(List<OutgoingMessage> messages) {
        if (messages.size() == 0) {
            return;
        }
        transactionTemplate.executeWithoutResult((t) -> {
            for (OutgoingMessage message : messages) {
                repository.delete(message);
            }
        });
    }
}
