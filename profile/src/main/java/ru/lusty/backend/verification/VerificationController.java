package ru.lusty.backend.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.lusty.backend.common.broker.BrokerTransactionTemplate;
import ru.lusty.backend.common.web.BaseController;
import ru.lusty.backend.filestore.api.FileStoreApi;
import ru.lusty.backend.profile.api.verification.ProfileVerificationRequest;
import ru.lusty.backend.profile.photo.ProfilePhotoService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class VerificationController extends BaseController {
    private final ProfilePhotoService profilePhotoService;
    private final FileStoreApi fileStoreApi;
    private final VerificationRepository verificationRepository;
    private final BrokerTransactionTemplate transactionTemplate;

    @PostMapping("/verification")
    public void requestVerification(@RequestPart("proof") MultipartFile file) throws IOException {
        try (var fileInputStream = file.getInputStream()) {
            var fileId = fileStoreApi.write(fileInputStream);
            var user = authService.getAuthenticated();
            transactionTemplate.transaction((rabbit) -> {
                final var verification = Verification.createNew(user.id(), fileId);
                verificationRepository.insert(verification);
                rabbit.convertAndSend("verifications",
                    new ProfileVerificationRequest(
                        verification.getId(),
                        fileStoreApi.getUrl(fileId),
                        profilePhotoService.getProfilePhotos(user.id())
                            .stream()
                            .map(p -> fileStoreApi.getUrl(p.getFileId()))
                            .toList()));
            });
        }
    }
}
