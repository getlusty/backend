package ru.lusty.backend.profile.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProfilePhotoService {
    private final TransactionTemplate transactionTemplate;
    private final ProfilePhotoRepository profilePhotoRepository;

    public List<ProfilePhoto> getProfilePhotos(UUID profileId) {
        return profilePhotoRepository.getProfilePhotoIds(profileId);
    }

    public void addPhoto(UUID profileId, UUID photoId) {
        transactionTemplate.executeWithoutResult((t) -> {
            var photos = getProfilePhotos(profileId);
            profilePhotoRepository.insert(new ProfilePhoto(profileId, photoId, photos.size()));
        });
    }

    public void reshuffle(UUID profileId, List<UUID> photos) {
        transactionTemplate.executeWithoutResult((t) -> {
            profilePhotoRepository.deleteAll(profileId);
            for (int i = 0; i < photos.size(); i++) {
                profilePhotoRepository.insert(new ProfilePhoto(profileId, photos.get(i), i));
            }
        });
    }

    public void deletePhoto(UUID profileId, UUID photoId) {
        transactionTemplate.executeWithoutResult((t) -> {
            final var photos = new ArrayList<>(getProfilePhotos(profileId));
            if (photos.size() == 1) {
                throw new IllegalArgumentException();
            }
            if (!photos.remove(photoId)) {
                throw new IllegalArgumentException();
            }
            profilePhotoRepository.deleteAll(profileId);
            for (int i = 0; i < photos.size(); i++) {
                profilePhotoRepository.insert(new ProfilePhoto(profileId, photos.get(i).getFileId(), i));
            }
        });
    }
}