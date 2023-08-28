package ru.lusty.backend.session;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import ru.lusty.auth.api.domain.LustyAuthUser;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.empty;
import static ru.lusty.backend.common.utils.ClockUtils.now;

@Component
@RequiredArgsConstructor
public class LiveService {
    private final CacheLiveService cacheLiveService;
    private final WebsocketSessionsRepository sessionsRepository;

    public void online(LustyAuthUser user, WebSocketSession session) {
        sessionsRepository.insert(new WebsocketSession(UUID.fromString(session.getId()), user.id(), user.deviceId(), now(), empty()));
        cacheLiveService.online(user, session);
    }

    public void offline(UUID sessionId) {
        cacheLiveService.offline(sessionId);
        final var session = sessionsRepository.getById(sessionId);
        session.setActiveTo(Optional.of(now()));
        sessionsRepository.update(session);
    }
}
