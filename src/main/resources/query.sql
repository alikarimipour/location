drop table if exists hibernate_sequence;
drop table if exists role;
drop table if exists user;
drop table if exists user_roles;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );
create table role (id bigint not null, description varchar(255), name varchar(255), primary key (id)) engine=MyISAM;
create table user (id bigint not null, age integer, password varchar(255), salary bigint, username varchar(255), primary key (id)) engine=MyISAM;
create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM;
alter table user_roles add constraint FKrhfovtciq1l558cw6udg0h0d3 foreign key (role_id) references role (id);
alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);

INSERT INTO user (id, username, password, salary, age) VALUES (1, 'ali', '$2a$10$e3nOUfiqWhCbjm7adsR6Oe2g8/guvew5iQiOAMT1Swk9KLrmLzU32', 3456, 33);
INSERT INTO user (id, username, password, salary, age) VALUES (2, '1', '$2a$10$e3nOUfiqWhCbjm7adsR6Oe2g8/guvew5iQiOAMT1Swk9KLrmLzU32', 7823, 23);
INSERT INTO user (id, username, password, salary, age) VALUES (3, '2', '$2a$10$e3nOUfiqWhCbjm7adsR6Oe2g8/guvew5iQiOAMT1Swk9KLrmLzU32', 4234, 45);

INSERT INTO tbl_role (user_role_id, role,name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO tbl_role (user_role_id, role,name) VALUES (2, 'User role', 'USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 5);
