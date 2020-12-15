package com.company.telegram;

import com.company.telegram.service.TgUserService;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.cuba.security.app.Authentication;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.inject.Inject;

@Component
public class MyAmazingBot extends TelegramLongPollingBot {
    @Inject
    private Logger log;

    @Inject
    Authentication authentication;

    @Inject private TgUserService tgUserService;

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            long id = update.getMessage().getChatId();
            try {
                log.info("Какой то текст");

                authentication.begin();
                tgUserService.createUser(id);
                authentication.end();
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                log.error("Error", e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "lolMessageBot";
    }

    @Override
    public String getBotToken() {
        return "1487031714:AAEz7teOXNw1CmUG9BCUxp225NcWYVZ8p5w";
    }
}
