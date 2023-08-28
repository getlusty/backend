package ru.lusty.backend.common.broker;

import com.github.kagkarlsson.scheduler.task.Task;
import com.github.kagkarlsson.scheduler.task.helper.Tasks;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.Duration;

import static com.github.kagkarlsson.scheduler.task.schedule.Schedules.fixedDelay;

@AutoConfiguration
@RequiredArgsConstructor
public class BrokerAutoConfiguration {
    private final TransactionTemplate transactionTemplate;
    private final RabbitTemplate rabbitTemplate;
    private final OutgoingMessageRepository outgoingMessageRepository;

    @Bean
    private BrokerTransactionTemplate brokerTransactionTemplate() {
        return new BrokerTransactionTemplate(transactionTemplate, rabbitTemplate, outgoingMessageRepository);
    }

    @Bean
    Task<Void> outgoingMessagePusher() {
        final var pusher = new OutgoingMessagePusher(rabbitTemplate, outgoingMessageRepository);
        return Tasks.recurring("outgoingMessagePusher", fixedDelay(Duration.ofSeconds(1)))
            .execute((instance, ctx) -> pusher.push());
    }
}
