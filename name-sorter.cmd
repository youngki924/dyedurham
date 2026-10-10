@echo off
setlocal
set "PROJECT_DIR=%~dp0"
call mvn -q -f "%PROJECT_DIR%pom.xml" -Dmaven.repo.local="%PROJECT_DIR%target\maven-repository" compile exec:java "-Dexec.args=%*"
exit /b %ERRORLEVEL%
