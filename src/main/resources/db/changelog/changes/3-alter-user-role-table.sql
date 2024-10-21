--liquibase formatted sql
--changeset ihorshein:create-user-table
alter table user_role add constraint FKf12i4bcm5dhlk7dwsax9mrqjk foreign key (roles_roleId) references role (roleId);
alter table user_role add constraint FK21e67fdkqdo24wj98y56wqf82 foreign key (User_userId) references user (userId)