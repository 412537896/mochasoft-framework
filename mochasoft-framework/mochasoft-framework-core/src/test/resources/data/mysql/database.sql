    drop table if exists ss_user_role;

    drop table if exists ss_role;

    drop table if exists ss_user;
    
    drop table if exists ss_team;

    

    CREATE TABLE ss_role (
        id BIGINT NOT NULL AUTO_INCREMENT,
    	NAME VARCHAR(255) NOT NULL UNIQUE,
    	permissions VARCHAR(255),
        PRIMARY KEY (id)
    );

    CREATE TABLE ss_user (
       	id BIGINT NOT NULL AUTO_INCREMENT,
        login_name VARCHAR(255) NOT NULL UNIQUE,
        NAME VARCHAR(64),
        PASSWORD VARCHAR(255),
        salt VARCHAR(64),
        email VARCHAR(128),
        STATUS VARCHAR(32),
        team_id BIGINT,
        PRIMARY KEY (id)
    );

    CREATE TABLE ss_user_role (
        user_id BIGINT NOT NULL,
        role_id BIGINT NOT NULL,
        PRIMARY KEY (user_id, role_id)
    );
    
   	CREATE TABLE ss_team (
       	id BIGINT NOT NULL AUTO_INCREMENT,
    	NAME VARCHAR(255) NOT NULL UNIQUE,
    	master_id BIGINT,
        PRIMARY KEY (id)
    );