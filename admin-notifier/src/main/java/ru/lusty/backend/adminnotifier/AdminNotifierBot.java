package ru.lusty.backend.adminnotifier;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class AdminNotifierBot extends TelegramLongPollingBot {
    private final String username;
    private volatile String adminChatId;

    public AdminNotifierBot(@Value("${admin.telegram.bot.token}") String botToken, @Value("${admin.telegram.bot.username}") String username) {
        super(botToken);
        this.username = username;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().getText() != null && update.getMessage().getText().equals("idjcnqfgln")) {
            this.adminChatId = update.getMessage().getChatId().toString();
            return;
        }
        if (true) {

        }

    }

    @Override
    public String getBotUsername() {
        return username;
    }

    public String getAdminChatId() {
        return adminChatId;
    }
}
