package com.company.telegram.service;

import com.company.telegram.entity.TgUser;

public interface TgUserService {
    String NAME = "telegram_TgUserService";

    void createUser(String  id, String firstName, String lastName, String userName);

    public TgUser getUserId(String id);

    void sendMsg(String id, String msg);


}