package ru.lusty.backend.profile.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.lusty.auth.api.service.AuthService;
import ru.lusty.backend.common.broker.BrokerTransactionTemplate;
import ru.lusty.backend.filestore.api.FileStoreApi;
import ru.lusty.backend.profile.ReshufflePhotosRequest;
import ru.lusty.backend.profile.api.verification.PhotoVerificationRequest;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProfilePhotoController {
    private final BrokerTransactionTemplate transactionTemplate;
    private final ProfilePhotoService profilePhotoService;
    private final FileStoreApi fileStoreApi;
    private final AuthService authService;

    @PostMapping("/profiles/photos")
    public void addPhoto(@RequestPart("photo") MultipartFile file) throws IOException {
        var user = authService.getAuthenticated();
        try (var fileInputStream = file.getInputStream()) {
            final var photoId = fileStoreApi.write(fileInputStream);
            transactionTemplate.transaction((broker) -> {
                profilePhotoService.addPhoto(user.id(), photoId);
            });
        }
    }

    @DeleteMapping("/profiles/photos/{id}")
    public void deletePhoto(@PathVariable("id") UUID photoId) {
        var user = authService.getAuthenticated();
        profilePhotoService.deletePhoto(user.id(), photoId);

    }

    @PutMapping("/profiles/photos/priority")
    public void reshufflePhotos(@RequestBody ReshufflePhotosRequest request) {
        var user = authService.getAuthenticated();
        var photos = profilePhotoService.getProfilePhotos(user.id());
        request.validate(photos.stream().map(ProfilePhoto::getFileId).toList());
        profilePhotoService.reshuffle(user.id(), request.getPhotos());
    }
}
