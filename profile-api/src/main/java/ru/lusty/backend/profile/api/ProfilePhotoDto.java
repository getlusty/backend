package ru.lusty.backend.profile.api;

import lombok.Getter;
import lombok.Setter;
import ru.lusty.backend.filestore.api.FileDto;

import java.util.UUID;

@Getter
@Setter
public class ProfilePhotoDto extends FileDto {

    public ProfilePhotoDto(UUID id, String url) {
        super(id, url);
    }
}
