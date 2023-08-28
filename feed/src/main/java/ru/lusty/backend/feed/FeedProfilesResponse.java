package ru.lusty.backend.feed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.profile.api.ProfileDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedProfilesResponse {
    private List<ProfileDto> profiles;
}
