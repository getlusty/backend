package ru.lusty.backend.common.jooq;

import org.jetbrains.annotations.NotNull;
import org.jooq.Converter;

import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;

public class JooqInstantConverter implements Converter<LocalDateTime, Instant> {

    @Override
    public Instant from(LocalDateTime databaseObject) {
        return databaseObject.toInstant(UTC);
    }

    @Override
    public LocalDateTime to(Instant userObject) {
        return LocalDateTime.ofInstant(userObject, UTC);
    }

    @Override
    public @NotNull Class<LocalDateTime> fromType() {
        return LocalDateTime.class;
    }

    @Override
    public @NotNull Class<Instant> toType() {
        return Instant.class;
    }
}
