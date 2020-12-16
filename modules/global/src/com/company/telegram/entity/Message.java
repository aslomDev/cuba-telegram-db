package com.company.telegram.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@Table(name = "TELEGRAM_MESSAGE")
@Entity(name = "telegram_Message")
public class Message extends StandardEntity {
    private static final long serialVersionUID = 3684073742261071567L;

    @Column(name = "MSG")
    private String msg;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_MSG_ID")
    private TgUser user;

    public Message() {
    }

    public Message(String msg, TgUser user) {
        this.msg = msg;
        this.user = user;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TgUser getUser() {
        return user;
    }

    public void setUser(TgUser user) {
        this.user = user;
    }
}