package ru.lusty.backend.session;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.lusty.auth.api.service.LustyAuthenticator;

import java.util.UUID;

import static java.util.Optional.empty;
import static ru.lusty.backend.common.utils.ClockUtils.now;

@Slf4j
@Component
@RequiredArgsConstructor
public class LustyWebsocketHandler implements WebSocketHandler {
    private final LustyAuthenticator authenticator;
    private final LiveService liveService;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("New connection");
        final var providedAccessToken = session.getHandshakeHeaders().get("Authorization").get(0).split(" ")[1];
        final var user = authenticator.authWithAccessToken(providedAccessToken).orElseThrow();
        liveService.online(user, session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Connection error");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Connection closed");
        liveService.offline(UUID.fromString(session.getId()));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
