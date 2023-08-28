package ru.lusty.backend.location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.common.jooq.Model;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLocation implements Model<UUID> {
    private UUID id;
    private UUID userId;
    private Double latitude;
    private Double longitude;
    private String deviceId;
    private Instant createdAt;

}
