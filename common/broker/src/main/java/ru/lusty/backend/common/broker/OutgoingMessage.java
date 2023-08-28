package ru.lusty.backend.common.broker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.common.jooq.Model;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutgoingMessage implements Model<UUID> {
    private UUID id;
    private String exchange;
    private Optional<String> routingKey;
    private String json;
    private Instant createdAt;

}
