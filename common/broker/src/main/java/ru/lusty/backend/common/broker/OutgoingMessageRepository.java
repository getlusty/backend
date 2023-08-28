package ru.lusty.backend.common.broker;

import org.springframework.stereotype.Component;
import ru.lusty.backend.common.broker.tables.OutgoingMessages;
import ru.lusty.backend.common.broker.tables.records.OutgoingMessagesRecord;
import ru.lusty.backend.common.jooq.JooqUpdatableRepository;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static ru.lusty.backend.common.broker.tables.OutgoingMessages.OUTGOING_MESSAGES;
import static ru.lusty.backend.common.utils.ClockUtils.now;

@Component
public class OutgoingMessageRepository extends JooqUpdatableRepository<UUID, OutgoingMessage, OutgoingMessagesRecord, OutgoingMessages> {

    @Override
    protected OutgoingMessagesRecord toRecord(OutgoingMessage model) {
        return new OutgoingMessagesRecord(model.getId(), model.getExchange(), model.getRoutingKey().orElse(null),
            model.getJson(), model.getCreatedAt());
    }

    @Override
    protected OutgoingMessage fromRecord(OutgoingMessagesRecord record) {
        return new OutgoingMessage(record.getId(), record.getExchange(), Optional.ofNullable(record.getRoutingKey()),
            record.getJson(), record.getCreatedAt());
    }

    @Override
    protected OutgoingMessages table() {
        return OUTGOING_MESSAGES;
    }

    public List<OutgoingMessage> findUnpublishedFor(Duration duration) {
        return jdbc.selectFrom(OUTGOING_MESSAGES)
            .where(OUTGOING_MESSAGES.CREATED_AT.lt(now().minus(duration)))
            .fetch()
            .map(this::fromRecord);
    }
}
