package ru.lusty.backend.profile.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.common.jooq.Model;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.empty;
import static java.util.UUID.randomUUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Model<UUID> {
    private UUID id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private boolean hidden;
    private Optional<String> instagram;
    private Instant createdAt;
    private Optional<Instant> deletedAt;

    public static Profile newProfile(String name, LocalDate birthday, Gender gender) {
        return new Profile(randomUUID(), name, birthday, gender, false, empty(), Clock.systemUTC().instant(), empty());
    }

}
