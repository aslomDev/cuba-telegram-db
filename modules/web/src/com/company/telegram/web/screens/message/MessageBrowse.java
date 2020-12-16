package com.company.telegram.web.screens.message;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegram.entity.Message;

@UiController("telegram_Message.browse")
@UiDescriptor("message-browse.xml")
@LookupComponent("messagesTable")
@LoadDataBeforeShow
public class MessageBrowse extends StandardLookup<Message> {
}