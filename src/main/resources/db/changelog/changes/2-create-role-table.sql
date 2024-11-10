--liquibase formatted sql
--changeset ihorshein:create-user-table
create table role (
    roleId bigint not null auto_increment,
    name varchar(255),
    primary key (roleId)
) engine=InnoDB;

create table user_role (
    userId bigint not null,
    roleId bigint not null
) engine=InnoDB

--rollback DROP TABLE role;
--rollback DROP TABLE user_role;
