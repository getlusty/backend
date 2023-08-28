package ru.lusty.backend.profile;

import lombok.Data;
import ru.lusty.backend.common.utils.ClockUtils;
import ru.lusty.backend.profile.api.Gender;

import java.time.Clock;
import java.time.LocalDate;

import static ru.lusty.backend.common.utils.ClockUtils.clock;

@Data
public class CreateProfileRequest {

    private String name;
    private LocalDate birthday;
    private Gender gender;

    public void validate() {
        validateName();
        validateBirthday();
    }


    private void validateName() {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 16) {
            throw new IllegalArgumentException();
        }
        if (!name.trim().matches("[a-zA-Z0-9а-яА-Я ]+")) {
            throw new IllegalArgumentException();
        }

        if (countOccurrences(name.trim(), ' ') > 1) {
            throw new IllegalArgumentException();
        }
    }

    private int countOccurrences(String input, char target) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }

    private void validateBirthday() {
        if (birthday == null) {
            throw new IllegalArgumentException();
        }
        final var now = LocalDate.now(clock());
        if (birthday.isBefore(now.minusYears(60))) {
            throw new IllegalArgumentException();
        }
        if (birthday.isAfter(now.minusYears(18))) {
            throw new IllegalArgumentException();
        }
    }
}
