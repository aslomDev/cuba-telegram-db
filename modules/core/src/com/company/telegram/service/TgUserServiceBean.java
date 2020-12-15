package com.company.telegram.service;

import com.company.telegram.entity.TgUser;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.cuba.security.app.Authentication;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(TgUserService.NAME)
public class TgUserServiceBean implements TgUserService {

    @Inject private Metadata metadata;
    @Inject private Persistence persistence;

    @Override
    @Authenticated
    public void createUser(Long id) {



        Transaction tx = persistence.createTransaction();

        try {
            EntityManager em = persistence.getEntityManager();
            TgUser tgUser = metadata.create(TgUser.class);
            tgUser.setUserId(id);
            em.persist(tgUser);
            tx.commit();
        } finally {
            tx.end();
        }
    }


}