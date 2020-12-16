package com.company.telegram.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|firstName")
@Table(name = "TELEGRAM_TG_USER")
@Entity(name = "telegram_TgUser")
public class TgUser extends StandardEntity {
    private static final long serialVersionUID = -4838208726973555950L;
    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_ID")
    private String userId;

    public TgUser(String userId) {
        this.userId = userId;
    }

    public TgUser() {
    }

    public TgUser(String userName, String firstName, String lastName, String userId) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}