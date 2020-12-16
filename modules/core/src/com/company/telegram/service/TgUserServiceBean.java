package com.company.telegram.service;

import com.company.telegram.MyAmazingBot;
import com.company.telegram.entity.Message;
import com.company.telegram.entity.TgUser;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import javax.inject.Inject;
import java.util.logging.Logger;

@Service(TgUserService.NAME)
public class TgUserServiceBean implements TgUserService {

    @Inject private Metadata metadata;
    @Inject private Persistence persistence;
    @Inject private MyAmazingBot bot;
//    @Inject private Logger log;

    @Override
    @Authenticated
    public void createUser(String id, String firstName, String lastName, String userName) {



        Transaction tx = persistence.createTransaction();

        try {
            EntityManager em = persistence.getEntityManager();
            TgUser tgUser = metadata.create(TgUser.class);
            tgUser.setUserId(id);
            tgUser.setFirstName(firstName);
            tgUser.setLastName(lastName);
            tgUser.setUserName(userName);
            em.persist(tgUser);
            tx.commit();
        } finally {
            tx.end();
        }
    }



    @Override
    public TgUser getUserId(String id) {
        Query query = persistence.getEntityManager().createQuery(
                "select t from telegram_TgUser t where t.userId = :userId");
        query.setParameter("userId", id);
        return (TgUser) query.getFirstResult();
    }

    @Override
    public void sendMsg(String id, String msg) {

        TgUser tgUser;
        Message message;

        Transaction tx = persistence.createTransaction();

        try {
            tgUser = getUserId(id);
            if (tgUser == null){
//                log.info("user mavjud emas");
                System.out.println("not found user");
            }
            else {
//                EntityManager em = persistence.getEntityManager();
//                 message = metadata.create(Message.class);
//                 message.setMsg(msg);
//                 message.setUser(tgUser);
                 SendMessage sendMessage = new SendMessage();
                 sendMessage.setChatId(id);
                 sendMessage.setText(msg);
                 bot.sendMsg(sendMessage);
//                em.persist(tgUser);
                tx.commit();
            }
        } finally {

        }




    }


}