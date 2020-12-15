package com.company.telegram.web.screens.tguser;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegram.entity.TgUser;

@UiController("telegram_TgUser.edit")
@UiDescriptor("tg-user-edit.xml")
@EditedEntityContainer("tgUserDc")
@LoadDataBeforeShow
public class TgUserEdit extends StandardEditor<TgUser> {
}