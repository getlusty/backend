package ru.lusty.backend.profile.api.verification;

import java.util.UUID;

public record PhotoVerificationRequest(UUID verificationId, String verificationPhotoUrl, String photoUrl) {

}
