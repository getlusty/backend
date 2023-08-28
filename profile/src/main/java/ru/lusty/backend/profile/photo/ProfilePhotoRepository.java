package ru.lusty.backend.profile.photo;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static ru.lusty.backend.profile.records.Tables.PROFILE_PHOTO;

@Component
@RequiredArgsConstructor
public class ProfilePhotoRepository {
    private final DSLContext jdbc;

    public void insert(ProfilePhoto profilePhoto) {
        jdbc.insertInto(PROFILE_PHOTO)
            .set(PROFILE_PHOTO.PROFILE_ID, profilePhoto.getProfileId())
            .set(PROFILE_PHOTO.FILE_ID, profilePhoto.getFileId())
            .set(PROFILE_PHOTO.PRIORITY, profilePhoto.getPriority())
            .execute();
    }

    public List<ProfilePhoto> getProfilePhotoIds(UUID profileId) {
        return jdbc.selectFrom(PROFILE_PHOTO)
            .where(PROFILE_PHOTO.PROFILE_ID.eq(profileId))
            .orderBy(PROFILE_PHOTO.PRIORITY.asc())
            .fetch((r) -> new ProfilePhoto(r.getProfileId(), r.getFileId(), r.getPriority()));
    }

    public void delete(ProfilePhoto profilePhoto) {
        jdbc.deleteFrom(PROFILE_PHOTO)
            .where(PROFILE_PHOTO.PROFILE_ID.eq(profilePhoto.getProfileId()).and(PROFILE_PHOTO.FILE_ID.eq(profilePhoto.getFileId())))
            .execute();
    }

    public void deleteAll(UUID profileId) {
        jdbc.deleteFrom(PROFILE_PHOTO)
            .where(PROFILE_PHOTO.PROFILE_ID.eq(profileId))
            .execute();
    }
}
