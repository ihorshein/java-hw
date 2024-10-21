--liquibase formatted sql
--changeset ihorshein:create-user-table
create table role (
    roleId bigint not null auto_increment,
    name varchar(255),
    primary key (roleId)
) engine=InnoDB;

create table user_role (
    User_userId bigint not null,
    roles_roleId bigint not null
) engine=InnoDB

--rollback DROP TABLE role;
--rollback DROP TABLE user_role;
