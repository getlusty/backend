package ru.lusty.backend.profile;

import org.springframework.stereotype.Component;
import ru.lusty.backend.common.jooq.JooqUpdatableRepository;
import ru.lusty.backend.profile.api.Profile;
import ru.lusty.backend.profile.records.tables.Profiles;
import ru.lusty.backend.profile.records.tables.records.ProfilesRecord;

import java.util.Optional;
import java.util.UUID;

import static ru.lusty.backend.profile.records.tables.Profiles.PROFILES;

@Component
public class ProfileRepository extends JooqUpdatableRepository<UUID, Profile, ProfilesRecord, Profiles> {

    @Override
    protected ProfilesRecord toRecord(Profile model) {
        return new ProfilesRecord(model.getId(), model.getName(), model.getBirthday(), model.getGender(),
            model.isHidden(), model.getCreatedAt(), model.getDeletedAt().orElse(null), model.getInstagram().orElse(null));
    }

    @Override
    protected Profile fromRecord(ProfilesRecord record) {
        return new Profile(record.getId(), record.getName(), record.getBirthday(), record.getGender(),
            record.getHidden(), Optional.ofNullable(record.getInstagram()), record.getCreatedAt(), Optional.ofNullable(record.getDeletedAt()));
    }

    @Override
    protected Profiles table() {
        return PROFILES;
    }

}
