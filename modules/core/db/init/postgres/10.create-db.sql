-- begin TELEGRAM_MESSAGE
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
)^
-- end TELEGRAM_MESSAGE
-- begin TELEGRAM_TG_USER
create table TELEGRAM_TG_USER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_NAME varchar(255),
    FIRST_NAME varchar(255),
    LAST_NAME varchar(255),
    USER_ID varchar(255),
    --
    primary key (ID)
)^
-- end TELEGRAM_TG_USER
