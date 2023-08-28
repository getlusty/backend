package ru.lusty.backend.feed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    private UUID id;
    private UUID authorId;
    private UUID targetId;
    private boolean liked;
    private Instant createdAt;

}
