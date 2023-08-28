package ru.lusty.backend.common.utils;

import java.time.Clock;
import java.time.Instant;

public class ClockUtils {

    public static final Clock clock() {
        return Clock.systemUTC();
    }

    public static final Instant now() {
        return clock().instant();
    }
}
