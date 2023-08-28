package ru.lusty.backend.session;

import org.springframework.stereotype.Component;
import ru.lusty.backend.common.jooq.JooqUpdatableRepository;
import ru.lusty.backend.location.records.tables.WebsocketSessions;
import ru.lusty.backend.location.records.tables.records.WebsocketSessionsRecord;

import java.util.Optional;
import java.util.UUID;

import static ru.lusty.backend.location.records.tables.WebsocketSessions.WEBSOCKET_SESSIONS;

@Component
public class WebsocketSessionsRepository extends JooqUpdatableRepository<UUID, WebsocketSession, WebsocketSessionsRecord, WebsocketSessions> {

    @Override
    protected WebsocketSession fromRecord(WebsocketSessionsRecord record) {
        return new WebsocketSession(record.getId(), record.getUserId(), record.getDeviceId(), record.getActiveFrom(),  Optional.ofNullable(record.getActiveTo()));
    }

    @Override
    protected WebsocketSessions table() {
        return WEBSOCKET_SESSIONS;
    }

    @Override
    protected WebsocketSessionsRecord toRecord(WebsocketSession model) {
        return new WebsocketSessionsRecord(model.getId(), model.getUserId(), model.getActiveFrom(),model.getActiveTo().orElse(null), model.getDeviceId());
    }
}
