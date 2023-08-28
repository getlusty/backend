package ru.lusty.backend.profile;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
public class ReshufflePhotosRequest {
    private List<UUID> photos;


    public void validate(List<UUID> existingPhotos) {
        if (existingPhotos.size() != photos.size()) {
            throw new IllegalArgumentException();
        }
        if (!toSet(photos).equals(toSet(existingPhotos))) {
            throw new IllegalArgumentException();
        }
    }

    private static Set<UUID> toSet(List<UUID> ids) {
        return new HashSet<>(ids);
    }
}
