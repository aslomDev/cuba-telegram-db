package com.company.telegram.web.screens.message;

import com.company.telegram.entity.TgUser;
import com.company.telegram.service.TgUserService;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.SourceCodeEditor;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.telegram.entity.Message;

import javax.inject.Inject;

@UiController("telegram_Message.edit")
@UiDescriptor("message-edit.xml")
@EditedEntityContainer("messageDc")
@LoadDataBeforeShow
public class MessageEdit extends StandardEditor<Message> {
    @Inject
    private LookupField<TgUser> userField;

    @Inject private TgUserService tgUserService;
    @Inject
    private SourceCodeEditor msgField;
    @Inject
    private CollectionContainer<TgUser> userId;

    @Subscribe("userField")
    public void onUserFieldValueChange(HasValue.ValueChangeEvent<TgUser> event) {

    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPostCommit(DataContext.PostCommitEvent event) {

        String id = "651707259";


        tgUserService.sendMsg(userId.getItem().getUserId(), msgField.getValue());

    }

    
    
    
    



}