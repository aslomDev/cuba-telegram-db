alter table TELEGRAM_MESSAGE add constraint FK_TELEGRAM_MESSAGE_ON_USER_MSG foreign key (USER_MSG_ID) references TELEGRAM_TG_USER(ID);
create index IDX_TELEGRAM_MESSAGE_ON_USER_MSG on TELEGRAM_MESSAGE (USER_MSG_ID);
