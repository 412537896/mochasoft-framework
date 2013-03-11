--------------------------------------------------------
--  文件已创建 - 星期四-一月-31-2013   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MOCHA_SECU_CONFIGURATION
--------------------------------------------------------

  CREATE TABLE "MOCHA_SECU_CONFIGURATION" 
   (  
    "ID" CHAR(36), 
  	"TYPE" CHAR(36), 
  	"KEY" VARCHAR2(1000), 
  	"VALUE" VARCHAR2(2000), 
  	"LASTUPDATETIME" NUMBER(13,0)
   );

--------------------------------------------------------
--  Constraints for Table MOCHA_SECU_CONFIGURATION
--------------------------------------------------------

  ALTER TABLE "MOCHA_SECU_CONFIGURATION" ADD CONSTRAINT "PK_MOCHA_SECU_CONFIGURATION" PRIMARY KEY ("ID") ENABLE;
 
  ALTER TABLE "MOCHA_SECU_CONFIGURATION" ADD CONSTRAINT "AK_MOCHA_SECU_CONFIGURATION" UNIQUE ("KEY") ENABLE;