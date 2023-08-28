package ru.lusty.backend.adminnotifier.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.lusty.backend.adminnotifier.AdminNotifierService;
import ru.lusty.backend.profile.api.verification.ProfileVerificationRequest;

@Component
@RequiredArgsConstructor
public class VerificationRequiredListener {
    private final AdminNotifierService adminNotifierService;

    @RabbitListener(queues = "verifications-admin-notifier")
    public void onVerificationRequest(ProfileVerificationRequest request) {
        adminNotifierService.askVerification(request);
    }
}
