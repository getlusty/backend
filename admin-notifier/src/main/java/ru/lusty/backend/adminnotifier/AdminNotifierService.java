package ru.lusty.backend.adminnotifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.media.InputMedia;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.lusty.backend.profile.api.verification.ProfileVerificationRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class AdminNotifierService {
    private final AdminNotifierBot adminNotifierBot;
    private final AdminTgChatsRepository adminTgChatsRepository;
    private static final ReplyKeyboard keyboard = new ReplyKeyboardMarkup(List.of(new KeyboardRow(List.of(
        KeyboardButton.builder().text("✅").build(),
        KeyboardButton.builder().text("❌").build())
    )));

    public void askVerification(ProfileVerificationRequest request) {
        final var messagePhotos = Stream.concat(Optional.of(request.verificationPhotoUrl()).stream(), request.profilePhotoUrls().stream())
            .map(u -> (InputMedia) new InputMediaPhoto(u))
            .toList();

        for (AdminTgChat adminTgChat : adminTgChatsRepository.findAll()) {
            try {
                var res = adminNotifierBot.execute(new SendMediaGroup(adminTgChat.getChatId(), messagePhotos));
                var execute = adminNotifierBot.execute(SendMessage.builder()
                    .chatId(adminTgChat.getChatId())
                    .replyToMessageId(res.get(0).getMessageId())
                    .replyMarkup(keyboard)
                    .build());
            } catch (TelegramApiException e) {
                log.error("Couldn't send message to admin for approve");
            }
        }

    }
}
