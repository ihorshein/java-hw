--liquibase formatted sql
--changeset ihorshein:create-user-table
alter table user_role add constraint FK21e67fdkqdo24wj98y56wqf82 foreign key (userId) references user (userId);
alter table user_role add constraint FKf12i4bcm5dhlk7dwsax9mrqjk foreign key (roleId) references role (roleId);
