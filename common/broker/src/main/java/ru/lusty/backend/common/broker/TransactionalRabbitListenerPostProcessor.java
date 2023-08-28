package ru.lusty.backend.common.broker;

import lombok.SneakyThrows;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.util.Arrays;

import static ru.lusty.backend.common.utils.JsonUtils.mapper;

// TODO
public abstract class TransactionalRabbitListenerPostProcessor<T> implements MessageListener {
    private final Class<T> type;

    public TransactionalRabbitListenerPostProcessor() {
        this.type = (Class<T>) Arrays.stream(this.getClass().getDeclaredMethods())
            .filter(m -> m.getName().equals("process"))
            .map(m -> m.getParameters()[0])
            .map(p -> p.getType())
            .findFirst()
            .orElseThrow();

    }

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        // TODO
        T typedBody = mapper().readValue(message.getBody(), type);
        process(typedBody);

    }

    protected abstract void process(T message);

    protected abstract String queue();

}
