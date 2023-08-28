package ru.lusty.backend.feed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.profile.api.Gender;
import ru.lusty.backend.profile.api.ProfileDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedProfilesRequest {
    private List<ProfileDto> skipProfiles;
    private Integer minAge;
    private Integer maxAge;
    private Gender gender;

}
