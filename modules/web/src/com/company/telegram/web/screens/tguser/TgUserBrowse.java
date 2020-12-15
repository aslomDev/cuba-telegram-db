package com.company.telegram.web.screens.tguser;

import com.haulmont.cuba.gui.screen.*;
import com.company.telegram.entity.TgUser;

@UiController("telegram_TgUser.browse")
@UiDescriptor("tg-user-browse.xml")
@LookupComponent("tgUsersTable")
@LoadDataBeforeShow
public class TgUserBrowse extends StandardLookup<TgUser> {
}