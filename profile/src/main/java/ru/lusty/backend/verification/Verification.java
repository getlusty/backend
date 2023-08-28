package ru.lusty.backend.verification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.common.jooq.Model;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.empty;
import static ru.lusty.backend.common.utils.ClockUtils.clock;
import static ru.lusty.backend.common.utils.ClockUtils.now;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Verification implements Model<UUID> {
    private UUID id;
    private UUID profileId;
    private UUID fileId;
    private Instant createdAt;
    private Optional<Instant> reviewedAt;
    private Optional<Boolean> approved;

    public static Verification createNew(UUID profileId, UUID fileId) {
        return new Verification(UUID.randomUUID(), profileId, fileId, now(), empty(), empty());
    }
}
