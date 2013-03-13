@echo off
echo [INFO] Use maven eclipse-plugin download jars and generate eclipse project files.
echo [Info] Please add "-Declipse.workspace=<path-to-eclipse-workspace>" at end of mvn command.

cd %~dp0
cd ..

set path=%M2_HOME%/bin;%windir%/system32;%path%
call mvn -Declipse.workspace=%cd% eclipse:clean eclipse:eclipse

cd bin
pause