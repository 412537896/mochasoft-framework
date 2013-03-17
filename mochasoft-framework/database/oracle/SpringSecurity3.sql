drop table  MOCHA_SECU_USER;
drop table  MOCHA_SECU_ROLE;
drop table  MOCHA_SECU_ROLE_USER;
drop table  MOCHA_SECU_RESOURCE;
drop table  MOCHA_SECU_PERMISSION;
drop table  MOCHA_SECU_PERMISSION_RES;
drop table  MOCHA_SECU_ROLE_PERMISSION;

/**
 * 1.用户表
 */
create table MOCHA_SECU_USER (
   id                CHAR(36)       not null,			--36位uuid
   user_id           VARCHAR(100)   not null,			--user登录id
   username          VARCHAR(100)   not null,			--user中文名称
   password          VARCHAR(100)   not null,			--user密码
   status            NUMBER(1)      default 1 not null, --状态，1为正常，0为禁用
   constraint PK_MOCHA_SECU_USER primary key (id),
   constraint UNI_Mocha_Secu_User unique (user_id)
);

/**
 * 2.角色表 
 */
create table MOCHA_SECU_ROLE (
  	id 			CHAR(36) 		not null,				--36位uuid
 	name 		varchar(20) 	not null,				--角色名称
 	create_time NUMBER(13)				,				--创建时间，数字型
 	descn		varchar(200) 			,				--描述信息
 	constraint 	PK_MOCHA_SECU_ROLE primary key (id),
 	constraint 	UNI_MOCHA_SECU_ROLE unique (name)
);

-- 3.角色 用户 映射表
create table MOCHA_SECU_ROLE_USER (
  id 		CHAR(36) 		not null,					--36位uuid
  role_id  	CHAR(36)       not null,					--角色ID
  user_id  	VARCHAR(100)       not null,				--user登录id
  constraint PK_MOCHA_SECU_ROLE_USER primary key (id)
);

/**
 * 4.资源表
 */
create TABLE MOCHA_SECU_RESOURCE (
  id 			CHAR(36)   		not null,				--36位uuid
  name			varchar(100)	not null,				--资源名称
  res_type		varchar(100) 	not null,				--资源类型
  resources		varchar(200) 	not null,				--资源信息
  order_num     NUMBER(8)       not null,				--排序
  create_time 	NUMBER(13)				,				--创建时间
  descn 		varchar(200) 			,				--描述信息
  CONSTRAINT PK_MOCHA_SECU_RESOURCE PRIMARY KEY (id)
);

/**
 * 5.权限表
 */
create TABLE MOCHA_SECU_PERMISSION (
  id 			CHAR(36)   		not null,				--36位UUID
  name			varchar(20)		not null,				--权限名称
  create_time 	NUMBER(13)				,				--创建时间
  descn 		varchar(200) 			,				--描述信息
  CONSTRAINT PK_MOCHA_SECU_PERMISSION PRIMARY KEY (id)
);

/**
 * 6.权限 资源表
 */
create TABLE MOCHA_SECU_PERMISSION_RES (
  id 		CHAR(36) 		not null,					--36位UUID
  per_id  	CHAR(36)       	not null,					--权限ID
  res_id  	CHAR(36)      	 not null,					--资源ID
  constraint PK_MOCHA_SECU_PERMISSION_RES primary key (id)
);

/**
 * 7.角色 权限表
 */
create table MOCHA_SECU_ROLE_PERMISSION (
  id 		CHAR(36) 		not null,					--36位UUID
  role_id 	CHAR(36)   		not null,					--角色id
  per_id	CHAR(36)   		not null,					--权限id
  constraint PK_MOCHA_SECU_ROLE_PERMISSION primary key (id)
);
 	
insert into MOCHA_SECU_USER(id,user_id, username, password, status) 
	values ('00000000-0000-0000-0000-000000000001','admin','系统管理员','c4ca4238a0b923820dcc509a6f75849b',1);
insert into MOCHA_SECU_USER(id,user_id, username, password, status) 
	values ('cd061323-1fad-49ae-8684-4e0c14c5824e','user','普通用户','c4ca4238a0b923820dcc509a6f75849b',1);
insert into MOCHA_SECU_USER(id,user_id, username, password, status) 
	values ('5e08a182-fd5b-4c0a-8854-8f0fdf53095c','guest','guest','c4ca4238a0b923820dcc509a6f75849b',0);

insert into MOCHA_SECU_ROLE(id,name,create_time,descn) values ('ROL00000-0000-0000-0000-000000000001','系统管理角色',1354291620000,'系统管理员desc');
insert into MOCHA_SECU_ROLE(id,name,create_time,descn) values ('ROL00000-0000-0000-0000-000000000002','普通用户角色',1354291620000,'普通用户desc');

INSERT INTO MOCHA_SECU_ROLE_USER(id,role_id, user_id) values('a2ae3667-23e0-4bff-8c2e-20f2235a302a','ROL00000-0000-0000-0000-000000000001','admin');
INSERT INTO MOCHA_SECU_ROLE_USER(id,role_id, user_id) values('75b149db-a719-4b2c-9400-ed0d0998b4b7','ROL00000-0000-0000-0000-000000000002','admin');
INSERT INTO MOCHA_SECU_ROLE_USER(id,role_id, user_id) values('f6ebbc41-e348-423d-9cf3-f73a6bff4b74','ROL00000-0000-0000-0000-000000000002','user');
INSERT INTO MOCHA_SECU_ROLE_USER(id,role_id, user_id) values('c46ccc4d-c0e6-4e50-b35d-b1b06b0a8bf7','ROL00000-0000-0000-0000-000000000002','guest');

INSERT INTO MOCHA_SECU_RESOURCE(id,name,res_type,resources,order_num,create_time,descn) 
	values('RES00000-0000-0000-0000-000000000001','admin开头的url','导航','/admin/**',1,1354291620000,'');
INSERT INTO MOCHA_SECU_RESOURCE(id,name,res_type,resources,order_num,create_time,descn) 
	values('RES00000-0000-0000-0000-000000000002','User开头的url' ,'导航','/user/**' ,2,1354291620000,'');
INSERT INTO MOCHA_SECU_RESOURCE(id,name,res_type,resources,order_num,create_time,descn) 
	values('RES00000-0000-0000-0000-000000000003','一级URL'       ,'导航','/*'       ,3,1354291620000,'');

INSERT INTO MOCHA_SECU_PERMISSION(id,name,create_time,descn)	
	values('PER00000-0000-0000-0000-000000000001','系统管理员权限',1354291620000,'');
INSERT INTO MOCHA_SECU_PERMISSION(id,name,create_time,descn)	
	values('PER00000-0000-0000-0000-000000000002','普遍用户权限',1354291620000,'');

INSERT INTO	MOCHA_SECU_PERMISSION_RES(id,per_id,res_id)
	values('6a7880a9-babf-45d1-abc7-8638dfe00db5','PER00000-0000-0000-0000-000000000001','RES00000-0000-0000-0000-000000000001');
INSERT INTO	MOCHA_SECU_PERMISSION_RES(id,per_id,res_id)
	values('b1a43557-429f-4c70-87b4-2acac63efbb1','PER00000-0000-0000-0000-000000000002','RES00000-0000-0000-0000-000000000002');
INSERT INTO	MOCHA_SECU_PERMISSION_RES(id,per_id,res_id)
	values('414cbe93-beee-43b8-965e-6fec589ef25f','PER00000-0000-0000-0000-000000000002','RES00000-0000-0000-0000-000000000003');
	
insert into MOCHA_SECU_ROLE_PERMISSION(id,role_id,per_id)
	values('a375edc7-646f-44f1-867c-0817ccdfcd72','ROL00000-0000-0000-0000-000000000001','PER00000-0000-0000-0000-000000000001');
insert into MOCHA_SECU_ROLE_PERMISSION(id,role_id,per_id)
	values('d1ed29a7-3b69-4277-a83a-23377efa8015','ROL00000-0000-0000-0000-000000000002','PER00000-0000-0000-0000-000000000002');
commit;

