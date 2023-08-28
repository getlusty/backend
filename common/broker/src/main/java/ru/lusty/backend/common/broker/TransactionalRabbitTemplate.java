package ru.lusty.backend.common.broker;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.lusty.backend.common.utils.ClockUtils.now;
import static ru.lusty.backend.common.utils.JsonUtils.mapper;

public class TransactionalRabbitTemplate {

    @Getter(AccessLevel.PACKAGE)
    private final List<OutgoingMessage> outgoingMessages = new ArrayList<>();

    @SneakyThrows
    public void convertAndSend(String exchange, String routingKey, Object message) {
        outgoingMessages.add(new OutgoingMessage(UUID.randomUUID(), exchange, Optional.of(routingKey), mapper().writeValueAsString(message), now()));
    }

    @SneakyThrows
    public void convertAndSend(String exchange, Object message) {
        outgoingMessages.add(new OutgoingMessage(UUID.randomUUID(), exchange, Optional.empty(), mapper().writeValueAsString(message), now()));
    }
}
