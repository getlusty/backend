package ru.lusty.backend.profile;

import lombok.Getter;
import lombok.Setter;
import ru.lusty.backend.profile.api.Profile;

import java.util.Optional;
import java.util.regex.Pattern;

@Getter
@Setter
public class UpdateProfileRequest extends CreateProfileRequest {
    private static final Pattern INSTAGRAM_REGEX = Pattern.compile("^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,29}$");

    private Optional<String> instagram;

    public void validate() {
        super.validate();
        validateInstagram();
    }

    private void validateInstagram() {
        instagram.ifPresent(i -> {
            final var matcher = INSTAGRAM_REGEX.matcher(i);
            if (!matcher.matches()) {
                throw new IllegalArgumentException();
            }
        });
    }

    public void mergeTo(Profile profile) {
        profile.setInstagram(instagram);
        profile.setName(getName());
        profile.setBirthday(getBirthday());
        profile.setGender(getGender());
    }

}
