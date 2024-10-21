--liquibase formatted sql
--changeset ihorshein:create-user-table
create table user (
    userId bigint not null auto_increment,
    phoneNumber varchar(25),
    password varchar(64),
    email varchar(255) not null,
    primary key (userId)
) engine=InnoDB

--rollback DROP TABLE user;
