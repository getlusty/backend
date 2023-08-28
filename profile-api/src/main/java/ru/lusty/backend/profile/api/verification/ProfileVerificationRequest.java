package ru.lusty.backend.profile.api.verification;

import java.util.List;
import java.util.UUID;

public record ProfileVerificationRequest(UUID verificationId, String verificationPhotoUrl, List<String> profilePhotoUrls) {

}
