package ru.lusty.backend.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.lusty.backend.common.web.BaseController;
import ru.lusty.backend.filestore.api.FileStoreApi;
import ru.lusty.backend.profile.api.Profile;
import ru.lusty.backend.profile.api.ProfileDto;
import ru.lusty.backend.profile.api.ProfilePhotoDto;
import ru.lusty.backend.profile.photo.ProfilePhotoService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ProfileController extends BaseController {
    private final ProfilePhotoService profilePhotoService;
    private final FileStoreApi fileStoreApi;
    private final TransactionTemplate transactionTemplate;
    private final ProfileRepository profileRepository;
    private final FreshProfilesCache freshProfilesCache;

    @PostMapping("/profiles")
    public void createProfile(
        @RequestPart("data") CreateProfileRequest request,
        @RequestPart("avatar") MultipartFile file) throws IOException {
        request.validate();
        try (var fileInputStream = file.getInputStream()) {
            var photoId = fileStoreApi.write(fileInputStream);
            fileInputStream.close();
            final var profileDto = transactionTemplate.execute((s) -> {
                final var profile = Profile.newProfile(request.getName(), request.getBirthday(), request.getGender());
                profileRepository.insert(profile);
                profilePhotoService.addPhoto(profile.getId(), photoId);
                return buildProfileDto(profile);
            });
            freshProfilesCache.addFreshProfile(profileDto);
        }
    }

    @PutMapping("/profiles")
    public void updateProfile(@RequestBody UpdateProfileRequest request) {
        request.validate();
        var user = authService.getAuthenticated();
        final var profileDto = transactionTemplate.execute((s) -> {
            var profile = profileRepository.getById(user.id());
            request.mergeTo(profile);
            profileRepository.update(profile);
            return buildProfileDto(profile);
        });
        freshProfilesCache.updateFreshProfile(profileDto);
    }

    @GetMapping("/profiles/own")
    public GetOwnProfileResponse getOwnProfile() {
        final var user = authService.getAuthenticated();
        final var profile = profileRepository.getById(user.id());
        return new GetOwnProfileResponse(buildProfileDto(profile));
    }

    private ProfileDto buildProfileDto(Profile profile) {
        final var photos = profilePhotoService.getProfilePhotos(profile.getId());
        return new ProfileDto(profile, photos.stream()
            .map(p -> new ProfilePhotoDto(p.getFileId(), fileStoreApi.getUrl(p.getFileId()))).toList());
    }
}
