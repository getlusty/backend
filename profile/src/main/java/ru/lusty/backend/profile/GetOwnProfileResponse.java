package ru.lusty.backend.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lusty.backend.profile.api.ProfileDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOwnProfileResponse {
    private ProfileDto profile;

}
