package ru.lusty.backend.session;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.replicatedmap.ReplicatedMap;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import ru.lusty.auth.api.domain.LustyAuthUser;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class CacheLiveService {

    private final ReplicatedMap<UUID, LustyAuthUser> onlineUsers;

    private final ConcurrentMap<UUID, WebSocketSession> onlineSessions;
    private final ConcurrentMap<UUID, UUID> onlineSessionIdToUserId;

    public CacheLiveService(HazelcastInstance hazelcastInstance) {
        this.onlineSessions = new ConcurrentHashMap<>();
        this.onlineSessionIdToUserId = new ConcurrentHashMap<>();
        this.onlineUsers = hazelcastInstance.getReplicatedMap("onlineUsers");
    }

    public void online(LustyAuthUser user, WebSocketSession session) {
        final var sessionId = UUID.fromString(session.getId());
        onlineSessions.put(sessionId, session);
        onlineSessionIdToUserId.put(sessionId, user.id());
        onlineUsers.put(user.id(), user);
    }

    public void offline(UUID sessionId) {
        var userId = onlineSessionIdToUserId.remove(sessionId);
        onlineSessions.remove(sessionId);
        onlineUsers.remove(userId);
    }

    public WebSocketSession getSessionById(UUID id) {
        return onlineSessions.get(id);
    }
}
