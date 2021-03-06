--1.数据表空间
CREATE TABLESPACE "FK_DATA" LOGGING
DATAFILE '/oradata/oradatacmcc/FK_DATA.dbf' SIZE 50 M
AUTOEXTEND ON NEXT 10240K MAXSIZE UNLIMITED EXTENT
MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT AUTO;
--2.索引表空间
CREATE TABLESPACE "FK_INDEX"
LOGGING DATAFILE '/oradata/oradatacmcc/FK_INDEX.dbf' SIZE 50 M
AUTOEXTEND ON NEXT 10240K MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL
SEGMENT SPACE MANAGEMENT AUTO;

--3.临时表空间
CREATE TEMPORARY TABLESPACE "FK_TEMP"
TEMPFILE '/oradata/oradatacmcc/FK_TEMP.dbf' SIZE 200M AUTOEXTEND
ON NEXT 10240K MAXSIZE UNLIMITED EXTENT MANAGEMENT LOCAL
UNIFORM SIZE 1M;

CREATE USER fk PROFILE "DEFAULT" IDENTIFIED BY "123456"
DEFAULT TABLESPACE "FK_DATA" TEMPORARY TABLESPACE "FK_TEMP"
ACCOUNT UNLOCK;

GRANT "CONNECT" TO fk;
GRANT "EXP_FULL_DATABASE" TO fk;
GRANT "IMP_FULL_DATABASE" TO fk;
GRANT "RESOURCE" TO fk;
GRANT UNLIMITED TABLESPACE TO fk;