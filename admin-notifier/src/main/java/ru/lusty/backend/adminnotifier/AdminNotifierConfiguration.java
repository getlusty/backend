package ru.lusty.backend.adminnotifier;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.ContainerCustomizer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lusty.backend.common.broker.TransactionalRabbitListenerPostProcessor;

@Configuration
@RequiredArgsConstructor
public class AdminNotifierConfiguration {

    private final AdminNotifierBot bot;

    @PostConstruct
    public void registerBots() throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DaemonBotSession.class);
        api.registerBot(bot);
    }

    @Bean("verifications-admin-notifier")
    public Queue myQueue() {
        return new Queue("verifications-admin-notifier", true, false, false);
    }

    @Bean
    public Binding binding(@Qualifier("verifications-admin-notifier") Queue myQueue, @Qualifier("verifications") FanoutExchange ex) {
        return BindingBuilder.bind(myQueue).to(ex);
    }

}
