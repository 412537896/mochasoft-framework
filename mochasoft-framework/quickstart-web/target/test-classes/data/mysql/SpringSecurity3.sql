drop table if exists MOCHA_SECU_GROUPS_MEMBERS;
drop table if exists MOCHA_SECU_GROUP_AUTHORITIES;
drop table if exists MOCHA_SECU_USERS;
drop table if exists MOCHA_SECU_GROUPS;

-- 1.用户表
    CREATE TABLE MOCHA_SECU_USERS (
       id INT(11) not null auto_increment primary key,
       -- 登录id
       userid varchar(100) not null unique,
       -- 用户姓名，通常中文
       username varchar(100) not null,
       -- 密码，需要md5加密
       password varchar(100) not null,
       -- 账号是否可用true. 是    false.否
       enable boolean not null
    );
    
-- 2.群组表 
    create table MOCHA_SECU_GROUPS (
  		id INT(11) not null auto_increment primary key,
 		group_name varchar(100) not null
 	);
 	
-- 3.群组成员表
	create table MOCHA_SECU_GROUPS_MEMBERS (
	  id INT(11) not null auto_increment primary key,
	  userid varchar(100) not null,
	  group_id INT(11) not null,
	  constraint fk_group_members_group foreign key(group_id) references MOCHA_SECU_GROUPS(id)
	);
	
-- 4.群组权限表
	create table MOCHA_SECU_GROUP_AUTHORITIES (
	  group_id INT(11) not null,
	  authority varchar(100) not null,
	  constraint fk_group_authorities_group foreign key(group_id) references MOCHA_SECU_GROUPS(id)
	  );
	  
insert into MOCHA_SECU_USERS(userid, username, password, enable) values ('admin','系统管理员','c4ca4238a0b923820dcc509a6f75849b',true);
insert into MOCHA_SECU_USERS(userid, username, password, enable) values ('user','普通用户','c4ca4238a0b923820dcc509a6f75849b',true);
insert into MOCHA_SECU_USERS(userid, username, password, enable) values ('guest','游客','c4ca4238a0b923820dcc509a6f75849b',false);

insert into MOCHA_SECU_GROUPS(group_name) values ('Users');
insert into MOCHA_SECU_GROUPS(group_name) values ('Administrators');

INSERT INTO MOCHA_SECU_GROUPS_MEMBERS(group_id, userid) SELECT id,'user' FROM groups WHERE group_name='Users';
INSERT INTO MOCHA_SECU_GROUPS_MEMBERS(group_id, userid) SELECT id,'guest' FROM groups WHERE group_name='Users';
INSERT INTO MOCHA_SECU_GROUPS_MEMBERS(group_id, userid) SELECT id,'admin' FROM groups WHERE group_name='Administrators';

insert into MOCHA_SECU_GROUP_AUTHORITIES(group_id, authority) select id,'ROLE_USER' from groups where group_name='Users'; 
insert into MOCHA_SECU_GROUP_AUTHORITIES(group_id, authority) select id,'ROLE_USER' from groups where group_name='Administrators'; 
insert into MOCHA_SECU_GROUP_AUTHORITIES(group_id, authority) select id,'ROLE_ADMIN' from groups where group_name='Administrators'; 
----------------------------------------------------------------------------------------------------------------------------