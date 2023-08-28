package ru.lusty.backend.profile;

public class UserNameValidator {

    private UserNameValidator() {

    }

    public static void validate(String name) {
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

    private static int countOccurrences(String input, char target) {
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }

}
