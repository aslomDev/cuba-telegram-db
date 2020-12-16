create table TELEGRAM_MESSAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MSG varchar(255),
    USER_MSG_ID uuid not null,
    --
    primary key (ID)
);