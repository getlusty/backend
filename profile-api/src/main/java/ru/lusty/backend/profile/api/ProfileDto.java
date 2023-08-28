package ru.lusty.backend.profile.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    private UUID id;
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private boolean hidden;
    private Instant createdAt;
    private List<ProfilePhotoDto> photos;

    public ProfileDto(Profile profile, List<ProfilePhotoDto> photos) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.birthday = profile.getBirthday();
        this.gender = profile.getGender();
        this.hidden = profile.isHidden();
        this.createdAt = profile.getCreatedAt();
        this.photos = photos;
    }

}
