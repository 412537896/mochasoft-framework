@echo off

set MVN=mvn
set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m

echo [Step 1] Install parent pom.xml to local repository.
cd %~dp0
cd ..
call mvn clean install deploy -Dmaven.test.skip=true

echo [Step 2] Install core.jar to local repository.
cd mochasoft-framework-core
call mvn clean install deploy -Dmaven.test.skip=true
if errorlevel 1 goto error

echo [Step 3] Install web to local repository.
cd ..
cd quickstart-web
call mvn clean install deploy -Dmaven.test.skip=true
if errorlevel 1 goto error

cd ..\bin
pause