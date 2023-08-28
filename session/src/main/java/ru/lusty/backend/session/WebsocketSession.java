package ru.lusty.backend.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.common.jooq.Model;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsocketSession implements Model<UUID> {
    private UUID id;
    private UUID userId;
    private String deviceId;
    private Instant activeFrom;
    private Optional<Instant> activeTo;

}
